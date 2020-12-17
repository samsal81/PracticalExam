package junitTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.MainPage;
import util.BrowserFactory;

public class Test3 {
	
	//Test 3: Validate that all list item could be removed using the remove button and when "Toggle All" functionality is on.
	WebDriver driver;
	MainPage mainp;
	
	@Before
	public void init() {
		
		// Initiates the driver 
		driver = BrowserFactory.BrowserInit();
		
		// Applies POM on the class that contains the web elements library and the interactive methods 
		mainp = PageFactory.initElements(driver, MainPage.class);
	}

	@Test
	public void ValidateAllListItemsCouldBeRemoved() throws InterruptedException {
		
		// this method stores all the categories in an array list
		mainp.StoreAllCategories();
		
		// this method inputs all the categories and add them
		mainp.InputAddAllCategoryField();
		
		// this method clicks the check box that selects all the categories listed
		mainp.ClickCheckBoxAll();
		
		// this method clicks the remove button
		mainp.ClickRemoveButton();
		
	}
	
	@After
	public void Teardown() throws InterruptedException {
		
		Thread.sleep(3000);
		
		// closes and quits the driver
		BrowserFactory.tearDown();
	}
}
