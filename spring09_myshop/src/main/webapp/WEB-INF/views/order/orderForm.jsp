<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../header.jsp" %>
  

  <script>


  function orderCheck() {
		// 유효성검사
		
		//받는사람
		let deliverynm = $("#deliverynm").val();
		if(deliverynm.length == 0 || deliverynm.trim() == ""){
			alert("받는사람을 작성해주세요!");
			return false;
		}//if end
		
		//받는주소
		let deliveryaddr = $("#deliveryaddr").val();
		if(deliveryaddr.length == 0 || deliveryaddr.trim() == ""){
			alert("주소를 작성해주세요!");
			return false;
		}//if end
		
		//배송메세지
		let deliverymsg = $("#deliverymsg").val();
		if(deliverymsg.length === 0){
			alert("배송메세지를 작성해주세요!");
			return false;
		}//if end
	  
	  
	  
	  
	  
	  
	  
}//orderCheck() end
  </script>
  
  
  <!-- 본문 시작 -->
  
  <div class="row">
    <div class="col-sm-12">
    	<p><h3>배송지 작성</h3></p>
    </div><!-- col end -->
  </div><!-- row end -->
    
    <div class="row">
    <div class="col-sm-12">
    	<form action="insert" method="post" onsubmit="return orderCheck()">
    	<table class="table table-hover">
			    <tbody style="text-align: left;">
		    	<tr>
		    		<th>받는사람</th>
		    		<td><input type="text" id="deliverynm" name="deliverynm" class="form-control"></td>
		    	</tr>
		    	<tr>
		    		<th>받는주소</th>
		    		<td><input type="text" id="deliveryaddr" name="deliveryaddr" class="form-control"></td>
		    	</tr>
				<tr>
		    		<th>배송메세지</th>
		    		<td><input type="text" id="deliverymsg" name="deliverymsg" class="form-control"></td>
		    	</tr>
		    	<tr>
		    		<th>결제구분</th>
		    		<td>
		    			<select name="payment" class="form-control">
		    				<option value="cash">현금결제</option>
		    				<option value="card">카드</option>
		    			</select>
		    		</td>
		    	</tr>
				<tr>
		    		<td colspan="2" align="center">
		    			<input type="submit" value="결제하기" class="btn btn-warning">
		    		</td>
		    	</tr>
		    	</tbody>
	    	</table>
    	
    	</form>
    </div><!-- col end -->
  </div><!-- row end -->
  <!-- 본문 끝 -->
</div><!-- container end -->

<%@ include file="../footer.jsp" %>