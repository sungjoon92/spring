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
	<title>list.jsp</title>
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
	<div class="title">음원 목록</div>

	<div class="content">
		<input type="button" value="음원등록"
			onclick="location.href='create.do?mediagroupno=${mediagroupno}'">
		<input type="button" value="HOME" onclick="location.href='/home.do'">
		<!-- 절대경로 -->
	</div>

	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>등록일</th>
			<th>음원파일명</th>
			<th>수정/삭제</th>
		</tr>


		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.mediano}</td>
				<td><a href="read.do?mediano=${dto.mediano }">${dto.title}</a></td>
				<td>${dto.rdate}</td>
				<td>
					${dto.filename}<br>
					${dto.filesize}<br>
					<c:set var="filesize" value="${fn:substringBefore(dto.filesize/1024, '.') }"></c:set>
					${filesize }KB
				</td>

				<td>
					<input type="button" value="수정"> 
					<input type="button" value="삭제">
				</td>
			</tr>

		</c:forEach>
	</table>

</body>
</html>