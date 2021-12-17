<%@ page language="java" contentType="text/html; charset=EUC-JP"
    pageEncoding="EUC-JP"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Search Page</title>
</head>
<body>
	<form>
		<div id="area">
			<c:forEach var="SearchVO" items="${databaselistArea}">
			<option value="${databaseArea}">
        		${databaseArea}   
			</c:forEach>
		</div>
		<div id="prefecture">
			<c:forEach var="SearchVO" items="${databaselistPrefecture}">
			<option value="${databasePrefecture}">
        		${databasePrefecture}
    		</option>
			</c:forEach>
		</div>
		<div id="city">
			<c:forEach var="SearchVO" items="${databaselistCity}">
			<option value="${databaseCity}">
        		${databaseCity}
    		</option>
			</c:forEach>
		</div>
		<div id="state">
			<c:forEach var="SearchVO" items="${databaselistCategory}">
			<option value="${databaseCategory}">
        		${databaseCategory}
    		</option>
			</c:forEach>
		</div>
		<div id="room">
			<c:forEach var="SearchVO" items="${databaselistRoom}">
			<option value="${databaseRoom}">
        		${databaseRoom}
    		</option>
			</c:forEach>
		</div>
		<div class="button">
     		<div class="accordion-body">
				<a class="btn btn-primary" href="javascript:void(0)" role="button">륫빕</a> 
				<a class="btn btn-primary" href="javascript:void(0)" role="button">��κⅱ</a>
			</div>
		</div>
	</form>
</body>
</html>