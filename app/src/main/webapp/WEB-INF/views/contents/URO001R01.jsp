<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
officeList ${regionalCode}<br/>
	<script>
	var timeoutComplete = false;
	var ajaxComplete = true;
	var cityNum = ${cityList.size()};
	var completeNum = 0;
	function Loading() {
	    var maskHeight = $(document).height();
	    var maskWidth  = window.document.body.clientWidth;
	     
	    var mask       = "<div id='mask' style='position:absolute; z-index:9000; background-color:#000000; display:none; left:0; top:0;'></div>";
	    var loadingImg ='';
	     
	    loadingImg +=" <div id='loadingImg'  style='position:absolute; z-index:9500; text-align:center; display:block; margin-top:300px; margin-left:750px;'/>";
	    loadingImg += "lodaing...";
	    loadingImg += "</div>";  
	 
	    $('body')
	        .append(mask)
	 
	    $('#mask').css({
	            'width' : maskWidth,
	            'height': maskHeight,
	            'opacity' :'0.3'
	    });
	    
	    $('#mask').show();
	  
	    $('.loadingImg').append(loadingImg);
	    $('#loadingImg').show();
	}
	function closeLoading() {
		  $('#mask, #loadingImg').hide();
		  $('#mask, #loadingImg').remove();
	}
	function closeLoading_timeout() {
		console.log("timeoutComplete");
		timeoutComplete = true;
		if(ajaxComplete ) {
			console.log("timeout and ajaxComplete close Modal");
			closeLoading();
		}
	}

	function onComplete(response, status, xhr) {
		if (status == "error") {
			console.log("error");
			ajaxComplete=true;
			closeLoading();
		} else {
			completeNum++;
			if(completeNum == cityNum) {
				console.log("ajaxComplete");
				ajaxComplete = true;
				if(timeoutComplete) {
					console.log("timeout and ajaxComplete close Modal");
					closeLoading();
				}
			}
		}
	}

	Loading();
	setTimeout("closeLoading_timeout()", 1000);
	</script>
	<div class="work-area">
		<c:forEach var="city" items="${cityList}" varStatus="status">
			<div class="card">
				<div class="card-header">${city.name}</div>
				<div id="ajax-result-${city.code}">
				<script>
					$("#ajax-result-${city.code}").load("/office/${regionalcode}/${city.code}/", onComplete);
				</script>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>