<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="list-group loadingImg">
		<c:forEach var="office" items="${officeList}">
			<a href="./${citycode}/detail?id=${office.sales_registerno}" class="list-group-item list-group-item-action">
				<div class="card mb-3">
					<div class="row g-0">
						<div class="col-md-4">
							<img src="..." class="img-fluid rounded-start" alt="...">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">${office.sales_officename}</h5>
								<p class="card-text">${office.sales_officename}</p>
								<p class="card-text">
									<small class="text-muted">something</small>
								</p>
							</div>
						</div>
					</div>
				</div>
			</a>
		</c:forEach>  
	</div>
</body>
</html>