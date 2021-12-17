<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="work-area">
		<div class="card">
			<div class="card-header">Notice.</div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">題名</th>
						<th scope="col">Date.</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="notice" items="${noticeList}">
						<tr>
							<th scope="row">${notice.notice_registerno}</th>
							<td><a href="/notice/detail?id=${notice.notice_registerno}">${notice.notice_title}</a></td>
							<td>${notice.notice_openingdate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav class="d-flex justify-content-center">
				<ul class="pagination">
					<c:if test="${paging.pageBegin > 1}">
						<li class="page-item"><a class="page-link" href="./?page=1">1</a></li>
						<li class="page-item">...</li>
					</c:if>
					<c:forEach var="i" begin="${paging.pageBegin}" end="${paging.pageEnd}">
							<li class="page-item ${i == param.page ? 'active' : ''}"><a class="page-link" href="./?page=${i}">${i}</a></li>
					</c:forEach>
					<c:if test="${paging.pageEnd < paging.maxPage}">
						<li class="page-item">...</li>
						<li class="page-item"><a class="page-link" href="./?page=${paging.maxPage}">${paging.maxPage}</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
</body>
</html>