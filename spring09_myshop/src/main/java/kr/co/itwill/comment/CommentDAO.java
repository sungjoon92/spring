package kr.co.itwill.comment;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class CommentDAO {
	
	public CommentDAO() {
		System.out.println("-----CommentDAO() 객체 생성됨");
	}//생성자 함수
	

	//sql연결
	@Autowired
	SqlSession sqlSession;
	
	 public int commentInsert(CommentDTO commentDto) {
	    	return sqlSession.insert("comment.insert", commentDto);
	 }//commentInsert() end
	 
	 public List<CommentDTO> commentList(int product_code) {
		 return sqlSession.selectList("comment.list", product_code);
	 }//commentList() end
	
	 
	 public int commentUpdate(CommentDTO comment) {
		 return sqlSession.update("comment.update", comment);
	 }//commentUpdate() end
	 
	 
	 public int commentDelete(int cno){
		 return sqlSession.delete("comment.delete", cno);
	 }//commentUpdate() end
}//CommentDAO class end

