<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div id="container">
	
		<div class="title">
			<h2>어드민게시판리스트</h2>
		</div>
		<div>
		<table class="table table-striped">
		<thead style="display: flex; justify-content: ;">
		<tr>
			<th>등록번호</th>
			<th>작성자</th>
			<th>패스워드</th>
			<th>제목</th>
			<th>내용</th>
			<th>삭제플레그</th>
			<th>작성일</th>
			<th>수정일</th>
		</tr>
		</thead>
		
		</tbody>
		<c:forEach var="list" items="${list}">
		<tr>
			<td><a href="/consulting/update?no=${list.consulting_registerno}">${list.consulting_registerno }</td>
			<td>${list.consulting_author }</td>
			<td>${list.consulting_password }</td>
			<td><a href="/admin/consulting/detail?no=${list.consulting_registerno}">${list.consulting_title }</td>
			<td>${list.consulting_content }</td>
			<td>${list.consulting_deleteflag }</td>
			<td>${list.consulting_writedate }</td>
			<td>${list.consulting_rewritedate }</td>
		</tr>		
		</c:forEach>
		<tbody>
		</table>
		</div>
	
				<!-- 페이지 -->                          
                <nav aria-label="...">
				  <ul class="pagination">
				  <!-- prev 표시 -->
				  <c:if test="${pageNavi.prev }">
				    <li class="page-item" onClick="javascript:page(${pageNavi.startPage-1});">
				      <a class="page-link" href="#" tabindex="-1">Previous</a>
				    </li>
				  </c:if>
				  <c:forEach begin="${pageNavi.startPage }" end="${pageNavi.endPage }" var="page">
				  
				  	<c:choose>
				  		<c:when test="${page eq pageNavi.paging.pageNo }">
						  	<li class="page-item active" onClick="page(${page})">
						      <a class="page-link" href="#" >${page } <span class="sr-only"></span></a>
						    </li>
					    </c:when>
					  	<c:otherwise>
					    	<li class="page-item" onClick="page(${page})"><a class="page-link" href="#">${page }</a></li>
					    </c:otherwise>
				  	</c:choose>
				  </c:forEach>
				  <!-- next 표시 -->
				  <c:if test="${pageNavi.next }">
				    <li class="page-item" onClick="page(${pageNavi.endPage + 1})">
				      <a class="page-link" href="#">Next</a>
				    </li>
				  </c:if>
				  </ul>
				  
				</nav>
			    <!-- 페이지끝 -->
			</div>
			<!-- 페이징 끝 -->
	<form method=get action=/index name=listForm>
		<!-- 상세보기 검색 유지용 -->
		<input type=hidden name=pageNo value="${pageNavi.paging.pageNo }">
		<!-- 상세보기 검색 유지용 끝 -->
	</form>
	<script type="text/javascript">
		
		function page(page){
			document.listForm.action="/index";
			document.listForm.pageNo.value=page;
			document.listForm.submit();
		}
		
	</script>
</body>
</html>