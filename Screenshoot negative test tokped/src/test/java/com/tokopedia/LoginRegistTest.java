package com.tokopedia;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class LoginRegistTest {
	
	WebDriver driver;
	String baseURL = "https://www.tokopedia.com/";
	
	public static File ambilGambar(WebDriver webdriver, String filePath) throws IOException {
		TakesScreenshot screenShoot = ((TakesScreenshot)webdriver);
		File srcFile = screenShoot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(filePath);
		
		//copy file at destination
		FileUtils.copyFile(srcFile,destinationFile);
		
		return destinationFile;
	}
	
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.get(this.baseURL);
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
					try{
						//file path
						String akhirFile = System.getProperty("user.dir") + "\\test-output\\tokpedss1.png";
						File destinationFile = LoginRegistTest.ambilGambar(driver, akhirFile);
						
						//report code
						Reporter.log("<a target='_blank' href=' "+ destinationFile.getAbsolutePath() + "'>"+"'<img src='" + destinationFile.getAbsolutePath() + "'width=100 height=100/></a>") ;
					
						}catch(IOException e) {
							System.out.println("ada eror bang");
						}
					
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
		
		Boolean state =true;
		while(state) {
			WebElement regis = driver.findElement(By.xpath("//input[@id='regis-input']"));
			regis.sendKeys("08119787884"); //nomor terdaftar
			state= false;
		}
		
		state =true;
		while(state) {
			try {
				WebElement submit = driver.findElement(By.xpath("//button[@data-testid=\"phone-email-submit\"]"));
				submit.click();

			 	try{
					//file path
					String akhirFile = System.getProperty("user.dir") + "\\test-output\\tokpedss2.png";
					File destinationFile = LoginRegistTest.ambilGambar(driver, akhirFile);
					
					//report code
					Reporter.log("<a target='_blank' href=' "+ destinationFile.getAbsolutePath() + "'>"+"'<img src='" + destinationFile.getAbsolutePath() + "'width=100 height=100/></a>") ;
				
					}catch(IOException e) {
						System.out.println("ada eror bang");
					}
			 	
				String error = driver.findElement(By.xpath("//h2[@class='css-1bzlqki-unf-heading ej53lua2']")).getText();
			 	System.out.println(error);
			 	Assert.assertTrue(error.contains("Nomor HP Sudah Terdaftar"));
			 	
				state = false;
			}catch(Exception e) {
				System.out.println("ada eror bang disini");
				state = true;
			}
		}
	}

	
	@AfterSuite
	public void closeDriver() {
		this.driver.close();
	
	}
	

}
