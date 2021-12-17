package com.test.ur.app.dto;

import java.util.Date;

public class URB010Dto {
	
	private int community_registerNo;
	private int community_buildingInfo;
	private String community_author;
	private String community_password;
	private String community_title;
	private String community_content;
	private String community_deleteFlag;
	private Date community_writeDate;
	private Date community_reWriteDate;
	
	private int reply_registerNo;
	private int reply_communityRegisterNo;
	private String reply_author;
	private String reply_password;
	private String reply_content;
	private String reply_deleteFlag;
	private Date reply_writeDate;
	private Date reply_reWriteDate;	 
	
	
	
	public int getCommunity_registerNo() {
		return community_registerNo;
	}
	public void setCommunity_registerNo(int community_registerNo) {
		this.community_registerNo = community_registerNo;
	}
	public int getCommunity_buildingInfo() {
		return community_buildingInfo;
	}
	public void setCommunity_buildingInfo(int community_buildingInfo) {
		this.community_buildingInfo = community_buildingInfo;
	}
	public String getCommunity_author() {
		return community_author;
	}
	public void setCommunity_author(String community_author) {
		this.community_author = community_author;
	}
	public String getCommunity_password() {
		return community_password;
	}
	public void setCommunity_password(String community_password) {
		this.community_password = community_password;
	}
	public String getCommunity_title() {
		return community_title;
	}
	public void setCommunity_title(String community_title) {
		this.community_title = community_title;
	}
	public String getCommunity_content() {
		return community_content;
	}
	public void setCommunity_content(String community_content) {
		this.community_content = community_content;
	}
	public String getCommunity_deleteFlag() {
		return community_deleteFlag;
	}
	public void setCommunity_deleteFlag(String community_deleteFlag) {
		this.community_deleteFlag = community_deleteFlag;
	}
	public Date getCommunity_writeDate() {
		return community_writeDate;
	}
	public void setCommunity_writeDate(Date community_writeDate) {
		this.community_writeDate = community_writeDate;
	}
	public Date getCommunity_reWriteDate() {
		return community_reWriteDate;
	}
	public void setCommunity_reWriteDate(Date community_reWriteDate) {
		this.community_reWriteDate = community_reWriteDate;
	}
	
	
	public int getReply_registerNo() {
		return reply_registerNo;
	}
	public void setReply_registerNo(int reply_registerNo) {
		this.reply_registerNo = reply_registerNo;
	}
	public int getReply_communityRegisterNo() {
		return reply_communityRegisterNo;
	}
	public void setReply_communityRegisterNo(int reply_communityRegisterNo) {
		this.reply_communityRegisterNo = reply_communityRegisterNo;
	}
	public String getReply_author() {
		return reply_author;
	}
	public void setReply_author(String reply_author) {
		this.reply_author = reply_author;
	}
	public String getReply_password() {
		return reply_password;
	}
	public void setReply_password(String reply_password) {
		this.reply_password = reply_password;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_deleteFlag() {
		return reply_deleteFlag;
	}
	public void setReply_deleteFlag(String reply_deleteFlag) {
		this.reply_deleteFlag = reply_deleteFlag;
	}
	public Date getReply_writeDate() {
		return reply_writeDate;
	}
	public void setReply_writeDate(Date reply_writeDate) {
		this.reply_writeDate = reply_writeDate;
	}
	public Date getReply_reWriteDate() {
		return reply_reWriteDate;
	}
	public void setReply_reWriteDate(Date reply_reWriteDate) {
		this.reply_reWriteDate = reply_reWriteDate;
	}
	

}


