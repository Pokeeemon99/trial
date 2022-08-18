import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BelajarSeleniumJavaDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		Select negaraAsal = new Select(driver.findElement(By.name("country")));
		negaraAsal.selectByIndex(3);
		
		int counter =1;
		
		if(negaraAsal.getOptions().size()>0) {
			for(WebElement elem: negaraAsal.getOptions()) {
				System.out.println(counter+""+elem.getText()+elem.getAttribute("value"));
				counter +=1;
			}
		}
		
		
//		for (WebElement elem:negaraAsal.getOptions()) {
//			if(elem.isDisplayed()) {
//				System.out.println(elem.getAttribute("value"));
//			}
//		}
		
		
	}

}
