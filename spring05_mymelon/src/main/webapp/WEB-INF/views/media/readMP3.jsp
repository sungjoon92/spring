<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script src="/js/code.jquery.com_jquery-3.7.1.min.js"></script>
<script src="/js/js.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>readMP3.jsp</title>
	<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>

<style>
* {
	font-family: gulim;
	font-size: 24px;
}
</style>

<script>
	
</script>

<body>

	<!-- //http://localhost:9095/home.do -->
	<div class="title">mp3 듣기</div>
	
	<div class="content">
		<p>${dto.title }</p>
		<audio src="../storage/${dto.filename }" controls></audio> 		
	</div>



</body>
</html>