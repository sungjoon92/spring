package kr.co.itwill.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.servlet.http.HttpServletRequest;

@Repository
public class ProductDAO {

    public ProductDAO() {
        System.out.println("-----ProductDAO() 객체 생성됨");
    }//end
    
    //스프링 빈으로 자동 생성된 객체를 가져와서 연결하기 (Spring09MyshopApplication 클래스 참조)
    @Autowired
    SqlSession sqlSession;
    
    
    public void insert(Map<String, Object> map) {
    	sqlSession.insert("product.insert", map);
    }//insert() end
    
    public List<Map<String, Object>> list() {
		return sqlSession.selectList("product.list");
	}//list() end

    public List<Map<String, Object>> search(String product_name){
    	return sqlSession.selectList("product.search", "%" + product_name+ "%");
    }//search() end

	public Map<String, Object> detail(int product_code) {
		return sqlSession.selectOne("product.detail", product_code);
	}// search() end

//    //삭제1
//    public void delete(String map){
//    	sqlSession.delete("product.delete", map);
//    }//search() end

	// 삭제2
	public void delete(int product_code) {
		sqlSession.delete("product.delete", product_code);
	}// search() end

	// 파일삭제
	public String filename(int product_code) {
		return sqlSession.selectOne("product.filename", product_code);
	}// search() end

	//업데이트
    public void update(Map<String, Object> map) {
    	sqlSession.update("product.update", map);
    }//update() end
    
}//class end
