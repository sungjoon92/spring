<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!-- 본문 시작 -->


<div class="row">
	<div class="col-sm-12">
		<p><h3 style="">문의사항</h3></p>
		<p>
			<button type="button" onclick="location.href='write'"
				class="btn btn-success">글쓰기</button>
			<button type="button" onclick="location.href='list'"
				class="btn btn-primary">글목록</button>
		</p>
	</div><!-- col end -->
</div><!-- row end -->

<!-- 검색 -->
<div class="row">
	<div class="col-sm-12">
		<!-- 검색 -->
		<form method="get" action="search">
			<p>
			 글 검색 : <input type="text" name="product_name"> <input
					type="submit" value="검색" class="btn">
			</p>
		</form>
	</div><!-- col end -->
</div><!-- row end -->


	<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>
