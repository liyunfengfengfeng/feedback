package com.hrbust.feedback.util;

public class StudentScore {
	private String gra_name;
	private String stu_name;
	private double scope;
	
	public String getgra_name() {
		return gra_name;
	}
	public void setgra_name(String gra_name) {
		this.gra_name = gra_name;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public double getScope() {
		return scope;
	}
	public void setScope(double scope) {
		this.scope = scope;
	}
	public StudentScore(){}
	public StudentScore(String gra_name, String stu_name, double scope) {
		this.gra_name = gra_name;
		this.stu_name = stu_name;
		this.scope = scope;
	}
	
	
}
