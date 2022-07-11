package com.tokopedia.login;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class LoginTest {
	
	WebDriver driver;
	String baseURL = "https://www.tokopedia.com/login";
	
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.navigate().to(this.baseURL);
	}
	
	@Test(description="Test date 08-July-22")
	public void testMethod(){
	    //method here
	    WebElement login = driver.findElement(By.xpath("//input[@id='email-phone']"));
	    login.sendKeys("085328787342");  //no hp belum terdaftar

	    try{
	        String error = driver.findElement(By.xpath("//h4[@class='css-1a4g0pw-unf-heading e1qvo2ff4']")).getText();
	        Assert.assertTrue(error.contains("Nomor HP belum terdaftar"));

	       }catch (Exception e){
	    	   System.out.println(e);
	       }
	}
	
	@AfterSuite
	public void closeDriver() {
		this.driver.close();
	
	}


}
