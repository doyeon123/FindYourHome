<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영업소 상세보기 페이지</title>

<script type="text/javascript">
function updateForm(){
	location.href = "/admin/goUpdateForm";	
}
</script>


<style>
table {
	width: 100%;
}



</style>

</head>
<body>

<div class="work-area">
	<div style="margin: 50px;">
		<h1 style="text-align:center; font-size: xxx-large; font-weight: 900;"> ${salesOffice.sales_officeName } </h1>
		<button style="float: right; margin: 2px;" class="btn btn-outline-dark" type="button" onclick="location.href='/admin/office'">목록</button>
		<button style="float: right; margin: 2px;" class="btn btn-outline-dark" type="button" onclick="location.href='/admin/office/update?sales_registerNo=${salesOffice.sales_registerNo}'">수정</button>
	</div>
	
	
	<input type="hidden" readonly class="form-control-plaintext" id="staticEmail" value="${salesOffice.sales_registerNo}">
   	
   	<div class="row" style="display: flex; height: auto; width: 100%; border:1px solid gold;">
	    <label for="staticEmail" class="col-sm-2 col-form-label">영업소 종류</label>
	    <div class="col-sm-10">
	  		
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" <c:if test="${salesOffice.sales_businessCode eq 'B1'}">value = '직영점'</c:if> <c:if test="${salesOffice.sales_businessCode eq 'B2'}">value = '부동산'</c:if><c:if test="${salesOffice.sales_businessCode eq 'B3'}">value = '기타'</c:if>>
    	</div>
  	</div>
   	
   	
   	
   	<div class="row" style="display: flex; height: auto; width: 100%; border:1px solid gold;" >
    	<label for="staticEmail" class="col-sm-2 col-form-label" >주소</label>
	    <div class="col-sm-10">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${salesOffice.e_name} ${salesOffice.a_name} ${salesOffice.s_name} ${salesOffice.sales_address}">
    	</div>
  	</div>
  	<div class="row">
	    <label for="staticEmail" class="col-sm-2 col-form-label">우편번호</label>
	    <div class="col-sm-10" style="display: flex; height: auto; width: 80%; border:1px solid gold;">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${salesOffice.sales_postalCode}">
    	</div>
  	</div>
  	
  	 <div class="row">
	    <label for="staticEmail" class="col-sm-2 col-form-label">전화번호</label>
	    <div class="col-sm-10" style="display: flex; height: auto; width: 80%; border:1px solid gold;">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${salesOffice.sales_telNum}">
    	</div>
  	</div>


  	<div class="row" style="display: flex;">
	    <label for="staticEmail" class="col-sm-2 col-form-label">영업시간</label>
	    <div class="col-sm-4"style="display: flex; height: auto; width: 80%; border:1px solid gold;">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${salesOffice.sales_officeHours}">
    	</div>
	    <label for="staticEmail" class="col-sm-2 col-form-label">휴일</label>
	    <div class="col-sm-4"style="display: flex; height: auto; width: 80%; border:1px solid gold;">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${salesOffice.sales_holiday}">
    	</div>
  	</div>
   	<div class="row" style="display: flex;">
	    <label for="staticEmail" class="col-sm-2 col-form-label">교통정보</label>
	    <div class="col-sm-10" style="display: flex; height: auto; width: 80%; border:1px solid gold;">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${salesOffice.sales_transportation}">
    	</div>
  	</div>


  	<div>
	  	<div class="row" style="display: flex;">
		    <label for="staticEmail" class="col-md-1 col-form-label">이미지</label>
		    <div class="col-md-2" style="display: flex; height: auto; width: 100%; ">
			    <c:url value="/fileDisplay" var="urlThum2">
					<c:param name="file_name" value="${salesOffice.sales_img}"></c:param>
				</c:url>
	      		<img src="${urlThum2}" class="form-control-plaintext" alt="건물 이미지">
	    	</div>
	  	</div>
  	</div>
</div>




</body>
</html>