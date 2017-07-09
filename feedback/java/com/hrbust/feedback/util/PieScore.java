package com.hrbust.feedback.util;

public class PieScore {
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	private double value;
	
	public PieScore(){}
	
	public PieScore(String name, double value){
		this.name = name;
		this.value = value;
	}
	
}
