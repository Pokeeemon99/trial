package com.tokopedia.scroll;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ScrollTest {
	WebDriver driver;
	
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		
		driver.get("https://www.tokopedia.com/search?q=geisha&source=universe&st=product&srp_component_id=02.07.01.01");
		
	}
	
	@Test
	public void testScroll() {
		
		//eksekusi scroll menggunakan javascript
		boolean state = true;
		while(state) {
			try{
				JavascriptExecutor js = (JavascriptExecutor) driver;
					for(int y=0; y<=1000; y++) {
						js.executeScript("window.scrollBy(0," + y + ")");	
					}
					
				List <WebElement> hargaHp = driver.findElements(By.xpath("//div[@data-testid=\"spnSRPProdPrice\"]"));
					for(WebElement harga: hargaHp) {
						System.out.println(harga.getText());
					}
					
				System.out.println("Jumlah harga hp yang terdeteksi adalah "+ hargaHp.size());
				
				Assert.assertEquals(hargaHp.size(), 80);
				state = false;
	
			}catch(Exception e) {
				//other
				state= true;
			}
		}	
	}
	
	
	@AfterSuite
	public void closeDriver() {
		this.driver.close();

	}	
}
