import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;


public class BelajarSelenium01 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
//		
//		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.amazon.com/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Xiaomi");
//		WebDriver driver;
//		String baseURL = "https://demo.guru99.com/V1/index.php";
//		String email;
//		String userName;
//		String Password;
//		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
//
//		driver = new ChromeDriver();
//		driver.navigate().to(baseURL);
//		
//		WebElement register = driver.findElement(By.linkText("http://demo.guru99.com/"));
//		
//		register.click();
//		System.out.println(register.isSelected());
//		
//		driver.close();
//		

	}

}