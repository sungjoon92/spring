package kr.co.itwill.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderCont {

	public OrderCont() {
		System.out.println("-----orederCont() 객체 생성");
	}

	@Autowired
	OrderDAO orderDao;

	@GetMapping("/orderform")
	public String orderForm() {
		return "order/orderForm";
	}// orederForm

	@PostMapping("/insert")
	public ModelAndView orderInsert(OrderDTO orderDto, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// System.out.println(orderDto.toString());

		String s_id = "itwill";
		// 1) 주문서 번호 생성하기
		// 최소주문 202311231436151
		// 최소주문 202311231436152
		// 최소주문 202311231436153

		// 오늘날짜 및 현재시간을 문자열 "년월일시분초"로 구성해서 반환
		// 20231123143615
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
		String cdate = sd.format(new Date());
		System.out.println(cdate);

		String orderno = orderDao.orderno(cdate);
		if (orderno.equals("1")) { // 최소 주문
			orderno = cdate + "1"; // "20231123143615" + "1"
		} else {
			int n = Integer.parseInt(orderno.substring(14)) + 1; // 맨마지막글자+1
			orderno = cdate + n;
		} // if end

		// 2) 총결제금액 구하기
		int totalamount = orderDao.totalamount(s_id);
//	      System.out.println(totalamount);
//	      System.out.println(orderno);

		// 3) orderDto에 주문서번호, 총결제금액, 세션아이디 추가로 담기
		orderDto.setOrderno(orderno);
		orderDto.setTotalamount(totalamount);
		orderDto.setId(s_id);

		// System.out.println(orderDto.toString());

		// 4) orderlist테이블에 3)의 내용으로 행 추가하기
		int cnt = orderDao.orderlistInsert(orderDto);
		if (cnt == 1) {

			// 5) cart테이블에 있는 주문상품을 orderdetail테이블에 옮겨 담기
			HashMap<String, String> map = new HashMap<>();
			map.put("orderno", orderno);
			map.put("s_id", s_id);

			int result = orderDao.orderdetailInsert(map);

			if (result != 0) {
				// 6) cart테이블 비우기
				orderDao.cartDelete(s_id);

				// 7)주문내역서 메일 보내기
				mav.addObject("msg1", "<img src='../images/logo_itwill.png'>");
				mav.addObject("msg2", "<p>주문이 완료되었습니다</p>");
				mav.addObject("msg3", "<p><a href='/product/list'>[계속쇼핑하기]</a></p>");
			} else {
				mav.addObject("msg1", "<img src='../images/fail.png'>");
				mav.addObject("msg2", "<p>주문이 실패하였습니다</p>");
				mav.addObject("msg3", "<p><a href='javascript:history.back()'>[다시시도]</a></p>");
			} // if end

		} else {
			mav.addObject("msg1", "<img src='../images/fail.png'>");
			mav.addObject("msg2", "<p>주문이 실패되었습니다.</p>");
			mav.addObject("msg3", "<p><a href=javascript:history.back()'>다시시도</a></p>");
		} // if end
		
		mav.setViewName("/order/msgView");
		return mav;
	}// orderInsert() end

}// OrderCont class end