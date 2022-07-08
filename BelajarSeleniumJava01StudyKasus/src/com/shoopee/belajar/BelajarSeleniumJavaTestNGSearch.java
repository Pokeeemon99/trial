package com.shoopee.belajar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BelajarSeleniumJavaTestNGSearch {
	WebDriver driver;
	String baseURL = "https://shopee.co.id/";
	String query = "jam";

				
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.navigate().to(this.baseURL);
		
	}
	
	@Test
	public void searchBarTest() {
		WebElement element = driver.findElement(By.className("shopee-searchbar-input__input"));
		element.sendKeys(query);
		element.sendKeys(Keys.RETURN);
//		String pageExpectation = "";
		Assert.assertEquals(this.driver.getTitle(), "Jual jam Harga Terbaik Juli 2022 | Shopee Indonesia");
		
	}
	
	@AfterSuite
	public void closeDriver() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //mengatasi eror timing

//		this.driver.close();

	}	
}
