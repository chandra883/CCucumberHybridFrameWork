package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchResultPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(partialLinkText = "HP LP3065")
	private WebElement validHPPoduct;

	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement noMatchFoundMessage;

	public boolean diaplayStatusOfValidProduvt() {
		// return validHPPoduct.isDisplayed();
		return elementUtils.displayStatusOfElement(validHPPoduct, CommonUtils.EXPLICT_WAIT_BASIC_TIME);
	}

	public String getNoMatchFoundMessage() {
		// return noMatchFoundMessage.getText();
		return elementUtils.getTextFromElement(noMatchFoundMessage, CommonUtils.EXPLICT_WAIT_BASIC_TIME);

	}

}
