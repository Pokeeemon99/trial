package com.juaracoding.test;
import org.testng.annotations.Test;

public class Kategori {
	
	@Test(groups= {"mingguan"})
	public void testElektronik() {
		System.out.println("testing category pada elektronik");
	}
	
	@Test(groups= {"harian", "mingguan"})
	public void testLatestProduct() {
		System.out.println("testing category pada latest produk");
	}
	
	@Test(groups= {"mingguan"})
	public void testRumahTangga() {
		System.out.println("testing category pada produk rumah tangga");
	}
	
	@Test(groups= {"harian", "mingguan"})
	public void testBarangDiskon() {
		System.out.println("testing category pada produk diskon");
	}

}
