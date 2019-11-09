package com.myfaculty.myapp;

public class Instructors {
	
	private int insId;
	private String insName;
	private String insAddress;
	private String insPhone;
	private int insSalary;
	private int depId;
	//private String insUsername;
	//private String insPassword;
	
	public Instructors(int insId, String insName, String insAddress, String insPhone, int insSalary, int depId) {
		super();
		this.insId = insId;
		this.insName = insName;
		this.insAddress = insAddress;
		this.insPhone = insPhone;
		this.insSalary = insSalary;
		this.depId = depId;
	}

	public Instructors() {
		super();
	}

	public int getInsId() {
		return insId;
	}

	public void setInsId(int insId) {
		this.insId = insId;
	}

	public String getInsName() {
		return insName;
	}

	public void setInsName(String insName) {
		this.insName = insName;
	}

	public String getInsAddress() {
		return insAddress;
	}

	public void setInsAddress(String insAddress) {
		this.insAddress = insAddress;
	}

	public String getInsPhone() {
		return insPhone;
	}

	public void setInsPhone(String insPhone) {
		this.insPhone = insPhone;
	}

	public int getInsSalary() {
		return insSalary;
	}

	public void setInsSalary(int insSalary) {
		this.insSalary = insSalary;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

}
