package testngTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.MainPage;
import util.BrowserFactory;

public class Test3 {
	
	// Test 3: Validate the month drop down has all the months (jan, feb, mar ...) in the Due Date dropdown section.
	WebDriver driver;
	MainPage mainp;

	@BeforeMethod
	public void init() {

		// Initiates the driver
		driver = BrowserFactory.BrowserInit();

		// Applies POM on the class that contains the web elements library and the
		// interactive methods
		mainp = PageFactory.initElements(driver, MainPage.class);
	}

	@Test
	public void ValidateMonthDropDownHasAllMonths() {

	}

	@AfterMethod
	public void Teardown() throws InterruptedException {

		Thread.sleep(3000);

		// closes and quits the driver
		BrowserFactory.tearDown();
	}
}
