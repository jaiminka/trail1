package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\configs\\Amazon.properties");
		prop = new Properties();
		prop.load(file);
	}
	public static void openBrowser() {
		String Browser = prop.getProperty("Browser");
		
		if(Browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	public static void openAmazon() {
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	public static void closeBrowser() {
		driver.quit();
	}

}
