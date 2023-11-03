package kr.co.itwill;

import org.springframework.stereotype.Controller;
//URL에서 요청, 응답이 가능한 클래스 지정
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 스프링 컨테이너 (톰캣)가 자동으로 객체 생성됨

public class Homecontroller {

	public Homecontroller() {
		System.out.println("Homecontroller() 객체 생성됨");
	}// end

	// 요청 명령어 등록하고, 실행의 주체는 메소드(함수)
	// 결과확인 http://localhost:9095/home.do

	@RequestMapping("/home.do")

	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		
		//application.properties 환경설정 참조
		// /WEB-INF/views/start.jsp
		mav.setViewName("start");
		
		//뷰페이지(start.jsp)와 값을 공유하기 위해 request 전역변수 활용
		mav.addObject("message","찎찌찎찎찎");
		mav.addObject("img","<img src='images/mouse.png'>");
		return mav;
	}// home() end

}// Homecontroller class end
