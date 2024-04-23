package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Login")
	private WebElement LoginOption;

	@FindBy(linkText = "Register")
	private WebElement RegisterOption;

	@FindBy(name = "search")
	private WebElement searchBoxField;

	@FindBy(xpath = "//button[contains(@class,'btn-default')]")
	private WebElement searchButton;

	public void clickOnMyAccount() {
		// myAccountDropMenu.click();
		elementUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICT_WAIT_BASIC_TIME);

	}

	public LoginPage selectLoginOption() {
		elementUtils.clickOnElement(LoginOption, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
		// LoginOption.click();
		return new LoginPage(driver);
	}

	public RegisterPage selectRegisterOption() {
		elementUtils.clickOnElement(RegisterOption, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
		// RegisterOption.click();
		return new RegisterPage(driver);
	}

	public void enterProductInSearchBox(String validProdcut) {
		elementUtils.typeTextIntoElement(searchBoxField, validProdcut, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
		// searchBoxField.sendKeys(validProdcut);
	}

	public SearchResultPage clickOnSearchButton() {
		elementUtils.clickOnElement(searchButton, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
		// searchButton.click();
		return new SearchResultPage(driver);
	}
}
