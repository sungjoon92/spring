<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
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
</style>

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
					<p style="border:5px solid black; padding:2px; border-radius:20px; ">
						상품명	 : <input type="text" name="product_name">
						   <input type="submit" value="검색" class="btn">
					</p>
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
<%@ include file="../footer.jsp" %>
//http://localhost:9095