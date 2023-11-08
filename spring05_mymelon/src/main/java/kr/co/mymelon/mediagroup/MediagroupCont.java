package kr.co.mymelon.mediagroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MediagroupCont {
	// private MediagroupDAO dao = new MediagroupDAO();
	// @Repository에 의해서 이미 객체가 생성되어 있으므로 new 하지 않아도 된다
	// @Autowired 스프링 컨테이너(톰캣)가 생성해 준 객체를 연결
	@Autowired
	private MediagroupDAO dao;
	@Autowired
	private JdbcTemplate jt;

	// 생성자 함수
	public MediagroupCont() {
		System.out.println("MediagroupCon() 객체 생성됨");
	}// end

	// 페이징 없는 목록
	// 리스트 페이지 불러오기
	@RequestMapping("mediagroup/list.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mediagroup/list");

		List<MediagroupDTO> list = dao.list();
		int totalRowCount = dao.totalRowCount(); // 총 글갯수

		mav.addObject("list", list);
		mav.addObject("count", totalRowCount);
		return mav;
	}// list() end
	// 비지니스 로직 구현

	public int create(MediagroupDTO dto) {
		int cnt = 0;
		try {
			StringBuilder sql = new StringBuilder();

			sql.append(" INSERT INTO mediagroup(mediagroupno, title) ");
			sql.append(" VALUES( mediagroup_seq.nextval, ? ) ");

			// SQL문 (insert, update, delete) 실행
			cnt = jt.update(sql.toString(), dto.getTitle());

		} catch (Exception e) {
			System.out.println("미디어그룹등록실패:" + e);
		} // end
		return cnt;
	}// create() end

	// 2) 페이징 있는 목록
//	   @RequestMapping("mediagroup/list.do")
//    public ModelAndView list(HttpServletRequest req) {
//        ModelAndView mav=new ModelAndView();
//        mav.setViewName("mediagroup/list");
//       
//        int totalRowCount=dao.totalRowCount(); //총 글갯수
//       
//        //페이징
//        int numPerPage   = 5;    // 한 페이지당 레코드 갯수
//        int pagePerBlock = 10;   // 페이지 리스트
//       
//        String pageNum=req.getParameter("pageNum");
//        if(pageNum==null){
//              pageNum="1";
//        }
//       
//        int currentPage=Integer.parseInt(pageNum);
//        int startRow   =(currentPage-1)*numPerPage+1;
//        int endRow     =currentPage*numPerPage;
//       
//        //페이지 수
//        double totcnt = (double)totalRowCount/numPerPage;
//        int totalPage = (int)Math.ceil(totcnt);
//         
//        double d_page = (double)currentPage/pagePerBlock;
//        int Pages     = (int)Math.ceil(d_page)-1;
//        int startPage = Pages*pagePerBlock;
//        int endPage   = startPage+pagePerBlock+1;
//       
//       
//        List list=null;     
//        if(totalRowCount>0){           
//              list=dao.list2(startRow, endRow);          
//        } else {           
//              list=Collections.EMPTY_LIST;           
//        }//if end
//         
//        int number=0;
//        number=totalRowCount-(currentPage-1)*numPerPage;
//         
//        mav.addObject("number",    number);
//        mav.addObject("pageNum",   currentPage);
//        mav.addObject("startRow",  startRow);
//        mav.addObject("endRow",    endRow);
//        mav.addObject("count",     totalRowCount);
//        mav.addObject("pageSize",  pagePerBlock);
//        mav.addObject("totalPage", totalPage);
//        mav.addObject("startPage", startPage);
//        mav.addObject("endPage",   endPage);
//        mav.addObject("list", list);
//        return mav;
//    }//list() end

	
	//목록 추가 페이지
	@RequestMapping("mediagroup/create.do")
	public ModelAndView createForm(MediagroupDTO dto) {
		ModelAndView mav =new ModelAndView();
		mav.setViewName("mediagroup/createForm");
		return mav;
		
	}//createForm() end
	
	
	
	
	
	// 목록 추가페이지 불러오기
	@PostMapping("mediagroup/create.do")
	public ModelAndView createProc(@ModelAttribute MediagroupDTO dto) {
		ModelAndView mav = new ModelAndView();

		int cnt = dao.create(dto);
		if (cnt == 0) {
			mav.setViewName("mediagroup/msgView");

			String msg1 = "<p>미디어 그룹 등록 실패</p>";
			String img = "<img src='../images/fail.png'>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='그룹목록' onclick='location.href=\"list.do\"'>";

			mav.addObject("msg1", msg1);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);

		} else {
			mav.setViewName("redirect:/mediagroup/list.do");
		} // if end
		return mav;
	}// createProc() end

