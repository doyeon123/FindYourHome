<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="work-area">
	<script type="text/javascript">
		function page(page) {

			document.listForm.action = "/admin/receipt";
			document.listForm.pageNo.value = page;
			document.listForm.submit();
		}
	</script>
	<h1 class="text-center fs-1">申請情報</h1>
	<div style="height: 800px; overflow: auto">
	
	
	
		<table class="table receipt">

			<tr>
				<td>申請番号</td>
				<td>建物情報</td>
				<td>漢字名</td>
				<td>フリガナ名</td>
				<td>生年月日</td>
				<td>性別</td>
				<td>国籍</td>
				<td>在留カードの有/無</td>
				<td>外国人入居日</td>
				<td>在留資格</td>
				<td>在留期間</td>
				<td>在留満了日</td>
				<td>電話番号</td>
				<td>郵便番号</td>
				<td>住所</td>
				<td>詳細住所</td>
				<td>職場名</td>
				<td>職場住所</td>
				<td>輸入証明書</td>
				<td>年収</td>
			
			</tr>

			<c:forEach var="receipt" items="${adminReceiptList}">
		
			<tr>	
				<td>${receipt.applicant_applyNo }</td>			
				<td>${receipt.z_name }</td>
				<td>${receipt.applicant_nameKanji } </td>
				<td>${receipt.applicant_nameFurigana } </td>
				<fmt:formatDate value="${receipt.applicant_birth }" pattern="yyMMdd" var="birthDate"></fmt:formatDate>
				<td>${birthDate }</td> 
				<td>${receipt.applicant_gender }</td>
				<td>${receipt.applicant_nationality }</td>
				<td>${receipt.applicant_regidentsCardFlag }</td>
				<fmt:formatDate value="${receipt.applicant_movingIn }" pattern="yyMMdd" var="moveDate"></fmt:formatDate>
				<td>${moveDate }</td>
				
				
				<td>${receipt.applicant_regidentsEligible} </td>
				<td>${receipt.applicant_regidentsDuration}</td>
				<fmt:formatDate value="${receipt.applicant_regidentsEndDate }" pattern="yyMMdd" var="regidentsDate"></fmt:formatDate>
				<td>${regidentsDate }</td>
				<td>${receipt.applicant_telNum }</td>
				<td>${receipt.applicant_postalCode }</td>
				<td>${receipt.applicant_address }</td>
				<td>${receipt.applicant_addressDetail }</td>
				<td>${receipt.applicant_workName }</td>
				<td>${receipt.applicant_workAddress }</td>
				<td>${receipt.applicant_incomeCertfication }</td>
				<td>${receipt.applicant_incomeYear }</td>
				
			<td>
			<a href="/admin/receipt/detail?no=${receipt.applicant_applyNo }">
				${receipt.applicant_buildingInfo} 情報を見る
				
				
				
				
				
			</a>
			</td>
			</c:forEach>
				
		</table>
	</div>
		
		<div class="d-grid gap-2 col-6 mx-auto";>
			<button type="button" onclick="location.href='/admin/receipt/create'" class="btn btn-info btn-lg">申請ページへ移動</button> 
			</div>
			<div class="d-grid gap-2 col-6 mx-auto">
			<button type="button" onclick="location.href='/admin/receipt/search'" class="btn btn-warning btn-lg">検索ページへ移動</button> 
			</div>
		
		
</div>
