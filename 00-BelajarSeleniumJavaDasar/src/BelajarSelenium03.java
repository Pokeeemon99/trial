import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class BelajarSelenium03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/ajax.html");
		
		List<WebElement> elements = driver.findElements(By.name("name"));
		System.out.println("jumlah element" + elements.size());
		
		for (WebElement element : elements) {
			System.out.println(element.getAttribute("value"));
			
		}
		
		driver.close();
//		WebElement elem = driver.findElement(By.id("gh-ac"));
//		elem.sendKeys("Iphone");
//		elem.sendKeys(Keys.RETURN);
//		
//		String teks= driver.findElement(By.className("srp-controls__count-heading")).getText();
//		
//		driver.close();
//	

	}

}
