package com.sz.quadratic.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sz.quadratic.interfaces.IEntity;

@Entity
@Table( name = "quadratic" )
public class Quadratic implements IEntity{
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "id")
	private int id;
	
	@Column(name = "a")
	private double a;
	
	@Column(name = "b")
	private double b;
	
	@Column(name = "c")
	private double c;
	
	@Column(name = "result1")
	private double result1;
	
	@Column(name = "result2")
	private double result2;
	
	public Quadratic() {}
	
	public Quadratic(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public Quadratic(double a, double b, double c, double result1, double result2) {
		this(a,b,c);
		this.result1 = result1;
		this.result2 = result2;
	}

	public String toString(){
		return a + " " + b + " " + c + " " + result1 + " " + result2;
 	}
	
	@Override
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}

	public double getResult1() {
		return result1;
	}

	public void setResult1(double result1) {
		this.result1 = result1;
	}

	public double getResult2() {
		return result2;
	}

	public void setResult2(double result2) {
		this.result2 = result2;
	}
}
