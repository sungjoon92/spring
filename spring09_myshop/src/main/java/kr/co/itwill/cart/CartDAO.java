package kr.co.itwill.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

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
	
	// 리스트1
	// public List<CartDTO> cartList(String id) {
	// return sqlSession.selectList("cart.list", id);
	// }// cartList() end

	// 리스트2
	public List<Map<String,Object>>cartList(String id) {
		return sqlSession.selectList("cart.list", id);
	}// cartList() end

//	public int cartDelete(int cartno){
//		 return sqlSession.delete("cart.delete", cartno);
//	 }//cartDelete() end

	public int cartDelete(HashMap<String, Object> map) {
		return sqlSession.delete("cart.delete", map);
	}// cartDelete() end

}// CartDAO class end
