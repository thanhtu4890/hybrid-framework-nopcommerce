package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.SearchPageUI;

public class SearchPageObject extends BasePage {
	WebDriver driver;
	
	public SearchPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public MyAccountPageObject openMyAccount() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, SearchPageUI.MY_ACCOUNT_FOOTER);
		clickToElement(driver, SearchPageUI.MY_ACCOUNT_FOOTER);
		return PageGeneratorManager.getMyAccountPage(driver);
	}
	
	
}
