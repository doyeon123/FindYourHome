<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<div class="work-area">
	<div class="upload=-area">
		<table class="table table_bordered text-center">
			<tr class="table-info">
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
				<td></td>
				
			</tr>
			<tr class="align-middle">
				<td>${applicantIn.applicant_applyNo }</td>
				<td>${applicantIn.applicant_buildingInfo }</td>
				<td>${applicantIn.applicant_nameKanji }</td>
				<td>${applicantIn.applicant_nameFurigana }</td>
				<fmt:formatDate value="${applicantIn.applicant_birth }"
					pattern="yyMMdd" var="birthDate"></fmt:formatDate>
				<td>${birthDate }</td>
				<td>${applicantIn.applicant_gender }</td>
				<td>${applicantIn.applicant_nationality }</td>
				<td>${applicantIn.applicant_regidentsCardFlag }</td>
				<fmt:formatDate value="${applicantIn.applicant_movingIn }"
					pattern="yyMMdd" var="moveDate"></fmt:formatDate>
				<td>${moveDate }</td>


				<td>${applicantIn.applicant_regidentsEligible}</td>
				<td>${applicantIn.applicant_regidentsDuration}</td>
				<fmt:formatDate value="${applicantIn.applicant_regidentsEndDate }"
					pattern="yyMMdd" var="regidentsDate"></fmt:formatDate>
				<td>${regidentsDate }</td>
				<td>${applicantIn.applicant_telNum }</td>
				<td>${applicantIn.applicant_postalCode }</td>
				<td>${applicantIn.applicant_address }</td>
				<td>${applicantIn.applicant_addressDetail }</td>
				<td>${applicantIn.applicant_workName }</td>
				<td>${applicantIn.applicant_workAddress }</td>
				<td>${applicantIn.applicant_incomeCertfication }</td>
				<td>${applicantIn.applicant_incomeYear }</td>
				<td>
				<button onclick="location.href='update?id=${applicantIn.applicant_applyNo }'" class="btn btn-primary">修整</button>
				</td>
			</tr>
		</table>
		
		
	</div>
</div>