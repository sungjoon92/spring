package kr.co.itwill.inquiry;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InquiryDAO {
	
	public  InquiryDAO() {
		System.out.println("-----inquiryDAO() 객체생성");
	}
	
	@Autowired
	SqlSession sqlSession;

	
}//CommentDAO class end

