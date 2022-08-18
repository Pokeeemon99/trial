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

public class AmazonSearchJavaSelenium {
	
	WebDriver driver;
	String baseURL = "https://www.amazon.com/";
	String query = "Alexa";
//
//	public void renderSolve() {
//		boolean state = true;
//		while (state) {
//			try {
//				List <WebElement> product = driver.findElements(By.xpath(baseURL));
//				System.out.println();
//				state = false;
//			} catch (StatementReferenceException e) {
//				state = true;
//			}
//		}
//	}
//	
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.navigate().to(this.baseURL);
		WebElement element = driver.findElement(By.xpath("//input[@type=\"text\"]"));
		element.sendKeys(query);
		element.sendKeys(Keys.RETURN);
	}
	
	
	@Test(description = "test 07-July-2022")
	public void test() {
		boolean state=true;
		while(state) {
			try {
				List <WebElement> hargaAlexa = driver.findElements(By.xpath("//span[@class=\"a-price-whole\"]"));
				for(WebElement harga: hargaAlexa) {
					System.out.println(harga.getText());
					Assert.assertNotNull(harga.getText());
					}
					state=false;
				} catch (Exception e) {
					state=true;
				}
			}
		}
	
	@AfterSuite
	public void closeDriver() {
		this.driver.close();
	
	}
		
		
}
	
	

