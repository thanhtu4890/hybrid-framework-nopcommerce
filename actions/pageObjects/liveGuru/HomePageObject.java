package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.HomePageUI;

public class HomePageObject extends BasePage {

	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageObject clickToFooterMyAccountLink() {
		getBasePage().clickToElement(driver, HomePageUI.FOOTER_LINK);
		return new LoginPageObject(driver);
	};
	
	
}
