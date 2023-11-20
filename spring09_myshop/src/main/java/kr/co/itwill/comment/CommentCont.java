package kr.co.itwill.comment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/comment")
public class CommentCont {

	public CommentCont() {
		System.out.println("-----CommentCont() 객체 생성됨");
	}// 생성자 함수

	//DAO와 연결
	@Autowired
	private CommentDAO commentDao;
	
	@PostMapping("/insert")
	@ResponseBody
	public int mCommentserviceInsert(@RequestParam int product_code
									, @RequestParam String content
									, HttpSession session) {
									  //HttpServletRequest req
									  //@ModelAttribute CommentDTO commentDto
		CommentDTO commentDto = new CommentDTO();
		commentDto.setProduct_code(product_code);
		commentDto.setContent(content);
		commentDto.setWname("test");
		//로그인 기능을 구현했거나 따로 댓글 작성자를 입력받는 폼이 있다면 입력 받아온 값으로 사용하면 된다.
		//예) session.getAttribute("s_id");
		//	따로 폼을 구현하지 않았기 떄문에 임시로 "test";
		 
		int cnt=commentDao.commentInsert(commentDto);
		return cnt;
	}//mCommentserviceInsert() end
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// CommentCont class end
