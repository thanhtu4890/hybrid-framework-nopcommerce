package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage{

	private WebDriver driver;
	
	public LoginPageObject (WebDriver driver){
		this.driver = driver;
	}
	
	public void enterEmail(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void enterPassword(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public HomePageObject clickLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}


}
