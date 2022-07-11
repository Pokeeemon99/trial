package com.tokopedia.loginregist;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginRegistTest {
	
	WebDriver driver;
	String baseURL = "https://www.tokopedia.com/";
	
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.navigate().to(this.baseURL);
	}
	
	
	@Test(description = "Test date 09-July-22")
	public void loginTest() { 
		 WebElement loginBtn = driver.findElement(By.xpath("//button[@data-testid=\"btnHeaderLogin\"]"));
		 loginBtn.click();

		Boolean state =true;
		while(state) {
			try {
				 WebElement login = driver.findElement(By.xpath("//input[@id='email-phone']"));				 
				 WebElement submit = driver.findElement(By.xpath("//button[@id=\"email-phone-submit\"]"));

					Actions builder = new Actions(driver);
					Action seriesAksi = builder
							.moveToElement(login)
							.sendKeys(login,"081197878846")
							.moveToElement(submit)
							.click()
							.build();
					seriesAksi.perform();	
		
					String error = driver.findElement(By.xpath("//h4[@class='css-1a4g0pw-unf-heading e1qvo2ff4']")).getText();
					Assert.assertTrue(error.contains("Nomor HP belum terdaftar"));
					
					driver.close();	
				state = false;
			}catch(Exception e) {
				state = true;
			}
		}
		
	}
	
	
	@Test(description = "Test date 09-July-22")
	public void registTest() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.navigate().to(this.baseURL);
		
		
		WebElement regisBtn = driver.findElement(By.xpath("//button[@data-testid=\"btnHeaderRegister\"]"));
		regisBtn.click();
		
//		Boolean state =true;
//		while(state) {
			try {
				 WebElement regis = driver.findElement(By.xpath("//input[@id='regis-input']"));
				 regis.sendKeys("0811987884"); //nomor terdaftar
				 WebElement submit = driver.findElement(By.xpath("//button[@data-testid=\"phone-email-submit\"]"));
				 submit.click();
				 
				 String error = driver.findElement(By.xpath("//h2[@class='css-1bzlqki-unf-heading ej53lua2']")).getText();
			     Assert.assertTrue(error.contains("Nomor HP Sudah Terdaftar"));				//ekspektasi nomor terdaftar(negative test)

//				 state = false;
			}catch(Exception e) {
//				state = true;
			}
		}
//	}
	
	
	
	@AfterSuite
	public void closeDriver() {
		this.driver.close();
	
	}
	

}
