import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BelajarSeleniumLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//tombol SubmitLogin
		//email email
		//pasword passwd
		
		//isi email
		//isi passwd
		//klik tombol login
		
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/login.html");
		
		WebElement inputEmail = driver.findElement(By.id("email"));
		inputEmail.sendKeys("email@gmail.com");
		
		WebElement inputPass = driver.findElement(By.id("passwd"));
		inputPass.sendKeys("password");
		
		driver.findElement(By.id("SubmitLogin")).click();
		
		driver.close();

	}

}
