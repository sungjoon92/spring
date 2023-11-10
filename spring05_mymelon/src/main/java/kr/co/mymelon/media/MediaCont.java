package kr.co.mymelon.media;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.utility.UploadSaveManager;

@Controller
public class MediaCont {

	@Autowired
	MediaDAO dao;

	public MediaCont() {
		System.out.println("MediaCont()객체 생성됨");
	}// end
		////////// 음원 목록페이지/////////

	@GetMapping("media/list.do")
	public ModelAndView list(int mediagroupno) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("media/list");
		mav.addObject("list", dao.list(mediagroupno));
		mav.addObject("mediagroupno", mediagroupno);
		return mav;
	}// list() end

//////////음원 등록페이지/////////
	@GetMapping("media/create.do")
	public ModelAndView createForm(int mediagroupno) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("media/createForm");
		mav.addObject("mediagroupno", mediagroupno);
		return mav;
	}// createForm() end

//////////음원 등록 완료 페이지/////////
	@PostMapping("media/create.do")
	public ModelAndView createproc(MediaDTO dto, HttpServletRequest req) {
		// createproc(String, MultpartFile posterMF, MultpartFile filenameMF)
		ModelAndView mav = new ModelAndView();
		mav.setViewName("media/msgView");

		///////////////////////////////////
		// 첨부된 파일 처리
		// MultipartFile postreMf = dto.getPosterMF();
		// MultipartFile FilenameMF = dto.getFilenameMF();
		// System.out.println(postreMf.getOriginalFilename());
		// System.out.println(postreMf.getSize());
		// System.out.println(FilenameMF.getOriginalFilename());
		// System.out.println(FilenameMF.getSize());

		// 첨부된 파일 처리
		// 실제 파일을 /storage폴더에 저장
		// 저장된 파일 관련 정보는 media 테이블에 저장

		// 파일 저장 폴더의 실제 물리적인 경로
		ServletContext application = req.getServletContext();
		String basepath = application.getRealPath("/storage");

		// 1 <input type='file' name='posterMF'>
		MultipartFile posterMf = dto.getPosterMF();// 파일 가져오기
		// /storage폴더에 첨부된 파일 저장하고, 리네임된 파일명 반환
		String poster = UploadSaveManager.saveFileSpring30(posterMf, basepath);
		dto.setPoster(poster); // 리네임된 파일명을 dto객체 담기

		// 2 <input type='file' name='filenameMF'>
		MultipartFile filenameMF = dto.getFilenameMF();// 파일 가져오기
		// /storage폴더에 첨부된 파일 저장하고, 리네임된 파일명 반환
		String filename = UploadSaveManager.saveFileSpring30(filenameMF, basepath);
		dto.setFilename(filename);
		dto.setFilesize(filenameMF.getSize());

		int cnt = dao.create(dto);
		if (cnt == 0) {
			String msg1 = "<p>음원 등록 실패</p>";
			String img = "<img src='../images/fail.png>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:hitory.back()'";
			String link2 = "<input type='button' value='목록으로' onclick='location.href=\"list.do?mediagroupno="
					+ dto.getMediagroupno() + "\"'>";
			mav.addObject("msg1", msg1);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			String msg1 = "<p>음원 등록 성공</p>";
			String img = "<img src='../images/sound.png'>";
			String link2 = "<input type='button' value='목록으로' onclick='location.href=\"list.do?mediagroupno="
					+ dto.getMediagroupno() + "\"'>";
			mav.addObject("msg1", msg1);
			mav.addObject("img", img);
			mav.addObject("link2", link2);
		} // if end
		return mav;
	}// createproc() end

	@GetMapping("media/read.do")
	public ModelAndView read(int mediano) {
		ModelAndView mav = new ModelAndView();
		MediaDTO dto = dao.read(mediano);
		if (dto != null) {
			String filename = dto.getFilename(); // 파일명 가져오기
			filename = filename.toLowerCase(); // 파일명 모두 소문자로 바꾸기
			if (filename.endsWith(".mp3")) { // 마지막 문자열이 .mp3인가?
				mav.setViewName("media/readMP3");
			} else if (filename.endsWith(".mp4")) { // 마지막 문자열이 .mp4인가?
				mav.setViewName("media/readMP4");
			} // if end
		} // if end
		mav.addObject("dto", dto);
		return mav;
	}// read() end

	@GetMapping("media/update.do")
	public ModelAndView updateForm(int mediano) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("media/updateForm");
		MediaDTO dto = dao.read(mediano); // 수정하고자 하는 행을 가져오기
		mav.addObject("dto", dto);
		return mav;
	}// update() end

	@PostMapping("media/update.do")
	public ModelAndView updteproc(MediaDTO dto, HttpServletRequest req) {

		// 기존에 저장된 정보를 가져오기
		MediaDTO oldDTO = dao.read(dto.getMediano());
		///////////////////////////////////
		// 파일을 수정할 것인지?
		ServletContext application = req.getServletContext();
		String basepath = application.getRealPath("/storage");

		// 1)
		MultipartFile posterMF = dto.getPosterMF();
		if (posterMF.getSize() > 0) { // 새로운 포스터 파일이 첨부되어 전송되었는지
			// 기존에 저장되어 있는 파일 삭제
			UploadSaveManager.deleteFile(basepath, oldDTO.getPoster());
			// 신규로 전송된 파일 저장
			String poster = UploadSaveManager.saveFileSpring30(posterMF, basepath);
			// 신규로 전송된 파일명 dto에 담기
			dto.setPoster(poster);
		} else {
			// 포스터 파일은 수정하지 않은경우
			dto.setPoster(oldDTO.getPoster());// 기존에 저장된 파일명
		} // if end

		// 2)
		MultipartFile filenameMF = dto.getFilenameMF();
		if (filenameMF.getSize() > 0) { // 새로운 포스터 파일이 첨부되어 전송되었는지
			// 기존에 저장되어 있는 파일 삭제
			UploadSaveManager.deleteFile(basepath, oldDTO.getFilename());
			// 신규로 전송된 파일 저장
			String filename = UploadSaveManager.saveFileSpring30(filenameMF, basepath);
			// 신규로 전송된 파일명 dto에 담기
			dto.setFilename(filename);
			dto.setFilesize(filenameMF.getSize());
		} else {
			// 포스터 파일은 수정하지 않은경우
			dto.setFilename(oldDTO.getFilename());// 기존에 저장된 파일명
			dto.setFilesize(oldDTO.getFilesize());// 기존에 저장된 파일명
		} // if end
			////////////////////////////////////////////

		ModelAndView mav = new ModelAndView();
		int cnt = dao.update(dto);
		if (cnt == 0) {
			mav.setViewName("media/msgView");
			String msg1 = "<p>음원 파일 수정 실패!!</p>";
			String img = "<img src='../images/fail.png'>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'";
			String link2 = "<input type='button' value='목록으로' onclick='location.href=\"list.do?mediagroupno="
					+ dto.getMediagroupno() + "\"'>";

			mav.addObject("msg1", msg1);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			mav.setViewName("redirect:/media/list.do?mediagroupno=" + dto.getMediagroupno());
		} // if end

		return mav;
	}// updteproc() end

	
	
	// 삭제 페이지 출력
	@GetMapping("media/delete.do")
	public ModelAndView deleteForm(int mediano, int mediagroupno) {
		                           //list.jsp에서 delete.do?mediano=${dto.mediano}&mediagroupno=${dto.mediagroupno}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("media/deleteForm");
		mav.addObject("mediano", mediano);
		mav.addObject("mediagroupno", mediagroupno);
		return mav;
	}// deleteForm() end
	
	// 삭제 적용 출력
	@PostMapping("media/delete.do")
	public ModelAndView deleteproc(MediaDTO dto) { //deleteForm.jsp에서 아래값을 dto로 받음
		                                           //<input type="hidden" name="mediagroupno">
												   //<input type="hidden" name="mediano"> 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("media/msgView");

		int cnt = dao.delete(dto);
		
		if (cnt == 0) {
			String msg1 = "<p>음원 삭제 실패</p>";
			String img = "<img src='../images/fail.png>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:hitory.back()'";
			String link2 = "<input type='button' value='목록으로' onclick='location.href=\"list.do?mediagroupno="
					+ dto.getMediagroupno() + "\"'>";
			mav.addObject("msg1", msg1);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			String msg1 = "<p>음원 삭제 성공</p>";
			mav.setViewName("redirect:/media/list.do?mediagroupno=" + dto.getMediagroupno());
			
		
		} // if end
		return mav;
	}// createproc() end

}// class end
