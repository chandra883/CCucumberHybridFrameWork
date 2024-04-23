package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;

	@FindBy(name = "agree")
	private WebElement privacyPolicyOption;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueBtn;

	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement yesForNewsletter;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement emailRegisteredWarningMessage;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement warningMessageFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement warningMessagelastName;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement warningMessageEmail;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement warningMessageTelephone;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement warningMessagePassword;

	public void enterFirstName(String firstName) {
		// firstNameField.sendKeys(firstName);
		elementUtils.typeTextIntoElement(firstNameField, firstName, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
	}

	public void enterLastName(String lastName) {
		// lastNameField.sendKeys(lastName);
		elementUtils.typeTextIntoElement(lastNameField, lastName, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
	}

	public void enterEmailAddress(String emialAddress) {
		// emailField.sendKeys(emialAddress);
		elementUtils.typeTextIntoElement(emailField, emialAddress, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
	}

	public void enterTelephone(String telephone) {
		// telephoneField.sendKeys(telephone);
		elementUtils.typeTextIntoElement(telephoneField, telephone, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
	}

	public void enterPassword(String password) {
		// passwordField.sendKeys(password);
		elementUtils.typeTextIntoElement(passwordField, password, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
	}

	public void enterconfirmPassword(String confirmpassword) {
		// confirmPasswordField.sendKeys(confirmpassword);
		elementUtils.typeTextIntoElement(confirmPasswordField, confirmpassword, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
	}

	public void selectPrivacypolicy() {
		// privacyPolicyOption.click();
		elementUtils.clickOnElement(privacyPolicyOption, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
	}

	public AccountSuccessPage clickOnContinueButton() {
		// continueBtn.click();
		elementUtils.clickOnElement(continueBtn, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
		return new AccountSuccessPage(driver);
	}

	public void selectYesForNewsLetter() {
		// yesForNewsletter.click();
		elementUtils.clickOnElement(yesForNewsletter, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
	}

	public String getEmailRegisteredWarningMessage() {
		// return emailRegisteredWarningMessage.getText();
		return elementUtils.getTextFromElement(emailRegisteredWarningMessage, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
	}

	public String getFirstNameWarningMessage() {
		// return warningMessageFirstName.getText();
		return elementUtils.getTextFromElement(warningMessageFirstName, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
	}

	public String getLastNameWarningMessage() {
		// return warningMessagelastName.getText();
		return elementUtils.getTextFromElement(warningMessagelastName, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
	}

	public String getEmailWarningMessage() {
		// return warningMessageEmail.getText();
		return elementUtils.getTextFromElement(warningMessageEmail, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
	}

	public String getTelephoneWarningMessage() {
		// return warningMessageTelephone.getText();
		return elementUtils.getTextFromElement(warningMessageTelephone, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
	}

	public String getPasswordWarningMessage() {
		// return warningMessagePassword.getText();
		return elementUtils.getTextFromElement(warningMessagePassword, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
	}
}
