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
<title>updateForm.jsp</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>

<style>
* {
	font-family: gulim;
	font-size: 24px;
}
</style>

<body>
	<!-- //http://localhost:9095/home.do -->
	<div class="title">미디어 그룹 수정</div>
	
	<form action="updateproc.do" method="post" name="frm">
		<input type="hidden" name="mediagroupno" value="${dto.mediagroupno }">
		<table class="table">
			<tr>
				<th>미디어 그룹 제목</th>
				<td><input type="text" name="title" size="50"
					value="${dto.title }"></td>
			</tr>
		</table>

		<div class="bottom">
			<input type="submit" value="등록">
			<input type="button"value="목록" onclick="location.href='list.do'">
		</div>
	</form>





</body>
</html>