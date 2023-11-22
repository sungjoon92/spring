<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<!-- 본문 시작 -->

<script>



function cartDelete(cartno) {
	//alert("댓글삭제" + cno);
	//alert(cartno);
	if(confirm("첨부된 파일은 영구히 삭제됩니다\n진행할까요?")){
	$.ajax({
			url : '/cart/delete/' + cartno 	//RESTful방식으로 웹 서비스요청. 예)/comment/delete/5
			,type :'post'
			//,data:{'cno':cno}
			,success:function(result){
				if(result==1){
					location.reload();
				}else{
					alert("댓글삭제실패:로그인후 사용이 가능합니다");
				}//if end
				alert("댓글이 삭제되었습니다")
			}//success end
			
	});//ajax() end
	}//if end
}//commentDelete() end

</script>

<div class="row">
	<div class="col-sm-12">
		<table class="table table-hover">
			<thead class="table=success">
				<th>아이디</th>
				<th>번호</th>
				<th>상품코드</th>
				<th>단가</th>
				<th>상품수량</th>
				<th>가격</th>
				<th>삭제</th>
			</thead>
			<tbody>
				<form name="cartfrm" id="cartfrm" method="post" enctype="multipart/form-data">
					<input type="hidden" name="cartno" value="${cart.CARTNO }">
					<c:forEach items="${list }" var="row">
						<tr>
							<td>${row.id }</td>
							<td>${row.cartno }</td>
							<td>${row.product_code }</td>
							<td>${row.price }</td>
							<td>${row.qty }</td>
							<td>${row.price*row.qty }</td>
							<td><input type="button" value="삭제"
								onclick="return cartDelete(${row.cartno })"></td>
						</tr>
					</c:forEach>
				</form>
			</tbody>
		</table>
	</div>
	<!-- col end -->
</div>
<!-- row end -->


<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>