<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link href="/resources/css/joinPage.css" rel="stylesheet" />

<script type="text/javascript"src="/resources/js/uru002e01.js"></script>
<script>
	function getLocation(event) {
		console.log(event.value)
		var con = document.getElementById("ABCD");

		if (event.value === "${kokuseki[1].code}") {
			con.style.display = '';

		} else {
			con.style.display = 'none';
		}
	}
	function getChange(event) {
		console.log(event.checked)

		if (event.checked == false) {
			document.getElementById("form-check-label1").innerText = "無";
			document.getElementById("zairyukado").value = "0";
		} else {
			document.getElementById("form-check-label1").innerText = "有";
			document.getElementById("zairyukado").value = "1";
		}

	}

	function getA(event) {
		console.log(event.checked)

		if (event.checked == false) {
			document.getElementById("form-check-label2").innerText = "無";
			document.getElementById("zairyushikaku").value = "0";
		} else {
			document.getElementById("form-check-label2").innerText = "有";
			document.getElementById("zairyushikaku").value = "1";
		}

	}

	function getB(event) {
		console.log(event.checked)

		if (event.checked == false) {
			document.getElementById("form-check-label3").innerText = "無";
			document.getElementById("yunyushomesho").value = "0";

		} else {
			document.getElementById("form-check-label3").innerText = "有";
			document.getElementById("yunyushomesho").value = "1";
		}
						
	}
		
</script>
<style type="text/css">
	.line{border-bottom:1px solid red:}
</style>
<h1 class="text-center fs-1" style="margin-top: 20px;">신청란</h1>
	<div style="margin-bottom:20px;">
	</div>
<div class="arearea" style="display: flex; justify-content: center; align-items: center;">
	

