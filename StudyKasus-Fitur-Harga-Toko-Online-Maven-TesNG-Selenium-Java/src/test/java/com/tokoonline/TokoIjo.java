package com.tokoonline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TokoIjo {

	WebDriver driver;
	String baseURL = "https://www.tokopedia.com/sony-audio/sony-wh-1000xm5-black-wireless-noise-cancelling-headphone-wh1000xm5?extParam=ivf%3Dfalse&src=topads";
	
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.navigate().to(this.baseURL);
	}
	
	@Test(description="test date 08-July-22")
	public void testHargaTotal() {
		boolean state = true;
		while(state) {
			try{
				WebElement elementKlik =driver.findElement(By.xpath("//button[@aria-label='Tambah 1']"));
				
				int banyakClick=6;
				
				for (int i=1; i<banyakClick; i++) {
					elementKlik.click();
				}
				
				WebElement hargaJual = driver.findElement(By.xpath("//div[@class='price']"));
				WebElement totalHarga = driver.findElement(By.xpath("//p[@data-testid='pdpProductPrice']"));
				
				String harga = hargaJual.getText().replace("Rp", "").replace(".","");;
				String hargaTotal = totalHarga.getText().replace("Rp","").replace(".","");
				
				int hargaInt = Integer.valueOf(harga);
				int hargaTotalInt = Integer.valueOf(hargaTotal);
				System.out.println(hargaTotal);
				
				int ekspektasiHarga = banyakClick*hargaInt;
				Assert.assertEquals(hargaTotalInt, ekspektasiHarga);
				
				state = false;
				
			}catch(Exception e){
				state = true;
				System.out.println(e);
			}
		}

	}
	
	
	@AfterSuite
	public void closeDriver() {
		this.driver.close();
	
	}

}
