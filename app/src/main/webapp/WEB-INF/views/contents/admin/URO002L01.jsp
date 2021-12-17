<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<title>영업소 전체 리스트/지역/이름 검색</title>

<div class="work-area">

	<script type="text/javascript">
		function page(page){
			document.listForm.action="/admin/office";
			document.listForm.pageNo.value=page;
			document.listForm.submit();
		}
		
		
		
		$(document).ready(function() {
			let result ="";
		    $('#zone_entireRegionalCode').change(function() {
		    	$.ajax({
		    		url:'/admin/office/'+$('select[id=zone_entireRegionalCode]').val(),
		    		method: 'get',
		    		dataType:'json',
		    		success: function(datas, status){
		    			result = ""
		    			$("#zone_areaRegionalCode").html(result);
		    			$("#zone_stateRegionalCode").html(result);
		    			console.log(datas);
		    			if(datas.result != "error"){
		    				console.log("codeBList @@@@@@@@@@ : "+ datas.result);
		    				result += "<option value=''> </option>"
		    				$.each(datas.result, function(i, data){
		    					result += "<option value='"+data.code+"'>"+data.name+"</option>"
		    				});
		    				$("#zone_areaRegionalCode").html(result);
		    			} else{
		    				$("#zone_areaRegionalCode").html(result);
		    			}
		    		},
		    		error: function(errorThorwon){
		    			console.log(errorThorwon);
		    		}
		    	});
		  	}); 
		    $('#zone_areaRegionalCode').change(function() {
		    	$.ajax({
		    		url:'/admin/office/'+$('select[id=zone_entireRegionalCode]').val()+'/'+$('select[id=zone_areaRegionalCode]').val(),
		    		method: 'get',
		    		dataType:'json',
		    		success: function(datas, status){
		    			let result ="";
		    			console.log(datas);
		    			if(datas.result != "error"){
		    				console.log("codeCList @@@@@@@@@@ : " + datas.result)
		    				result += "<option value=''> </option>"
		    				$.each(datas.result, function(i, data){
		    					result += "<option value='"+data.code+"'>"+data.name+"</option>"
		    				});
		    				$("#zone_stateRegionalCode").html(result);
		    			} else{
		    				$("#zone_stateRegionalCode").html(result);
		    			}
		    		},
		    		error: function(errorThorwon){
		    			console.log(errorThorwon);
		    		}
		    	});
		  	});
		});
		
		

	</script>


	<h1 class="text-center fs-1">영업소 리스트</h1>
	<div style="margin: 30px;">
		<div>
			<form name="search" action="/admin/office/search" method="post">
				<div class="row g-3 align-items-center" style="float: left;">
					<div class="input-group">
						<p style="padding-top: 10px; padding-right: 10px;">전체 :</p>
						<select class="form-select" id="zone_entireRegionalCode"
							name="zone_entireRegionalCode"
							aria-label="Example select with button addon" style="width:150px;">
							<option value = '' selected>전체검색</option>
							<c:forEach var="codeAList" items="${codeAList}">
								<option value="${codeAList.code}">${codeAList.name}</option>
							</c:forEach>
						</select> 
						<select class="form-select"
							aria-label="Example select with button addon"
							id="zone_areaRegionalCode" name="zone_areaRegionalCode" style="width:150px;">
							<option value="" selected></option>
							<c:forEach var="codeBList" items="${codeBListAll}">
								<option value="${codeBList.code}"
									<c:if test="${codeBList.code == update.zone_areaRegionalCode}">selected</c:if>>${codeBList.name}</option>
							</c:forEach>
						</select> 
						<select class="form-select"
							aria-label="Example select with button addon"
							id="zone_stateRegionalCode" name="zone_stateRegionalCode" style="width:150px;">
							<option value="" selected></option>
							<c:forEach var="codeCList" items="${codeCListAll}">
								<option value="${codeCList.code}"
									<c:if test="${codeCList.code == update.zone_stateRegionalCode}">selected</c:if>>${codeCList.name}</option>
							</c:forEach>
						</select>
						<input id="search_name" name="search_name" type="text" class="form-control" aria-label="Text input with dropdown button" placeholder="영업소 검색" style="width:150px;">
						<button class="btn btn-outline-secondary" type="submit">검색</button>
					</div>
				</div>
			</form>
			<div>
				<button type="button" class="btn btn-primary"
					onclick="location.href='/admin/office/officeWriteForm'" style="margin-left: 10px" >영업소
					등록</button>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${fn:length(list) == 0}">
			<h1 class="text-center fs-1">정보 없음</h1>
		</c:when>
		<c:otherwise>
			<div class="List" style="margin-top: 20px;">
				<c:forEach var="list" items="${list }">
					<div class="row" style="display: inline-block; margin: 10px;">
						<div class="col-sm-6" style="width: 100%">

							<div class="card" style="width: 18rem; display: inline-block;">
								<c:url value="/fileDisplay" var="urlThum">
									<c:param name="file_name" value="${list.sales_img}"></c:param>
								</c:url>
								<img src="${urlThum}" class="card-img-top" alt="영업소 이미지">
								<div class="card-body">
									<h5 class="card-title">${list.sales_officeName }</h5>

									<p class="card-text" style="margin-bottom: 0.5rem;">${list.e_name }
										${list.a_name } ${list.s_name }</p>


									<a href="/admin/office/detail?no=${list.sales_registerNo}">
										${list.sales_officeName} 영업소 상세 보기 </a>
								</div>
							</div>

						</div>
					</div>
				</c:forEach>
			</div>
			<!-- 페이징 소스 -->
				<div id="pagination-box">
					<nav style="vertical-align: middle;" aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<c:if test="${pageNavi.prev}">
								<li class="page-item" onClick="javascript:page(${pageNavi.startPage-1});"><a class="page-link"
									href="#" tabindex="-1">&lt;</a></li>
							</c:if>
							<c:forEach begin="${pageNavi.startPage }" end="${pageNavi.endPage }"
								var="page">
								<li class="page-item ${pageNavi.paging.pageNo eq page ?'active':''}"  onClick="page(${page })"><a class="page-link" href="#">${page }</a></li>
							</c:forEach>
							<c:if test="${pageNavi.next}">
								<li class="page-item" onClick="page(${pageNavi.endPage+1});"><a class="page-link" href="#">&gt;</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
				<!-- 페이징 끝 -->
				<form method=get action=/admin/office name=listForm>
					<!-- 상세보기 검색 유지용 -->
					${pageNavi.paging.type } <input type=hidden name=pageNo
						value=${pageNavi.paging.pageNo }>
					<!-- 상세보기 검색 유지용 끝 -->
			
				</form>
		</c:otherwise>
	</c:choose>
</div>












