package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AdminBasePage;
import pageUIs.admin.nopCommerce.ProductSearchPageUI;

public class ProductSearchPageObject extends AdminBasePage {

	WebDriver driver;
	public ProductSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void enterToProductNameTextbox(String productName) {
		waitForElementVisible(driver, ProductSearchPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, ProductSearchPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}
	public void clickToSearchButton() {
		waitForElementClickable(driver, ProductSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, ProductSearchPageUI.SEARCH_BUTTON);
		
	}
	public ProductDetailPageObject clickToEditButtonByProductName(String productName) {
		waitForElementClickable(driver, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		return PageGeneratorManager.getProductDetailPage(driver);
	}
	public boolean isSuccessMessageDisplay() {
		waitForElementVisible(driver, ProductSearchPageUI.SUCCESS_MESSAGE);
		return isElementDisplay(driver, ProductSearchPageUI.SUCCESS_MESSAGE);
	}

	public boolean isImageUpdated(String imageName, String productName) {
		imageName = imageName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, ProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME ,imageName ,productName);
		return isElementDisplay(driver, ProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME ,imageName ,productName);
	}
	
}
