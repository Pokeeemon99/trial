import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class BelajarSeleniumEbay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.ebay.com/");
		
		WebElement elem = driver.findElement(By.id("gh-ac")); //id (description = "automation 07-July-2022")
		elem.sendKeys("Iphone");
		elem.sendKeys(Keys.RETURN);
		
		String teks= driver.findElement(By.className("srp-controls__count-heading")).getText();
		
		driver.close();
		
		
		
//		driver.findElement(By.id("gh-ac")).sendKeys("Xiaomi");
//		driver.findElement(By.id("gh-ac")).sendKeys(Keys.RETURN);

	}

}