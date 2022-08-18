package com.tokoonline;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TokoOrange {
	WebDriver driver;
	String baseURL = "https://shopee.co.id/Handphone-Murah-Galaxy-M22-12GB-512GB-HP-androit-termurah-Promo-Cuci-Gudang-Android-Ponsel-Baru-Original-6.4Inci-4G-5G-HD-Screen-Mobile-Phone-i.704144021.13093965070?sp_atk=0b653b53-b6b6-4fa1-8a6b-5c0bb2a8962d&xptdk=0b653b53-b6b6-4fa1-8a6b-5c0bb2a8962d";
	
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
				WebElement elementKlik =driver.findElement(By.xpath("//div[contains(@class,'flex items-center G2C2rT')]//button[2]"));
				
				int banyakClick=1;
				
				for (int i=1; i<banyakClick; i++) {
					elementKlik.click();
				}
				
				WebElement hargaJual = driver.findElement(By.xpath("//div[@class='pmmxKx']"));
				WebElement totalHarga = driver.findElement(By.xpath("//div[@class='pmmxKx']"));
				
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
