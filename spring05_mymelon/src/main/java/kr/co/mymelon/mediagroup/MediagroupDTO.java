package kr.co.mymelon.mediagroup;

public class MediagroupDTO {

	private int mediagroupno; // NUMBER NOT NULL PRIMARY KEY, -- 그룹번호
	private String title; // VARCHAR2(255) NOT NULL -- 그룹제목

	public int getMediagroupno() {
		return mediagroupno;
	}

	public MediagroupDTO() {
	};

	public void setMediagroupno(int mediagroupno) {
		this.mediagroupno = mediagroupno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "MediagroupDTO [mediagroupno=" + mediagroupno + ", title=" + title + "]";
	}

}// class end
