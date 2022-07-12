package com.herokuapp.buttons;

import org.openqa.selenium.By;
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

public class ButtonsTest {

	WebDriver driver;
	String baseURL = "https://formy-project.herokuapp.com/buttons";
	
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.get(this.baseURL);
	}
	
	@Test(priority=1)
	public void testPrimaryButton(){
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Primary']"));
		button.click();		
		String expectation="Primary";
		Assert.assertEquals(button.getText(), expectation);
	
	}
	
	
	@Test(priority=2)
	public void testLeftMidleRigtButton(){
		WebElement left = driver.findElement(By.xpath("//button[normalize-space()='Left']"));
		left.click();
		String expectation="Left";
		Assert.assertEquals(left.getText(), expectation);
	
	}
	
	
	@Test(priority=3)
	public void test12Dropdown(){
		WebElement drop = driver.findElement(By.xpath("//button[@id='btnGroupDrop1']"));
		WebElement drop1 = driver.findElement(By.xpath("//a[normalize-space()='Dropdown link 1']"));
		WebElement drop2 = driver.findElement(By.xpath("//a[normalize-space()='Dropdown link 2']"));
		Actions builder = new Actions(driver);
		Action action = builder.moveToElement(drop)
				.click()
				.moveToElement(drop1)
				.click()
				.build();
		action.perform();
		
		String expectation="https://formy-project.herokuapp.com/buttons#";
		Assert.assertEquals(driver.getCurrentUrl(), expectation);
		
	}	
	
	@AfterSuite
	public void closeDriver() {
		this.driver.close();
	
	}

}
