package com.test.ur.app.dto;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public class URB002Dto {
	private int zone_registerNo;
	private String zone_entireRegionalCode;
	private String zone_areaRegionalCode;
	private String zone_stateRegionalCode;
	private String zone_officalName;
	private int zone_maintenaceCost;
	private String zone_maintenaceCostFlag;
	private String zone_postalCode;
	private String zone_address;
	private String zone_layout;
	private int zone_houseHoldsNo;
	private String zone_trafficInfo;
	private String zone_trafficInfoLink;
	private String zone_buildingStructure;
	private int zone_managementYear;
	private String zone_parkingLotInfo;
	private String zone_characteristic;
	private String[] zone_note_chk;
	private String zone_note;
	private String zone_buildingImg;
	private String zone_locationImg;
	private String zone_regionalImg;
	private String zone_surroundingImg;
	private String e_name;
	private String a_name;
	private String s_name;
	private String equip_name;
	private String search_codeA;
	private String search_codeB;
	private String search_codeC;
	private String search_name;
	
	public int getZone_registerNo() {
		return zone_registerNo;
	}
	public void setZone_registerNo(int zone_registerNo) {
		this.zone_registerNo = zone_registerNo;
	}
	public String getZone_entireRegionalCode() {
		return zone_entireRegionalCode;
	}
	public void setZone_entireRegionalCode(String zone_entireRegionalCode) {
		this.zone_entireRegionalCode = zone_entireRegionalCode;
	}
	public String getZone_areaRegionalCode() {
		return zone_areaRegionalCode;
	}
	public void setZone_areaRegionalCode(String zone_areaRegionalCode) {
		this.zone_areaRegionalCode = zone_areaRegionalCode;
	}
	public String getZone_stateRegionalCode() {
		return zone_stateRegionalCode;
	}
	public void setZone_stateRegionalCode(String zone_stateRegionalCode) {
		this.zone_stateRegionalCode = zone_stateRegionalCode;
	}
	public String getZone_officalName() {
		return zone_officalName;
	}
	public void setZone_officalName(String zone_officalName) {
		this.zone_officalName = zone_officalName;
	}
	public int getZone_maintenaceCost() {
		return zone_maintenaceCost;
	}
	public void setZone_maintenaceCost(int zone_maintenaceCost) {
		this.zone_maintenaceCost = zone_maintenaceCost;
	}
	public String getZone_maintenaceCostFlag() {
		return zone_maintenaceCostFlag;
	}
	public void setZone_maintenaceCostFlag(String zone_maintenaceCostFlag) {
		this.zone_maintenaceCostFlag = zone_maintenaceCostFlag;
	}
	public String getZone_postalCode() {
		return zone_postalCode;
	}
	public void setZone_postalCode(String zone_postalCode) {
		this.zone_postalCode = zone_postalCode;
	}
	public String getZone_address() {
		return zone_address;
	}
	public void setZone_address(String zone_address) {
		this.zone_address = zone_address;
	}
	public String getZone_layout() {
		return zone_layout;
	}
	public void setZone_layout(String zone_layout) {
		this.zone_layout = zone_layout;
	}
	public int getZone_houseHoldsNo() {
		return zone_houseHoldsNo;
	}
	public void setZone_houseHoldsNo(int zone_houseHoldsNo) {
		this.zone_houseHoldsNo = zone_houseHoldsNo;
	}
	public String getZone_trafficInfo() {
		return zone_trafficInfo;
	}
	public void setZone_trafficInfo(String zone_trafficInfo) {
		this.zone_trafficInfo = zone_trafficInfo;
	}
	public String getZone_trafficInfoLink() {
		return zone_trafficInfoLink;
	}
	public void setZone_trafficInfoLink(String zone_trafficInfoLink) {
		this.zone_trafficInfoLink = zone_trafficInfoLink;
	}
	public String getZone_buildingStructure() {
		return zone_buildingStructure;
	}
	public void setZone_buildingStructure(String zone_buildingStructure) {
		this.zone_buildingStructure = zone_buildingStructure;
	}
	public int getZone_managementYear() {
		return zone_managementYear;
	}
	public void setZone_managementYear(int zone_managementYear) {
		this.zone_managementYear = zone_managementYear;
	}
	public String getZone_parkingLotInfo() {
		return zone_parkingLotInfo;
	}
	public void setZone_parkingLotInfo(String zone_parkingLotInfo) {
		this.zone_parkingLotInfo = zone_parkingLotInfo;
	}
	public String getZone_characteristic() {
		return zone_characteristic;
	}
	public void setZone_characteristic(String zone_characteristic) {
		this.zone_characteristic = zone_characteristic;
	}
	public String getZone_note() {
		return zone_note;
	}
	public void setZone_note(String zone_note) {
		this.zone_note = zone_note;
	}
	public String getZone_buildingImg() {
		return zone_buildingImg;
	}
	public void setZone_buildingImg(String zone_buildingImg) {
		this.zone_buildingImg = zone_buildingImg;
	}
	public String getZone_locationImg() {
		return zone_locationImg;
	}
	public void setZone_locationImg(String zone_locationImg) {
		this.zone_locationImg = zone_locationImg;
	}
	public String getZone_regionalImg() {
		return zone_regionalImg;
	}
	public void setZone_regionalImg(String zone_regionalImg) {
		this.zone_regionalImg = zone_regionalImg;
	}
	public String getZone_surroundingImg() {
		return zone_surroundingImg;
	}
	public void setZone_surroundingImg(String zone_surroundingImg) {
		this.zone_surroundingImg = zone_surroundingImg;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getEquip_name() {
		return equip_name;
	}
	public void setEquip_name(String equip_name) {
		this.equip_name = equip_name;
	}
	public String[] getZone_note_chk() {
		return zone_note_chk;
	}
	public void setZone_note_chk(String[] zone_note_chk) {
		this.zone_note_chk = zone_note_chk;
	}
	public String getSearch_codeA() {
		return search_codeA;
	}
	public void setSearch_codeA(String search_codeA) {
		this.search_codeA = search_codeA;
	}
	public String getSearch_codeB() {
		return search_codeB;
	}
	public void setSearch_codeB(String search_codeB) {
		this.search_codeB = search_codeB;
	}
	public String getSearch_codeC() {
		return search_codeC;
	}
	public void setSearch_codeC(String search_codeC) {
		this.search_codeC = search_codeC;
	}
	public String getSearch_name() {
		return search_name;
	}
	public void setSearch_name(String search_name) {
		this.search_name = search_name;
	}
	public List<String> getSurroundImges(){
		return Arrays.asList(zone_surroundingImg.split(","));
	}
}
