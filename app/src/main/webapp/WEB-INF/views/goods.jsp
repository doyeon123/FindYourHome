<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>HiRDB Select</title>
</head>
<body>
	<h1>
		HiRDB findAll  
	</h1>
	<hr/>
	<table border="1">
		<c:forEach items="${list}" var="goods" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${goods.goodscd}</td>
				<td>${goods.goodsname}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>