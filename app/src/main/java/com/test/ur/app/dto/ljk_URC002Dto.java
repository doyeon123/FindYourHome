package com.test.ur.app.dto;

import java.sql.Date;

public class ljk_URC002Dto {
	
	private int consulting_registerno;
	private String consulting_author;
	private String consulting_password;
	private String consulting_title;
	private String consulting_content;
	private String consulting_deleteflag;
	private Date consulting_writedate;
	private Date consulting_rewritedate;
	
	
	public int getConsulting_registerno() {
		return consulting_registerno;
	}
	public void setConsulting_registerno(int consulting_registerno) {
		this.consulting_registerno = consulting_registerno;
	}
	public String getConsulting_author() {
		return consulting_author;
	}
	public void setConsulting_author(String consulting_author) {
		this.consulting_author = consulting_author;
	}
	public String getConsulting_password() {
		return consulting_password;
	}
	public void setConsulting_password(String consulting_password) {
		this.consulting_password = consulting_password;
	}
	public String getConsulting_title() {
		return consulting_title;
	}
	public void setConsulting_title(String consulting_title) {
		this.consulting_title = consulting_title;
	}
	public String getConsulting_content() {
		return consulting_content;
	}
	public void setConsulting_content(String consulting_content) {
		this.consulting_content = consulting_content;
	}
	public String getConsulting_deleteflag() {
		return consulting_deleteflag;
	}
	public void setConsulting_deleteflag(String consulting_deleteflag) {
		this.consulting_deleteflag = consulting_deleteflag;
	}
	public Date getConsulting_writedate() {
		return consulting_writedate;
	}
	public void setConsulting_writedate(Date consulting_writedate) {
		this.consulting_writedate = consulting_writedate;
	}
	public Date getConsulting_rewritedate() {
		return consulting_rewritedate;
	}
	public void setConsulting_rewritedate(Date consulting_rewritedate) {
		this.consulting_rewritedate = consulting_rewritedate;
	}

}
