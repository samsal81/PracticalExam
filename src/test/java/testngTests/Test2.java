package testngTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.MainPage;
import util.BrowserFactory;

public class Test2 {

	// Test 2: Validate a user is not able to add a duplicated category. If it does then the following message will display: "The category you want to add already exists: <duplicated category name>."
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
	public void ValidateNoDuplicateCategoryAndMessageDisplayed() throws InterruptedException {
		
		// this method creates a new category
		mainp.CreateANewCategory("java");
		
		// this message validates the duplicate message is displayed if a duplicate category name is attempted
		mainp.ValidateDuplicateWarningMessage();
		Thread.sleep(2000);
		
		// This command navigates the browser to the previous page
		driver.navigate().back();
		
		// this method checks if the attempt to create a duplicate category was not successful
		mainp.ValidateDuplicateCategoryIsNotListed();

	}

	@AfterMethod
	public void Teardown() throws InterruptedException {

		Thread.sleep(3000);

		// closes and quits the driver
		BrowserFactory.tearDown();
	}
}
