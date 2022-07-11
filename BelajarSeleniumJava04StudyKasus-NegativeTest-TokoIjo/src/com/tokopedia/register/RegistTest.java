package com.tokopedia.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class RegistTest {
	
	WebDriver driver;
	String baseURL = "https://www.tokopedia.com/register";
	
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.navigate().to(this.baseURL);
	}
	
	
	@Test(description="test date 08-July-22")
	public void testMethod(){
	    //method here
		 WebElement regis = driver.findElement(By.xpath("//input[@id='regis-input']"));
		 regis.sendKeys("0811987884"); //nomor terdaftar
		 WebElement submit = driver.findElement(By.xpath("//button[@data-testid=\"phone-email-submit\"]"));
		 submit.click();

		 
	    try{
	        String error = driver.findElement(By.xpath("//h2[@class='css-1bzlqki-unf-heading ej53lua2']")).getText();

	        Assert.assertTrue(error.contains("Nomor HP Sudah Terdaftar"));				//ekspektasi nomor terdaftar(negative test)
	        

	       }catch (Exception e){
	         System.out.println(e);
	       }
	}
	
	@AfterSuite
	public void closeDriver() {
		this.driver.close();
	
	}

	
}
