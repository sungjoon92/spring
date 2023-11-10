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
	<title>readMP4.jsp</title>
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
	<div class="title">mp4 듣기</div>
	
	<div class="content">
		<p>${dto.title }</p>
		<video src="../storage/${dto.filename }" poster="..storage/${dto.poster }" width="300" controls ></video>
	</div>
</body>
</html>