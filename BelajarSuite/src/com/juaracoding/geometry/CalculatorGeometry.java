package com.juaracoding.geometry;

public class CalculatorGeometry {
	double x;
	double y;
	
	public CalculatorGeometry(double x, double y) {
		this.x = x;
		this.y = y;
		
	}
	
	public double luasPersegi() {
		double hasil = this.x * this.y;
		return hasil;
	}
	
	public double luasSegitiga() {
		double hasil = this.x * this.y /2;
		return hasil;
	}
}
