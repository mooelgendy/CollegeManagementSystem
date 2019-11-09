package com.myfaculty.myapp;

public class Courses {
	
	private int coId;
	private String coName;
	private int coHours;
	private int depId;
	private int insId;
	
	public Courses(int coId, String coName, int coHours, int depId, int insId) {
		super();
		this.coId = coId;
		this.coName = coName;
		this.coHours = coHours;
		this.depId = depId;
		this.insId = insId;
	}

	public Courses() {
		super();
	}

	public int getCoId() {
		return coId;
	}

	public void setCoId(int coId) {
		this.coId = coId;
	}

	public String getCoName() {
		return coName;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}

	public int getCoHours() {
		return coHours;
	}

	public void setCoHours(int coHours) {
		this.coHours = coHours;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public int getInsId() {
		return insId;
	}

	public void setInsId(int insId) {
		this.insId = insId;
	}

}
