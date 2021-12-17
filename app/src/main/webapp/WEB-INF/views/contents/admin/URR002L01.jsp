<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="work-area">
	<div style="margin: 0 auto; width: 70%;">
		<script type="text/javascript">
		$(document).ready(function(){
			$("#search").change(function(){
				//console.log($("#search").val());
				$("#searchForm").submit();
			});
		});
		
			function page(page){
				document.listForm.action="/admin/room";
				document.listForm.pageNo.value=page;
				document.listForm.submit();
			}
			
		</script>
		<div style="text-align: right">
			<a href="/admin/room/create?id=${id}&area=${area}"><input type="button" class="btn btn-outline-primary" value="登録"></a>
			<a href="/admin/builids"><input type="button" class="btn btn-outline-dark" value="建物リスト"></a>
		</div>
		<form id="searchForm" action="/admin/room" method="get">
			<select id="search" name="search">
				<option value=""></option>
				<c:forEach var="room" items="${roomList }">
					<option value="${room.code }">${room.name } </option>
				</c:forEach>
			</select>
			<input type=hidden name=pageNo value="${pageNavi.paging.pageNo }">
			<input type=hidden name=id value="${id}">
			<input type=hidden name=area value="${area}">
			<a href="/admin/room?id=${id}&area=${area}&search=${search}"><input type="button" class="btn btn-outline-dark btn-sm" value="リスト"></a>
		</form>
		<div class="table-responsive">
			<table class="table table-striped" style="margin-top: 20px">
				<thead>
					<tr class="bg-light">
						<th scope="col" style="text-align: center">番号</th>
						<th scope="col" style="text-align: center">地域</th>
						<th scope="col" style="text-align: center">間取り</th>
						<th scope="col" style="text-align: center">床面積</th>
						<th scope="col" style="text-align: center">敷金</th>
						<th scope="col" style="text-align: center">礼金</th>
						<th scope="col" style="text-align: center">部屋の番号</th>
						<th scope="col" style="text-align: center">家賃</th>
						<th scope="col" style="text-align: center">階</th>
						<th scope="col" style="text-align: center">詳細ページ</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="goods">
						<fmt:formatNumber type="number" maxFractionDigits="3"
							value="${goods.room_yaching}" var="yaching"></fmt:formatNumber>
						<input type="hidden" name="room_registerNo" value="${goods.room_registerNo}" >
						<input type="hidden" name="zone_registerNo" value="${goods.zone_registerNo}" >
						<input type="hidden" name="zone_officalName" value="${goods.zone_officalName}" >
						<tr>
							<td style="text-align: center">${goods.room_registerNo}</td>
							<td style="text-align: center">${goods.arname}</td>
							<td style="text-align: center">${goods.rcname}</td>
							<td style="text-align: center">${goods.room_flowArea}m<sup>2</sup></td>
							<td style="text-align: center">${goods.room_sikiking}ヶ月</td>
							<td style="text-align: center">${goods.room_racing}</td>
							<td style="text-align: center">${goods.room_roomNo}</td>
							<td style="text-align: center">${yaching}</td>
							<td style="text-align: center">${goods.room_numOfFloors}</td>
							<td style="text-align: center">
							<a href="/admin/room/detail?id=${goods.room_registerNo}">
								<input type="button" class="btn btn-outline-primary" value="詳細"></a>
							</td>
						</tr>
					</c:forEach>
					<c:if test="${list.size() == 0}">
						<tr>
							<td colspan='10' align="center" style="font-size: 30px">部屋が存在しません。</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div>
	
		<!-- 페이징 소스 -->
		<div id="pagination-box">
			<nav style="vertical-align: middle;" aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
					<c:if test="${pageNavi.prev}">
						<li class="page-item" onClick="javascript:page(1);"><a class="page-link"
							href="#" tabindex="-1">&lt;&lt;</a></li>
						<li class="page-item" onClick="javascript:page(${pageNavi.startPage-1});"><a class="page-link"
							href="#" tabindex="-1">&lt;</a></li>
					</c:if>
					<c:forEach begin="${pageNavi.startPage }" end="${pageNavi.endPage }"
						var="page">
						<li class="page-item ${pageNavi.paging.pageNo eq page ? 'active' : ''}" onClick="page(${page })" ><a class="page-link" href="#">${page }</a></li>
					</c:forEach>
					<c:if test="${pageNavi.next}">
						<li class="page-item" onClick="page(${pageNavi.endPage+1});"><a class="page-link" href="#">&gt;</a></li>
						<li class="page-item" onClick="page(${pageNavi.endPageNo});"><a class="page-link" href="#">&gt;&gt;</a></li>
					</c:if>
				</ul>
			</nav>
		</div>	
		<!-- 페이징 끝 -->
		<form method=get action=/admin/room name=listForm>
			<!-- 상세보기 검색 유지용 -->
			${pageNavi.paging.type }
			<input type=hidden name=pageNo value="${pageNavi.paging.pageNo }">
			<input type=hidden name=id value="${id}">
			<input type=hidden name=area value="${area}">
			<input type=hidden name=search value="${search}">
			<!-- 상세보기 검색 유지용 끝 -->
		</form>
	</div>
</div>
	