package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AdminBasePage;

public class DashboardPageObject extends AdminBasePage {

	WebDriver driver;
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
