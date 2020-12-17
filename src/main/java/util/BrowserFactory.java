package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	// This method initializes the browser and navigate to the website
	// then maximize the Browser window and delete the cookies and set an implicit wait
	public static WebDriver BrowserInit() {
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://techfios.com/test/101/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	// This method closes the driver that is running the browser window and after that quits the driver
	public static void tearDown() {
		
		driver.close();
		driver.quit();
	}

}
