import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BelajarSeleniumCheckList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/facebook.html");
		
		WebElement checkList = driver.findElement(By.id("persist_box"));
		
		checkList.click();
		System.out.println(checkList.isSelected());
		
		checkList.click();
		System.out.println(checkList.isSelected());
		
		driver.close();

	}

}
