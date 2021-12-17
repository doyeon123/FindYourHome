<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<div class="work-area">
		<div class="gap-2 d-md-flex justify-content-md-end">
			<button type="button" onclick="location.href='/builid/' + ${buildNo} + '/community/create'" class="btn btn-primary">등록</button>
		</div>
		<br>
<%-- 		<c:if  test="${community.community_deleteFlag == 'N'}"> --%>
		<div>
			<table class="table table-striped table-hover table-bordered">
				<tr class="table-info text-center">
					<td class="col-sm-1"><strong>등록번호</strong></td>
					<td class="col-sm-1"><strong>건물번호</strong></td>
					<td class="col-sm-5"><strong>제목</strong></td>
					<td class="col-sm-2"><strong>작성일</strong></td>
					<td class="col-sm-2"><strong>수정일</strong></td>				
				</tr>
		
			<c:forEach var="community" items="${communityList}">
				<tr>
					<td class="text-center">${community.community_registerNo }</td>
					<td class="text-left">${community.community_buildingInfo }</td>
					<td class="text-left"><a href="/builid/${community.community_buildingInfo}/community/detail?id=${community.community_registerNo}">${community.community_title }</a></td>
					<fmt:formatDate value="${community.community_writeDate }" pattern="yy-MM-dd" var="writeDate"></fmt:formatDate>
					<td class="text-center">${writeDate }</td>
					<fmt:formatDate value="${community.community_reWriteDate }" pattern="yy-MM-dd" var="reWriteDate"></fmt:formatDate>
					<td class="text-center">${reWriteDate }</td>
				</tr>
	
			</c:forEach>
			</table>
		</div>
<%-- 		</c:if> --%>

		
				<nav style="vertical-align: middle;">
			<ul class="pagination">
				<c:if test="${pageNavi.prev }">
					<li onClick="javascript:page(${pageNavi.startPage-1 },${id },${area });">
					<a href="#" tabindex="-1">&lt;</a></li>
				</c:if>
				<c:forEach begin="${pageNavi.startPage }" end="${pageNavi.endPage }" var="page">
					<c:choose>
						<c:when test="${page eq pageNavi.paging.pageNo }">
							<li onClick="page(${page })"><a href="#">${page }</a></li>
						</c:when>
						<c:otherwise>
							<li onClick="page(${page })"><a href="#">${page }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${pageNavi.next }">
					<li onClick="page(${pageNavi.endPage+1},${id },${area });"><a href="#">&gt;</a></li>
				</c:if>
				
				
			</ul>
		</nav>
</div>
<!-- 페이징 끝 -->
	<form method=get action=/builid/{buildNo}/community name=listForm>
		<!-- 상세보기 검색 유지용 -->
		${pageNavi.paging.type }
		<input type=hidden name=page value="${pageNavi.paging.pageNo }">
        <input type=hidden name=id value="${id}">
		<input type=hidden name=area value="${area}">
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
		document.listForm.action="/builid/{buildNo}/community";
		document.listForm.pageNo.value=page;
		document.listForm.submit();
	}
	</script>
		


</html>

