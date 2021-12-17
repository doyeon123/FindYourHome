<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="work-area">
	<script type="text/javascript">
		function page(page){
			document.listForm.action="/admin/builids";
			document.listForm.pageNo.value=page;
			document.listForm.submit();
		}
		$(document).ready(function() {
			let result ="";
		    $('#search_codeA').change(function() {
		    	$.ajax({
		    		url:'/admin/builids/'+$('select[id=search_codeA]').val(),
		    		method: 'get',
		    		dataType:'json',
		    		success: function(datas, status){
		    			result = ""
		    			$("#search_codeB").html(result);
		    			console.log(datas);
		    			if(datas.result != "error"){
		    				console.log("codeBList @@@@@@@@@@ : "+ datas.result);
		    				result += "<option value=''> </option>"
		    				$.each(datas.result, function(i, data){
		    					result += "<option value='"+data.code+"'>"+data.name+"</option>"
		    				});
		    				$("#search_codeB").html(result);
		    			} else{
		    				$("#search_codeB").html(result);
		    			}
		    		},
		    		error: function(errorThorwon){
		    			console.log(errorThorwon);
		    		}
		    	});
		  	}); 
		    $('#search_codeB').change(function() {
		    	$.ajax({
		    		url:'/admin/builids/'+$('select[id=search_codeA]').val()+'/'+$('select[id=search_codeB]').val(),
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
		    				$("#search_codeC").html(result);
		    			} else{
		    				$("#search_codeC").html(result);
		    			}
		    		},
		    		error: function(errorThorwon){
		    			console.log(errorThorwon);
		    		}
		    	});
		  	});
		});
	</script>
	<h1 class="text-center fs-1">建物リスト</h1> 
		<div style="margin:20px;">
			<form name="search" action="/admin/builids" method="get">
				<div class="row g-3 align-items-center" style="float:left;">
		        	<div class="input-group">
		        	<p style="padding-top: 10px; padding-right: 10px;">全体 : </p>
						<select class="form-select" id="search_codeA" name="search_codeA" aria-label="Example select with button addon">
							<option value="" selected></option>
							<c:forEach var="codeAList" items="${codeAList}">
				        		<option value="${codeAList.code}">${codeAList.name}</option>
				     		</c:forEach>
						</select>
						<select class="form-select" aria-label="Example select with button addon" id="search_codeB" name="search_codeB">
			        		<option value="" selected></option>
			        		<c:forEach var="codeBList" items="${codeBListAll}">
					        	<option value="${codeBList.code}">${codeBList.name}</option>
					     	</c:forEach>
		        		</select>
		        		<select class="form-select" aria-label="Example select with button addon" id="search_codeC" name="search_codeC">
			        		<option value="" selected></option>
			        		<c:forEach var="codeCList" items="${codeCListAll}">
					        	<option value="${codeCList.code}">${codeCList.name}</option>
					     	</c:forEach>
		        		</select>
		        		<input id="search_name" name="search_name" type="text" class="form-control" aria-label="Text input with dropdown button" placeholder="建物検索">
						<button class="btn btn-outline-secondary" type="submit">検索</button>
					</div>
		        </div>
	        </form>
	        <div>
				<button type="button" class="btn btn-primary" onclick="location.href='/admin/builids/create'" style="float: right;">建物登録</button>
			</div>
		</div>
        <c:choose>
        	<c:when test="${fn:length(list) == 0}">
        		<div style="margin: 100px;">
        			<h1 class="text-center fs-1">結果がありません</h1>
        		</div>
        	</c:when>
        	<c:otherwise>
	        	<div class="List" style="margin-top:70px;">
	        		<c:forEach var="buildList" items="${list}">
		        		<div class="row" style="display:inline-block; margin:10px;">
		  					<div class="col-sm-6" style="width:100%">
		  					
				        		<div class="card" style="width: 18rem; display:inline-block;">
					        		<c:url value="/fileDisplay" var="urlThum">
										<c:param name="file_name" value="${buildList.zone_buildingImg}"></c:param>
									</c:url>
								  <img src="${urlThum}" class="card-img-top" alt="建物イメージ">
								  <div class="card-body">
								    <h5 class="card-title">${buildList.zone_officalName }</h5>
								    <p class="card-text" style="margin-bottom: 0.5rem;">${buildList.a_name } ${buildList.s_name }</p>
								    <a href="/admin/builds?no=${buildList.zone_registerNo}" class="btn btn-primary">詳細</a>
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
				<form method=get action=/admin/builids name=listForm>
					<!-- 상세보기 검색 유지용 -->
					${pageNavi.paging.type } <input type=hidden name=pageNo
						value=${pageNavi.paging.pageNo }>
					<!-- 상세보기 검색 유지용 끝 -->
				</form>
        	</c:otherwise>
        </c:choose>
</div>