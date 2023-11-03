<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>start.jsp</title>
</head>
<body>

	<h3>환영합니다</h3>

	<!-- java에서 mav.addObject("message","<p>찎찌찎찎찎</p>"); -->
	<!-- java에서 mav.addObject("name","값"); -->
	<!-- 의 request 호출 -->
	${requestScope.message } 
	<br>
	${img }

</body>
</html>