<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="">
	<div class="message-area" style="overflow: auto;">
		<c:forEach var="msg" items="${messages}" varStatus="status">
		    <p>${status.count} : <c:out value="${msg}" /></p>
		</c:forEach>
	</div>
	
	<div class="upload-area">
		<form id="frm-all-upload" name="form" action="/admin/codeUpload" method="post" enctype="multipart/form-data">		
			<div class="input-group" style="padding-bottom: 10px;">
				<div style="width: 100%; margin: 10px;">
					<label>등록할 데이터 선택</label>
				</div>
				<select name="updateTable" class="form-select" aria-label="update-table">
					<option selected>업데이트할 테이블을 선택</option>
					<option value="1">지역코드(전체)</option>
					<option value="2">지역코드(구역지역)</option>
					<option value="3">지역코드(구(시))</option>
					<option value="4">진행코드</option>
					<option value="5">방구조</option>
					<option value="6">인터넷코드</option>
					<option value="7">업소코드</option>
					<option value="8">카테고리</option>
					<option value="9">국적</option>
					<option value="10">장비</option>
				</select>
				<div style="width: 100%; margin: 10px;">
					<label>지역코드</label>
				</div>
				<input type="hidden" value="test">
				<input type="file" name="file" class="form-control" id="inputGroupFile01" aria-describedby="upload-all" aria-label="Upload">
				<input type="submit" class="btn btn-outline-secondary" id="upload-all" value="Upload">
			</div>
		</form>
		
	</div>
	<script type="text/javascript">

	</script>
</div>
