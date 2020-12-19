package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.MainPage;
import util.BrowserFactory;

public class MainPageSteps {

	WebDriver driver;
	MainPage mainp;

	@Before
	public void Setup() {

		driver = BrowserFactory.BrowserInit();
		mainp = PageFactory.initElements(driver, MainPage.class);
	}

	@Given("^Set Sky Blue Background button exists$")
	public void set_SkyBlue_Background_button_exists() throws Throwable {

		mainp.VerifyBlueSkyBGButtonExists();
	}

	@When("^I click on the Sky Blue button$")
	public void i_click_on_the_button() throws Throwable {
		
		mainp.ClickBlueSkyBGButton();
	}

	@Then("^the background color will change to sky blue$")
	public void the_background_color_will_change_to_sky_blue() throws Throwable {

		mainp.VerifyBGColorTurnedSkyBlue();
	}
	
	@Given("^white Background button exists$")
	public void white_Background_button_exists() throws Throwable {
		
	    mainp.VerifyWhiteBGButtonExists();
	}

	@When("^I click on the white button$")
	public void i_click_on_the_white_button() throws Throwable {
		
	    mainp.ClickWhiteBGButton();
	}

	@Then("^the background color will change to white$")
	public void the_background_color_will_change_to_white() throws Throwable {
		
		mainp.VerifyBGColorTurnedWhite();
	}

	@After
	public void CloseBrowser() {

		BrowserFactory.tearDown();
	}
}
