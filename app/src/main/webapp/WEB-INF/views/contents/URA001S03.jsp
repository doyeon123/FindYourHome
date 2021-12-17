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
		<div class="card-header">市・区</div>
	    <div class="city_title">
			<c:forEach var="prefecture" items="${prefectureList}"> 
				<a class="btn btn-secondary" role="button">${prefecture.name}</a>
			</c:forEach>
		</div>	
	</div>
</div>	

<!-- Search -->
<form action="/area/${prefectureCode}/${cityCode}/build" method="post" style="position: reletive; left:500px; bottom: 400px">
	<div class="card-header">
	<ul class="list-group" style="width: 62%">
		<span class="badge bg-success" style="font-size: 1.5em">条件指定</span></ul>
	<div class="searchDatail_table">
		<ul class="list-group" style="width: 62%">
		  <span class="badge bg-warning text-dark" style="font-size: 16px">間取り</span>
		  <li class="list-group-item" style="padding-right: 10px">
		  	<c:forEach var="room" items="${roomList}" varStatus="status1">
       				<input name="room_structure" type="checkbox" value="${room.code}">${room.name}
           	</c:forEach>
          </li>
        </ul>
		  <ul class="list-group" style="width: 62%">
		  <span class="badge bg-warning text-dark" style="font-size: 16px">設備</span>
		  <li class="list-group-item">
		  	<c:forEach var="equip" items="${equipList}" varStatus="status2">
       			<c:if test="${status2.index != 12}">
        			<input name="zone_note" type="checkbox" value="${equip.code}">${equip.name}
       			</c:if>
       			<c:if test="${status2.index == 12}">
       				<br>	
        			<input type="checkbox" value="${equip.code}">${equip.name}        			
        			<div class="internet_type">
	        			<c:forEach var="internet" items="${internetList}">
	        				<input name="zone_note" type="checkbox" value="${internet.code}">${internet.name}
	        			</c:forEach>
        			</div>
       			</c:if>
          	</c:forEach>
		  </li>
		</ul>
		<ul class="list-group" style="width: 62%">
			<span class="badge bg-warning text-dark" style="font-size: 16px">家賃</span>
			<li class="list-group-item">
				<select class="" name="yachingList" id="yachingList" >
				    <option value="${yachingList}">下限なし</option>
				</select> ~
				<select class="" name="yachingList" id="yachingList" >
				    <option value="${yachingList}">上限なし</option>
				</select>
			</li>
		</ul>
	</div>
	<!-- button -->
	<div style="margin-top: 10px">
        <button class="btn btn-info" type="submit">検索</button>
    </div>
   </div>	
</form>


	
</body>
</html>