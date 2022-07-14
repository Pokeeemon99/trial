package com.phptravels.home;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class VisaTest {	
	WebDriver driver;
	String baseURL = "https://www.phptravels.net/";
	String negaraAsal = "Indonesia";
	String negaraTujuan= "Afghanistan";
	
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.get(this.baseURL);
		
	}
	
	@Test(priority=1)
	public void visaTest() {
		WebElement visa = driver.findElement(By.xpath("//span[normalize-space()='visa']"));
		visa.click();
		WebElement fromCountry = driver.findElement(By.xpath("//span[@id='select2-from_country-container']"));
		WebElement toCountry = driver.findElement(By.xpath("//span[@id='select2-to_country-container']"));
		WebElement date = driver.findElement(By.xpath("//div[@class='col-md-2']//input[@id='date']"));
		WebElement dates = driver.findElement(By.xpath("//form[@id='visa-submit']//input[@id='date']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')",date);
		date.clear();

		WebElement submit = driver.findElement(By.xpath("//form[@id='visa-submit']//button[@id='submit']"));
		
		Boolean state=true;
		while(state) {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				for(int y=0; y<=100; y++) {
					js.executeScript("window.scrollBy(0," + y + ")");	
					}
				
	
				Actions build = new Actions(driver);
				Action series = build.moveToElement(fromCountry).click()
						.sendKeys(fromCountry, this.negaraAsal, Keys.ENTER)
						.moveToElement(toCountry).click()
						.sendKeys(toCountry, this.negaraTujuan, Keys.ENTER)
						.moveToElement(date)
						.click()
						.moveToElement(dates)
						.click()
						.sendKeys(dates, "25-07-2022")
						.moveToElement(submit)
						.click()
						.build();
				series.perform();
				state=false;
				
			}catch(Exception e) {}
			
			Assert.assertEquals(driver.getTitle(), "Submit Visa - PHPTRAVELS");
		}
		
	}
	
	@Test(priority=2)
	public void formTest() {
		Boolean state=true;
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		WebElement phone = driver.findElement(By.xpath("//input[@placeholder='Phone']"));
		WebElement date = driver.findElement(By.xpath("//input[@placeholder='Date']"));
		WebElement dates = driver.findElement(By.xpath("//input[@placeholder='Date']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')",date);
		date.clear();
		WebElement notes = driver.findElement(By.xpath("//textarea[@placeholder='Notes']"));

		WebElement submit = driver.findElement(By.xpath("//form[@id='visa-submit']//button[@id='submit']"));
		
		while(state) {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				for(int y=0; y<=100; y++) {
					js.executeScript("window.scrollBy(0," + y + ")");	
					}
				
	
				Actions build = new Actions(driver);
				Action series = build.moveToElement(firstName).click()
						.sendKeys(firstName, "otong")
						.moveToElement(lastName).click()
						.sendKeys(lastName, "surotong")
						.moveToElement(email).click()
						.sendKeys(email, "surotong@gmail.com")
						.moveToElement(phone).click()
						.sendKeys(phone, "08965657866")
						.moveToElement(date)
						.click()
						.moveToElement(dates)
						.click()
						.sendKeys(dates, "25-07-2022")
						.moveToElement(notes).click()
						.sendKeys(notes, "trial")
						.moveToElement(submit)
						.click()
						.build();
				series.perform();
				state=false;
				
			}catch(Exception e) {}
			
			Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Your visa form has been submitted']")).getText(), "Your visa form has been submitted");
			
		}

	}
	
	@AfterSuite
	public void closeDriver() {
		this.driver.close();
	
	}
	
}