//	//목록 삭제
//	@RequestMapping("mediagroup/delete.do")
//	public ModelAndView deleteForm(MediagroupDTO dto) {
//		ModelAndView mav = new ModelAndView();
//		
//		int cnt = dao.delete(dto);
//		if(cnt == 0) {
//			mav.setViewName("mediagroup/msgView");
//			String msg1 = "<p>미디어 그룹 삭제 실패</p>";
//			String link2 = "<input type='button' value='그룹목록' onclick='location.href=\"list.do\"'>";
//			
//			mav.addObject("msg", msg1);
//			mav.addObject("link2", link2);
//			
//		}else {
//			mav.setViewName("redirect:/mediagroup/list.do");
//		}//if end
//		return mav;
//	}//deleteForm() end

	// 목록 삭제2
	@RequestMapping("mediagroup/delete.do")
//	public ModelAndView deleteForm(HttpServletRequest req) {
//		int mediagroupno = Integer.parseInt(req.getParameter("mediagroupno"));
//	}
//	public ModelAndView deleteForm(MediagroupDTO dto) {
//		int mediagroupno = dto.getMediagroupno();
//	}
//	public ModelAndView deleteForm(@RequestParam("meidagroupno") int a) {}

	// 삭제 페이지 출력
	public ModelAndView deleteForm(int mediagroupno) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mediagroup/deleteForm");
		mav.addObject("mediagroupno", mediagroupno);
		return mav;
	}// deleteForm() end

	// 삭제 완료페이지 출력
	@PostMapping("mediagroup/delete.do")
	public ModelAndView deleteProc(int mediagroupno) {
		ModelAndView mav = new ModelAndView();
		int cnt = dao.delete(mediagroupno);

		if (cnt == 0) {
			mav.setViewName("mediagroup/msgView");
			String msg1 = "<p>미디어 그룹 삭제 실패</p>";
			String img = "<img src='../images/fail.png'>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='그룹목록' onclick='location.href=\"list.do\"'>";

			mav.addObject("msg", msg1);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);

		} else {
			mav.setViewName("redirect:/mediagroup/list.do");
		} // if end
		return mav;
	}// deleteproc() end

	// 수정페이지 출력
	@GetMapping("mediagroup/update.do")
	public ModelAndView updateForm(int mediagroupno) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("mediagroup/updateForm");
		mav.addObject("dto", dao.update(mediagroupno));
		return mav;
	}// updateForm() end

	// 수정 완료 페이지 출력
	@PostMapping("mediagroup/updateproc.do")
	public ModelAndView updateproc(MediagroupDTO dto) {
		ModelAndView mav = new ModelAndView();
	System.out.println(dto.getMediagroupno());	
	System.out.println(dto.getTitle());	
		
		int cnt = dao.updateproc(dto);
		if (cnt == 0) {
			mav.setViewName("mediagroup/msgView");
			String msg1 = "<p>미디어 그룹 삭제 실패</p>";
			String img = "<img src='../images/fail.png'>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='그룹목록' onclick='location.href=\"list.do\"'>";

			mav.addObject("msg", msg1);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);

		} else {
			mav.setViewName("redirect:/mediagroup/list.do");
		} // if end
		return mav;
	}// updateForm() end

}// class end
