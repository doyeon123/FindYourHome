package com.test.ur.app.dto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;

public class URO001Dto {
	private int sales_registerno;
	private String sales_businesscode;
	private String sales_areacode;
	private String sales_officename;
	private String sales_telnum;
	private String sales_postalcode;
	private String sales_address;
	private String sales_officehours;
	private String sales_holiday;
	private String sales_transportation;
	private String sales_reference;
	private String sales_renewalcontract;
	private String sales_deleteflag;
	private Date sales_registerdate;
	private Date sales_renewaldate;
	private String sales_img;
	
	public int getSales_registerno() {
		return sales_registerno;
	}
	public void setSales_registerno(int sales_registerno) {
		this.sales_registerno = sales_registerno;
	}
	public String getSales_businesscode() {
		return sales_businesscode;
	}
	public void setSales_businesscode(String sales_businesscode) {
		this.sales_businesscode = sales_businesscode;
	}
	public String getSales_areacode() {
		return sales_areacode;
	}
	public void setSales_areacode(String sales_areacode) {
		this.sales_areacode = sales_areacode;
	}
	public String getSales_officename() {
		return sales_officename;
	}
	public void setSales_officename(String sales_officename) {
		this.sales_officename = sales_officename;
	}
	public String getSales_telnum() {
		return sales_telnum;
	}
	public void setSales_telnum(String sales_telnum) {
		this.sales_telnum = sales_telnum;
	}
	public String getSales_postalcode() {
		return sales_postalcode;
	}
	public void setSales_postalcode(String sales_postalcode) {
		this.sales_postalcode = sales_postalcode;
	}
	public String getSales_address() {
		return sales_address;
	}
	public void setSales_address(String sales_address) {
		this.sales_address = sales_address;
	}
	public String getSales_officehours() {
		return sales_officehours;
	}
	public void setSales_officehours(String sales_officehours) {
		this.sales_officehours = sales_officehours;
	}
	public String getSales_holiday() {
		return sales_holiday;
	}
	public void setSales_holiday(String sales_holiday) {
		this.sales_holiday = sales_holiday;
	}
	public String getSales_transportation() {
		return sales_transportation;
	}
	public void setSales_transportation(String sales_transportation) {
		this.sales_transportation = sales_transportation;
	}
	public String getSales_reference() {
		return sales_reference;
	}
	public void setSales_reference(String sales_reference) {
		this.sales_reference = sales_reference;
	}
	public String getSales_renewalcontract() {
		return sales_renewalcontract;
	}
	public void setSales_renewalcontract(String sales_renewalcontract) {
		this.sales_renewalcontract = sales_renewalcontract;
	}
	public String getSales_deleteflag() {
		return sales_deleteflag;
	}
	public void setSales_deleteflag(String sales_deleteflag) {
		this.sales_deleteflag = sales_deleteflag;
	}
	public Date getSales_registerdate() {
		return sales_registerdate;
	}
	public void setSales_registerdate(Date sales_registerdate) {
		this.sales_registerdate = sales_registerdate;
	}
	public Date getSales_renewaldate() {
		return sales_renewaldate;
	}
	public void setSales_renewaldate(Date sales_renewaldate) {
		this.sales_renewaldate = sales_renewaldate;
	}
	public String getSales_img() {
		return sales_img;
	}
	public void setSales_img(String sales_img) {
		this.sales_img = sales_img;
	}
	
	@Override
	public String toString() {
		Class cls = this.getClass();
		Method[] arrMethod = cls.getMethods();
		StringBuffer sb = new StringBuffer(this.getClass().toString());
		sb.append(" => ");
		try {
			for (Method m : arrMethod) {
				if (m.getName().startsWith("get") && !m.getName().equals("getClass")) {
					sb.append(m.getName());
					sb.append(": ");
					sb.append(m.invoke(this, null));
					sb.append(", ");
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return sb.toString().substring(0, sb.length() - 2);
	}

}
