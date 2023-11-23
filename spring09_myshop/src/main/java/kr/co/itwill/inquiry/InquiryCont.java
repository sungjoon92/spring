package kr.co.itwill.inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inquiry")
public class InquiryCont {
	
	public  InquiryCont() {
		System.out.println("-----inquiryCont() 객체 생성");
	}
	
	
	@Autowired
	InquiryDAO inquiryDAO; 
	
	
	
	@GetMapping("/list")
	public String inquiryList() {
		return "inquiry/list";
	}//orederForm
	
}//OrderCont class end