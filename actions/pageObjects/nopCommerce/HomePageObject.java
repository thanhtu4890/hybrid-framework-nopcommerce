package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public boolean isHomePageSliderDisplayed() {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_SLIDER);
		return isElementDisplay(driver, HomePageUI.HOME_PAGE_SLIDER);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public SearchPageObject openSeachPage() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.SEARCH_PAGE_FOOTER);
		clickToElement(driver, HomePageUI.SEARCH_PAGE_FOOTER);
		return PageGeneratorManager.getSearchPage(driver);
	}

}
