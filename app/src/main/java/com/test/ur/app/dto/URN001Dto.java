package com.test.ur.app.dto;

import java.sql.Date;
import java.util.List;

public class URN001Dto {

	private int notice_registerno;
	private String notice_category;
	private String notice_entireregionalcode;
	private String notice_title;
	private String notice_content;
	private String notice_link;
	private Date notice_writedate;
	private Date notice_rewritedate;
	private Date notice_displydate;
	
	
	
	
	public int getNotice_registerno() {
		return notice_registerno;
	}
	public void setNotice_registerno(int notice_registerno) {
		this.notice_registerno = notice_registerno;
	}
	public String getNotice_category() {
		return notice_category;
	}
	public void setNotice_category(String notice_category) {
		this.notice_category = notice_category;
	}
	public String getNotice_entireregionalcode() {
		return notice_entireregionalcode;
	}
	public void setNotice_entireregionalcode(String notice_entireregionalcode) {
		this.notice_entireregionalcode = notice_entireregionalcode;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getNotice_link() {
		return notice_link;
	}
	public void setNotice_link(String notice_link) {
		this.notice_link = notice_link;
	}
	
	
	public Date getNotice_writedate() {
		return notice_writedate;
	}
	public void setNotice_writedate(Date notice_writedate) {
		this.notice_writedate = notice_writedate;
	}
	public Date getNotice_rewritedate() {
		return notice_rewritedate;
	}
	public void setNotice_rewritedate(Date notice_rewritedate) {
		this.notice_rewritedate = notice_rewritedate;
	}
	public Date getNotice_displydate() {
		return notice_displydate;
	}
	public void setNotice_displydate(Date notice_displydate) {
		this.notice_displydate = notice_displydate;
	}
	
	
}

