<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>media.jsp</title>
</head>
<body>
	<div style="text-align: center;">
		<h3>음악목록</h3>
		<img src="/music/gangnamstyle.jpg" alt="강남스타일" id="poster"
			width="300px" height="250px"> <br> <br>
		<audio src="/music/gangnamstyle.mp3" id="audio1" controls></audio>
	</div>

	<hr>

	<div style="margin: auto; width: 50%;">
		<ol>
			<li><a href="javascript:loadMusic('/music/genie.jpg', '/music/genie.mp3')">소원을말해봐</a></li>
			<li><a href="javascript:loadMusic('/music/sheis.jpg', '/music/sheis.mp3')">그녀가처음 울던 날</a></li>
			<li><a href="javascript:loadMusic('/music/candy.jpg', '/music/candy.mp3')">내귀에 캔디</a></li>
			<li><a href="javascript:loadMusic('/music/gangnamstyle.jpg', '/music/gangnamstyle.mp3')">강남스타일</a></li>
		</ol>
	</div>

	<script>
		function loadMusic(jpg, mp3) {
			// alert(jpg,mp3)

			let poster = document.getElementById("poster");
			let audio1 = document.getElementById("audio1");

			// alert(poster);
			// alert(audio1);

			// console.log(poster);
			// console.log(audio1);

			poster.src = jpg;
			audio1.src = mp3;
			poster.style.cssText = "opacity:70%; height:350px"
			audio1.style.cssText = "opacity:70%; "

			audio1.play();

		}//loadMusic() end
	</script>




</body>
</html>