<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>계산결과</h3>
	
	<h3>JSP</h3>
	<%=request.getAttribute("message") %>       <br>
	숫자1 : <%=request.getAttribute("no1") %>    <br>
	숫자2 : <%=request.getAttribute("no2") %>    <br>
	결과 : <%=request.getAttribute("result") %>  <br>
	<%=request.getAttribute("img") %>           <br>
	
	<h3>EL</h3>
	${message }
	${no1 }  ${no2 } = ${result }<br>
	${img} 

	<h3>EL</h3>
	${message }
	${no1 }  ${no2 } = ${result }<br>
	${img == null ? "" : img} 
</body>
</html>