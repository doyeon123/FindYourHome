<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 영업소 수정 폼 -->
<style type="text/css">
#att_zone {
	width: 660px;
	min-height: 150px;
	padding: 10px;
	border: 1px dotted #00f;
}

#att_zone:empty:before {
	content: attr(data-placeholder);
	color: #999;
	font-size: .9em;
}

td, th {
	border: 1px solid #444444;
	padding: 10px;
}

table {
	border: 1px solid #444444;
	border-collapse: collapse;
	width: 400px;
	height: 400px;
	margin-left: auto;
	margin-right: auto;
}
</style>


<script type="text/javascript">
//제출폼 확인




</script>
</head>


<!-- 바디 부분 -->
<body>

	<div class="work-area">
		<div class="container-md">
			<!-- 작성 form -->
			<form name="officeForm" id="officeForm"
				action="/admin/office/update?no=${salesOffice.sales_registerNo}"
				method="post" enctype="multipart/form-data"
				onsubmit="return formCheck();">
				<div class="row g-3 align-items-center">

					<table>
						<tr>
							<td class="bold">영업소 타입</td>
							<td><input type="radio" id="sales_businessCode"
								name="sales_businessCode" value="B1" checked>직영점 <input
								type="radio" id="sales_businessCode" name="sales_businessCode"
								value="B2">부동산 <input type="radio"
								id="sales_businessCode" name="sales_businessCode" value="B3">기타
							</td>
						</tr>
						<tr>
							<td class="bold">영업소 지역</td>
							<td>
							
							
							
							
							
								<c:choose>
		<c:when test = "${not empty update.zone_registerNo}">
    		<div class="container-md"> 
		        
			        <div class="row g-3 align-items-center">
			        
			        <input type="text" name="zone_registerNo" value="${update.zone_registerNo}">
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
			        <div id="zone_areaRegionalCode0">       
				        <p>
				        	FK(지역코드 : 구역) :
				        	<select id="zone_areaRegionalCode" name="zone_areaRegionalCode">
				        		<c:forEach var="codeBList" items="${codeBListAll}">
						        	<option value="${codeBList.code}" <c:if test="${codeBList.code == update.zone_areaRegionalCode}">selected</c:if> >${codeBList.name}</option>
						     	</c:forEach>
			        		</select>
				        </p>
			        </div>       
			        <div id="zone_stateRegionalCode0">       
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
    	</c:when>
    	
    	
    	<c:otherwise>
    		<div class="container-md"> 
			        <div class="row g-3 align-items-center">
				        <p>
				        	FP(지역코드 : 전체) :
				        	<select id="zone_entireRegionalCode" name="zone_entireRegionalCode">
				        		<option value=""> </option>
				        		<c:forEach var="codeAList" items="${codeAList}">
						        	<option value="${codeAList.code}">${codeAList.name}</option>
						     	</c:forEach>
			        		</select>
				        </p>
			        </div>
			        <div id="zone_areaRegionalCode0">       
				        <p>
				        	FK(지역코드 : 구역) :
				        	<select id="zone_areaRegionalCode" name="zone_areaRegionalCode">
				        		
			        		</select>
				        </p>
			        </div>       
			        <div id="zone_stateRegionalCode0">       
				        <p>
				        	FK(지역코드 : 구(시)) :
				        	<select id="zone_stateRegionalCode" name="zone_stateRegionalCode">
				        		
			        		</select>
				        </p>
			        </div>
			        
		    </div>
    	</c:otherwise>
    </c:choose>
							
							
							
							
							
							
							
							
							
							
							
							</td>
						</tr>
						<tr>
							<td class="bold">영업소 이름</td>
							<td><input type="text" name="sales_officeName"
								id="sales_officeName"></td>
						</tr>
						<tr>
							<td class="bold">영업소 전화번호</td>
							<td><input type="tel" name="sales_telNum" id="sales_telNum">
							</td>
						</tr>
						<tr>
							<td class="bold">영업소 우편번호</td>
							<td><input type='number' name="sales_postalCode1"
								id="sales_postalCode" oninput='handleOnInput(this, 3)' /> - <input
								type='number' name="sales_postalCode2" id="sales_postalCode"
								oninput='handleOnInput(this, 4)' /></td>
						</tr>
						<tr>
							<td class="bold">영업소 주소</td>
							<td><input type="text" name="sales_address"
								id="sales_address"></td>
						</tr>
						<tr>
							<td class="bold">영업소 영업 시간</td>
							<td><input type="time" name="sales_officeHours1"
								id="sales_officeHours"> ∼ <input type="time"
								name="sales_officeHours2" id="sales_officeHours"></td>
						</tr>

						<tr>
							<td class="bold">영업소 휴무일</td>
							<td><input type="text" name="sales_holiday"
								id="sales_holiday"></td>
						</tr>

						<tr>
							<td class="bold">영업소 교통편</td>
							<td><input type="text" name="sales_transportation"
								id="sales_transportation"></td>
						</tr>

						<tr>
							<td class="bold">sales_reference</td>
							<td><input type="text" name="sales_reference"
								id="sales_reference"></td>
						</tr>

						<tr>
							<td class="bold">sales_renewalContract</td>
							<td><input type="text" name="sales_renewalContract"
								id="sales_renewalContract"></td>
						</tr>


						<!--	 
			<tr>
			<div id='image_preview'>
				<td class="bold">영업소 사진 첨부</td>
				<td>
					<input type='file' id='btnAtt' name="sales_img" multiple='multiple' />
					<div id='att_zone' data-placeholder='파일을 첨부 하려면 파일 선택 버튼을 클릭하거나 파일을 드래그앤드롭 하세요'></div>
				</td>
			</div>
			</tr>
				 -->

					</table>
				</div>


				<input type="submit" class="btn btn-primary" value="수정하기" />


			</form>
		</div>
	</div>



	<script>
	( /* att_zone : 이미지들이 들어갈 위치 id, btn : file tag id */
			  imageView = function imageView(att_zone, btn){

			    var attZone = document.getElementById(att_zone);
			    var btnAtt = document.getElementById(btn)
			    var sel_files = [];
			    
			    // 이미지와 체크 박스를 감싸고 있는 div 속성
			    var div_style = 'display:inline-block;position:relative;'
			                  + 'width:150px;height:120px;margin:5px;border:1px solid #00f;z-index:1';
			    // 미리보기 이미지 속성
			    var img_style = 'width:100%;height:100%;z-index:none';
			    // 이미지안에 표시되는 체크박스의 속성
			    var chk_style = 'width:30px;height:30px;position:absolute;font-size:24px;'
			                  + 'right:0px;bottom:0px;z-index:999;background-color:rgba(255,255,255,0.1);color:#f00';
			  
			    btnAtt.onchange = function(e){
			      var files = e.target.files;
			      var fileArr = Array.prototype.slice.call(files)
			      for(f of fileArr){
			        imageLoader(f);
			      }
			    }  
			    
			  
			    // 탐색기에서 드래그앤 드롭 사용
			    attZone.addEventListener('dragenter', function(e){
			      e.preventDefault();
			      e.stopPropagation();
			    }, false)
			    
			    attZone.addEventListener('dragover', function(e){
			      e.preventDefault();
			      e.stopPropagation();
			      
			    }, false)
			  
			    attZone.addEventListener('drop', function(e){
			      var files = {};
			      e.preventDefault();
			      e.stopPropagation();
			      var dt = e.dataTransfer;
			      files = dt.files;
			      for(f of files){
			        imageLoader(f);
			      }
			      
			    }, false)
			    

			    
			    /*첨부된 이미리즐을 배열에 넣고 미리보기 */
			    imageLoader = function(file){
			      sel_files.push(file);
			      var reader = new FileReader();
			      reader.onload = function(ee){
			        let img = document.createElement('img')
			        img.setAttribute('style', img_style)
			        img.src = ee.target.result;
			        attZone.appendChild(makeDiv(img, file));
			      }
			      
			      reader.readAsDataURL(file);
			    }
			    
			    /*첨부된 파일이 있는 경우 checkbox와 함께 attZone에 추가할 div를 만들어 반환 */
			    makeDiv = function(img, file){
			      var div = document.createElement('div')
			      div.setAttribute('style', div_style)
			      
			      var btn = document.createElement('input')
			      btn.setAttribute('type', 'button')
			      btn.setAttribute('value', 'x')
			      btn.setAttribute('delFile', file.name);
			      btn.setAttribute('style', chk_style);
			      btn.onclick = function(ev){
			        var ele = ev.srcElement;
			        var delFile = ele.getAttribute('delFile');
			        for(var i=0 ;i<sel_files.length; i++){
			          if(delFile== sel_files[i].name){
			            sel_files.splice(i, 1);      
			          }
			        }
			        
			        dt = new DataTransfer();
			        for(f in sel_files) {
			          var file = sel_files[f];
			          dt.items.add(file);
			        }
			        btnAtt.files = dt.files;
			        var p = ele.parentNode;
			        attZone.removeChild(p)
			      }
			      div.appendChild(img)
			      div.appendChild(btn)
			      return div
			    }
			  }
			)('att_zone', 'btnAtt')
			

	//우편주소길이 함수
	function handleOnInput(el, maxlength)	{
 				 if(el.value.length > maxlength) {
   				 el.value = el.value.substr(0, maxlength);
 			 }
			}
	

	
	//제출폼
	function formCheck() {
	
	var sales_officeName = document.getElementById('sales_officeName');
	var sales_telNum = document.getElementById('sales_telNum');
	var sales_address = document.getElementById('sales_address');

	if (sales_officeName.value.length == "") {
		alert("영업소 이름을 입력해주세요");
		return false;
	}
	
	if (sales_telNum.value.length == "") {
		alert("전화번호를 입력하세요.");
		return false;
	}
	
	if (sales_address.value.length == "") {
		alert("주소를 입력하세요.");
		return false;
	}
	
	return true;

}
	

	//////영업소 구역 바꾸기
	$(document).ready(function() {
		let result ="";
	    $('#zone_entireRegionalCode').change(function() {
	    	$.ajax({
	    		url:'/admin/office/goUpdateForm'+$('select[id=zone_entireRegionalCode]').val(),
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
	    		url:'/admin/office/goUpdateForm/'+$('select[id=zone_entireRegionalCode]').val()+'/'+$('select[id=zone_areaRegionalCode]').val(),
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

	
			
	</script>
</body>
