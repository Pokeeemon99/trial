package com.juaracoding.weapon;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WeaponTest {
	int tembak;
	int peluru;
	Weapon m4;
	
	@BeforeSuite
	public void setUp() {
		this.peluru = 30;
		this.tembak = 50;
		this.m4 = new Weapon(peluru);
		
	}
	
	@Test
	public void testShoot() {
		int nilaiEkspektasi = 0;
		assertEquals(this.m4.shoot(tembak), nilaiEkspektasi);
	}
	
	@Test
	public void testReload() {
		int nilaiEkspektasi = 30;
		assertEquals(this.m4.reload(), nilaiEkspektasi);
	}



}
