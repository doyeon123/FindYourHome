<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="work-area">
	<div style="margin: 0 auto; width: 45%;">
		<form action="${form}" method="post" enctype="multipart/form-data">
			<div style="text-align: right">
				<button class="btn btn-outline-primary" type="submit">OK</button>
				<button class="btn btn-outline-secondary" type="reset" onclick="history.back(-1);">キャンセル</button>
			</div>
			<div style="margin-top: 20px">
			<%-- <c:set var="id" value="${id}"/>
			<c:set var="area" value="${area}"/>
			<c:if test="${dto.room_zoneInfo != null }">
				<c:set var="id" value="${dto.zno}"/>
				<c:set var="area" value="${dto.room_areaInfo}"/>
			</c:if> --%>
				<input type="hidden" name="room_registerNo" value="${dto.room_registerNo}">
				<input type="hidden" name="room_zoneInfo" value="${id}">
				<input type="hidden" name="room_areaInfo" value="${area}">
		 		<%-- <div class="row">
					<label for="staticEmail" class="col-sm-2 col-form-label">건물번호 </label>
					<div class="col-sm-4">
						<input type="text" class="form-control-plaintext" id="staticEmail" name="room_zoneInfo" value="${dto.zno}" readonly>
					</div>
				</div>
		 		<div class="row">
					<label for="staticEmail" class="col-sm-2 col-form-label">지역 </label>
					<div class="col-sm-4">
						<input type="text" class="form-control-plaintext" id="staticEmail" value="${dto.arname}" readonly>
					</div>
				</div> --%>
				<div class="row">
					<label for="staticEmail" class="col-sm-2 col-form-label">間取り </label>
					<div class="col-sm-4">
						<select name="room_structure">
							<option value=""> </option>
							<c:forEach var="roomStructureList" items="${roomStructureList}">
								<option value="${roomStructureList.code}" <c:if test="${roomStructureList.code == dto.room_structure}">selected</c:if> >${roomStructureList.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row">
					<label for="staticEmail" class="col-sm-2 col-form-label">床面積 </label>
					<div class="col-sm-4">
						<input type="text" id="formGroupExampleInput" placeholder="数字のみ入力してください。"
							   name="room_flowArea" value="${dto.room_flowArea}"
							   onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
					</div>
				</div>
				<div class="row">
					<label for="staticEmail" class="col-sm-2 col-form-label">敷金(月) </label>
					<div class="col-sm-4">
						<input type="text" id="formGroupExampleInput" placeholder="数字のみ入力してください。"
							   name="room_sikiking" value="${dto.room_sikiking}"
							   onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
					</div>
				</div>
				<div class="row">
					<label for="staticEmail" class="col-sm-2 col-form-label">礼金 </label>
					<div class="col-sm-4">
					<input type="text" id="formGroupExampleInput"
						   name="room_racing" value="${dto.room_racing}">
					</div>
				</div>
				<div class="row">
					<label for="staticEmail" class="col-sm-2 col-form-label">部屋の番号 </label>
					<div class="col-sm-4">
						<input type="text" id="formGroupExampleInput" placeholder="数字のみ入力してください。"
							   name="room_roomNo" value="${dto.room_roomNo}"
							   onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
					</div>
				</div>
				<div class="row">
					<label for="staticEmail" class="col-sm-2 col-form-label">家賃 </label>
					<div class="col-sm-4">
						<input type="text" id="formGroupExampleInput" placeholder="数字のみ入力してください。"
							   name="room_yaching" value="${dto.room_yaching}"
							   onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
						</div>
				</div>
				<div class="row">
					<label for="staticEmail" class="col-sm-2 col-form-label">階 </label>
					<div class="col-sm-4">
						<input type="text" id="formGroupExampleInput" placeholder="数字のみ入力してください。"
							   name="room_numOfFloors" value="${dto.room_numOfFloors}"
							   onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
					</div>
				</div>
				<div class="row">
					<label for="staticEmail" class="col-sm-2 col-form-label">間取り図 </label>
					<div class="col-sm-4">
						<input type="file" name="room_roomArrange" id="room_roomArrange" accept="image/*">
					</div>
				</div>
				<div class="row">
					<label for="staticEmail" class="col-sm-2 col-form-label">写真(360)</label>
					<div class="col-sm-4">
						<input type="file" name="room_img360" id="room_img360" accept="image/*">
					</div>
				</div>
				<div class="row">
					<label for="staticEmail" class="col-sm-2 col-form-label">写真 </label>
					<div class="col-sm-4">
						<input type="file" name="room_img" id="room_img" multiple="multiple" accept="image/*">
					</div>
				</div>
			</div>
		</form>
	</div>
</div>