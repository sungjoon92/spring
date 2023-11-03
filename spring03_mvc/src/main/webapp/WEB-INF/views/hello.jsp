<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>hello.jsp</title>
</head>
<body>

	<h3>안녕하세요</h3>

	<!-- java에서 mav.addObject("message","<p>환영합니다</p>");  -->
	<!-- 의 request 호출 -->
	${requestScope.message } ${message }

</body>
</html>