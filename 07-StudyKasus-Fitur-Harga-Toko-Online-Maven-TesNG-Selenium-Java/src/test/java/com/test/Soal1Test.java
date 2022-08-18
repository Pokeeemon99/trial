package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Soal1Test {
	WebDriver driver;
	String baseURL = "https://formy-project.herokuapp.com/form";
	
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.navigate().to(this.baseURL);
	}
	
	@Test
	public void testIsiForm() {
		WebElement firstName= driver.findElement(By.id("first-name"));
		WebElement lastname = driver.findElement(By.id("last-name"));
		WebElement jobTitle = driver.findElement(By.id("job-title"));
		WebElement edu1 = driver.findElement(By.id("radio-button-1"));
		WebElement genderMan = driver.findElement(By.id("checkbox-1"));
		WebElement experience = driver.findElement(By.id("select-menu"));
		WebElement date = driver.findElement(By.id("datepicker"));
		WebElement submit = driver.findElement(By.xpath("//a[@role='button']"));
		
		Reporter.log("test isi form");
		

		Actions builder = new Actions(driver);
		Action seriesAksi = builder.moveToElement(firstName)
				.keyDown(firstName, Keys.SHIFT)
				.sendKeys(firstName,"hello")  //Capital
				.keyUp(firstName, Keys.SHIFT)
				.moveToElement(lastname)   //moveToElement equals TAB on Keyboard
				.sendKeys(lastname,"kkkkksksksk")
				.moveToElement(jobTitle)
				.sendKeys(jobTitle,"CTO")
				.moveToElement(edu1)
				.click()
				.moveToElement(genderMan)
				.click()
				.moveToElement(experience)
				.click()
				.sendKeys(experience, Keys.ARROW_DOWN)
				.sendKeys(experience, Keys.ARROW_DOWN)
				.sendKeys(experience, Keys.ENTER)
				.moveToElement(date)
				.sendKeys(date, "29121999")
				.sendKeys(experience, Keys.ENTER)
				.moveToElement(submit)
				.click()
				.build();
				seriesAksi.perform();
		Assert.assertEquals(this.driver.getTitle(), "Formy");
		
		
	}

}
