package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;

public class Search {
	WebDriver driver;
	private HomePage homePage;
	private SearchResultPage resultPage;
	private DriverFactory driverFactory;

	@Given("user navigates to home page")
	public void user_navigates_to_home_page() {
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
	}

	@When("user enters valid product {string} into search field")
	public void user_enters_valid_product_into_search_field(String validProduct) {
		homePage = new HomePage(driver);
		homePage.enterProductInSearchBox(validProduct);

	}

	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
		resultPage = homePage.clickOnSearchButton();
	}

	@Then("user should get valid product details")
	public void user_should_get_valid_product_details() {
		Assert.assertTrue(resultPage.diaplayStatusOfValidProduvt());

	}

	@When("user enters invalid product {string} into search field")
	public void user_enters_invalid_product_into_search_field(String invalidProduct) {
		homePage = new HomePage(driver);
		homePage.enterProductInSearchBox(invalidProduct);

	}

	@Then("user should get a message about no product matched")
	public void user_should_get_a_message_about_no_product_matched() {
		Assert.assertEquals("There is no product that matches the search criteria.",
				resultPage.getNoMatchFoundMessage());
		//Assert.fail(); //Intentionally failing script 

	}

	@When("user does not enters any product into search field")
	public void user_does_not_enters_any_product_into_search_field() {
		// intentionally kept blank
		homePage = new HomePage(driver);
	}

}
