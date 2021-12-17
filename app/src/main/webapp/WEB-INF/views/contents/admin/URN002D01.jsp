<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<div class="work-area">
	<div class="upload-area">
		<table class="table table-bordered text-center">
			<tr class="table-info">
				<td><strong>등록번호</strong></td>
				<td><strong>카테고리</strong></td>
				<td><strong>지역코드(전체)</strong></td>
				<td><strong>제&nbsp;&nbsp;&nbsp;목</strong></td>
				<td><strong>내&nbsp;&nbsp;&nbsp;용</strong></td>
				<td><strong>링&nbsp;&nbsp;&nbsp;크</strong></td>
				<td><strong>표시기간</strong></td>
				<td><strong>작 성 일</strong></td>
				<td><strong>수 정 일</strong></td>
				<td></td>
			</tr>
			<tr class="align-middle"> <!-- 반복 아님 c:Foreach 쓰지않기 -->
				<td>${notice.notice_registerNo }</td>
				<td>${notice.categoryName }</td>
				<td>${notice.entireName }</td>
				<td>${notice.notice_title }</td>
				<td>${notice.notice_content }</td>
				<td>${notice.notice_link }</td>
				<fmt:formatDate value="${notice.notice_displyDate }" pattern="yyyy-MM-dd" var="displyDate"></fmt:formatDate>
				<td>${displyDate }</td>
				<fmt:formatDate value="${notice.notice_writeDate }" pattern="yy-MM-dd" var="writeDate"></fmt:formatDate>
				<td>${writeDate }</td>
				<fmt:formatDate value="${notice.notice_reWriteDate }" pattern="yy-MM-dd" var="reWriteDate"></fmt:formatDate>
				<td>${reWriteDate }</td>
				<td>
				<button onclick="location.href='update?id=${notice.notice_registerNo}'" class="btn btn-primary">수정</button>
				</td>
			</tr>
		</table>
	</div>
</div>