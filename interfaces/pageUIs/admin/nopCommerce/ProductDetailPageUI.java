package pageUIs.admin.nopCommerce;

public class ProductDetailPageUI {
	
	public static final String TOOGLE_ICON_BY_CARD_NAME = "//div[@class='card-title' and contains(string(),'%s')]/following-sibling::div//i";
	
	public static final String PICTURE_IMAGE_ADD_BY_FILE_NAME = "//div[@class='upload-picture-block']//img[contains(@src,'%s')]";
	public static final String ALT_TEXTBOX_ADD_BY_FILE_NAME = "//input[@id='AddPictureModel_OverrideAltAttribute']";
	public static final String TITLE_TEXTBOX_ADD_BY_FILE_NAME = "//input[@id='AddPictureModel_OverrideTitleAttribute']";
	public static final String DISPLAY_ORDER_TEXTBOX_ADD_BY_FILE_NAME = "//*[@id='product-pictures']//input[@class='k-formatted-value k-input']/following-sibling::span[@class='k-select']//span[@class='k-link k-link-increase']";
	public static final String ADD_PRODUCT_PICTURE_BUTTON = "//button[@id='addProductPicture']";
	public static final String PICTURE_TABLE_BY_IMAGE_INFO = "//a[contains(@href,'%s')]/parent::td/following-sibling::td[contains(text(),'%s')]/following-sibling::td[contains(text(),'%s')]/following-sibling::td[contains(text(),'%s')]";
	public static final String SAVE_BUTTON = "//button[@name='save']";
	public static final String DELETE_BUTTON_BY_IMAGE_TITLE = "//td[contains(text(),'%s')]/following-sibling::td[contains(string(),'Delete')]";
	
	
}
