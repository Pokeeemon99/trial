package contoh.screenshoot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ssCode {
	
	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
		
		try {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tokopedia.com/");
		
		//file path
		String akhirFile = System.getProperty("user.dir") + "\\test-output\\tokpedss.png";
		File destinationFile = ssCode.ambilGambar(driver, akhirFile);
		
		//report code
		Reporter.log("<a target='_blank' href=' "+ destinationFile.getAbsolutePath() + "'>"+"'<img src='" + destinationFile.getAbsolutePath() + "'width=100 height=100/></a>") ;
		
		}catch(IOException e) {
			System.out.println("ada eror bang");
		}
	}

	public static File ambilGambar(WebDriver webdriver, String filePath) throws IOException {
		TakesScreenshot screenShoot = ((TakesScreenshot)webdriver);
		File srcFile = screenShoot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(filePath);
		
		//copy file at destination
		FileUtils.copyFile(srcFile,destinationFile);
		
		return destinationFile;
	}
}
