<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idChack.jsp</title>
	<script src="../js/code.jquery.com_jquery-3.7.1.min.js"></script>
	<script src="../js/jquery.cookie.js"></script>
</head>

<body>

	<h3>회원등록폼</h3>

	<form>
		<table border="1" width="400px">
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" id="userid" placeholder="id를 입력해주세요" style="color:gray"> 
					<input type="button" value="아이디중복확인" id="btn_userid">
					<br>
					<div id="panel" style="display: none"></div>
				</td>
			</tr>
		</table>
	</form>


	<script>
		$("#btn_userid").click(function() {
			//alert();
			$.post("idcheckproc.do"   				//요청 명령어
			,"userid=" + $("#userid").val().trim()	//전달값(변수=값& 변수=값)
			,responseProc              				//콜백함수
			);                         
		
		})//click end
		
		function responseProc(result) {
			//alert(result);
			$("#panel").empty();
			$("#panel").html(result);
			$("#panel").show();
			
		}//responseProc() end
	</script>
</body>
</html>
