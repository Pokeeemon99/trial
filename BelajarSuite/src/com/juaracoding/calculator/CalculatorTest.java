package com.juaracoding.calculator;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CalculatorTest {
	int a1;
	int a2;
	CalculatorApp cal;
	
	@BeforeSuite
	public void setup() {
		this.a1=10;
		this.a2=20;
		this.cal = new CalculatorApp(a1, a2);
	}
	
	@Test
	public void testPengurangan() {
		int nilaiEkspektasi = 10;
		assertEquals(this.cal.kurang(),nilaiEkspektasi);
	}

}
