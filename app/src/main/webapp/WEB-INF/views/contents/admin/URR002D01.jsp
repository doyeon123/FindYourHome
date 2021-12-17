<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="work-area">
	<div style="margin: 0 auto; width: 70%;">
		<div style="text-align: right">
			<a href="/admin/room/builids?no=${dto.room_registerNo}"><input type="button" class="btn btn-outline-primary" value="修正"></a>
			<a href="/admin/room?id=${dto.room_zoneInfo}&area=${dto.room_areaInfo}"><input type="button" class="btn btn-outline-dark" value="リスト"></a>
		</div>
		<div style="margin-top: 20px">
			<div class="row" style="display: flex;">
			    <label for="staticEmail" class="col-sm-2 col-form-label">建物名</label>
			    <div class="col-sm-10">
		      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${dto.zone_officalName}">
		    	</div>
		  	</div>
			<div class="row" style="display: flex;">
			    <label for="staticEmail" class="col-sm-2 col-form-label">床面積</label>
			    <div class="col-sm-4">
		      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${dto.room_flowArea}">
		    	</div>
			    <label for="staticEmail" class="col-sm-2 col-form-label">間取り</label>
			    <div class="col-sm-4">
		      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${dto.room_structure}">
		    	</div>
		  	</div>
			<div class="row" style="display: flex;">
			    <label for="staticEmail" class="col-sm-2 col-form-label">家賃</label>
			    <div class="col-sm-10">
		      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${dto.room_yaching}">
		    	</div>
		  	</div>
			<div class="row" style="display: flex;">
			    <label for="staticEmail" class="col-sm-2 col-form-label">敷金</label>
			    <div class="col-sm-4">
		      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${dto.room_sikiking}">
		    	</div>
			    <label for="staticEmail" class="col-sm-2 col-form-label">礼金</label>
			    <div class="col-sm-4">
		      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${dto.room_racing}">
		    	</div>
		  	</div>
			<div class="row" style="display: flex;">
			    <label for="staticEmail" class="col-sm-2 col-form-label">階</label>
			    <div class="col-sm-4">
		      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${dto.room_numOfFloors}">
		    	</div>
			    <label for="staticEmail" class="col-sm-2 col-form-label">部屋の番号</label>
			    <div class="col-sm-4">
		      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${dto.room_roomNo}">
		    	</div>
		  	</div>
			<div>
				<c:url value="/fileDisplay" var="urlThum">
					<c:param name="file_name" value="${dto.room_roomArrange}"></c:param>
				</c:url>
				<img src="${urlThum}" style="width: 200px; height: 200px;">
				<c:url value="/fileDisplay" var="urlThum2">
					<c:param name="file_name" value="${dto.room_img360}"></c:param>
				</c:url>
				<img src="${urlThum2}" style="width: 200px; height: 200px;">
				<c:url value="/fileDisplay" var="urlThum3">
					<c:param name="file_name" value="${dto.room_img}"></c:param>
				</c:url>
				<img src="${urlThum3}" style="width: 200px; height: 200px;">
			</div>
		</div>
	</div>
</div>