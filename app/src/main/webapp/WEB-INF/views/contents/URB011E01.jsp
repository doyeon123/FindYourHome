<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


<div class="work-area">	
      <c:if test="${empty community.community_registerNo}">
			<form id="createForm" name="create" action="/builid/${buildNo}/community/create" method="post">
			<table class="table table-bordered">				
			    <tr>
					<td class="text-center"><strong>작성자</strong></td>		
					<td colspan="3"><input type="text" id="community_author" name="community_author" class="col-sm-9 col-form-label"></td>		
				</tr>
				<tr>
					<td class="text-center"><strong>건물번호</strong></td>
					<td colspan="3"><input type="text" value="${buildNo}" id="community_buildingInfo" name="community_buildingInfo" class="col-sm-9 col-form-label"></td>
				</tr>
				<tr>
					<td class="text-center"><strong>제목</strong></td>
					<td colspan="3"><input type="text" id="community_title" name="community_title" class="col-sm-9 col-form-label"></td>
				</tr>
				<tr>
					<td class="text-center"><strong>패스워드</strong></td>
					<td colspan="3"><input type="text" id="community_password" name="community_password" class="col-sm-9 col-form-label"></td>
				</tr>
				<tr>
					<td class="text-center align-middle"><strong>내용</strong></td>
					<td colspan="3"><textarea id="community_content" name="community_content" rows="7" class="col-sm-9 col-form-label"></textarea></td>
				</tr>
				
				</table>
				<div class="d-grid gap-2 col-6 mx-auto">
					<button type="submit" class="btn btn-primary float-right">등록</button>
				</div>		
			</form>
		</c:if>	
		<c:if test="${not empty community.community_registerNo}">
			<form id="updateForm" name="update" action="/builid/${buildNo}/community/update" method="post">
			<input type="hidden" name="community_registerNo" value="${community.community_registerNo }">
			<table class="table table-bordered">				
			    <tr>
					<td class="text-center"><strong>작성자</strong></td>		
					<td colspan="3"><input type="text" value="${community.community_author}" id="community_author" name="community_author" class="col-sm-9 col-form-label"></td>		
				</tr>
				<tr>
					<td class="text-center"><strong>건물번호</strong></td>
					<td colspan="3"><input type="text" value="${buildNo}" id="community_buildingInfo" name="community_buildingInfo" class="col-sm-9 col-form-label"></td>
				</tr>
				<tr>
					<td class="text-center"><strong>제목</strong></td>
					<td colspan="3"><input type="text" value="${community.community_title}" id="community_title" name="community_title" class="col-sm-9 col-form-label"></td>
				</tr>
				<tr>
					<td class="text-center"><strong>패스워드</strong></td>
					<td colspan="3"><input type="text" value="${community.community_password}" id="community_password" name="community_password" class="col-sm-9 col-form-label"></td>
				</tr>
				<tr>
					<td class="text-center align-middle"><strong>내용</strong></td>
					<td colspan="3"><textarea id="community_content" name="community_content" rows="7" class="col-sm-9 col-form-label">${community.community_content}</textarea></td>
				</tr>
				
				</table>
				<div class="d-grid gap-2 col-6 mx-auto">
					<button type="submit" class="btn btn-primary float-right">수정</button>
				</div>		
			</form>		
		</c:if>


</div>
