package com.test.ur.app.dto;

public class CodeDto {

	private String code;
	private String name;
	private String code1;
	private String code2;
	private String code3;
	private String code4;

	public CodeDto(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public CodeDto(String code, String name, String code1) {
		this.code = code;
		this.name = name;
		this.code1 = code1;
	}

	public CodeDto(String code, String name, String code1, String code2, String code3, String code4) {
		this.code = code;
		this.name = name;
		this.code1 = code1;
		this.code2 = code2;
		this.code3 = code3;
		this.code4 = code4;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("code : ").append(code);
		sb.append(", name : ").append(name);
		sb.append(", code1 : ").append(code1);
		sb.append(", code2 : ").append(code2);
		sb.append(", code3 : ").append(code3);
		sb.append(", code4 : ").append(code4);
		return sb.toString();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getCode3() {
		return code3;
	}

	public void setCode3(String code3) {
		this.code3 = code3;
	}

	public String getCode4() {
		return code4;
	}

	public void setCode4(String code4) {
		this.code4 = code4;
	}
}
