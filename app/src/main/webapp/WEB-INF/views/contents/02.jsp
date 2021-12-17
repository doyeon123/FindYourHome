<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<%-- 수정페이지 --%>
<div class="work-area">	
	<c:choose>
		<c:when test="${not empty notice. notice_registerNo}">
			<form id="updateForm" name="update" action="/admin/notice/update" method="post">
				<table class="table table-bordered">
					<div>
						<input type="hidden" id="notice_registerNo" name="notice_registerNo" value="${notice.notice_registerNo }">
					</div>
					<tr>
						<td class="text-center" width="10%"><strong>카테고리</strong></td>
						<td width="40%"><select id="notice_category" name="notice_category" class="form-control form-select-sm">
							<c:forEach var="codeC" items="${codeCList }">
								<option value="${codeC.code }">${codeC.name }</option>
							</c:forEach></select></td>
						<td class="text-center" width="10%"><strong>지역코드(전체)</strong></td>
						<td width="40%"><select id="notice_entireRegionalCode" name="notice_entireRegionalCode" class="form-control form-select-sm">
							<c:forEach var="codeA" items="${codeAList }">
								<option value="${codeA.code }">${codeA.name }</option>
							</c:forEach></select></td>
					</tr>
					<tr>
						<td class="text-center"><strong>표시기간</strong></td>
						<td colspan="3"><input type="date" id="notice_displyDate" onChange="parse(this)">
						<input type="hidden" id="notice_displyDate2" name="notice_displyDate"></td>
					</tr>
					<tr>
						<td class="text-center"><strong>제목</strong></td>
						<td colspan="3"><input type="text" id="notice_title" name="notice_title" value="${notice.notice_title }" class="col-sm-9 col-form-label"></td>
					</tr>
					<tr>
						<td class="text-center align-middle"><strong>내용</strong></td>
						<td colspan="3"><textarea id="notice_content" name="notice_content" rows="7" class="col-sm-9 col-form-label">${notice.notice_content }</textarea></td>
					</tr>
					<tr>
						<td class="text-center"><strong>링크</strong></td>
						<td colspan="3"><input type="text" id="notice_link" name="notice_link" value="${notice.notice_link }" class="col-sm-9 col-form-label"></td>
					
				</table>
				
				<div class="d-grid gap-2 col-6 mx-auto">
				<%-- 버튼 타입을 submit으로 해두면 위에서 다른 조건이 있어도 무조건 승인되고 말기 때문에 조심 --%>
				<button type="button" value="수정" onclick="vali()" class="btn btn-primary">수정</button>
				</div>
			</form>
		</c:when>
			
		<%-- 등록페이지 --%>
		<c:otherwise>
			<form id="createForm" name="create" action="/admin/notice/create" method="post">
			<table class="table table-bordered">
				<tr>
					<td class="text-center" width="10%"><strong>카테고리</strong></td>
					<td width="40%"><select id="notice_category" name="notice_category" class="form-control form-select-sm">
						<c:forEach var="codeC" items="${codeCList }">
							<option value="${codeC.code }">${codeC.name }</option>
						</c:forEach></select></td>
					<td class="text-center" width="10%"><strong>지역코드(전체)</strong></td>
					<td width="40%"><select id="notice_entireRegionalCode" name="notice_entireRegionalCode" class="form-control form-select-sm">
						<c:forEach var="codeA" items="${codeAList }">
							<option value="${codeA.code }">${codeA.name }</option>
						</c:forEach></select></td>
				</tr>
				<tr>
					<td class="text-center"><strong>표시기간</strong></td>
				<%-- 표시기간이 뜨는 툴 옆에 보이지 않는 칸을 만들어서, 표시기간 툴에서 날짜를 설정하면 보이지 않는 칸에 들어오게 설정! 그리고 그 칸에서 값을 보내주기 --%>
					<td colspan="3"><input type="date" id="notice_displyDate" onChange="parse(this)">
					<input type="hidden" id="notice_displyDate2" name="notice_displyDate"></td>
				</tr>
				<tr>
					<td class="text-center"><strong>제목</strong></td>
					<td colspan="3"><input type="text" id="notice_title" name="notice_title" class="col-sm-9 col-form-label"></td>
				</tr>
				<tr>
					<td class="text-center align-middle"><strong>내용</strong></td>
					<td colspan="3"><textarea id="notice_content" name="notice_content" rows="7" class="col-sm-9 col-form-label"></textarea></td>
				</tr>
				<tr>
					<td class="text-center"><strong>링크</strong></td>
					<td colspan="3"><input type="text" id="notice_link" name="notice_link" class="col-sm-9 col-form-label col-form-label-sm"></td>
				</tr>
				
				</table>
				<div class="d-grid gap-2 col-6 mx-auto">
					<button type="button" onclick="valida()" class="btn btn-primary float-right">등록</button>
				</div>
			</form>
		</c:otherwise>
	</c:choose>
</div>
	
	<script type="text/javascript">
		function parse(e){
			document.querySelector("#notice_displyDate2").value = e.value.replace(/T/gi, "");
		}
	
		// 제목이 빈칸일 경우 승인되지 않도록 설정
		function vali(){
			let notice_title = document.getElementById("notice_title").value;
			if(notice_title === ''){
					document.querySelector('#notice_title').focus();
					return false;
					}
			document.querySelector('#updateForm').submit();
			}
		
			// 제이쿼리
			/* function valida(){
				let notice_displyDate2 = $('#notice_displyDate2').val();
				if(notice_displyDate2 === ''){
					$('#notice_displyDate').focus();
					return false;
				}
				document.querySelector('#form').submit();
			} */
		
		// 자바스크립트
		// 표시기간이 빈칸일 경우 승인되지 않도록 설정
		function valida(){
			
			let notice_title = document.getElementById("notice_title").value;
			let notice_displyDate2 = document.getElementById("notice_displyDate2").value;
			
			if(notice_title === ''){
					document.querySelector('#notice_title').focus();
					return false;
				}
			
			if(notice_displyDate2 === ''){
				document.querySelector('#notice_displyDate').focus();
				return false;
				}
			document.querySelector('#createForm').submit();
			}
		
			/* document.querySelector일때는 class일때는 '.', id일때는 '#' 따옴표 주의!!!
			-> document.querySelector('#notice_displyDate2')
			
			getElementById/getElementsByName/getElementsByClassName일때는 큰따옴표만 넣어주기
			-> document.getElementById("notice_displyDate2") */
		
	</script>