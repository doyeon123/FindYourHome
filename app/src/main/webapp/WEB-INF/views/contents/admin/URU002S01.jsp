<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<meta charset="UTF-8">
<script type="text/javascript">
		function page(page){
			document.listForm.action="/admin/receipt/search";
			document.listForm.pageNo.value=page;
			document.listForm.submit();
		}
		$(document).ready(function() {
			let result ="";
		    $('#zone_entireRegionalCode').change(function() {
		    	$.ajax({
		    		url:'/admin/receipt/search/'+$('select[id=zone_entireRegionalCode]').val(),
		    		method: 'get',
		    		dataType:'json',
		    		success: function(datas, status){
		    			result = ""
		    			$("#zone_areaRegionalCode").html(result);
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
		    		url:'/admin/receipt/search/'+$('select[id=zone_entireRegionalCode]').val()+'/'+$('select[id=zone_areaRegionalCode]').val(),
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



<div class="work-area">



<h1 class="text-center fs-1"> 検索　</h1>
	<div>
		<form name="search" action="/admin/receipt/search" method="post">
			<div class="row g-3 align-items-center" style="float:left;">
				<div class="input-group">
			
			<p style="padding-top: 20px; padding-right: 20px"> 地域 : </p>
				<select calss="form-select" id="zone_entireRegionalCode" name="zone_entireRegionalCode" aria-label="Example select with button addon">
					<option value="" selected></option>
						<c:forEach var="codeAList" items="${codeAList}">
				      	  <option value="${codeAList.code}">${codeAList.name}</option>
				     	</c:forEach>
				</select>
				<select class="form-select" aria-label="Example select with button addon" id="zone_areaRegionalCode" name="zone_areaRegionalCode">
			        <option value="" selected></option>
			        	<c:forEach var="codeBList" items="${codeBListAll}">
					        <option value="${codeBList.code}">${codeBList.name}</option>
					     </c:forEach>
		        </select>
		        <select class="form-select" aria-label="Example select with button addon" id="zone_stateRegionalCode" name="zone_stateRegionalCode">
			        <option value="" selected></option>
			        	<c:forEach var="codeCList" items="${codeCListAll}">
					        <option value="${codeCList.code}">${codeCList.name}</option>
					     	</c:forEach>
		        </select> 
				</div>	
				<div>	
		        <input id="zone_officalName" name="zone_officalName" type="text" class="form-control" aria-label="Text input with dropdown button" placeholder="建物検索">
				<button class="btn btn-outline-secondary" type="submit">検索</button>
				</div>
	</div>
	</form>

<c:choose>
        	<c:when test="${fn:length(list) == 0}"><h1 class="text-center fs-1">結果がありません</h1></c:when>
        	<c:otherwise>
	        	<div class="List" style="margin-top:50px;">
	        		<c:forEach var="buildList" items="${list}">
		        		<div class="row" style="display:inline-block; margin:10px;">
		  					<div class="col-sm-6" style="width:100%">
		  					
				        		<div class="card" style="width: 18rem; display:inline-block;">
					        		<c:url value="/fileDisplay" var="urlThum">
										<c:param name="file_name" value="${buildList.zone_buildingImg}"></c:param>
									</c:url>
								  <img src="${urlThum}" class="card-img-top" alt="건물 이미지">
								  <div class="card-body">
								    <h5 class="card-title">${buildList.zone_officalName }</h5>
								    <p class="card-text" style="margin-bottom: 0.5rem;">${buildList.a_name } ${buildList.s_name }</p>
								    <a href="/admin/builds?no=${buildList.zone_registerNo}" class="btn btn-primary">자세히 보기</a>
								  </div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

		
		
	
	</c:otherwise>
        </c:choose>
	
	
	
	</div>


</div>