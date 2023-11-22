<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
		rel="stylesheet">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="/js/jquery-3.7.1.min.js"></script>
	<link href="/css/main.css" rel="stylesheet" type="text/css">
</head>


<style>
.col-sm-12 {
	width:100%;
	display: flex;
	flex-direction: column;
	align-items: center;
	flex-wrap: wrap;
}

.container {
	width: 100%;
	display: flex;
	align-items: center;
	flex-wrap: wrap;
	justify-content: space-between;
	text-align: center;
}

.item {
	width: 15%;
	height: 30%;
}
 img {
	width: 100%;
	height: 100%;
}

div {
	margin: 0;
	padding: 0;
}
@media screen and (max-width:900px) {
	.item {
	width: 30%;
	}
}
@media screen and (max-width:700px) {
	.item {
	width: 50%;
	}
}
@media screen and (max-width:500px) {
	.item {
	width: 100%;
	}
}

h1{
	cursor: pointer;
}

</style>


<body>

	<div class="p-5 bg-info text-white text-center">
		<h1 onclick="javascript.href='http://localhost:9095/product/list'">My Shop</h1>
	</div>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active"
					href="/product/list">상품</a></li>
				<li class="nav-item"><a class="nav-link active"
					href="/cart/list">장바구니</a></li>
			</ul>
		</div>
	</nav>

	<div class="">
		<!-- 본문 시작 -->

		<div class="row">
			<div class="col-sm-12">
				<p>
				<h3 style="corsur">상품목록</h3>
				</p>
				<p>
					<button type="button" onclick="location.href='write'"
						class="btn btn-success">상품등록</button>
					<button type="button" onclick="location.href='list'"
						class="btn btn-primary">상품전체목록</button>
				</p>
			</div>
			<!-- col end -->
		</div>
		<!-- row end -->

		<div class="row">
			<div class="col-sm-12">
				<!-- 검색 -->
				<form method="get" action="search">
					상품명	 : <input type="text" name="product_name">
					상품명	 : <input type="submit" value="검색" class="btn">
				</form>
				
			</div>
			<!-- col end -->
		</div>
		<!-- row end -->
		<div class="row">
			<div class="">
				<!-- varStatus="상태용 변수" -->
				<div class="container">
					
						<c:forEach items="${list }" var="row" varStatus="vs">
							<div class="item">
								<c:choose>
									<c:when test="${row.FILENAME != '-'}">
										<a href="detail/${row.PRODUCT_CODE}"> 
											<img alt="" src="/storage/${row.FILENAME }">
										</a>
									</c:when>
								
								<c:otherwise>
									등록된 사진 없음!!<br>
								</c:otherwise>
								
								</c:choose>
								<div>
									상품명 : <a href="detail/${row.PRODUCT_CODE}"> ${row.PRODUCT_NAME }</a>
								</div>
								<div>
									상품가격 :
									<fmt:formatNumber value="${row.PRICE }" pattern="#,###"></fmt:formatNumber>
								</div>
							</div>
						</c:forEach>
				</div>
				<!-- col end -->
			</div>
			<!-- row end -->
			<!-- 본문 끝 -->
		</div>
		<!-- container end -->
		<div class="mt-5 p-4 bg-dark text-white text-center">
			<p>ITWILL 아이티윌 교육센터</p>
		</div>
</body>
</html>
