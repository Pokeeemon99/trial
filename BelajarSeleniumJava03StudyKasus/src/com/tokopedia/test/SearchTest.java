package com.tokopedia.test;

import static org.testng.Assert.*;

import java.util.List;
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

public class SearchTest {
	
	WebDriver driver;
	String baseURL = "https://www.tokopedia.com/";
	String query = "Iphone";

				
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.navigate().to(this.baseURL);
//		WebElement element = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)"));
		WebElement element = driver.findElement(By.xpath("(//input[@type='text'])"));
		element.sendKeys(query);
		element.sendKeys(Keys.RETURN);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
	}
	
	@Test(description = "test 07-July-2022")
	public void searchBarTest() {
//		List <WebElement> daftarHp = driver.findElements(By.xpath("//*[@id=\"zeus-root\"]/div/div[2]/div/div[2]/div[4]"));
//		List <WebElement> hargaHp = driver.findElements(By.xpath("//div[@data-testid='spnSRPProdPrice']"));
		List <WebElement> hargaHp = driver.findElements(By.xpath("//div[@data-testid=\"linkProductPrice\"]"));

		for(WebElement harga: hargaHp) {
			String price = harga.getText().replace("Rp", "").replace(".", "").replace(" ", "");
			int hargaInt= Integer.valueOf(price);
			System.out.println(hargaInt);
			Assert.assertEquals(hargaInt > Integer.valueOf("0"), true);
			
		}
		
		
	}
	
	@AfterSuite
	public void closeDriver() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES); //mengatasi eror timing

		this.driver.close();

	}	

}
