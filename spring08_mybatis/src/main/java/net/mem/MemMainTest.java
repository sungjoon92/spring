package net.mem;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class MemMainTest {

	public static void main(String[] args) {

		try {
			// factory 공장
			// 어떤 특정 정보를 주면 객체로 생성해 줌
			// 객체 생성 : new 연산자 (POJO방식), Bean

			// 1) DB연결 환경 설정 파일 가져오기
			String resource = "config/jdbc.xml";
			InputStream is = Resources.getResourceAsStream(resource);

			// 2) DB연결하기 위한 팩토리빈(factory bean) 생성
			// DBOpen + DAT
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
			System.out.println("db연결 성공!");

			// 3) 쿼리문 생성 및 변환
			// PreparedStatement와 비슷한 기능
			SqlSession sql = ssf.openSession(true); // autocommit 처리
////////////////////////////////////////

			// 행추가
			int result = sql.insert("mem.insertRow", new MemDTO("까까", 11));
//			System.out.println("행추가 결과: "+ result);

			// 행수정
//			// num =6행의 이름과 나이를 수정하기
//			int result = sql.update("mem.updateRow", new MemDTO(21,"고구마", 20));
//			System.out.println("행수정 결괴: " +result);

			// 행삭제
//			// num =6행의 이름과 나이를 수정하기
//			int result = sql.delete("mem.deleteRow", 35);
//			System.out.println("행삭제 결괴: " + result);

			// 전체 목록
//			List<MemDTO> list = sql.selectList("mem.selectAll");
//			for (int i = 0; i < list.size(); i++) {
//				MemDTO dto = list.get(i);
//				System.out.print(dto.getNum() + " ");
//				System.out.print(dto.getName() + " ");
//				System.out.print(dto.getAge() + " ");
//				System.out.println();
//			} // for end
///////////////////////////////////////////////////////////

//			List<MemDTO> list = sql.selectList("mem.search", "아");
//			for (int i = 0; i < list.size(); i++) {
//				MemDTO dto = list.get(i);
//				System.out.print(dto.getNum() + " ");
//				System.out.print(dto.getName() + " ");
//				System.out.print(dto.getAge() + " ");
//				System.out.println();
//			} // for end

			// 상세보기
//			// num =6 행 상세보기
//			MemDTO dto = sql.selectOne("mem.selectRead", 81);
//				System.out.print(dto.getNum() + " ");
//				System.out.print(dto.getName() + " ");
//				System.out.print(dto.getAge() + " ");
//				System.out.println();
//			

			// 전체 행 갯수
			System.out.println("현재 행 갯수 : " + sql.selectOne("mem.rowCount"));

		} catch (Exception e) {
			System.out.println("실패: " + e);
		} // end

	}// main end

}// MemMainTest() end
