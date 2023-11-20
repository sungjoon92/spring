package kr.co.itwill.comment;

public class CommentDTO {

	private int cno; 			// number primary key --댓글번호
	private int product_code;	// number not null --부모글번호
	private String content; 	// varchar2(255) not null --댓글내용
	private String wname;	 	// varchar2(100) not null --작성자
	private String regdate; 	// date default sysdate --작성일

	public CommentDTO() {
		System.out.println("CommentDTO() 객체 생성됨");
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getProduct_code() {
		return product_code;
	}

	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "CommentDTO [cno=" + cno + ", product_code=" + product_code + ", content=" + content + ", wname=" + wname
				+ ", regdate=" + regdate + "]";
	}

}// commetnDTO class end
