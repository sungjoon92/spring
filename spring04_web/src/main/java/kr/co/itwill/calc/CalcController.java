package kr.co.itwill.calc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CalcController {

	public CalcController() {
		System.out.println("CalcController() 객체 생성됨");
	}// end

	// URL에서 요청한 명령어를 등록
	// @RequestMapping(value ="", method = get | post )

	// 결과확인 http://localhost:9095/add.do?no1=3&no2=5
	// /add,do 요청 명령어를 get방식으로 요청하면
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	// add.do 를 get 방식으로 호출 했을때
	// public ModelAndView add() 호출
	public ModelAndView add(HttpServletRequest req) {
		// ?no1=3&no2=5를 불렀을때 add()의 매개변수를 부름
		// 사용자가 요청한 값 가져오기
		int no1 = Integer.parseInt(req.getParameter("no1")); // 3
		int no2 = Integer.parseInt(req.getParameter("no2")); // 5
		int result = no1 + no2; // 8

		ModelAndView mav = new ModelAndView();
		mav.setViewName("calcResult");

		// 전역변수를 활용하여 공유장소에 값 올리기
		req.setAttribute("no1", no1);
		req.setAttribute("no2", no2);
		req.setAttribute("result", result);
		req.setAttribute("message", "<h3>두수 사이의 합</h3>");
		req.setAttribute("img", "<img src='images/add.png'>");

		return mav;
	}// add() end

	// 결과확인 http://localhost:9095/sub.do?no1=3&no2=5
	// GetMapping("") 아래 명령어와 동일
	@RequestMapping(value = "/sub.do", method = RequestMethod.GET)
	public ModelAndView sub(HttpServletRequest req) {

		int no1 = Integer.parseInt(req.getParameter("no1")); // 3
		int no2 = Integer.parseInt(req.getParameter("no2")); // 5
		int result = no1 - no2;

		ModelAndView mav = new ModelAndView();
		mav.setViewName("calcResult");

		mav.addObject("no1", no1);
		mav.addObject("no2", no2);
		mav.addObject("result", result);
		mav.addObject("message", "<h3>두수 사이의 차</h3>");
		mav.addObject("img", "<img src='images/sub.png'>");

		return mav;
	}// sub() end

	// 결과확인 http://localhost:9095/mul.do?no1=3&no2=5
	// GetMapping("") 아래 명령어와 동일
	@RequestMapping(value = "/mul.do", method = RequestMethod.GET)
	public ModelAndView mul(HttpServletRequest req) {

		int no1 = Integer.parseInt(req.getParameter("no1")); // 3
		int no2 = Integer.parseInt(req.getParameter("no2")); // 5
		int result = no1 * no2;

		ModelAndView mav = new ModelAndView();
		mav.setViewName("calcResult");

		mav.addObject("no1", no1);
		mav.addObject("no2", no2);
		mav.addObject("result", result);
		mav.addObject("message", "<h3>두수 사이의 곱</h3>");
		mav.addObject("img", "<img src='images/mul.png'>");

		return mav;
	}// mul() end

	// 결과확인 http://localhost:9095/div.do?no1=3&no2=5
	@GetMapping("/div.do") //아래 명령어와 동일
//	@RequestMapping(value = "/div.do", method = RequestMethod.GET)
	public ModelAndView div(HttpServletRequest req, HttpServletResponse session) {

		double no1 = Integer.parseInt(req.getParameter("no1")); // 3
		double no2 = Integer.parseInt(req.getParameter("no2")); // 5
		double result = no1 / no2;

		ModelAndView mav = new ModelAndView();
		mav.setViewName("calcResult");

		mav.addObject("no1", no1);
		mav.addObject("no2", no2);
		mav.addObject("result", result);
		mav.addObject("message", "<h3>두수 사이의 나눈값</h3>");
		mav.addObject("img", "<img src='images/div.png'>");

		return mav;
	}// mul() end

}// CalcController class end
