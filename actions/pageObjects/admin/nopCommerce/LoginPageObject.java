package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AdminBasePage;
import pageUIs.admin.nopCommerce.LoginPageUI;

public class LoginPageObject extends AdminBasePage {

	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void enterToEmailTextBox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}
	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	public DashboardPageObject clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashBoardPage(driver);
	}
	
}
