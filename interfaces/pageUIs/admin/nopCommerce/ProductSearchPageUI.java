package pageUIs.admin.nopCommerce;

public class ProductSearchPageUI {

	public static final String PRODUCT_NAME_TEXTBOX = "//input[@id='SearchProductName']";
	public static final String SEARCH_BUTTON = "//button[@id='search-products']";
	public static final String EDIT_BUTTON_BY_PRODUCT_NAME = "//td[text()='%s']/following-sibling::td//a[text()='Edit']";
	public static final String SUCCESS_MESSAGE = "//div[@class='alert alert-success alert-dismissable']";
	public static final String PRODUCT_IMAGE_BY_PRODUCT_NAME = "//img[contains(@src,'%s')]/parent::td/following-sibling::td[contains(text(),'%s')]";
	
}
