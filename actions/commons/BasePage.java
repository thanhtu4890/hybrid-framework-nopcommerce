package commons;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.admin.nopCommerce.ProductSearchPageObject;

import pageObjects.admin.nopCommerce.PageGeneratorManager;

import pageUIs.admin.nopCommerce.AdminBasePageUI;
import pageUIs.nopCommerce.BasePageUI;


public class BasePage {

	public static BasePage getBasePage() {
		return new BasePage();
	}
	
	public void openURL(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		ExplicitWait = new WebDriverWait(driver, 5);
		return ExplicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	public void sendKeyToAlert(WebDriver driver, String text) {
		 waitForAlertPresence(driver).sendKeys(text);
	}
	
	public void switchToWindowById(WebDriver driver, String windowID) {
		 Set<String> allWindowIDs = driver.getWindowHandles();
		 
		 for (String ID : allWindowIDs) {
			if (ID != windowID) {
				driver.switchTo().window(windowID);
				break;
			}
		}
		
	}
	
	public void switchToWindowByTitle(WebDriver driver, String tabTitle) {
		 Set<String> allWindowIDs = driver.getWindowHandles();
		 
		 for (String ID : allWindowIDs) {
			driver.switchTo().window(ID);
			if (driver.getTitle().equals(tabTitle)) {
				break;
			}		
		}
	}
	
	public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
		 Set<String> allWindowIDs = driver.getWindowHandles();
		 
		 for (String ID : allWindowIDs) {
			if (ID != parentID) {
				driver.switchTo().window(ID);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}
	
	public String getDymanicLocator(String locator, String...params) {
		return String.format(locator, (Object[])params);
	}
	
	public WebElement getWebElement(WebDriver driver, String locator) {
		 return driver.findElement(By.xpath(locator));
	}
	
	public List<WebElement> getWebElements(WebDriver driver, String locator) {
		 return driver.findElements(By.xpath(locator));
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		 getWebElement(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator , String... params) {
		 getWebElement(driver, getDymanicLocator(locator,params)).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String text) {
		WebElement element = getWebElement(driver, locator);
		element.clear(); 
		element.sendKeys(text);
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String text, String...params) {
		WebElement element = getWebElement(driver, getDymanicLocator(locator, params));
		element.sendKeys(text);
	}
	
	public void presskeyToElement(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locator),key).perform();
	}
	
	public void presskeyToElement(WebDriver driver, String locator, Keys key, String...params) {
		Actions action = new Actions(driver);
		locator = getDymanicLocator(locator, params);
		action.sendKeys(getWebElement(driver, locator),key).perform();
	}
	
	public String getTextFromElement(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}
	
	public String getTextFromElement(WebDriver driver, String locator, String...params) {
		return getWebElement(driver, getDymanicLocator(locator, params)).getText();
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String textItem) {
		Select select = new Select(getWebElement(driver, locator));
		select.selectByValue(textItem);
	}
	
	public String getSelectedItemInDefaultDropdown(WebDriver driver, String locator, String textItem) {
		Select select = new Select(getWebElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropDownMultiple(WebDriver driver, String locator, String textItem) {
		Select select = new Select(getWebElement(driver, locator));
		return select.isMultiple();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String locator, String childXpath , String textItem) {
		WebElement dropdown = getWebElement(driver, locator);
		jExecute = (JavascriptExecutor) driver;
		dropdown.click();
		sleepInSecond(1);
		
		WebDriverWait explicitWait = new WebDriverWait(driver, 5);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
		
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(textItem)) {
				jExecute.executeScript("arguments[0].scrollIntoView(true);", textItem);
				sleepInSecond(1);
				item.click();
				break;
			}	
		}
	}
	
	public String getElementAttribute(WebDriver driver, String locator, String attribute) {
		return getWebElement(driver, locator).getAttribute(attribute);
	}
	
	public String getElementAttribute(WebDriver driver, String locator, String attribute , String... params) {
		return getWebElement(driver, getDymanicLocator(locator, params)).getAttribute(attribute);
	}
	
	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}
	
	public String getElementCSSValue(WebDriver driver, String locator, String propertyName) {
		return getWebElement(driver, locator).getCssValue(propertyName);
	}
	
	public int getElementSize(WebDriver driver, String locator) {
		return getWebElements(driver, locator).size();
	}
	
	public int getElementSize(WebDriver driver, String locator, String...params) {
		locator = getDymanicLocator(locator, params);
		return getWebElements(driver, locator).size();
	}
	
	public void checkDefaultcheckbox(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckDefaultcheckbox(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplay(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementDisplay(WebDriver driver, String locator , String...params) {
		locator = getDymanicLocator(locator, params);
		return getWebElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementEnable(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}
	
	public void switchToFrameIframe(WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver, locator));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locator)).perform();		
	}
	
