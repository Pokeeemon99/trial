import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BelajarSeleniumKlikGambar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://lms.juaracoding.com/");
		
		WebElement elem = driver.findElement(By.cssSelector("a[title='Home']")); // automation date 06-July-22
		System.out.println(elem.getTagName());
		
		WebElement elemTmg = driver.findElement(By.cssSelector("img[alt='logo']")); // automation date 06-July-22
		System.out.println(elemTmg.getAttribute("src"));


	}

}
