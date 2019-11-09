package com.myfaculty.myapp;

public class Students {
	
	private int studId;
	private String studName;
	private String studAddress;
	private String StudPhone;
	private int depId;
	//private String studUsername;
	//private String studPassword;
	
	public Students(int studId, String studName, String studAddress, String studPhone, int depId) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studAddress = studAddress;
		StudPhone = studPhone;
		this.depId = depId;
	}
	public Students() {
		super();
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getStudAddress() {
		return studAddress;
	}
	public void setStudAddress(String studAddress) {
		this.studAddress = studAddress;
	}
	public String getStudPhone() {
		return StudPhone;
	}
	public void setStudPhone(String studPhone) {
		StudPhone = studPhone;
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	
	
	
}