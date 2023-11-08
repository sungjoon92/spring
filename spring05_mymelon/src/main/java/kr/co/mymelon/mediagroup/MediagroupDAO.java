package kr.co.mymelon.mediagroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

//@Service
//@Repository 모델 클래스 시정 스프링 컨테이너(톰캣)가 자동으로 객체를 생성해 준다
@Repository
public class MediagroupDAO {

	// DBOpen dbopen = new DBOpen(); 과 동일한 형태
	// @Autowired 스프링 컨테이너가 생성해준 객체를 연결
	@Autowired
	private JdbcTemplate jt;
	// db정보를 가져옴
	// spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
	// spring.datasource.url=jdbc:oracle:thin:@localhost:1521/xe
	// spring.datasource.username=system
	// spring.datasource.password=1234

	/*
	 * ● JdbcTemplate 클래스 -> 기본 자바 JDBC를 좀 더 편리하게 사용할 수 있다 -> JDBC를 위한 틀. JDBC
	 * 프로그래밍에 특화되어 있다 -> JdbcTemplate = DriverManager + Connection + Statement +
	 * ResultSet
	 * 
	 * ● @Autowired -> Spring이 필요시 자동으로 객체를 생성하여 필드(Instance variable, 객체 변수)에 할당함
	 * 
	 * ● @Repository -> DAO를 스프링에 인식시키기 위해서 주로 사용하며, 해당 클래스를 객체로 만들어 준다 -> 모델클래스로
	 * 지정하면 스프링컨테이너에서 관리를 해줌 -> DAO관련 빈을 자동 등록 대상으로 만들때 사용한다
	 * 
	 * ● RowMapper = PreparedStatement + ResultSet
	 * 
	 * ● [교재] - 초보웹개발자를 위한 스프링5 프로그래밍 입문 Chapter 4 의존 자동 주입 Chapter 8 DB 연동
	 */
	StringBuilder sql = null;

	public MediagroupDAO() {
		System.out.println("MediagroupDAO()객체 생성됨");
	}// end

	// 비지니스 로직 구현
///////////////리스트 추가하기//////////////////
	public int create(MediagroupDTO dto) {
		int cnt = 0;
		try {
			sql = new StringBuilder();

			sql.append(" INSERT INTO mediagroup(mediagroupno, title) ");
			sql.append(" VALUES( mediagroup_seq.nextval, ?) ");

			// SQL문 (INSETR, DELECT, UPDATE)
			cnt = jt.update(sql.toString(), dto.getTitle());
		} catch (Exception e) {
			System.out.println("미디어그룹 등록실패" + e);
		} // end
		return cnt;
	}// create() end

///////////////////추가한 리스트 보이기////////////////////////
	public List<MediagroupDTO> list() {
		List<MediagroupDTO> list = null;
		try {
			sql = new StringBuilder();

			sql.append(" SELECT mediagroupno, title ");
			sql.append(" FROM mediagroup ");
			sql.append(" ORDER BY mediagroupno DESC");

			RowMapper<MediagroupDTO> rowMapper = new RowMapper<MediagroupDTO>() {

				@Override
				public MediagroupDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					MediagroupDTO dto = new MediagroupDTO();
					dto.setMediagroupno(rs.getInt("mediagroupno"));
					dto.setTitle(rs.getString("title"));
					return dto;
				}// mapRow() end
			};// rowMapper end

			list = jt.query(sql.toString(), rowMapper);
		} catch (Exception e) {
			System.out.println("미디어그룹 목록 확인 실패" + e);
		} // end
		return list;
	}// list() end

	
	public int totalRowCount() {
		int cnt = 0;
		try {
			sql = new StringBuilder();
			sql.append(" SELECT COUNT(*) FROM mediagroup ");

			cnt = jt.queryForObject(sql.toString(), Integer.class);
			// queryForObject = SELECT COUNT(*) 를 가져오는 기능
			// SELECT를 실행했을 때 하나의 객체(object)를 가져올때 사용한다
		} catch (Exception e) {
			System.out.println("전체 행 갯수:" + e);
		} // end
		return cnt;
	}// totalRowCount() end

///////////////목록삭제1///////////////////
//	public int delete(MediagroupDTO dto) {
//		int cnt = 0;
//		try {
//			sql = new StringBuilder();
//			
//			sql.append(" DELETE FROM mediagroup ");
//			sql.append(" WHERE mediagroupno = ? ");
//
//			//SQL문 (INSETR, DELECT, UPDATE)
//			cnt = jt.update(sql.toString(), dto.getMediagroupno());
//		} catch (Exception e) {
//			System.out.println("미디어그룹 등록삭제실패" + e);
//		}//end
//		return cnt;
//	}//delete() end

///////////////목록삭제2///////////////////
	public int delete(int mediagroupno) {
		int cnt = 0;
		try {
			sql = new StringBuilder();
			sql.append(" DELETE FROM mediagroup ");
			sql.append(" WHERE mediagroupno = ? ");

			// SQL문 (INSETR, DELECT, UPDATE)
			cnt = jt.update(sql.toString(), mediagroupno);
		} catch (Exception e) {
			System.out.println("미디어그룹 삭제실패" + e);
		} // end
		return cnt;
	}// delete() end

////////////////목록 수정//////////////////
	public MediagroupDTO update(int mediagroupno) {
		MediagroupDTO dto = null;
		try {
			sql = new StringBuilder();

			sql.append(" SELECT mediagroupno, title ");
			sql.append("   FROM mediagroup ");
			sql.append("  WHERE mediagroupno = " + mediagroupno);

			RowMapper<MediagroupDTO> rowMapper = new RowMapper<MediagroupDTO>() {
				@Override
				public MediagroupDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					MediagroupDTO dto = new MediagroupDTO();
					dto.setMediagroupno(rs.getInt("mediagroupno"));
					dto.setTitle(rs.getString("title"));
					return dto;
				}// mapRow() emd
			};// rowMapper end

			dto = jt.queryForObject(sql.toString(), rowMapper);
		} catch (Exception e) {
			System.out.println("미디어그룹 목록 확인 실패" + e);
		} // end
		return dto;
	}// update() end

	
////////////////목록 수정 완료//////////////
	public int updateproc(MediagroupDTO dto) {
		int cnt = 0;
		try {
			sql = new StringBuilder();
			sql.append(" UPDATE mediagroup ");
			sql.append(" SET title = ? ");
			sql.append(" WHERE mediagroupno = ? ");

			// SQL문 (INSETR, DELECT, UPDATE)
			cnt = jt.update(sql.toString(), dto.getTitle(), dto.getMediagroupno());
		} catch (Exception e) {
			System.out.println("미디어그룹 수정실패" + e);
		} // end
		return cnt;
	}// delete() end
	
	
	
}// class end
