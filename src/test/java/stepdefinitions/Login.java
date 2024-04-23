package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {

	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	private DriverFactory driverFactory;

	@Given("user should navigates to login page")
	public void user_should_navigates_to_login_page() {

		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();

	}

	@When("^user enter valid email address (.+) into email field$")
	public void user_enter_valid_email_address_into_email_field(String validemailText) {
		loginPage.enterEmailAddress(validemailText);

	}

	@When("^user enter valid password (.+) into password field$")
	public void user_enter_valid_password_into_password_field(String validpassword) {
		loginPage.enterPassword(validpassword);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		accountPage = loginPage.clickOnLogin();
	}

	@Then("user should successfully logged in")
	public void user_should_successfully_logged_in() {
		Assert.assertTrue(accountPage.displayStatusOfMyAcoount());
	}

	@When("user enter invalid email address into email field")
	public void user_enter_invalid_email_address_into_email_field() {
		commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
	}

	@When("user enter invalid password {string} into password field")
	public void user_enter_invalid_password_into_password_field(String invalidpassword) {
		loginPage.enterPassword(invalidpassword);
	}

	@Then("user should get warning message as no match found")
	public void user_should_get_warning_message_as_no_match_found() {
		Assert.assertTrue(
				loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("user dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		loginPage.enterEmailAddress("");
	}

	@When("user dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		loginPage.enterPassword("");
	}

}
