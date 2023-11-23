package kr.co.itwill.order;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO {
	
	public  OrderDAO() {
		System.out.println("-----OrderDAO() 객체생성");
	}
	
	@Autowired
	SqlSession sqlSession;

	
	 public String orderno(String cdate) {
	    return sqlSession.selectOne("order.orderno", cdate);
			
	    }//insert() end
	
	
}//CommentDAO class end

