<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<!-- 본문 시작 -->

<style>
#crattr {
	line-height: 100px;
 }
#crattr td input{
	width: 50px;
	height: 40px;
	line-height: 40px;
	margin: 0;
	padding:0;
}
</style>


<script>


//장바구니 삭제
/* function cartDelete(cartno) {
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
				//alert("댓글이 삭제되었습니다")
			}//success end
			
	});//ajax() end
	}//if end
}//commentDelete() end */

function cartDelete(cartno){
    if(confirm("해당 상품을 삭제할까요?")){
       //또다른 방법<form action='/cart/delete'></form>
       //또다른 방법(RESTful) location.href='/cart/delete' + cartno;
    	   location.href = '/cart/delete?cartno=' + cartno;
    }//if end
 }//cartDelete() end

 
 
 function order() {
	 if(confirm("주문하시겠습니까?")){
	    	   location.href = '/order/orderform';
	    }//if end
}//order() end

</script>

<div class="row">
	<div class="col-sm-12">
		<table class="table table-hover">
			<thead class="table=success">
				<th>아이디</th>
				<th>이미지</th>
				<th>상품명</th>
				<th>단가</th>
				<th>상품수량</th>
				<th>가격</th>
				<th>삭제</th>
			</thead>
			<tbody>
				<form name="cartfrm" id="cartfrm" method="post" enctype="multipart/form-data">
					<input type="hidden" name="cartno" value="${cart.CARTNO }">
					<c:forEach items="${list }" var="row">
						<tr id="crattr">
							<td>${row.ID }</td>
							<td style="width:100px; height:100px"><img style="width:100%; height:100%;" src="/storage/${row.FILENAME}"></td>
							<td>${row.PRODUCT_NAME }</td>
							<td>${row.PRICE }</td>
							<td>${row.QTY }</td>
							<td>${row.PRICE*row.QTY }</td>
							<td>
								<input  type="button" value="삭제" onclick="return cartDelete(${row.CARTNO })">
							</td>
						</tr>
					</c:forEach>
				</form>
			</tbody>
		</table>
		
		<br>
		
		<input type="button" value="계속쇼핑하기" onclick="location.href='/product/list'">
		<input type="button" value="주문하기" onclick="order()">		
	</div>
	<!-- col end -->
</div>
<!-- row end -->


<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>