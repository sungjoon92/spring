<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>bbsResult.jsp</title>
</head>
<body>

	<h3>* 글쓰기 결과 *</h3>


	1) JSP
	작성자 	: <%=request.getAttribute("wname") %>	<br>
	제목	 	: <%=request.getAttribute("subject") %>	<br>
	내용	 	: <%=request.getAttribute("content") %>	<br>
	비밀번호 	: <%=request.getAttribute("passwd") %>	<br>
	
	<hr>
	
	
	2)EL
	작성자 	: ${wname }		<br>
	제목	 	: ${subject }	<br>
	내용	 	: ${content }	<br>
	비밀번호 	: ${passwd }	<br>
         


</body>
</html>