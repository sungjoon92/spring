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
	<div class="title">미디어 그룹 목록</div>



	<div class="content">
		<input type="button" value="그룹등록" onclick="location.href='create.do'">
	</div>

	<c:if test="${count==0 }"></c:if>

	<c:if test="${ count>0}">
		<table>
			<tr>
				<th>번호</th>
				<th>그룹번호</th>
				<th>그룹제목</th>
				<th>수정/삭제</th>
			</tr>
			<!-- ${list}는 MediagroupCont클래스의 list()함수에서 mav.addObject("list")를 가리킴 -->
			<c:forEach items="${list }" var="dto" varStatus="vs">
				<tr>
					<td>${vs.count}</td>
					<td>${dto.mediagroupno }</td>
					<td><a href="../media/list.do?mediagroupno=${dto.mediagroupno}">${dto.title}</a></td>
					
					<td>
						<input type="button" value="수정" onclick="location.href='update.do?mediagroupno=${dto.mediagroupno}'"> 
						<input type="button" value="삭제" onclick="location.href='delete.do?mediagroupno=${dto.mediagroupno}'">
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>







</body>
</html>