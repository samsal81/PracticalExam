package junitTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.MainPage;
import util.BrowserFactory;

public class Test2 {

	// Test 2: Validate that a single list item could be removed using the remove button when a single checkbox is selected.
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
	public void ValidateSingleListItemCouldBeRemoved() throws InterruptedException {

		// this method stores all the categories in an array list
		mainp.StoreAllCategories();

		// this method takes the first item in the array list and add it to the TODO list
		mainp.AddOneListItemToList();

		// this method removes the first item on the item list
		mainp.SelectAndRemoveOneListItem();

	}
	
	@After
	public void Teardown() throws InterruptedException {
		
		Thread.sleep(3000);
		
		// closes and quits the driver
		BrowserFactory.tearDown();
	}
}
