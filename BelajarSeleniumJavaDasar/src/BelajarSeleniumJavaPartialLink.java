
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BelajarSeleniumJavaPartialLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/newtours/index.php");
	
		String egis = driver.findElement(By.partialLinkText("EGIS")).getText();
		System.out.println(egis);
		
		egis = driver.findElement(By.partialLinkText("egis")).getText();
		System.out.println(egis);

	}

}



