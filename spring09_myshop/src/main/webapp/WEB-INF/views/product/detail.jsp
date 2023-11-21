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

	*{
		margin: 0;
		padding: 0;
	}
	 #loader {
        width: 100%;
        height: 50%;
        background-color: #ede9df;
        position: fixed;
        left: 0;
        bottom: 0;
        background-image: url(./loader.gif);
        background-repeat: no-repeat;
        background-position: center;
		display: none;
    } 

	
	.commentArea tr{
		display:flex;
		justify-content: space-between;
	}
	.commentArea td{
		font-size: 20px;
		text-align: left;
	}
	
	.commentArea a{
		width: 100%;
		border: 1px solid #000;
		border-radius: 10px;
		padding: 0 3%;
		text-align: center;
	}
	.content_text{
		text-align: left;
		width: 100%;
		float: right;
	}
	.button{
		float: right;
		width: 5%;
		font-size: 20px;
	
	}	


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
  <!-- 로딩 이미지 -->
  <div id="loader"></div>
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
				<div class="commentList" >
				</div>
			</div><!-- col end -->
		</div><!-- row end -->
	<!-- 댓글 끝 -->



<!-- 댓글 관련 자바 스크립트 -->    
<script>

	let product_code = '${product.PRODUCT_CODE }';//부모글 번호
	$(function() {
		commentList();
		
	})//end
	
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
			 ,error  : function(error){		//에러시 호출값
				alert(error);
			 }//error end					
			 ,success: function(result){		//성공시 호출값
				 //alert(result); object
				 if(result == 1){ //댓글 등록 성공
					 commentList();//댓글 등록후 댓글목록 함수 호출
					 $("#content").val("");//기존 댓글 내용을 빈 문자열로 대입(초기화)
				 }else{
				 }//if end
			 }//success	end	
		})//ajax() end
	};// commentInsert() end 
	
	
	//댁글 조회 함수
	function commentList() {
		//alert("댓글목록 함수 호출");
		$.ajax({
				url		: '/comment/list'
				,type	: 'get'
				,data	: {"product_code" : product_code}//부모글 번호 (전역변수로 선언되어있음)
				,error	: function(error){
					alert(error);
					//console.log(error);
				}//error end
				,success: function(result){
					//alert(result);
					//console.log(result);
					let a="";
					$.each(result, function(key, value) {
						//console.log(key); 	//순서 0 1 2 3
						//console.log(value);	//[object object]
						// console.log(value.cno)
						// console.log(value.content)
						// console.log(value.product_code)
						// console.log(value.wname)
						// console.log(value.regdate)
						
						
						
				        // a += '댓글번호:' + value.cno +' / 작성자:' + value.wname  + '' +  value.regdate;
				        // a += '<p>내용:' + value.content + '</p>';

			            a += "<table class='commentArea' style='border-bottom:1px solid darkgray; margin-bottom:15px; width:100%;'>";
			            a += "	<tbody class='commentInfo" + value.cno + "'>";
			            a += "		<tr>";
		                a += "  		<td>댓글번호 : "+ value.cno 	 + "</td>";
		                a += "   		<td>작성자 : "  + value.wname	 + "</td>";
		                a += "  		<td>" 		    + value.regdate  + "</td>";
						a += "		</tr>";
						a += "		<tr>";
						a += " 			<td class='commentContent" + value.cno + "'></td>"
		                a += "   		<td class='content_text'>내용 : " + value.content + "</td>";
					 // a += '   		<td><a href="javascript:commentUpdate(' + value.cno +',\'' + value.content + '\')">수정</a></td>';
						a += " 			<td class='button'><a href='javascript:commentUpdate("+ value.cno + ",\"" + value.content + "\")'>수정</a></td>";
						a += " 			<td class='button'><a href='javascript:commentDelete("+ value.cno + ")'>삭제</a></td>";
		                a += "		</tr>";
		                a += "	</tbody>";
		                a += "</table>";
					});//each() end
					$(".commentList").html(a);
				}//success end
			});//ajax() end
	}//commentList() end
	

	//댓글 수정 - 전달받은 댓글내용을 <input type=text>에 출력
	function commentUpdate(cno, content){
		//alert(cno+content);

	  let a ="";
      a += "<div class='input-group'>";
      a += "   <input type='text' value='" + content +"' id='content_"+ cno +"'>";
      a += "   <button type='button' onclick='commentUpdateProc("+ cno +")'>수정</button>";
      a += "</div>";
      //alert(a);
      $(".commentContent" + cno).html(a);
	}//commentUpdate end
	
	//댓글 수정후 댓글목록함수 호출
	function commentUpdateProc(cno){
		let updateContent = $("#content_" + cno).val();


		$.ajax({
			url : '/comment/update'
			,type:'post'
			,data:{'cno':cno, 'content':updateContent}
			,success:function(){

			}
		})//ajax() end
	}//commentUpdateProc end

/* 	
	$(".commentreset").click(function() {
		let listData = $(".commentList");
		document.productfrm.action="/comment/list";
		document.productfrm.submit();
		commentlist(listData);//댓글등록 함수 호출
	})//click() end
	
	 
	// 댓글 조회 함수
	function commentlist(listData){
		 $("#loader").show();
		//alert("댓글등록 함수 호출:" + insertData);
		$.ajax({
			 url     : '/comment/list'	//요청명령어
			 ,type   : 'post'			//요청방식		
			 ,data   : listData			//전달값
			 ,error  : function(error){		//에러시 호출값
				//alert(error);
			 }//error end					
			 ,success: function(data){			//성공시 호출값
				 alert(data);
				 $(".commentList table").append(data);
				 $(data).each(function () {
					 
						//tbody 삭제					 
					 $("table").empty();
					 
			           //let $tr = $("<tr>");
			           //let $td1 = $("<td>").text(${content});
			           //let $td2 = $("<td>").text(${wname});
			           //let $td3 = $("<td>").text(${regdate});
			           //$tr.append($td1, $td2, $td3).appendTo("tbody");
					 	
			           let str="";
			           
			            str += "<table>";
			            str += "<tbody>";
			            str += "<tr>";
		                str += "   <td>" + ${content} + "</td>";
		                str += "   <td>" + ${wname} + "</td>";
		                str += "   <td>" + ${regdate}+ "</td>";
		                str += "</tr>";
		                str += "</tbody>";
		                str += "</table>";
			       })//each end
			       
				   
			 }//success	end	
		
		})//ajax() end
		 $("#loader").fadeOut(500);
	};// commentInsert() end 
	 */
	
	
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
