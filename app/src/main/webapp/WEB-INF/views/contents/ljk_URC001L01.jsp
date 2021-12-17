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
	
		<div align="center" class="title">
			<h2>�Խ��Ǹ���Ʈ</h2>
		</div>
		<div align="right">
			<input type="button" value="�۾���"  onclick="location.href='/consulting/create'" class="btn btn-primary" style="margin-right: 20px">
		</div>
		<div>
		<table class="table table-striped">
		<thead>
		<tr>
			<th>��Ϲ�ȣ</th>
			<th>�ۼ���</th>
			<th>�н�����</th> <!-- �Ⱥ��̰� -->
			<th>����</th>
			<th>����</th>		<!-- �Ⱥ��̰� -->
			<th>�����÷���</th> <!-- �Ⱥ��̰� -->
			<th>�ۼ���</th>
			<th>������</th>
		</tr>
		</thead>
		
		</tbody>
		<c:forEach var="list" items="${list}">
		<tr>
			<td><a href="/consulting/update?no=${list.consulting_registerno}">${list.consulting_registerno }</td>
			<td>${list.consulting_author }</td>
			<td>${list.consulting_password }</td>	<!-- �Ⱥ��̰� -->
			<td><a href="/admin/consulting/detail?no=${list.consulting_registerno}">${list.consulting_title }</td>
			<td>${list.consulting_content }</td>	<!-- �Ⱥ��̰� -->
			<td>${list.consulting_deleteflag }</td>	<!-- �Ⱥ��̰� -->
			<td>${list.consulting_writedate }</td>
			<td>${list.consulting_rewritedate }</td>
		</tr>		
		</c:forEach>
		<tbody>
		</table>
		</div>
	
				<!-- ������ -->                          
                <nav aria-label="...">
				  <ul class="pagination">
				  <!-- prev ǥ�� -->
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
				  <!-- next ǥ�� -->
				  <c:if test="${pageNavi.next }">
				    <li class="page-item" onClick="page(${pageNavi.endPage + 1})">
				      <a class="page-link" href="#">Next</a>
				    </li>
				  </c:if>
				  </ul>
				  
				</nav>
			    <!-- �������� -->
			</div>
			<!-- ����¡ �� -->
	<form method=get action=/index name=listForm>
		<!-- �󼼺��� �˻� ������ -->
		<input type=hidden name=pageNo value="${pageNavi.paging.pageNo }">
		<!-- �󼼺��� �˻� ������ �� -->
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