package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterEmail(String email) {
		getBasePage().waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		getBasePage().sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void enterPassword(String password) {
		getBasePage().waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		getBasePage().sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickLoginButton() {
		getBasePage().waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		getBasePage().clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public String getEmailValidationMessage() {
		return getBasePage().getTextFromElement(driver, LoginPageUI.EMAIL_EMPTY_MESSAGE);
	}

	public String getPasswordValidationMessage() {
		return getBasePage().getTextFromElement(driver, LoginPageUI.PASSWORD_EMPTY_MESSAGE);
	}

	public String getLoginValidationMessage() {
		// TODO Auto-generated method stub
		return getBasePage().getTextFromElement(driver, LoginPageUI.LOGIN_VALIDATION_MESSAGE);
	};
	
	
}
