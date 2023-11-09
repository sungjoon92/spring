package kr.co.mymelon.media;

import org.springframework.web.multipart.MultipartFile;

public class MediaDTO {
	private int mediano; // NUMBER NOT NULL PRIMARY KEY, -- 미디어 번호
	private String title; // VARCHAR2(255) NOT NULL, -- 제목
	private String poster; // VARCHAR2(255) DEFAULT 'poster.jpg' NOT NULL, -- 포스터 이미지
	private String filename; // VARCHAR2(255) NOT NULL, -- 음원 파일명
	private long filesize; // NUMBER DEFAULT 0 NOT NULL,
	private String mview; // CHAR(1) DEFAULT 'Y' NOT NULL, -- 출력모드
	private String rdate; // DATE NOT NULL, -- 등록일
	private int mediagroupno;// NUMBER NULL

	// lombok.jar 라이브러리 활용시
	// DTO getter, setter를 작성하지않아도
	// @getter, @setter 어노테이션으로 사용 가능하다
	public MediaDTO() {}

	////////////////////////////////
	// 첨부된 파일을 저장하기 위해 (createForm.jsp참조)
	// <input type='file' name='posterMF'>
	private MultipartFile posterMF;
	// <input type='file' name='filenameMF'>
	private MultipartFile filenameMF;

	//2)getter와 setter함수 작성
	
	public MultipartFile getPosterMF() {
		return posterMF;
	}

	public void setPosterMF(MultipartFile posterMF) {
		this.posterMF = posterMF;
	}

	public MultipartFile getFilenameMF() {
		return filenameMF;
	}

	public void setFilenameMF(MultipartFile filenameMF) {
		this.filenameMF = filenameMF;
	}

	////////////////////////////////

	public int getMediano() {
		return mediano;
	}

	public void setMediano(int mediano) {
		this.mediano = mediano;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

	public String getMview() {
		return mview;
	}

	public void setMview(String mview) {
		this.mview = mview;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getMediagroupno() {
		return mediagroupno;
	}

	public void setMediagroupno(int mediagroupno) {
		this.mediagroupno = mediagroupno;
	}

	@Override
	public String toString() {
		return "MediaDTO [mediano=" + mediano + ", title=" + title + ", poster=" + poster + ", filename=" + filename
				+ ", filesize=" + filesize + ", mview=" + mview + ", rdate=" + rdate + ", mediagroupno=" + mediagroupno
				+ ", posterMF=" + posterMF + ", filenameMF=" + filenameMF + "]";
	}

}// MediaDTO end
