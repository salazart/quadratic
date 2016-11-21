package com.sz.quadratic.service;

import com.sz.quadratic.exception.QuadraticException;
import com.sz.quadratic.models.Quadratic;

public class QuadraticService {
	private double a;
	private double b;
	private double c;
	
	public QuadraticService(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public QuadraticService(String a, String b, String c) throws QuadraticException {
		try {
			this.a = Double.parseDouble(a);
			this.b = Double.parseDouble(b);
			this.c = Double.parseDouble(c);
		} catch (Exception e) {
			throw new QuadraticException("Invalid parsing coefficients quadratic equation");
		}
	}
	
	public QuadraticService(Quadratic quadratic){
		this.a = quadratic.getA();
		this.b = quadratic.getB();
		this.c = quadratic.getC();
	}
	
	public boolean isResult(){
		return getDiscriminant() >= 0;
	}
	
	private double getDiscriminant(){
		return Math.pow(b, 2) - 4 * a * c;
	}
	
	public Quadratic getQuadratic(){
		return new Quadratic(a, b, c, getFirstResult(), getSecondResult());
	}
	
	public double getFirstResult(){
		return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
	}
	
	public double getSecondResult(){
		return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
	}
}