<!--  <div style="display: flex; justify-content: center; align-items: center;">-->
	<%-- <c:choose>
		<c:when test="${true}"> --%>
		<form action="${from }" method="post">
	
		<div>

 				<input type=hidden name=applicant_applyNo value="${id}">
				<input type=hidden name=tatemonojoho value="${receipt.applicant_buildingInfo}">
			<table>
				<tr>
					<th><strong>名前</strong></th>
					<td><input type=text name=kanjinamae size=20 value="${receipt.applicant_nameKanji }"></td>
					
					<th>生年月日</th>
					<fmt:formatDate value="${receipt.applicant_birth }" pattern="yyyyMMdd" var="birthDate"></fmt:formatDate>
					<td><input type=text name=senengatsunichi size=20 value="${birthDate }"></td>
				</tr>
				<tr>
					<th><strong>フリガナ名</strong></th>
					<td><input type=text name=furigananamae size=20 value="${receipt.applicant_nameFurigana }"></td>
				<th>性別</th>
					<td>
						<input type="radio" name="seibutsu" id="RadioGender" checked value="0" value=${receipt.applicant_gender } /> 男性 
						<input type="radio" name="seibutsu" id="RadioGender" value="1" value=${receipt.applicant_gender } /> 女性
					</td>
			</tr>
			<tr>
				<th>国籍</th>
					<td><c:forEach items="${kokuseki}" var="code">
							<input class="form-check-input" type="radio"
								name="flexRadioDefault" onclick="getLocation(this)"
								id="flexRadioDefault2" checked value="${code.code}"
								value=${receipt.applicant_nationality }>
							<label class="form-check-label" for="flexRadioDefault2">
								${code.name} </label>
						</c:forEach></td>
			
			<th><label for="phoneNo">電話番号</label></th>
					<td>
						
						<input type="tel"
							id="phoneNo" name="fonbango" placeholder="Enter Phone Number"
							maxlength="16"
							value="${receipt.applicant_telNum }"> <label
							for="phoneNo"></label>
						
						
					</td>
				</tr>
			

				
	
			<tbody id="ABCD">
				<tr>
					<th>在留カードの有/無</th>
					<td><input type=checkbox name=zairyukado onclick="getChange(this)" id="zairyukado" value="0" value="${receipt.applicant_regidentsCardFlag }"
						<c:if test="${receipt.applicant_regidentsCardFlag == 1}">checked</c:if>/>
						<label id="form-check-label1" for="zairyukado1"> 
							<c:if test="${receipt.applicant_regidentsCardFlag == 1}">有</c:if> 
							<c:if test="${receipt.applicant_regidentsCardFlag == 0}">無</c:if>
					</label></td>
					
					<th>在留期間</th>
					<td><input type=text name=zairyukikan size=20
						value="${receipt.applicant_regidentsDuration}" /></td>
				</tr>
				<tr>
					<th>外国人入居日</th>
					<fmt:formatDate value="${receipt.applicant_movingIn }"
						pattern="yyyyMMdd" var="moveDate"></fmt:formatDate>
					<td><input type=text name=gaikokunyukyobi size=20
						value="${moveDate }" /></td>
				</tr>
				<tr>
					<th>在留資格</th>
					<td><input type=checkbox name=zairyushikaku
						onclick="getA(this)" id="zairyushikaku" value="0"
						value="${receipt.applicant_regidentsEligible}"
						<c:if test="${receipt.applicant_regidentsEligible == 1}">checked</c:if> /> <label
						id="form-check-label2" for="zairyushikaku2"> <c:if
								test="${receipt.applicant_regidentsEligible == 1}">有</c:if> <c:if
								test="${receipt.applicant_regidentsEligible == 0}">無</c:if>			
								</label></td>
								
					<th>在留満了日</th>
					<fmt:formatDate value="${receipt.applicant_regidentsEndDate }"
						pattern="yyyyMMdd" var="regidentsDate"></fmt:formatDate>
					<td><input type=text name=zairyumanryobi size=20
						value="${regidentsDate }"></td>
								
				</tr>
				
			
			</tbody>		
			
				
				<tr>
				<th> <label for="zipcode">郵便番号 </label></th>
					<td>
						<div class="int_zipcode_area">
							<input type="text" id="zipcode" name="yubinbango" placeholder="Enter ZipCode"  maxlength="7"
								value="${receipt.applicant_postalCode }"> <label
								></label>
							
						</div>
					</td>
					
					
					
					</tr>
					
				<tr>
					<th><label for="home_address">住所</label></th>
					<td colspan="4">
						<input type="text" id="home_address" name="shichusho" size=57
							placeholder="Enter Home_address" maxlength="50" value="${receipt.applicant_address }">
			
				
					</td>
				</tr>
				
				<tr>
					<th>詳細住所</th>
					<td colspan="4">
					<input type=text name=shosaijusho size=57 value="${receipt.applicant_addressDetail }">
					</td>
				</tr>
					
				<tr>
					<td>職場名</td>
					<td><input type=text name=shokubana size=20 value="${receipt.applicant_workName }"></td>
				<td>職場住所</td>
					<td><input type=text name=shokobanajusho size=20 value="${receipt.applicant_workAddress }"></td>
				
				</tr>

				<tr>
					<td>輸入証明書</td>
					<td>
						<input type=checkbox name=yunyushomesho
							onclick="getB(this)" id="yunyushomesho" value="0"
							value="${receipt.applicant_incomeCertfication }" <c:if
							test="${receipt.applicant_incomeCertfication == 1}">checked</c:if> /> <label
							id="form-check-label3" for="yunyushomesho1"><c:if
									test="${receipt.applicant_incomeCertfication == 1}">有</c:if> <c:if
									test="${receipt.applicant_incomeCertfication == 0}">無</c:if> </label>
					</td>
					
					<td>年収</td>
					<td><input type=text name=nenshu size=20
						value="${receipt.applicant_incomeYear }"></td>
				</tr>
				
				<tr>
					<td colspan=4 align="center" >
					<input type="reset" style="width:100pt;" class="btn btn-danger btn-lg" value="Reset"> &emsp;&emsp;
					<input type="submit" style="width:100pt;" class="btn btn-primary btn-lg" value="Ok"></td>
				</tr>
			</table>
		</div>
		
	

</form>

</div>

<%-- </c:when>

<c:otherwise> </c:otherwise>

</div>
</c:choose> --%>








