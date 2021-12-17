package com.test.ur.app.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class URU002Dto {

	private int applicant_applyNo;
	private String applicant_buildingInfo;
	private String applicant_nameKanji;
	private String applicant_nameFurigana;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date applicant_birth;
	private String applicant_gender;
	private String applicant_nationality;
	private String applicant_regidentsCardFlag;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date applicant_movingIn;
	private String applicant_regidentsEligible;
	private String applicant_regidentsDuration;
	private Date applicant_regidentsEndDate;
	private String applicant_telNum;
	private String applicant_postalCode;
	private String applicant_address;
	private String applicant_addressDetail;
	private String applicant_workName;
	private String applicant_workAddress;
	private String applicant_incomeCertfication;
	private String applicant_incomeYear;
	private String z_name;

	public int getApplicant_applyNo() {
		return applicant_applyNo;
	}

	public void setApplicant_applyNo(int applicant_applyNo) {
		this.applicant_applyNo = applicant_applyNo;
	}

	public String getApplicant_buildingInfo() {
		return applicant_buildingInfo;
	}

	public void setApplicant_buildingInfo(String applicant_buildingInfo) {
		this.applicant_buildingInfo = applicant_buildingInfo;
	}

	public String getApplicant_nameKanji() {
		return applicant_nameKanji;
	}

	public void setApplicant_nameKanji(String applicant_nameKanji) {
		this.applicant_nameKanji = applicant_nameKanji;
	}

	public String getApplicant_nameFurigana() {
		return applicant_nameFurigana;
	}

	public void setApplicant_nameFurigana(String applicant_nameFurigana) {
		this.applicant_nameFurigana = applicant_nameFurigana;
	}

	public Date getApplicant_birth() {
		return applicant_birth;
	}

	public void setApplicant_birth(Date applicant_birth) {
		this.applicant_birth = applicant_birth;
	}

	public String getApplicant_gender() {
		return applicant_gender;
	}

	public void setApplicant_gender(String applicant_gender) {
		this.applicant_gender = applicant_gender;
	}

	public String getApplicant_nationality() {
		return applicant_nationality;
	}

	public void setApplicant_nationality(String applicant_nationality) {
		this.applicant_nationality = applicant_nationality;
	}

	public String getApplicant_regidentsCardFlag() {
		return applicant_regidentsCardFlag;
	}

	public void setApplicant_regidentsCardFlag(String applicant_regidentsCardFlag) {
		this.applicant_regidentsCardFlag = applicant_regidentsCardFlag;
	}

	public Date getApplicant_movingIn() {
		return applicant_movingIn;
	}

	public void setApplicant_movingIn(Date applicant_movingIn) {
		this.applicant_movingIn = applicant_movingIn;
	}

	public String getApplicant_regidentsEligible() {
		return applicant_regidentsEligible;
	}

	public void setApplicant_regidentsEligible(String applicant_regidentsEligible) {
		this.applicant_regidentsEligible = applicant_regidentsEligible;
	}

	public String getApplicant_regidentsDuration() {
		return applicant_regidentsDuration;
	}

	public void setApplicant_regidentsDuration(String applicant_regidentsDuration) {
		this.applicant_regidentsDuration = applicant_regidentsDuration;
	}

	public Date getApplicant_regidentsEndDate() {
		return applicant_regidentsEndDate;
	}

	public void setApplicant_regidentsEndDate(Date applicant_regidentsEndDate) {
		this.applicant_regidentsEndDate = applicant_regidentsEndDate;
	}

	public String getApplicant_telNum() {
		return applicant_telNum;
	}

	public void setApplicant_telNum(String applicant_telNum) {
		this.applicant_telNum = applicant_telNum;
	}

	public String getApplicant_postalCode() {
		return applicant_postalCode;
	}

	public void setApplicant_postalCode(String applicant_postalCode) {
		this.applicant_postalCode = applicant_postalCode;
	}

	public String getApplicant_address() {
		return applicant_address;
	}

	public void setApplicant_address(String applicant_address) {
		this.applicant_address = applicant_address;
	}

	public String getApplicant_addressDetail() {
		return applicant_addressDetail;
	}

	public void setApplicant_addressDetail(String applicant_addressDetail) {
		this.applicant_addressDetail = applicant_addressDetail;
	}

	public String getApplicant_workName() {
		return applicant_workName;
	}

	public void setApplicant_workName(String applicant_workName) {
		this.applicant_workName = applicant_workName;
	}

	public String getApplicant_workAddress() {
		return applicant_workAddress;
	}

	public void setApplicant_workAddress(String applicant_workAddress) {
		this.applicant_workAddress = applicant_workAddress;
	}

	public String getApplicant_incomeCertfication() {
		return applicant_incomeCertfication;
	}

	public void setApplicant_incomeCertfication(String applicant_incomeCertfication) {
		this.applicant_incomeCertfication = applicant_incomeCertfication;
	}

	public String getApplicant_incomeYear() {
		return applicant_incomeYear;
	}

	public void setApplicant_incomeYear(String applicant_incomeYear) {
		this.applicant_incomeYear = applicant_incomeYear;
	}

	public String getZ_name() {
		return z_name;
	}

	public void setZ_name(String z_name) {
		this.z_name = z_name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String show = "";
		show += "applicant_applyNo=" + Integer.toString(applicant_applyNo);
		show += "applicant_buildingInfo=" + applicant_buildingInfo;
		show += "applicant_nameKanji=" + applicant_nameKanji;
		show += "applicant_nameFurigana=" + applicant_nameFurigana;

		if (applicant_birth != null) {
			show += "applicant_birth=" + format.format(applicant_birth);
		}
		show += "applicant_gender=" + applicant_gender;
		show += "applicant_nationality=" + applicant_nationality;
		show += "applicant_regidentsCardFlag=" + applicant_regidentsCardFlag;

		if (applicant_movingIn != null) {
			show += "applicant_movingIn=" + format.format(applicant_movingIn);
		}

		show += "applicant_regidentsEligible=" + applicant_regidentsEligible;
		show += "applicant_regidentsDuration=" + applicant_regidentsDuration;

		if (applicant_regidentsEndDate != null) {
			show += "applicant_regidentsEndDate=" + format.format(applicant_regidentsEndDate);
		}

		show += "applicant_telNum=" + applicant_telNum;
		show += "applicant_postalCode=" + applicant_postalCode;
		show += "applicant_address=" + applicant_address;
		show += "applicant_addressDetail=" + applicant_addressDetail;
		show += "applicant_workName=" + applicant_workName;
		show += "applicant_workAddress=" + applicant_workAddress;
		show += "applicant_incomeCertfication=" + applicant_incomeCertfication;
		show += "applicant_incomeYear=" + applicant_incomeYear;

		return show;

	}

}
