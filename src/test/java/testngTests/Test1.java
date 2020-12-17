package testngTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.MainPage;
import util.BrowserFactory;

public class Test1 {
	
	// Test 1: Validate a user is able to add a category and once the category is added it should display.
	WebDriver driver;
	MainPage mainp;
	
	@BeforeMethod
	public void init() {
		
		// Initiates the driver 
		driver = BrowserFactory.BrowserInit();
		
		// Applies POM on the class that contains the web elements library and the interactive methods 
		mainp = PageFactory.initElements(driver, MainPage.class);
	}
	
	@Test
	public void ValidateAddCategoryAndDisplayed() {
		
		// this method creates a new category
		// Any value can be entered replacing Selenium
		mainp.CreateANewCategory("Selenium");
		
		// this method checks if the newly created category was displayed on the list
		mainp.ValidateNewCategoryIsListed();
	}
	
	@AfterMethod
	public void Teardown() throws InterruptedException {
		
		Thread.sleep(3000);
		
		// closes and quits the driver
		BrowserFactory.tearDown();
	}
}
