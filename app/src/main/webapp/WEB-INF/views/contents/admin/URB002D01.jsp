<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<div class="work-area">
	<div style="margin: 50px;">
		<h1 style="text-align:center; font-size: xxx-large; font-weight: 900;"> ${detail.zone_officalName } </h1>
		<button style="float: right; margin: 2px;" class="btn btn-outline-dark" type="button" onclick="location.href='/admin/builids'">목록</button>
		<button style="float: right; margin: 2px;" class="btn btn-outline-dark" type="button" onclick="location.href='/admin/builids/update?zone_registerNo=${detail.zone_registerNo}'">수정</button>
		<a style="float: right; margin: 2px;" href="/admin/room?id=${detail.zone_registerNo}&area=${detail.zone_areaRegionalCode}&search"><input type="button" class="btn btn-primary" value="방정보"></a>
	</div>
	<input type="hidden" readonly class="form-control-plaintext" id="staticEmail" value="${detail.zone_registerNo}">
   	<div class="row" >
    	<label for="staticEmail" class="col-sm-2 col-form-label">주소</label>
	    <div class="col-sm-10">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${detail.e_name} ${detail.a_name} ${detail.s_name} ${detail.zone_address}">
    	</div>
  	</div>
  	<div class="row" style="display: flex;">
	    <label for="staticEmail" class="col-sm-2 col-form-label">우편번호</label>
	    <div class="col-sm-10">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${detail.zone_postalCode}">
    	</div>
  	</div>
  	<div class="row" style="display: flex;">
	    <label for="staticEmail" class="col-sm-2 col-form-label">공익비</label>
	    <div class="col-sm-4">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${detail.zone_maintenaceCost}">
    	</div>
	    <label for="staticEmail" class="col-sm-2 col-form-label">공익비FLAG</label>
	    <div class="col-sm-4">
	    	<c:if test="${detail.zone_maintenaceCostFlag == 1}">
	      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="있음">
	    	</c:if>
	    	<c:if test="${detail.zone_maintenaceCostFlag == 0}">
	      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="없음">
	    	</c:if>
    	</div>
  	</div>
  	<div class="row" style="display: flex;">
	    <label for="staticEmail" class="col-sm-2 col-form-label">세대수</label>
	    <div class="col-sm-4">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${detail.zone_houseHoldsNo}">
    	</div>
	    <label for="staticEmail" class="col-sm-2 col-form-label">건물구조</label>
	    <div class="col-sm-4">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${detail.zone_buildingStructure}">
    	</div>
  	</div>
  	<div class="row" style="display: flex;">
	    <label for="staticEmail" class="col-sm-2 col-form-label">관리연수</label>
	    <div class="col-sm-4">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${detail.zone_managementYear}">
    	</div>
	    <label for="staticEmail" class="col-sm-2 col-form-label">주차장 정보</label>
	    <div class="col-sm-4">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${detail.zone_parkingLotInfo}">
    	</div>
  	</div>
   	<div class="row" style="display: flex;">
	    <label for="staticEmail" class="col-sm-2 col-form-label">교통정보</label>
	    <div class="col-sm-10">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${detail.zone_trafficInfo}">
    	</div>
  	</div>
   	<div class="row" style="display: flex;">
	    <label for="staticEmail" class="col-sm-2 col-form-label">교통정보 파일링크</label>
	    <div class="col-sm-10">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${detail.zone_trafficInfoLink}">
    	</div>
  	</div>
   	<div class="row" style="display: flex;">
	    <label for="staticEmail" class="col-sm-2 col-form-label">특징</label>
	    <div class="col-sm-10">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${detail.zone_characteristic}">
    	</div>
  	</div>
   	<div class="row" style="display: flex;">
	    <label for="staticEmail" class="col-sm-2 col-form-label">비고</label>
	    <div class="col-sm-10" style="margin-top: 10px;">
		    <c:forEach items="${equipList}" var="equip" varStatus="status">
			    <c:forTokens items="${detail.zone_note}" delims="," var="item">
				    <c:if test="${equip.code == item}">
				    	<c:choose>
				    		<c:when test="${status.last}">
				    			${equip.name}
				    		</c:when>
				    		<c:otherwise>
				    			${equip.name}, 
				    		</c:otherwise>
				    	</c:choose>
				    </c:if>
				</c:forTokens>
		    </c:forEach>
		    <c:forEach items="${IList}" var="IList">
			    <c:forTokens items="${detail.zone_note}" delims="," var="item">
				    <c:if test="${IList.code == item}">
				    	${IList.name}
				    </c:if>
				</c:forTokens>
		    </c:forEach>
    	</div>
  	</div>
  	<div>
	  	<div class="row" style="display: flex;">
		    <label for="staticEmail" class="col-md-1 col-form-label">배치도</label>
		    <div class="col-md-2" >
		    	<c:url value="/fileDisplay" var="urlThum">
					<c:param name="file_name" value="${detail.zone_layout}"></c:param>
				</c:url>
				<img src="${urlThum}" class="form-control-plaintext" alt="배치도">
	    	</div>
	    	<label for="staticEmail" class="col-md-1 col-form-label">건물</label>
		    <div class="col-md-2">
			    <c:url value="/fileDisplay" var="urlThum2">
					<c:param name="file_name" value="${detail.zone_buildingImg}"></c:param>
				</c:url>
	      		<img src="${urlThum2}" class="form-control-plaintext" alt="건물 이미지">
	    	</div>
	    	<label for="staticEmail" class="col-md-1 col-form-label">위치</label>
		    <div class="col-md-2">
			    <c:url value="/fileDisplay" var="urlThum3">
					<c:param name="file_name" value="${detail.zone_locationImg}"></c:param>
				</c:url>
	      		<img src="${urlThum3}" class="form-control-plaintext" alt="위치 이미지">
	    	</div>
	    	<label for="staticEmail" class="col-md-1 col-form-label">구역</label>
		    <div class="col-md-2">
			    <c:url value="/fileDisplay" var="urlThum3">
					<c:param name="file_name" value="${detail.zone_locationImg}"></c:param>
				</c:url>
	      		<img src="${urlThum3}" class="form-control-plaintext" alt="구역 이미지">
	    	</div>
	  	</div>
	   	<div class="row" style="display: flex;">
		    <label for="staticEmail" class="col-md-1 col-form-label">주변</label>
		    <c:forEach items="#{detail.surroundImges}" var="imgs" varStatus="status">
			    <div class="col-md-2">
			    	<c:url value="/fileDisplay" var="urlThum5">
						<c:param name="file_name" value="${imgs}"></c:param>
					</c:url>
		      		<img src="${urlThum5}" class="form-control-plaintext" alt="주변 이미지">
		    	</div>
	    	</c:forEach>
	  	</div>
  	</div>
</div>