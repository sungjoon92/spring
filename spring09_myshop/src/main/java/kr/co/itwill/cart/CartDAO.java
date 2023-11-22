package kr.co.itwill.cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Repository
public class CartDAO {

	public CartDAO() {
		System.out.println("-----CartDAO() 객체 생성됨");
	}// 생성자 함수

	@Autowired
	SqlSession sqlSession;

	public int cartInsert(CartDTO dto) {
		return sqlSession.insert("cart.insert", dto);
	}// cartInsert() end

	public List<CartDTO> cartList(String id) {
		return sqlSession.selectList("cart.list", id);
	}// cartList() end

	
	public int cartDelete(int cartno){
		 System.out.println("11");
		 return sqlSession.delete("cart.delete", cartno);
	 }//commentUpdate() end
	
	
}// CartDAO class end
