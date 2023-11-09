package kr.co.mymelon.media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Controller
@Repository
public class MediaDAO {

	@Autowired
	private JdbcTemplate jt;
	private StringBuilder sql = null;

	public MediaDAO() {
		System.out.println("MediaDAO()객체 생성됨");
	}// end

	public List<MediaDTO> list(int mediagroupno){
		List<MediaDTO> list = null;
		try {
			sql=new StringBuilder();
			sql.append(" select mediano, title, poster, poster, filename, filesize, mview, rdate, mediagroupno ");
			sql.append(" FROM media ");
			sql.append(" WHERE mview='Y' AND mediagroupno= " + mediagroupno);
			sql.append(" ORDER BY mediano DESC ");
		
			RowMapper<MediaDTO> rowMapper=new RowMapper<MediaDTO>() {
				
				@Override
				public MediaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					MediaDTO dto = new MediaDTO();
					dto.setMediano(rs.getInt("mediano"));
					dto.setTitle(rs.getString("title"));
					dto.setPoster(rs.getString("poster"));
					dto.setFilename(rs.getString("filename"));
					dto.setFilesize(rs.getLong("filesize"));
					dto.setMview(rs.getString("mview"));
					dto.setRdate(rs.getString("Rdate"));
					dto.setMediagroupno(rs.getInt("mediagroupno"));
					
					return dto;
				}//mapRow() end
			};//rowMapper

			list = jt.query(sql.toString(), rowMapper);

		} catch (Exception e) {
			System.out.println("media 목록살패:" + e);
		} // end
		return list;
	}// list() end

	
	///////음원 등록//////
	public int create(MediaDTO dto) {
		int cnt=0;
		try {
			sql=new StringBuilder();
			
			sql.append(" INSERT INTO media(mediano, title, poster, filename, filesize, mediagroupno, rdate) ");
			sql.append(" VALUES (media_seq.nextval, ?, ?, ?, ?, ?, sysdate) ");
			
			cnt=jt.update(sql.toString(), dto.getTitle(),dto.getPoster(), dto.getFilename(), dto.getFilesize(), dto.getMediagroupno());
			} catch (Exception e) {
			System.out.println("음원등록실패"+e);
		}//end
		return cnt;
	}// create() end
	
	
	
	//////// 상세보기////////
	public MediaDTO read(int mediano) {
		MediaDTO dto = null;
		try {
			sql=new StringBuilder();
			sql.append(" select mediano, title, poster, poster, filename, filesize, mview, rdate, mediagroupno ");
			sql.append(" FROM media ");
			sql.append(" WHERE mediano = " + mediano);
		
			RowMapper<MediaDTO> rowMapper=new RowMapper<MediaDTO>() {
				
			@Override
				public MediaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					MediaDTO dto = new MediaDTO();
					dto.setMediano(rs.getInt("mediano"));
					dto.setTitle(rs.getString("title"));
					dto.setPoster(rs.getString("poster"));
					dto.setFilename(rs.getString("filename"));
					dto.setFilesize(rs.getLong("filesize"));
					dto.setMview(rs.getString("mview"));
					dto.setRdate(rs.getString("Rdate"));
					dto.setMediagroupno(rs.getInt("mediagroupno"));
					return dto;

				}// mapRow() end
			};// rowMapper

		dto = jt.queryForObject(sql.toString(), rowMapper);

	} catch (Exception e) {
		System.out.println("media 목록살패:" + e);
	} // end
	return dto;
}// list() end
	
	
	

}// class end
