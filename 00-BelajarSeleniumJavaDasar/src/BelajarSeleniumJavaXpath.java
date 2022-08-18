import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BelajarSeleniumJavaXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/index.php");
		
		
		
	//Xpath Formulation
		
		//button[contains(@class,"rounded")]
		//button[@type="submit"]
		//element[@attribute='nilai']
		//element[contain(@attr,"nilai")]


	}

}
