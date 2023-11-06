package kr.co.itwill.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginCont {


	public LoginCont() {
		System.out.println("LoginCont() 객체 생성됨");
	}//end
		
	
	
	@GetMapping("/login/login.do")	
	public String loginForm() {
		return "login/loginForm";
	}//loginForm() end
	
	
	//http://localhost:9095/login/login.do
	@PostMapping("/login/login.do")
	public ModelAndView loginproc(LoginDTO dto, HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto",dto);
		if(dto.getId().equals("itwill") && dto.getPw().equals("1234")) {
			//로그인 성공했을때
			mav.setViewName("login/loginResult");
			
			//sesstion 전역변수에 값 올리기
			session.setAttribute("s_id", dto.getId());
			session.setAttribute("s_pw", dto.getPw());
			req.setAttribute("message", "<p>로그인 성공!!!</p>");

		}else {
			//로그인 실패했을때
			mav.setViewName("login/msgview");
			req.setAttribute("message", "<p>아이디와 비번이 일치하지 않습니다</p>");
			req.setAttribute("link", "<a href='javascript:history.back()'>[다시시도]</a>");
			
		}//if end
		
		return mav;
	}//login() end;
	
	
	
}//LoginCont class end
