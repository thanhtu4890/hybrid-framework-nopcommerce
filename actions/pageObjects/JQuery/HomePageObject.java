package pageObjects.JQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {

	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGING_BY_NUMBER,pageNumber);
		clickToElement(driver, HomePageUI.PAGING_BY_NUMBER,pageNumber);
	}

	public boolean isPageNumberActive(String pageNumber) {
		 waitForElementVisible(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
		 return isElementDisplay(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
	}

	public void inputToHeaderTextboxByName(String headerName, String text) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, headerName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, text, headerName);
		presskeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, Keys.ENTER, headerName);
	}

	public void clickToIconByCountryName(String countryName, String iconAction) {
		waitForElementVisible(driver, HomePageUI.ICON_BY_COUNTRYNAME, countryName, iconAction);
		clickToElement(driver, HomePageUI.ICON_BY_COUNTRYNAME, countryName, iconAction);
	}

	public boolean isRowValueDisplay(String females, String country) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE, females,country);
		return isElementDisplay(driver, HomePageUI.ROW_VALUE, females,country);
	}

	public void inputToTextBoxByRowNumber(String headname, String rowindex, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.HEADER_INDEX, headname) + 1;
		
		System.out.println(getWebElement(driver, getDymanicLocator(HomePageUI.HEADER_INDEX, headname)));
		
		System.out.println(getWebElement(driver, getDymanicLocator(HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX,rowindex, String.valueOf(columnIndex))));
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX, rowindex, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX,value, rowindex, String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String row, String iconAction) {
		waitForElementClickable(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, row ,iconAction);
		clickToElement(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, row ,iconAction);
	}

	
}
