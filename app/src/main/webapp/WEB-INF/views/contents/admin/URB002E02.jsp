<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<div class="work-area">
    		<div class="container-md" style="border: 1px solid;"> 
    		<%-- <c:set var="form" value="/admin/builids/create" />
    		<c:if test="${not empty update.zone_registerNo}">
    			<c:set var="form" value="/admin/builids/update" />
   			</c:if> <c:out value="${form}" /> --%>        
		        <form name="form_1" action="${form}" method="post" onsubmit="return formCheck();" enctype="multipart/form-data">
		        <div class="row" style="display:flex; padding: 12px; border-bottom: 1px solid;">
			        <div class="col-sm-4">
			        <input type="hidden" name="zone_registerNo" value="${update.zone_registerNo}">
				        <p>
				        	FP(지역코드 : 전체) : 
				        	<select id="zone_entireRegionalCode" name="zone_entireRegionalCode">
				        		<option value=""> </option>
				        		<c:forEach var="codeAList" items="${codeAList}">
						        	<option value="${codeAList.code}" <c:if test="${codeAList.code == update.zone_entireRegionalCode}">selected</c:if> >${codeAList.name}</option>
						     	</c:forEach>
			        		</select>
				        </p>
			        </div>
			        <div class="col-sm-4" id="zone_areaRegionalCode0">       
				        <p>
				        	FK(지역코드 : 구역) :
				        	<select id="zone_areaRegionalCode" name="zone_areaRegionalCode">
				        		<c:forEach var="codeBList" items="${codeBListAll}">
						        	<option value="${codeBList.code}" <c:if test="${codeBList.code == update.zone_areaRegionalCode}">selected</c:if> >${codeBList.name}</option>
						     	</c:forEach>
			        		</select>
				        </p>
			        </div>       
			        <div class="col-sm-4" id="zone_stateRegionalCode0">       
				        <p>
				        	FK(지역코드 : 구(시)) :
				        	<select id="zone_stateRegionalCode" name="zone_stateRegionalCode">
				        		<c:forEach var="codeCList" items="${codeCListAll}">
						        	<option value="${codeCList.code}" <c:if test="${codeCList.code == update.zone_stateRegionalCode}">selected</c:if> >${codeCList.name}</option>
						     	</c:forEach>
			        		</select>
				        </p>
			        </div>
		        </div>
		  		<div class="row" style="padding: 12px; border-bottom:1px solid;">
			    	<label for="exampleInputPassword1" class="form-label">명칭</label>
			    	<input type="text" id="zone_officalName" name="zone_officalName" autocomplete="off" placeholder="명칭" value="${update.zone_officalName}" class="form-control">
			  	</div>
			  	<div class="row" style="display:flex; padding-bottom: 5px; padding-top: 12px; border-bottom: 1px solid;">
			  		<div class="col-sm-8">
				    	<label for="exampleInputPassword1" class="form-label">공익비</label>
				    	<input type="text" id="zone_maintenaceCost" name="zone_maintenaceCost" autocomplete="off" placeholder="공익비" value="${update.zone_maintenaceCost}" class="form-control">
				  	</div>
			  		<div class="col-sm-4">
				    	<label for="exampleInputPassword1" class="form-label">공익비FLAG</label>
				    	<div class="checkstyle" style="display: flex; padding: 5px;">
			               	<div class="mb-3 form-check" style="margin-left: 10px;">
						   		<input name="zone_maintenaceCostFlag" type="radio" class="form-check-input" value="1">
						    	<label class="form-check-label" for="zone_maintenaceCostFlag1">유</label>
						  	</div>
			               	<div class="mb-3 form-check" style="margin-left: 10px;">
						   		<input name="zone_maintenaceCostFlag" type="radio" class="form-check-input" value="0">
						    	<label class="form-check-label" for="zone_maintenaceCostFlag0">무</label>
						  	</div>
				  		</div>
				  	</div>
			  	</div>
			  	<div class="row" style="display:flex; padding-bottom: 12px; padding-top: 12px; border-bottom:1px solid;">
			  		<div class="col-sm-4">
				    	<label for="exampleInputPassword1" class="form-label">우편번호</label>
				    	<input type="text" id="zone_postalCode" name="zone_postalCode" autocomplete="off" placeholder="우편번호" value="${update.zone_postalCode}" class="form-control">
				  	</div>
			  		<div class="col-sm-8">
				    	<label for="exampleInputPassword1" class="form-label">주소</label>
				    	<input type="text" id="zone_address" name="zone_address" autocomplete="off" placeholder="주소" value="${update.zone_address}" class="form-control">
				  	</div>
			  	</div>
			  	<div class="row" style="display:flex; padding-bottom: 12px; padding-top: 12px; border-bottom:1px solid;">
			  		<div class="col-sm-4">
				    	<label for="exampleInputPassword1" class="form-label">세대수</label>
				    	<input type="text" id="zone_houseHoldsNo" name="zone_houseHoldsNo" autocomplete="off" placeholder="세대수" value="${update.zone_houseHoldsNo}" class="form-control">
				  	</div>
				  	<div class="col-sm-4">
				    	<label for="exampleInputPassword1" class="form-label">관리연수</label>
				    	<input type="text" id="zone_managementYear" name="zone_managementYear" autocomplete="off" placeholder="관리연수" value="${update.zone_managementYear}" class="form-control">
				  	</div>
			  		<div class="col-sm-4">
				    	<label for="exampleInputPassword1" class="form-label">주차장정보</label>
				    	<input type="text" id="zone_parkingLotInfo" name="zone_parkingLotInfo" autocomplete="off" placeholder="주차장정보" value="${update.zone_parkingLotInfo}" class="form-control">
				  	</div>
			  	</div>
			  	<div class="row" style="display:flex; padding-bottom: 12px; padding-top: 12px; border-bottom:1px solid;">
			  		<div class="col-sm-6">
				    	<label for="exampleInputPassword1" class="form-label">교통정보</label>
				    	<input type="text" id="zone_trafficInfo" name="zone_trafficInfo" autocomplete="off" placeholder="교통정보" value="${update.zone_trafficInfo}" class="form-control">
				  	</div>
			  		<div class="col-sm-6">
				    	<label for="exampleInputPassword1" class="form-label">교통정보(파일링크)</label>
				    	<input type="text" id="zone_trafficInfoLink" name="zone_trafficInfoLink" autocomplete="off" placeholder="교통정보(파일링크)" value="${update.zone_trafficInfoLink}" class="form-control">
				  	</div>
			  	</div>
			  	<div class="row" style="display:flex; padding-bottom: 12px; padding-top: 12px; border-bottom:1px solid;">
			  		<div class="col-sm-6">
				    	<label for="exampleInputPassword1" class="form-label">건물구조</label>
				    	<input type="text" id="zone_buildingStructure" name="zone_buildingStructure" autocomplete="off" placeholder="건물구조" value="${update.zone_buildingStructure}" class="form-control">
				  	</div>
			  		<div class="col-sm-6">
				    	<label for="exampleInputPassword1" class="form-label">특징</label>
				    	<input type="text" id="zone_characteristic" name="zone_characteristic" autocomplete="off" placeholder="특징" value="${update.zone_characteristic}" class="form-control">
				  	</div>
			  	</div>
               	<label for="exampleInputPassword1" class="form-label">비고</label>
               	<div class="checkstyle" style="display: flex; padding: 5px;">
	               	<c:forEach var="eList" items="${codeEList}" varStatus="status" end="6">
		               	<div class="mb-3 form-check" style="margin-left: 10px;">
					   		<input name="zone_note" type="checkbox" class="form-check-input" value="${eList.code}" onclick="getCheckboxValue(event)" <c:forEach var="tempArr" items="${temp}"><c:if test="${eList.code == tempArr}">checked</c:if></c:forEach>>
					    	<label class="form-check-label" for="exampleCheck1">${eList.name}</label>
					  	</div>
				  	</c:forEach>
			  	</div>
			  	<div class="checkstyle" style="display: flex; padding: 5px;">
	               	<c:forEach var="eList" items="${codeEList}" varStatus="status" begin="7">
		               	<div class="mb-3 form-check" style="margin-left: 10px;">
					   		<input name="zone_note" type="checkbox" class="form-check-input" value="${eList.code}" onclick="getCheckboxValue(event)" <c:forEach var="tempArr" items="${temp}"><c:if test="${eList.code == tempArr}">checked</c:if></c:forEach>>
					    	<label class="form-check-label" for="exampleCheck1">${eList.name}</label>
					  	</div>
				  	</c:forEach>
			  	</div>
			  	<div id="internet" style="display: none; padding: 5px;">
	               	<c:forEach var="eList" items="${codeIList}" varStatus="status">
		               	<div class="mb-3 form-check" style="margin-left: 10px;">
					   		<input id="internet${status.index}" name="zone_note" type="checkbox" class="form-check-input" value="${eList.code}" <c:forEach var="tempArr" items="${temp}"><c:if test="${eList.code == tempArr}">checked</c:if></c:forEach>>
					    	<label class="form-check-label" for="exampleCheck1">${eList.name}</label>
					  	</div>
				  	</c:forEach>
			  	</div>
               	
			    <p> 배치도 : <input type="file" name="zone_layout" id="zone_layout" accept="image/*"></p>
		        <p> 건물이미지 : <input type="file" name="zone_buildingImg" id="zone_buildingImg" accept="image/*"></p>
		        <p> 위치이미지 : <input type="file" name="zone_locationImg" id="zone_locationImg" accept="image/*"></p>
		        <p> 구역이미지 : <input type="file" name="zone_regionalImg" id="zone_regionalImg" accept="image/*"></p>
		        <p> 주변이미지 : <input type="file" name="surroundingImg_images" id="surroundingImg_images" accept="image/*" multiple></p>
	
				<button class="btn btn-outline-primary" type="submit">등록</button>
				<button class="btn btn-outline-warning" type="reset" onclick="history.back(-1);">취소</button>
				<button class="btn btn-outline-dark" type="reset" onclick="location.href='/admin/builids'">목록</button>
	        </form>
	    </div>
    <script type="text/javascript">
	$(document).ready(function() {
		let result ="";
	    $('#zone_entireRegionalCode').change(function() {
	    	$.ajax({
	    		url:'/admin/builids/create/'+$('select[id=zone_entireRegionalCode]').val(),
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
	    				$("#zone_areaRegionalCode").html();
	    			}
	    			
	    		},
	    		error: function(errorThorwon){
	    			console.log(errorThorwon);
	    		}
	    		
	    	});
	  	}); 
	    
	    $('#zone_areaRegionalCode').change(function() {
	    	$.ajax({
	    		url:'/admin/builids/create/'+$('select[id=zone_entireRegionalCode]').val()+'/'+$('select[id=zone_areaRegionalCode]').val(),
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
	    				$("#zone_stateRegionalCode").html();
	    			}
	    			
	    		},
	    		error: function(errorThorwon){
	    			console.log(errorThorwon);
	    		}
	    		
	    	});
	  	});
	    
	}); 
	
	function getCheckboxValue(event)  {
		let result = '';
		if(event.target.value == 'E13')  {
			if(event.target.checked)
				document.getElementById("internet").style.display='flex';
			else{
				document.getElementById("internet0").checked = false;
				document.getElementById("internet1").checked = false;
				document.getElementById("internet2").checked = false;
				document.getElementById("internet3").checked = false;
				document.getElementById("internet4").checked = false;
				$("#internet").hide();
			}
		}
  	}
	
	function formCheck(){
		// 값 가져오기
		let zone_entireRegionalCode = $("#zone_entireRegionalCode").val();
		let zone_areaRegionalCode = $("#zone_areaRegionalCode").val();
		let zone_stateRegionalCode = $("#zone_stateRegionalCode").val();
		let zone_officalName = $("#zone_officalName").val();
		let zone_maintenaceCost = $("#zone_maintenaceCost").val();
		let zone_maintenaceCostFlag = $("input:checked[Name='zone_maintenaceCostFlag']").is(":checked")
		let zone_postalCode = $("#zone_postalCode").val();
		let zone_address = $("#zone_address").val();
		let zone_layout = $("#zone_layout").val();
		let zone_houseHoldsNo = $("#zone_houseHoldsNo").val();
		let zone_trafficInfo = $("#zone_trafficInfo").val();
		let zone_trafficInfoLink = $("#zone_trafficInfoLink").val();
		let zone_buildingStructure = $("#zone_buildingStructure").val();
		let zone_managementYear = $("#zone_managementYear").val();
		
		// 정규 표현식 작성
		var zone_officalNameReg = /^[a-zA-Z0-9ぁ-ゔァ-ヴー々〆〤一-龥]{1,20}$/;
		var zone_maintenaceCostReg = /^[0-9]*$/;
		var zone_postalCodeReg = /^[0-9]{1,7}$/;

		if(zone_entireRegionalCode == ""){
			alert("지역을 선택해 주세요.");
			$("#zone_entireRegionalCode").focus();
			return false;
		}
		
		if(zone_areaRegionalCode == ""){
			alert("지역을 선택해 주세요.");
			$("#zone_areaRegionalCode").focus();
			return false;
		}
		
		if(zone_stateRegionalCode == ""){
			alert("지역을 선택해 주세요.");
			$("#zone_stateRegionalCode").focus();
			return false;
		}
		
		if(zone_officalName == "" || !zone_officalNameReg.test(zone_officalName)){
			alert("건물명을 영어,일어,숫자로 20자 이내로 입력해 주세요.");
			$("#zone_officalName").focus();
			return false;
		}
		
		if(zone_maintenaceCostFlag == false){
			alert("공익비FLAG를 체크해 주세요.");
			$("#zone_maintenaceCostFlag").focus();
			return false;
		}
		
		if(zone_address == "" || !zone_officalNameReg.test(zone_address)){
			alert("주소를 영어,일어,숫자로 20자 이내로 입력해 주세요.");
			$("#zone_address").focus();
			return false;
		}
		
		if(!zone_layout){
			alert("배치도 파일을 첨부해 주세요.");
			$("#zone_layout").focus();
			return false;
		}
		
		if(zone_trafficInfo == "" || !zone_officalNameReg.test(zone_trafficInfo)){
			alert("교통정보를 영어,일어,숫자로 20자 이내로 입력해 주세요.");
			$("#zone_trafficInfo").focus();
			return false;
		}
		
		if(zone_trafficInfoLink == "" || !zone_officalNameReg.test(zone_trafficInfoLink)){
			alert("교통정보 링크를 영어,일어,숫자로 20자 이내로 입력해 주세요.");
			$("#zone_trafficInfoLink").focus();
			return false;
		}
		
		if(zone_buildingStructure == "" || !zone_officalNameReg.test(zone_buildingStructure)){
			alert("건물구조를 영어,일어,숫자로 20자 이내로 입력해 주세요.");
			$("#zone_buildingStructure").focus();
			return false;
		}
		
		return true;
	}
	
	
	//자릿수 (,) 찍기
	function inputNumberAutoComma(obj) {
     
		// 콤마( , )의 경우도 문자로 인식되기때문에 콤마를 따로 제거한다.
		var deleteComma = obj.value.replace(/\,/g, "");
		let str = obj.value;
		//console.log(str)
		str = "" + str;
		if(blankCheck(str)){
			str = str.replace(/[^0-9]/g, "");
		}else{
			str = null;
		}
		
		obj.value = str;
		
		   
		// 기존에 들어가있던 콤마( , )를 제거한 이 후의 입력값에 다시 콤마( , )를 삽입한다.
		// 콤마 삽입은 제외함.
		obj.value=inputNumberRemoveComma(obj.value);
	}
	
	function inputNumberWithComma(str) {
	
		str = String(str); 
		// 전체숫자를 찾고, 숫자가 3번 나타나는 부분이 1회이상 연속되고 뒤에 숫자가 없을 경우, 전체숫자에서 ,를 찍는다
		return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, "$1,");
	}
	// 콤마( , )가 들어간 값에 콤마를 제거하는 함수
	function inputNumberRemoveComma(str) {
	
		str = String(str);
		return str.replace(/[^\d]+/g, "");
	}
	
	function blankCheck(str){
		if(str == null || str == "null"
			|| str == undefined || str == "undefined"
			|| str == '' || str == "" || str.length == 0
		){
			return null;
		}else{
			return str;
		}
	}
	</script>
</div>