<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ajaxtest02</title>
	<script src="../js/code.jquery.com_jquery-3.7.1.min.js"></script>
	<script src="../js/jquery.cookie.js"></script>
</head>

<body>

	<h3>* $.ajax() 서버에서 응답받기 *</h3>

	<button id="btn">* 서버에서 응답받기 *</button>
	<div id="panel"></div>
	 
	<script>
/* 		1//)$.ajax() 함수
		// 형식) $.ajax({name:value, name:value, name:value, ~~~})
		$("#btn").click(function () {
			$.ajax({
				url 	 : "message.do"	//요청명령어
			   ,type 	 : "get"		//get방식
			   ,dataType : "text"		//응답메세지 타입
			   ,error	 : function(error){
					alert("에러:" + error);
			   } //error callback 함수
			   ,success	 : function(result){
					//alert("성공:" + result);
					$("#panel").empty();
					$("#panel").append(result + "<br>");
					//$("#panel").text(result + "<br>");
					//$("#panel").html(result + "<br>");
					
			   }//success callback 함수
			})//ajax() end
		});//click end
		
		 */
		
			
		//2) $.get() 방식
		// AJAX를 GET 방식으로 요청하는 함수
		// 형식 $.get("요청명령어", callback함수)
		$("#btn").click(function () {
			$.get("message2.do", responseproc);
		})//click end
		
		function responseproc(result){
			$("#panel").append(result);			
		}//responseproc() end
		
		
		
		
		
		
	</script>
</body>
</html>
