import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class BelajarSeleniumJavaSeriesAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/index.php");
		
		WebElement uid = driver.findElement(By.name("uid"));		//automation date 05-July-22 
		WebElement password = driver.findElement(By.name("password"));
		WebElement btnSubmit = driver.findElement(By.name("btnLogin"));
		
		Actions builder = new Actions(driver);
		Action seriesAksi = builder.moveToElement(uid)
				.keyDown(uid, Keys.SHIFT)
				.sendKeys(uid,"hello")  //Capital
				.keyUp(uid, Keys.SHIFT)
				.moveToElement(password)   //moveToElement equals TAB on Keyboard
				.sendKeys(password,"kkkkksksksk")
				.moveToElement(btnSubmit)
				.click()
				.build();
				
		seriesAksi.perform();
		
		//uid.sendKeys("HELLO")
		//password.sendKeys("kkkkksksksk")
		//btn.submit.click();
		


	}

}
