<%@page import="kr.co.itwill.bbs.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>bbsResult2.jsp</title>
</head>
<body>

	<h3>* 글쓰기 결과 *</h3>


	1) JSP<br>
<%
	BbsDTO bdto = (BbsDTO)request.getAttribute("dto");
	out.println("작성자 : " + bdto.getWname() + "<br>");
	out.println("제목	  : " + bdto.getSubject() + "<br>");
	out.println("내용  : " + bdto.getContent() + "<br>");
	out.println("비번  : " + bdto.getPasswd() + "<br>");
%>
	<hr>
	
	
	2)EL<br>
	작성자 	: ${dto.wname }		<br>
	제목	 	: ${dto.subject }	<br>
	내용	 	: ${dto.content }	<br>
	비밀번호 	: ${dto.passwd }	<br>
         


</body>
</html>