	public void scrollToBottomPage(WebDriver driver) {
		jExecute = (JavascriptExecutor) driver;
		jExecute.executeScript("0, document.body.scrollHeight");
	}
	
	public void clickToElementByJS(WebDriver driver, String locator) {
		jExecute = (JavascriptExecutor) driver;
		jExecute.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}
	
	public String getElementValidationMessage(WebDriver driver, String locator) {
		jExecute = (JavascriptExecutor) driver;
		return (String) jExecute.executeScript("return arguments[0].validationMessage", getWebElement(driver, locator));
	}
	
	public boolean Waitpageloadsuccess(WebDriver driver) {
		ExplicitWait = new WebDriverWait(driver, longTimeout);
		jExecute = (JavascriptExecutor)driver;
		
		ExpectedCondition<Boolean> jQueryload = new ExpectedCondition<Boolean>() {
			
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean)jExecute.executeScript("return jQuery.active === 0 && window.jQuery != null");
				}
		};
		return ExplicitWait.until(jQueryload);
	}
	
	public void waitForElementVisible(WebDriver driver , String locator) {
		ExplicitWait = new WebDriverWait(driver, longTimeout);
		ExplicitWait.until(ExpectedConditions.visibilityOf(getWebElement(driver, locator)));
	}
	
	public void waitForElementVisible(WebDriver driver , String locator, String... params) {
		locator = getDymanicLocator(locator, params);
		ExplicitWait = new WebDriverWait(driver, longTimeout);
		ExplicitWait.until(ExpectedConditions.visibilityOf(getWebElement(driver, locator)));
	}
	
	public void waitForAllElementVisible(WebDriver driver , String locator) {
		ExplicitWait = new WebDriverWait(driver, longTimeout);
		ExplicitWait.until(ExpectedConditions.visibilityOfAllElements(getWebElement(driver, locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver , String locator) {
		ExplicitWait = new WebDriverWait(driver, longTimeout);
		ExplicitWait.until(ExpectedConditions.invisibilityOf(getWebElement(driver, locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver , String locator, String params) {
		locator = getDymanicLocator(locator, params);
		ExplicitWait = new WebDriverWait(driver, longTimeout);
		ExplicitWait.until(ExpectedConditions.invisibilityOf(getWebElement(driver, locator)));
	}
	
	public void waitForAllElementInvisible(WebDriver driver , String locator) {
		ExplicitWait = new WebDriverWait(driver, longTimeout);
		ExplicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElements(driver, locator)));
	}
	
	public void waitForElementClickable(WebDriver driver , String locator) {
		ExplicitWait = new WebDriverWait(driver, longTimeout);
		ExplicitWait.until(ExpectedConditions.elementToBeClickable(getWebElement(driver, locator)));
	}
	
	public void waitForElementClickable(WebDriver driver , String locator, String...params) {
		
		locator = getDymanicLocator(locator, params);
		ExplicitWait = new WebDriverWait(driver, longTimeout);
		ExplicitWait.until(ExpectedConditions.elementToBeClickable(getWebElement(driver, locator)));
	}
	
	
	public void sleepInSecond(int second) {
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public ProductSearchPageObject openSubMenuPageByName(WebDriver driver, String menuPageName, String subMenuPageName) {
		waitForElementClickable(driver, AdminBasePageUI.MENU_LINK_BY_NAME, menuPageName);
		clickToElement(driver, AdminBasePageUI.MENU_LINK_BY_NAME, menuPageName);
		waitForElementClickable(driver, AdminBasePageUI.SUB_MENU_LINK_BY_NAME, subMenuPageName);
		clickToElement(driver, AdminBasePageUI.SUB_MENU_LINK_BY_NAME, subMenuPageName);
		return PageGeneratorManager.getProductSearchPage(driver);
	}
	
	public void uploadFilesByCardName(WebDriver driver,String cardName, String...fileNames) {
		String filePath = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator ;
		String fullFileName = "";
		for (String fileName : fileNames) {
			fullFileName = fullFileName + filePath + fileName + "\n";
		}
		fullFileName.trim();
		
		sendkeyToElement(driver, AdminBasePageUI.UPLOAD_FILE_BY_CARD_NAME, fullFileName, cardName);
	}

	public void openFooterpage(WebDriver driver, String footerMenu) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_FAGE_FOOTER,footerMenu);
		clickToElement(driver, BasePageUI.DYNAMIC_FAGE_FOOTER,footerMenu);
	}
	
	
	private long longTimeout = 30;
	WebDriverWait ExplicitWait;
	JavascriptExecutor jExecute;
	
}
