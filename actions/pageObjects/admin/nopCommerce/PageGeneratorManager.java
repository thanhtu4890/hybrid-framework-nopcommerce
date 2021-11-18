package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	private static DashboardPageObject dashboardPage;
	private static LoginPageObject loginPage;
	private static ProductDetailPageObject productdetailPage;
	private static ProductSearchPageObject productsearchPage;
	
	
	private PageGeneratorManager() {
		
	}
	
	public static DashboardPageObject getDashBoardPage(WebDriver driver) {
		
		if (dashboardPage == null) {
			return new DashboardPageObject(driver);
		}
		return dashboardPage;
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		
		if (loginPage == null) {
			return new LoginPageObject(driver);
		}
		return loginPage;
	}
	public static ProductDetailPageObject getProductDetailPage(WebDriver driver) {
	
	if (productdetailPage == null) {
		return new ProductDetailPageObject(driver);
	}
	return productdetailPage;
}
	public static ProductSearchPageObject getProductSearchPage(WebDriver driver) {
	
	if (productsearchPage == null) {
		return new ProductSearchPageObject(driver);
	}
	return productsearchPage;
}
}
