package page;

import java.util.ArrayList;
import java.util.HashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class MainPage {

	WebDriver driver;
	ArrayList<String> categories = new ArrayList<String>();
	int cat;
	String CatName;

	// A constructor to initialize the driver on this page
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	// WebElements Library
	@FindBy(how = How.NAME, using = "allbox")
	WebElement CheckBoxAll;
	@FindBy(how = How.NAME, using = "data")
	WebElement AddCategoryField;
	@FindBy(how = How.XPATH, using = "//input[@value='Add']")
	WebElement ButtonAddCategoryField;
	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'Back')]")
	WebElement BackButton;
	@FindBy(how = How.XPATH, using = "//b[1]")
	WebElement WarningPage;
	@FindBy(how = How.XPATH, using = "//input[@value='Remove']")
	WebElement RemoveButton;
	@FindBy(how = How.XPATH, using = "//input[@value='Add category']")
	WebElement CreateCategoryButton;
	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'The category you want to add already exists:')]")
	WebElement DuplicateWarningMessage;
	@FindBy(how = How.NAME, using = "colour")
	WebElement ColourSelector;
	@FindBy(how = How.NAME, using = "categorydata")
	WebElement CreateCategoryField;

	// Interactive Methods
	
	// this method clicks the check box that selects all the categories listed
	public void ClickCheckBoxAll() {
		CheckBoxAll.sendKeys(Keys.SPACE);
	}

	// this method inputs all the categories and add them
	public void InputAddAllCategoryField() throws InterruptedException {

		for (String i : categories) {
			AddCategoryField.sendKeys(i);
			ButtonAddCategoryField.click();
			
			// since the first category input is followed by an error I had to create this condition
			if(categories.indexOf(i) == 0) {
				driver.navigate().back();
				//AddCategoryField.clear();
				//AddCategoryField.sendKeys(i);
				ButtonAddCategoryField.click();
			}
			
		}

	}

	// this method stores all the categories in an array list
	public void StoreAllCategories() {

		cat = driver.findElements(By.xpath("//div[@class='controls']/a")).size();

		for (int i = 2; i <= cat; i++) {

			String CategoryName = driver.findElement(By.xpath("//div[@class='controls']/a[" + i + "]/span")).getText();
			categories.add(CategoryName);

		}
	}
	
	// this method checks if all the list items are selected
	public void ValidateAllListItemsChecked() {
		
		for (int i=1; i<cat-1; i++) {
			boolean selected = driver.findElement(By.xpath("//*[@id='todos-content']/form/ul/li["+i+"]/input")).isSelected();
			if(selected == true) {
				System.out.println(categories.get(i) + " is selected!");
			}else {
				System.out.println(categories.get(i) + " is not selected...");
			}
			
		}
	}
	
	// this method clicks the remove button
	public void ClickRemoveButton() {
		
		RemoveButton.click();
		driver.navigate().back();
		RemoveButton.click();
	}
	
	// this method takes the first item in the array list and add it to the todo list
	public void AddOneListItemToList() {
		
		AddCategoryField.sendKeys(categories.get(0));
		ButtonAddCategoryField.click();
		driver.navigate().back();
		ButtonAddCategoryField.click();
	}
	
	// this method removes the first item on the item list
	public void SelectAndRemoveOneListItem() {
		
		driver.findElement(By.xpath("//*[@id='todos-content']/form/ul/li[1]/input")).click();
		RemoveButton.click();
		driver.navigate().back();
		RemoveButton.click();
	}
	
	// this method creates a new category
	public void CreateANewCategory(String CatName) {
		
		this.CatName = CatName;
		CreateCategoryField.sendKeys(CatName);
		Select dropdown = new Select(ColourSelector);
		dropdown.selectByVisibleText("Yellow");
		CreateCategoryButton.click();
		
	}
	
	// this method checks if the newly created category was displayed on the list
	public void ValidateNewCategoryIsListed() {
		
		StoreAllCategories();
		
		if(categories.contains(CatName)) {
			System.out.println("Newly add category " + CatName + "is displayed!");
		}else {
			System.out.println("No new catgory is displayed...");
		}
	}
	
	// this method checks if the attempt to create a duplicate category was not successful
		public void ValidateDuplicateCategoryIsNotListed() {
			
			int catsize = driver.findElements(By.xpath("//div[@class='controls']/a")).size();
			HashSet<String> Cats = new HashSet<String>();

			for (int i = 2; i <= catsize; i++) {

				String CategoryName = driver.findElement(By.xpath("//div[@class='controls']/a[" + i + "]/span")).getText();
				Cats.add(CategoryName);

			}
			
			if(Cats.add(CatName) == false) {
				System.out.println("Rule is successful the duplicate Category name was not allowed to be created!");
			}else {
				System.out.println("The rule failed and the new duplicate category was actually created...");
			}
		}
		
	// this message validates the duplicate message is displayed if a duplicate category name is attempted
	public void ValidateDuplicateWarningMessage() {
		
		if(DuplicateWarningMessage.isDisplayed()) {
			System.out.println("Success! The duplicate warning message was displayed!");
		}else {
			System.out.println("Faliure! The duplicate warning message failed to display!");
		}
	}

}
