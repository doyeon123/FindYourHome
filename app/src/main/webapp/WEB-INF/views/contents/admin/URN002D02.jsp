<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<div class="work-area">
	<div style="width: 60%; margin: 0 auto;">
		<div class="gap-2 d-md-flex justify-content-md-end">
			<button type="button" onclick="location.href='/admin/notice/create'" class="btn btn-primary">등록</button>
		</div>
		<br>
		<div>
			<table class="table table-striped table-hover table-bordered">
				<tr class="table-info text-center">
					<td class="col-sm-1"><strong>등록번호</strong></td>
					<td class="col-sm-4"><strong>제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</strong></td>
					<td class="col-sm-2"><strong>작 성 일</strong></td>
					<td class="col-sm-2"><strong>수 정 일</strong></td>
				</tr>
		
			<c:forEach var="notice" items="${adminNoticeList}">
				<tr>
					<td class="text-center">${notice.notice_registerNo }</td>
					<td class="text-left"><a href="/admin/notice/detail?id=${notice.notice_registerNo}" style="text-decoration: none;">${notice.notice_title }</a></td>
					<fmt:formatDate value="${notice.notice_writeDate }" pattern="yy-MM-dd" var="writeDate"></fmt:formatDate>
					<td class="text-center">${writeDate }</td>
					<fmt:formatDate value="${notice.notice_reWriteDate }" pattern="yy-MM-dd" var="reWriteDate"></fmt:formatDate>
					<td class="text-center">${reWriteDate }</td>
				</tr>
	
			</c:forEach>
			</table>
		</div>
		
		<%-- 페이징 처리 --%>
		<nav style="vertical-align: middle;" aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
			
				<c:if test="${pageNavi.prev }">
					<%-- 제일 앞 페이지로 이동 --%>
					<li onClick="javascript:page(1);">
						<a href="#" tabindex="-1">&lt;&lt;</a>
					</li>
					<li class="page-item" onClick="javascript:page(${pageNavi.startPage-1 });">
						<a class="page-link" href="#" tabindex="-1">&lt;</a>
					</li>
				</c:if>
				
				<c:forEach begin="${pageNavi.startPage }" end="${pageNavi.endPage }" var="page">
					<%-- 현재 페이지라면 action 발동 --%>
					<li class="page-item ${pageNavi.paging.pageNo eq page ?'active':''}" onClick="page(${page })">
						<a class="page-link" href="#">${page }</a>
					</li>
				</c:forEach>
				
				<c:if test="${pageNavi.next }">
					<%-- 제일 마지막 페이지로 이동 --%>
					<li class="page-item" onClick="page(${pageNavi.endPage+1});">
						<a class="page-link" href="#">&gt;</a>
					</li>
					<li onClick="page(${pageNavi.endPageNo});">
						<a href="#">&gt;&gt;</a>
					</li>
				</c:if>
			</ul>
		</nav>
	</div>
</div>

	<form method=get action=/admin/room name=listForm>
		<!-- 상세보기 검색 유지용 -->
		${pageNavi.paging.type }
		<input type=hidden name=pageNo value="${pageNavi.paging.pageNo }">
		<!-- 상세보기 검색 유지용 끝 -->
	</form>

	<script type="text/javascript">
	// alert
	$(document).ready(function() {
		let result = '${result}';
		console.log(result);
		if(result !== 'error' && result !== '' && result !== null && result !== 'undefined'){
			alert(result);
		}
	});
	
	function page(page){
		document.listForm.action="/admin/notice";
		document.listForm.pageNo.value=page;
		document.listForm.submit();
	}
	</script>
</html>

