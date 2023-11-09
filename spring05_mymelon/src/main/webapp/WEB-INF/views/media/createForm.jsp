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
	function mediachack() {
		let title = document.getElementsByName("title").value;
		let form = document.getElementsByName("frm").value;
		
		if(title == null && title.length >= 1){
			form return false;
			alert("제목을 1글자 이상 작성해주세요!");
		}else{
			form return true;
		}//if end
	}//mediachack() end
</script>

<body>

	<!-- //http://localhost:9095/home.do -->
	<div class="title">음원 등록</div>
	
	<form name="frm" method="post" action="create.do"
		enctype="multipart/form-data" onsubmit="return mediachack()">
		<input type="hidden" name="mediagroupno" value="${mediagroupno }">

		<table>
			<tr>
				<th>제목</th>
				<td><input type='text' name='title' size='50'></td>
			</tr>
			<tr>
				<th>포스터</th>
				<td><input type='file' name='posterMF' size='50'></td>
			</tr>
			<tr>
				<th>미디어 파일</th>
				<td><input type='file' name='filenameMF' size='50'></td>
			</tr>
			
		</table>
		
		<div class="bottom">
			<input type="submit" value="음원등록">
			<input type="button" value="음원목록" onclick="location.href='list.do?mediagroupno=${mediagroupno}'">
			<input type="button" value="HOME" onclick="location.href='/home.do'"><!-- 절대경로 -->
		</div>
		
		
	</form>
</body>
</html>