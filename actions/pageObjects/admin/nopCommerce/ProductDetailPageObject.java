package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AdminBasePage;
import pageUIs.admin.nopCommerce.ProductDetailPageUI;

public class ProductDetailPageObject extends AdminBasePage {

	WebDriver driver;
	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clicktoExpandPanelByName(String panelName) {
		waitForElementClickable(driver, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		String toogleIconStatus = getElementAttribute(driver, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, "class" , panelName);
		if (toogleIconStatus.contains("fa-plus")) {
			clickToElement(driver, ProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		}
	}

	public boolean isPictureUploadSuccessByFileName(String filename) {
		filename = filename.split("\\.")[0];
		waitForElementVisible(driver, ProductDetailPageUI.PICTURE_IMAGE_ADD_BY_FILE_NAME,filename);
		return isElementDisplay(driver, ProductDetailPageUI.PICTURE_IMAGE_ADD_BY_FILE_NAME,filename);
	}
	public void enterToAltsTextbox(String productAlt) {
		waitForElementVisible(driver, ProductDetailPageUI.ALT_TEXTBOX_ADD_BY_FILE_NAME);
		sendkeyToElement(driver, ProductDetailPageUI.ALT_TEXTBOX_ADD_BY_FILE_NAME, productAlt);
	}
	public void enterToTitleTextbox(String productTitle) {
		waitForElementVisible(driver, ProductDetailPageUI.TITLE_TEXTBOX_ADD_BY_FILE_NAME);
		sendkeyToElement(driver, ProductDetailPageUI.TITLE_TEXTBOX_ADD_BY_FILE_NAME, productTitle);
		
	}
	public void enterToDisplayOrderTextbox(String productOrder) {
		waitForElementVisible(driver, ProductDetailPageUI.DISPLAY_ORDER_TEXTBOX_ADD_BY_FILE_NAME);
		clickToElement(driver, ProductDetailPageUI.DISPLAY_ORDER_TEXTBOX_ADD_BY_FILE_NAME);
	}
	public void clickToAddPictureButton() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver,ProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver,ProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
	}
	public boolean isImageDisplay(String imageName, String imageOrder, String imageAlt, String imageTitle) {
		imageName = imageName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver,ProductDetailPageUI.PICTURE_TABLE_BY_IMAGE_INFO, imageName, imageOrder, imageAlt, imageTitle);
		return isElementDisplay(driver,ProductDetailPageUI.PICTURE_TABLE_BY_IMAGE_INFO, imageName, imageOrder, imageAlt, imageTitle);
	}
	public ProductSearchPageObject clickToSaveButton() {
		waitForElementVisible(driver,ProductDetailPageUI.SAVE_BUTTON);
		clickToElement(driver,ProductDetailPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getProductSearchPage(driver);
	}
	public void clickToDeleteButtonByPictureName(String imageTitle) {
		waitForElementClickable(driver,ProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, imageTitle);
		clickToElement(driver,ProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, imageTitle);
		waitForAlertPresence(driver);
		acceptAlert(driver);
		
	}
	
	
}
