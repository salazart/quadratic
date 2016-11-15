package com.sz.quadratic.service;

public class QuadraticService {
	private double a;
	private double b;
	private double c;
	
	public QuadraticService(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public boolean isResult(){
		return getDiscriminant() >= 0;
	}
	
	private double getDiscriminant(){
		return Math.pow(b, 2) - 4 * a * c;
	}
	
	public double getFirstResult(){
		return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
	}
	
	public double getSecondResult(){
		return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
	}
}
