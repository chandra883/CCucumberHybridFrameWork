package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {

	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;
	private DriverFactory driverFactory;

	@Given("user navigates to resgister account page")
	public void user_navigates_to_resgister_account_page() {
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.selectRegisterOption();

	}

	@When("user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		commonUtils = new CommonUtils();

		registerPage.enterFirstName(dataMap.get("firstname"));
		registerPage.enterLastName(dataMap.get("lastname"));
		registerPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterconfirmPassword(dataMap.get("password"));

	}

	@When("user enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerPage.enterFirstName(dataMap.get("firstname"));
		registerPage.enterLastName(dataMap.get("lastname"));
		registerPage.enterEmailAddress(dataMap.get("email"));
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterconfirmPassword(dataMap.get("password"));

	}

	@When("user selects priacy policy")
	public void user_selects_priacy_policy() {
		registerPage.selectPrivacypolicy();
	}

	@When("user clicks on continue butoon")
	public void user_clicks_on_continue_butoon() {
		accountSuccessPage = registerPage.clickOnContinueButton();
	}

	@Then("user account should be created successfully")
	public void user_account_should_be_created_successfully() {
		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getAccountSuccessMessage());
	}

	@When("user selects yes for privacy policy")
	public void user_selects_yes_for_privacy_policy() {
		registerPage.selectYesForNewsLetter();
	}

	@Then("user should  get warning message as  email registered already")
	public void user_should_get_warning_message_as_email_registered_already() {
		registerPage.getEmailRegisteredWarningMessage().contains("Warning: E-Mail Address is already registered!");
	}

	@When("user does not enter any details into fields")
	public void user_does_not_enter_any_details_into_fields() {
		// intentionally kept blank
	}

	@When("clicks on continue button")
	public void clicks_on_continue_button() {
		accountSuccessPage = registerPage.clickOnContinueButton();
	}

	@Then("user should get warning message of all mandatory fields")
	public void user_should_get_warning_message_of_all_mandatory_fields() {

		Assert.assertEquals("First Name must be between 1 and 32 characters!",
				registerPage.getFirstNameWarningMessage());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getLastNameWarningMessage());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailWarningMessage());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",
				registerPage.getTelephoneWarningMessage());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarningMessage());

	}

}
