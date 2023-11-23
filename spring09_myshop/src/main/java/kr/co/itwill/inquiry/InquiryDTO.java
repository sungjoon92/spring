package kr.co.itwill.inquiry;

public class InquiryDTO {
	 private int 	inquiryno;  //number           not null  -- 일련번호
	 private String wname;    	//varchar2(20)     not null  -- 작성자
	 private String subject;    //varchar2(255)    not null  -- 제목
	 private String content;    //varchar2(4000)   not null  -- 내용
	 private String regdt;      //date   		   default   sysdate    -- 작성일
	 private int 	readcnt;  	//number(5)        default   0 not null -- 글조회수
	 private String passwd;  	//varchar2(10)     not null  -- 글비밀번호
//	 private  primary 	key(inquiryno)      -- inquiryno 기본키
	 
	 
	
	 
	 
	 
	 
	 
}// commetnDTO class end
