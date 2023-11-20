<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>datail.jsp</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="/js/jquery-3.7.1.min.js"></script>
	<link href="/css/main.css" rel="stylesheet" type="text/css">
</head>

<style>
	
</style>


<script type="text/javascript">
	
	function product_update() {
		document.productfrm.action="/product/update";
		document.productfrm.submit();
	}//product_update() end
	
	function product_delete() {
		//docment.productfrm은 본문의 <form name=productfrm>을 가리킴
		if(confirm("첨부된 파일은 영구히 삭제됩니다\n진행할까요?"))
		document.productfrm.action="/product/delete";
		document.productfrm.submit();
	}//product_delete() end
	
	function product_cart() {
		document.productfrm.action="/product/cart";
		document.productfrm.submit();
}//product_cart() end




</script>

<body>
<div class="p-5 bg-info text-white text-center">
  <h1>My Shop</h1>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link active" href="/product/list">상품</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="/cart/list">장바구니</a>
      </li>
    </ul>
  </div>
</nav>

<div class="container text-center">
  <!-- 본문 시작 -->
  
  <div class="row">
    <div class="col-sm-12">
    	<p><h3>상품목록</h3></p>
	    <p>
	        <button type="button" onclick="location.href='/product/list'" class="btn btn-primary">상품전체목록</button>
	    </p> 
    </div><!-- col end -->
  </div><!-- row end -->

  <div class="row">
    <div class="col-sm-12">
		 <form name="productfrm" id="productfrm" method="post" action="" enctype="multipart/form-data">
			<input type="hidden" name="product_code" value="${product.PRODUCT_CODE }">
		 	<table class="table table-hover">
			    <tbody style="text-align: left;">
				    <tr>
						<td>상품명</td>
						<td> <input type="text" name="product_name" class="form-control" value="${product.PRODUCT_NAME}" > </td>
				    </tr>
				    <tr>
						<td>상품가격</td>
						<td> <input type="number" name="price" class="form-control" value="${product.PRICE}"> </td>
				    </tr>
				    <tr>
						<td>상품설명</td>
						<td> 
						    <textarea rows="5" cols="60" name="description" class="form-control">${product.DESCRIPTION }</textarea>     
						 </td>
				    </tr>
				    <tr>
						<td>상품사진</td>
						<td>
							<c:if test="${product.FILENAME != '-' }">
								<img src="/storage/${product.FILENAME }" width="100px">
							</c:if>
							<input type="file" name="img" class="form-control">
						</td>
					</tr>
				    <tr>
						<td colspan="2" align="center">
						    <input type="submit" value="상품수정" 		class="btn btn-success"  onclick="product_update() " style="background-color:red" value="${product.PRODUCT_CODE}"> 
						    <input type="button" value="상품삭제"		class="btn btn-success"  onclick="product_delete() "> 
						    <input type="button" value="장바구니담기" 	class="btn btn-success"  onclick="product_cart()   " style="background-color:blue;"> 
						</td>
				    </tr>   
			    </tbody> 
		    </table>
		 </form>
    </div><!-- col end -->
  </div><!-- row end -->

    <!-- 댓글시작 -->
    	<div class="row">
  	  		<div class="col=sm=12"><!-- 댓글등록 -->
  	  			<form name="commentInsertForm" id="commentInsertForm">
  	  				<!-- 부모글번호 -->
  	  				<input type="hidden" name="product_code" id="product_code" value="${product.PRODUCT_CODE }">
  	  				<table class="table table-borderless">
					<tr>
						<td>
							<input type="text" name="content" id="content" placeholder="댓글 내용 입력해 주세요" class="form-control">
						</td>
						<td>
							<button type="button"  name="commentInsertBtn" id="commentInsertBtn" class="btn btn-secondary">댓글등록</button>
						</td>
					</table>
  	  			</form>
			</div><!-- col end -->
		</div><!-- row end -->
    
		<div class="row">
			<div class="col=sm=12"><!-- 댓글 목록 -->
				<div class="commetnList"></div>
			</div><!-- col end -->
		</div><!-- row end -->
	<!-- 댓글 끝 -->

<!-- 댓글 관련 자바 스크립트 -->    
<script>
	let product_code = '${product.PRODUCT_CODE }';//부모글 번호
	
	//댓글 등록 버튼을 클릭했을때
	$("#commentInsertBtn").click(function() {
		
		// alert($);
		let content = $("#content").val();
		content = content.trim();
		if(content.length==0){
			alert("댓글 내용 입력해 주세요~");
			$("#content").focus();
		}else{
			//<form id="commentInsertForm"></form>안의 컨트롤요소 전부 가져오기
			let insertData = $("#commentInsertForm").serialize();
			//alert(insertData);
			commentInsert(insertData);//댓글등록 함수 호출
		}//if end
	});//click() end

	// 댓글 등록 함수
	function commentInsert(insertData){
		//alert("댓글등록 함수 호출:" + insertData);
		$.ajax({
			 url     : '/comment/insert'	//요청명령어
			 ,type   : 'post'				//요청방식
			 ,data   : insertData			//전달값
			 ,error  : function(error){			//에러시 호출값
				alert(error);
			 }//error end					
			 ,success: function(data){			//성공시 호출값
				alert(data);
			 }//success	end	
		})//ajax() end
	};// commentInsert() end 
	
</script>
    
    
    
    
  <!-- 본문 끝 -->
</div><!-- container end -->

<div class="mt-5 p-4 bg-dark text-white text-center">
  <p>ITWILL 아이티윌 교육센터</p>
</div>


	<!-- 	 
	결과확인 http://localhost:9095
	또는 http://localhost:9095/product/list 
	-->
</body>
</html>
    