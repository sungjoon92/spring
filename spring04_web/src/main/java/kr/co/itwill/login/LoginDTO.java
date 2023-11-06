package kr.co.itwill.login;

public class LoginDTO { // Date Transfer Object

	private String id;
	private String pw;
	
	//기본 생성자 함수
	public  LoginDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "BbsDTO [id=" + id + ", pw=" + pw + "]";
	}

	
	
}// class end
