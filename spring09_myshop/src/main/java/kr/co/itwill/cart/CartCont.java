package kr.co.itwill.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartCont{
	
	public CartCont(){
		System.out.println("-----CartCont()객체 생성");
	}//end
	
	
	@Autowired
	CartDAO cartDao;
	@PostMapping("/insert")
	public String cartInsert(@ModelAttribute CartDTO cartDto, HttpSession session) {
		//로그인 기능을 구현했다면 session.getAttribute() 활용
		//cartDto.setId(session.getAttribute("a_id"));
		cartDto.setId("itwill");  //임시로 "itwill"
		
		cartDao.cartInsert(cartDto);
		
		return "redirect:/cart/list"; //장바구니 목록페이지 호출 

	}//cartInsert() end
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) {
		//로그인 했다면
		String s_id="itwill";
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cart/list");
		mav.addObject("list", cartDao.cartList(s_id));
		return mav;
	}//list() end
	
	
	@RequestMapping("/delete/{cartno}")
	@ResponseBody
	public int cartDelete(@PathVariable int cartno)throws Exception{
		int cnt = cartDao.cartDelete(cartno);
		
		return cnt;
		
	}//cartDelete() end
	
	

	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// CommentCont class end
