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
				<td><strong>건물번호</strong></td>
				<td><strong>작성자</strong></td>
				<td><strong>패스워드</strong></td>
				<td><strong>제목</strong></td>
				<td><strong>내용</strong></td>
				<td><strong>삭제플레그</strong></td>
				<td><strong>작성일</strong></td>
				<td><strong>수정일</strong></td>
				<td></td>
				<td></td>
			</tr>
			<tr class="align-middle"> <!-- 반복 아님 c:Foreach 쓰지않기 -->
				<td>${community.community_registerNo}</td>
				<td>${community.community_buildingInfo}</td>
				<td>${community.community_author}</td>
				<td>${community.community_password}</td>
				<td>${community.community_title}</td>
				<td>${community.community_content}</td>
				<td>${community.community_deleteFlag}</td>
				<fmt:formatDate value="${community.community_writeDate}" pattern="yy-MM-dd" var="writeDate"></fmt:formatDate>
				<td>${writeDate }</td>
				<fmt:formatDate value="${community.community_reWriteDate}" pattern="yy-MM-dd" var="reWriteDate"></fmt:formatDate>
				<td>${reWriteDate }</td>
				<td>
				<button onclick="location.href='update?id=${community.community_registerNo}'" class="btn btn-primary">수정</button>
				</td>
				<td>
				<button onclick="remove(${community.community_registerNo})" class="btn btn-primary">삭제</button>
				</td>
			</tr>
		</table>
	</div>
</div>

<script type="text/javascript">
	function remove(community_registerNo){
		let id = community_registerNo;
		if(confirm(id + " 번 게시물을 삭제하시겠습니까?")){
			location.href = "/builid/${community.community_buildingInfo}/community/remove?id=${community.community_registerNo}";
		}
	}


</script>