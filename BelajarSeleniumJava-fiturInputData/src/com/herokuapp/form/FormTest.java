package com.herokuapp.form;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FormTest {
	
	WebDriver driver;
	String baseURL = "https://formy-project.herokuapp.com/form";
	
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.navigate().to(this.baseURL);
	}
	
	@Test(description = "test date 07-July-22")
	public void testForm(){
		WebElement uid = driver.findElement(By.id("first-name"));		//automation date 05-July-22 
		WebElement lastname = driver.findElement(By.id("last-name"));
		WebElement jobTitle = driver.findElement(By.id("job-title"));
		WebElement edu1 = driver.findElement(By.id("radio-button-1"));
		WebElement genderMan = driver.findElement(By.id("checkbox-1"));
		WebElement experience = driver.findElement(By.id("select-menu"));
		WebElement date = driver.findElement(By.id("datepicker"));
		WebElement submit = driver.findElement(By.xpath("//a[@role='button']"));
		

		Actions builder = new Actions(driver);
		Action seriesAksi = builder.moveToElement(uid)
				.keyDown(uid, Keys.SHIFT)
				.sendKeys(uid,"hello")  //Capital
				.keyUp(uid, Keys.SHIFT)
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
	
	
	
	@AfterSuite
	public void closeDriver() {
		this.driver.close();
	
	}

}
