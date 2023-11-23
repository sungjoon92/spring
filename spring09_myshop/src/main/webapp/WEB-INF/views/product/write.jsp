<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../header.jsp" %>
  <!-- 본문 시작 -->
  
  <div class="row">
    <div class="col-sm-12">
    	<p><h3>상품목록</h3></p>
	    <p>
	        <button type="button" onclick="location.href='list'" class="btn btn-primary">상품전체목록</button>
	    </p> 
    </div><!-- col end -->
  </div><!-- row end -->

  <div class="row">
    <div class="col-sm-12">
		 <form name="productfrm" id="productfrm" method="post" action="insert" enctype="multipart/form-data">
		 	<table class="table table-hover">
			    <tbody style="text-align: left;">
			    <tr>
					<td>상품명</td>
					<td> <input type="text" name="product_name" class="form-control"> </td>
			    </tr>
			    <tr>
					<td>상품가격</td>
					<td> <input type="number" name="price" class="form-control"> </td>
			    </tr>
			    <tr>
					<td>상품설명</td>
					<td> 
					    <textarea rows="5" cols="60" name="description" class="form-control"></textarea>     
					 </td>
			    </tr>
			    <tr>
					<td>상품사진</td>
					<td> <input type="file" name="img" class="form-control"> </td>
			    </tr>
			    <tr>
					<td colspan="2" align="center">
					    <input type="submit" value="상품등록" class="btn btn-success"> 
					</td>
			    </tr>   
			    </tbody> 
		    </table>
		 </form>
    </div><!-- col end -->
  </div><!-- row end -->
    
  <!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>