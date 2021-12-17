<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--Attributes 
	path : area or office set in /office,/area
	--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<div class="work-area">
	<div class="card">
		<div class="card-header">市・区</div>
	    <div class="city_title">
			<c:forEach var="prefecture" items="${prefectureList}"> 
				<a class="btn btn-secondary" href="/area/${prefecture.code2}/${prefecture.code1}" role="button">${prefecture.name}</a>
			</c:forEach>
		</div>	
	</div>
</div>
</body>
</html>
