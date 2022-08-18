package com.juaracoding.groups;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AuthenticationTest {
	int dataPersiapan;
	
	@BeforeSuite
	public void setupDriver() {
		this.dataPersiapan=5;
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void closeDriver() {
		System.out.println("After Suite");
	}
	
	@Test(groups= {"mingguan"})
	public void webLogin() {
		this.dataPersiapan-=1;
		System.out.println("web login "+ this.dataPersiapan);
	}
	
	@Test(groups= {"mingguan"})
	public void mobileLogin() {
		this.dataPersiapan-=1;
		System.out.println("mobile login " + this.dataPersiapan);
	}
	
	@Test(groups= {"harian", "mingguan"})
	public void apiLogin() {
		this.dataPersiapan-=1;
		System.out.println("api login " + this.dataPersiapan);
	}

}
