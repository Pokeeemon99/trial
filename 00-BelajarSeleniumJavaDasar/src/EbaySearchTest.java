import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class EbaySearchTest {
	WebDriver driver;
	String baseURL = "https://www.ebay.com/";
	String query = "Xiaomi";

				
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.navigate().to(this.baseURL);
		
	}
	
	@Test
	public void searchBarTest() {
		WebElement element = driver.findElement(By.id("gh-ac"));
		element.sendKeys("Samsung");
		element.sendKeys(Keys.RETURN);
		String pageExpectation = "samsung: Search Result | eBay";
		Assert.assertEquals(this.driver.getTitle(), pageExpectation);
		
	}
	
	@AfterSuite
	public void closeDriver() {
		this.driver.close();
	}


}
