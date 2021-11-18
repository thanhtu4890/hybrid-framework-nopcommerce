package com.nopcommerce.admin;


import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.admin.nopCommerce.DashboardPageObject;
import pageObjects.admin.nopCommerce.LoginPageObject;
import pageObjects.admin.nopCommerce.PageGeneratorManager;
import pageObjects.admin.nopCommerce.ProductDetailPageObject;
import pageObjects.admin.nopCommerce.ProductSearchPageObject;


public class Level_10_Admin_Upload_File extends BaseTest {
	
	
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	ProductSearchPageObject productSearchPage;
	ProductDetailPageObject productDetailsPage;
	String productAvatarImage = "rocklee.jpg";
	String productName = "Nikon D5500 DSLR";
	
	
  @Parameters({"browser","appUrl"})
  
  @BeforeClass
  public void beforeClass(String browsername, String appURL) {
	  driver = getBrowserDriver(browsername, appURL);
	 
	  
	  loginPage = PageGeneratorManager.getLoginPage(driver);
	  
	  loginPage.enterToEmailTextBox("admin@yourstore.com");
	  loginPage.enterToPasswordTextBox("admin");
	  dashboardPage = loginPage.clickToLoginButton();
	  productSearchPage = dashboardPage.openSubMenuPageByName(driver ,"Catalog","Products");
	  productSearchPage.enterToProductNameTextbox(productName);
	  productSearchPage.clickToSearchButton();
	  productDetailsPage = productSearchPage.clickToEditButtonByProductName(productName);
  }
  
  @Test
  public void Admin_01_Upload_File() {
	  
	  productDetailsPage.clicktoExpandPanelByName("Pictures");
	  productDetailsPage.uploadFilesByCardName(driver, "pictures",productAvatarImage );
	  assertTrue(productDetailsPage.isPictureUploadSuccessByFileName("rocklee"));
	  
	  productDetailsPage.enterToAltsTextbox("Nikon alt");
	  productDetailsPage.enterToTitleTextbox("Nikon title");
	  productDetailsPage.enterToDisplayOrderTextbox("1"); 
	  productDetailsPage.clickToAddPictureButton();
	  assertTrue(productDetailsPage.isImageDisplay(productName,"1","Nikon alt","Nikon title"));
	  
	  productSearchPage = productDetailsPage.clickToSaveButton();
	  assertTrue(productSearchPage.isSuccessMessageDisplay());
	  productSearchPage.enterToProductNameTextbox(productName);
	  productSearchPage.clickToSearchButton();
	  assertTrue(productSearchPage.isImageUpdated(productName,"Nikon D5500 DSLR"));
	  productDetailsPage = productSearchPage.clickToEditButtonByProductName("Nikon D5500 DSLR");
	  productDetailsPage.clicktoExpandPanelByName("Pictures");
	  productDetailsPage.sleepInSecond(2);
	  productDetailsPage.clickToDeleteButtonByPictureName("Nikon title");
	  
	  assertTrue(productDetailsPage.isMessageDisplayInEmptyTable(driver,"productpictures","No data available in table"));
	  productSearchPage = productDetailsPage.clickToSaveButton();
	  productSearchPage.enterToProductNameTextbox(productName);
	  productSearchPage.clickToSearchButton();
	  assertTrue(productSearchPage.isImageUpdated("default-image","Nikon D5500 DSLR"));
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

  public int generate_rand_numbe() {
	  Random ran = new Random();  
	  return ran.nextInt(9999);
  }
  
}
