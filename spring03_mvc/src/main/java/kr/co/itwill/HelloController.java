package kr.co.itwill;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

//URL에서 요청한 명령어를 읽어서 처리해 주는 클래스
//HelloController클래스는 컨트롤러 기능이다
//스프링컨테이너(웹서버)가 자동으로 객체 생성
@Controller

public class HelloController {

	public HelloController() {
		System.out.println("HelloController() 객체 생성됨");
	}// end

	// 결과확인 http://localhost:9095/hello.do
	// 요청명령어 등록 후 실행의 주체는 메소드(함수)

	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		
		//application.porperties 환경 설정 파일이 prefix와 suffix값을 조합해서 뷰페이지를 완성
		ModelAndView mav= new ModelAndView();
		mav.setViewName("hello"); // /WEB-INF/views/ + hello + .jsp
		//setViewName 확장자명은 알아서 찾아감
		
		//서로 다른 페이지들 간에 값을 공유하기 위한 전역변수
		// request, session, application 활용
		
		// Request.setAttribute()함수와 동일
		mav.addObject("message","<p>환영합니다</p>");
		return mav;
		
	}// hello() end

}// HelloController class end