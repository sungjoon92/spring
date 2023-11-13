<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookTest.jsp</title>
	<script src="../js/code.jquery.com_jquery-3.7.1.min.js"></script>
	<script src="../js/jquery.cookie.js"></script>
</head>

<body>


	<h3>교재 검색</h3>

	<form name="search" id="search" action="">
		<input type="text" name="keyword" id="keyword">
		<input type="button" value="검색">
	</form>
	 
	<!-- 검색 결과 출력 -->
	
	<div id="panel" style="display:none;"></div>
	<div id="display"></div>
	
	<script>
		$("#keyword").keyup(function() {
			//alert("test");
			
			if($("#keyword").val()==""){
			$("#panel").hide();		//검색어가 존재하지않으면 출력어를 숨긴다
		}//if endS
	
		//1) id="keyword" 값 가져오기
			//let params = $("#keyword").val();
			//alert(params);

			//2) <form id="search"></form>
			//폼안의 모든 컨트롤 요소를 가져오기
			let params = $("#search").serialize();
			//alert(params); //keyword = java

			$.post("searchproc.do", params, responseProc);
		})//keyup() end

		function responseProc(data) {
		}//responseProc() end
	</script>
</body>
</html>
