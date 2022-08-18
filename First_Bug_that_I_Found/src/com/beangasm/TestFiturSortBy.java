package com.beangasm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestFiturSortBy {
	WebDriver driver = null;
	String url = "https://beangasm.id/";
	  
  @BeforeSuite
  public void setup() {
	System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
    
    this.driver = new ChromeDriver();
    
    this.driver.manage().window().maximize();
    this.driver.get(this.url);
  }
  
  
  @Test(groups="run")
  public void testBtnRoasted() {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int y=0; y<=10; y++) {
			js.executeScript("window.scrollBy(0," + y + ")");	
			}
		
	  WebElement roastedBtn = driver.findElement(By.xpath("//a[@href='https://beangasm.id/product?category=roasted-beans']"));
	  roastedBtn.sendKeys(Keys.RETURN);
	  
	  Assert.assertEquals(driver.findElement(By.xpath("//a[normalize-space()='Roasted Beans']")).getText(), "Roasted Beans");
  }
  
  @Test(groups="run")
  public void testSortByCheapest() {
	  WebElement sortBy = driver.findElement(By.xpath("//div[@class='nice-select wide lnk-sort sort-by-filter']"));
	  sortBy.click();
	  Boolean state = true;
	  while(state) {
		  try{
			  WebElement sortByCheapest = driver.findElement(By.xpath("//li[normalize-space()='Cheapest']"));
			  sortByCheapest.click();
			  
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  for(int y=0; y<=60; y++) {
				  js.executeScript("window.scrollBy(0," + y + ")");
				  }
			  state = false;
		  	}catch(Exception e) {}
	  }
	  
	  state = true;
	  while (state) {
		  try {
		    List<WebElement> prices = this.driver.findElements(By.xpath("//div[@class='hm-fp-bdy w-100 mb-3']//div[@class='hm-fp-bdy-pr mb-1']"));
		    System.out.println("Price Size Cheapest--> " + prices.size());
		    
		    int currentPrice = 0;
			    for (WebElement price: prices) {
			      String harga = price.getText().replace("Rp", "").replace(".", "").replace(" ", "");
			      int latestInt= Integer.valueOf(harga);
				          System.out.println("Coffee price before Rp" + currentPrice + " vs " +"Coffee price after Rp"+ latestInt);
			      
			      if (currentPrice <= latestInt) {
			        currentPrice = latestInt;
			      } else {
			        Assert.assertTrue(currentPrice <= latestInt);
			      }
			    }
			    
			    state = false;
		    }catch (Exception e) {
		    
		  }
		}
  	}
  

  @Test(groups="run")
  public void testSortByMostExpensive() {

	  Boolean state = true;
	  while(state) {
		  try {
			  WebElement sortBy = driver.findElement(By.xpath("//div[@class='nice-select wide lnk-sort sort-by-filter']"));
					//to perform Scroll on application using Selenium
			      JavascriptExecutor js = (JavascriptExecutor) driver;
			      js.executeScript("window.scrollBy(0,-15)");
			  sortBy.click();
			  state = false;
		  }catch(Exception e) {}
	  }
	  
	  state = true;
	  while(state) {
		  try{
			  WebElement sortByMostExpensive = driver.findElement(By.xpath("//li[@class='option selected focus']"));
			  sortByMostExpensive.click();
			  
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  for(int y=0; y<=60; y++) {
				  js.executeScript("window.scrollBy(0," + y + ")");
				  }
			  state = false;
		  	}catch(Exception e) {}
	  }
	  
	  state = true;
	  while (state) {
		  try {
		    List<WebElement> prices = this.driver.findElements(By.xpath("//div[@class='hm-fp-bdy w-100 mb-3']//div[@class='hm-fp-bdy-pr mb-1']"));
		    System.out.println("Price Size MostExpensive --> " + prices.size());
		    
		    int currentPrice = Integer.valueOf(prices.get(0).getText().replace("Rp", "").replace(".", "").replace(" ", ""));;
			    for (WebElement price: prices) {
			      String harga = price.getText().replace("Rp", "").replace(".", "").replace(" ", "");
			      int latestInt= Integer.valueOf(harga);
				          System.out.println("Coffee price before Rp" + currentPrice + " vs " +"Coffee price after Rp"+ latestInt);
			      
			      if (currentPrice >= latestInt) {
			        currentPrice = latestInt;
			      } else {
			        Assert.assertTrue(currentPrice >= latestInt);
			      }
			    }
			    
			    state = false;
		    }catch (Exception e) {
		    
		  }
		}
  	}
  
  
	@AfterSuite
	public void closeDriver(){
		this.driver.close();
		
	}




}
