package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


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
	
	public WebElement getWebElement(WebDriver driver, String xpathLocator) {
		 return driver.findElement(By.xpath(xpathLocator));
	}
	
	public List<WebElement> getWebElements(WebDriver driver, String xpathLocator) {
		 return driver.findElements(By.xpath(xpathLocator));
	}
	
	public void clickToElement(WebDriver driver, String xpathLocator) {
		 getWebElement(driver, xpathLocator).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String xpathLocator, String text) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear(); 
		element.sendKeys(text);
	}
	
	public String getTextFromElement(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(textItem);
	}
	
	public String getSelectedItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropDownMultiple(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String xpathLocator, String childXpath , String textItem) {
		WebElement dropdown = getWebElement(driver, xpathLocator);
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
	
	public String getElementAttribute(WebDriver driver, String xpathLocator, String attribute) {
		return getWebElement(driver, xpathLocator).getAttribute(attribute);
	}
	
	public String getElementText(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}
	
	public String getElementCSSValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	}
	
	public int getElementSide(WebDriver driver, String xpathLocator, String propertyName) {
		return getWebElements(driver, xpathLocator).size();
	}
	
	public void checkDefaultcheckbox(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckDefaultcheckbox(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplay(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}
	
	public boolean isElementEnable(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}
	
	public void switchToFrameIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();		
	}
	
	public void scrollToBottomPage(WebDriver driver) {
		jExecute = (JavascriptExecutor) driver;
		jExecute.executeScript("0, document.body.scrollHeight");
	}
	
	public void clickToElementByJS(WebDriver driver, String xpathLocator) {
		jExecute = (JavascriptExecutor) driver;
		jExecute.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	}
	
	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		jExecute = (JavascriptExecutor) driver;
		return (String) jExecute.executeScript("return arguments[0].validationMessage", getWebElement(driver, xpathLocator));
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
	
	public void waitForElementVisible(WebDriver driver , String xpathLocator) {
		ExplicitWait = new WebDriverWait(driver, longTimeout);
		ExplicitWait.until(ExpectedConditions.visibilityOf(getWebElement(driver, xpathLocator)));
	}
	
	public void waitForAllElementVisible(WebDriver driver , String xpathLocator) {
		ExplicitWait = new WebDriverWait(driver, longTimeout);
		ExplicitWait.until(ExpectedConditions.visibilityOfAllElements(getWebElement(driver, xpathLocator)));
	}
	
	public void waitForElementInvisible(WebDriver driver , String xpathLocator) {
		ExplicitWait = new WebDriverWait(driver, longTimeout);
		ExplicitWait.until(ExpectedConditions.invisibilityOf(getWebElement(driver, xpathLocator)));
	}
	
	public void waitForAllElementInvisible(WebDriver driver , String xpathLocator) {
		ExplicitWait = new WebDriverWait(driver, longTimeout);
		ExplicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElements(driver, xpathLocator)));
	}
	
	public void waitForElementClickable(WebDriver driver , String xpathLocator) {
		ExplicitWait = new WebDriverWait(driver, longTimeout);
		ExplicitWait.until(ExpectedConditions.elementToBeClickable(getWebElement(driver, xpathLocator)));
	}
	
	public void sleepInSecond(int second) {
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private long longTimeout = 30;
	WebDriverWait ExplicitWait;
	JavascriptExecutor jExecute;
	
}
