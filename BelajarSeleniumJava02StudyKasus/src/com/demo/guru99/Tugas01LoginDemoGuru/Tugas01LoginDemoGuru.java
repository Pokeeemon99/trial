package com.demo.guru99.Tugas01LoginDemoGuru;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Tugas01LoginDemoGuru {
	
	WebDriver driver;
	String baseURL = "https://demo.guru99.com/V1/index.php";
	String userName="mngr422858";
	String Password="tatUper";
	
	
				
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.navigate().to(this.baseURL);
		
	}
	
	
	@Test(description = "test 05-July-2022")
	public void loginTest() {
		WebElement user = driver.findElement(By.name("uid"));
		user.sendKeys(this.userName);

		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys(this.Password);
		
		driver.findElement(By.name("btnLogin")).click();

		
		String pageExpectation = "GTPL Bank Manager HomePage";
		Assert.assertEquals(this.driver.getTitle(), pageExpectation);
			
	}
	
	
	@AfterSuite
	public void closeDriver() {
		this.driver.close();
	
	}
	

}
