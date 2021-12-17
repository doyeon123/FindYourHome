<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="work-area">
		<div class="card">
			<div class="card-header">地域選択</div>
			<div class="accordion accordion-flush" id="accordionExample">
			<c:forEach var="area" items="${areaList}" varStatus="status">
				<div class="accordion-item">
					<h2 class="accordion-header" id="heading-${area.code}">
						<button class="accordion-button collapsed" type="button"
							data-bs-toggle="collapse" data-bs-target="#collapse-${area.code}" 
							aria-controls="collapse-${area.code}">
							${area.name}</button>
					</h2>
					<div id="collapse-${area.code}" class="accordion-collapse collapse"
						aria-labelledby="heading-${area.code}" data-bs-parent="#accordionExample">
						<div class="accordion-body">
						<c:forEach var="regional" items="${regionalList[status.index]}" varStatus="status2"> 
							<a class="btn btn-primary" href="/office/${regional.code}/" role="button">${regional.name}</a>
						</c:forEach>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>