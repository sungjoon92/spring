package kr.co.itwill.calc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ComputeController {

	public ComputeController() {
		System.out.println("ComputeController() 객체 생성됨");
	}// end

	
	//요청명령어를 처리하는 메소드 매개변수의 유연성
	//@requestParam("요청변수명")자료형 변수명
	//사용자가 요청한 값을 직접 변수에 저장 가능
	
	// URL에서 요청한 명령어를 등록
	// @RequestMapping(value ="", method = get | post )

	// 결과확인 http://localhost:9095/diff.do?no1=3&no2=5
	@RequestMapping("/diff.do") // GET | POST 허용

	// @RequestMapping(value = "/diff.do", method = RequestMethod.GET)
	// diff.do 를 get | post 방식으로 호출 했을때
	// public ModelAndView diff() 호출
	public ModelAndView diff(@RequestParam("no1") int a, @RequestParam("no2") int b) {
		// ?no1=3&no2=5를 불렀을때 add()의 매개변수를 부름
		// 사용자가 요청한 값 가져오기
		int result = Math.abs(a-b);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("calcResult");

		// 전역변수를 활용하여 공유장소에 값 올리기
		mav.addObject("no1", a);
		mav.addObject("no2", b);
		mav.addObject("result", result);
		mav.addObject("message", "<h3>두수 사이의 차이</h3>");
		mav.addObject("img", "<img src='images/apeach.png'>");

		return mav;
	}// add() end

	
	
	// 결과확인 http://localhost:9095/max.do?no1=3&no2=5
	@RequestMapping("/max.do") // GET | POST 허용
	// @RequestMapping(value = "/diff.do", method = RequestMethod.GET)
	// diff.do 를 get | post 방식으로 호출 했을때
	// public ModelAndView diff() 호출
	public ModelAndView max(int no1, int no2) {
		// ?no1=3&no2=5를 불렀을때 add()의 매개변수를 부름
		// 사용자가 요청한 값 가져오기
		int result = Math.max(no1, no2);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("calcResult");

		// 전역변수를 활용하여 공유장소에 값 올리기
		mav.addObject("no1", no1);
		mav.addObject("no2", no2);
		mav.addObject("result", result);
		mav.addObject("message", "<h3>두수 사이의 큰값</h3>");
		mav.addObject("img", "<img src='images/apeach.png'>");

		return mav;
	}// add() end
}// ComputeController class end
