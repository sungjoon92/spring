package kr.co.itwill.order;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderCont {
	
	public  OrderCont() {
		System.out.println("-----orederCont() 객체 생성");
	}
	
	
	@Autowired
	OrderDAO orderDao; 
	
	
	
	@GetMapping("/orderform")
	public String orderForm() {
		return "order/orderForm";
	}//orederForm
	
	
	@PostMapping("/insert")
	public ModelAndView orderInsert(OrderDTO orderDto, HttpSession session) {
		
		//System.out.println(orderDto.toString());	
			
		//1) 주문서 번호 생성하기
		// 최소주문 202311231436151
		// 최소주문 202311231436152
		// 최소주문 202311231436153
		
		//오늘날짜 및 현재시간을 문자열 "년월일시분초"로 구성해서 반환
		//20231123143615
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
		String cdate = sd.format(new Date());
		System.out.println(cdate);
		
		String orderno = orderDao.orderno(cdate);
		if(orderno.equals("1")) { //최소 주문
			orderno = cdate +"1"; //"20231123143615" + "1"
		}else {
			int n=Integer.parseInt(orderno.substring(14))+1; //맨마지막글자+1
			orderno = cdate + n ;
		}//if end
		
		System.out.println(orderno);
		return null;
	}//orderInsert end
	
	
}//OrderCont class end