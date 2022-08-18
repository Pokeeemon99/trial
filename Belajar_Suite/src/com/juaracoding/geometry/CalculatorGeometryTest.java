package com.juaracoding.geometry;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CalculatorGeometryTest {
	int a1;
	int a2;
	CalculatorGeometry cal;
	
	@BeforeSuite
	public void setup() {
		this.a1=10;
		this.a2=20;
		this.cal = new CalculatorGeometry(a1, a2);
	}
	
	@Test
	public void testLuasPersegi() {
		int nilaiEkspektasi = 200;
		assertEquals(this.cal.luasPersegi(),nilaiEkspektasi);
	}
	
	@Test
	public void testLuasSegitiga() {
		int nilaiEkspektasi = 100;
		assertEquals(this.cal.luasSegitiga(),nilaiEkspektasi);
	}

}
