<%@page import="kr.co.itwill.login.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginResult.jsp</title>
</head>
<body>
	<h3>* 로그인 결과 *</h3>



	1) JSP
	
	<table border="1">
		<tr>
			<%
			request.getAttribute("message");
			out.println("<td>" + "아이디 : " + session.getAttribute("s_id") + "</td>");
			out.println("<td>" + "비번	 : " + session.getAttribute("s_pw") + "</td>");
			
			%>
		</tr>
	</table>
	<hr>

	2)EL
	<br> ${message }
	<br> 아이디 : ${s_id }
	<br> 비밀번호 : ${s_pw }
	<br>


</body>
</html>