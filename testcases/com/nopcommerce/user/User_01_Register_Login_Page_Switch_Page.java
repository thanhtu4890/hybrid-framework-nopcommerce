package com.nopcommerce.user;


import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.OrderPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.SearchPageObject;

public class User_01_Register_Login_Page_Switch_Page {
	
	String ProjectPath = System.getProperty("user.dir");
	WebDriver driver;
	String emailAddress;
	String password;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	LoginPageObject loginPage;
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", ProjectPath + "\\browserDrivers\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  password = "123456";
	  emailAddress = "qatest" + generate_rand_numbe()+"@yopmail.com";
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
	  driver.manage().window().maximize();
  }
  
  @Test
  public void TC_01_Register_Success() {
	  
	  homePage = new HomePageObject(driver);
	  registerPage = homePage.clickToRegisterLink();
	  registerPage.clickGenderMaleRadioButton();
	  registerPage.enterFirstName("John");
	  registerPage.enterLastName("Snow");
	  registerPage.enterEmail(emailAddress);
	  registerPage.enterPassword(password);
	  registerPage.enterConfirmPassword(password);
	  registerPage.clickRegisterButton();
	  assertTrue(registerPage.isSuccessMessageDisplayed());
	  homePage = registerPage.clickLogoutLink();
	  assertTrue(homePage.isHomePageSliderDisplayed());
  }
  
  @Test
  public void TC_02_Login_To_System() {
	  loginPage = homePage.clickToLoginLink();
	  loginPage.enterEmail(emailAddress);
	  loginPage.enterPassword(password);
	  homePage = loginPage.clickLoginButton();
	  assertTrue(homePage.isHomePageSliderDisplayed());
  }
  
  @Test
  public void TC_03_Switch_Page_At_Footer() {
	  // home - search
	  searchPage = homePage.openSeachPage();
	  // search - my account
	  myAccountPage = searchPage.openMyAccount();
	  // my account - order
	  myAccountPage.openFooterpage(driver, "Orders");
	  orderPage = PageGeneratorManager.getOrderPage(driver);
  }
  
  @Test
  public void TC_04_Switch_Page_At_Footer_Dynamic_Locator() {
	  
	  // order - my account
	  orderPage.openFooterpage(driver, "My account");
	  myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
	  // my account - search
	  myAccountPage.openFooterpage(driver, "Search");
	  searchPage = PageGeneratorManager.getSearchPage(driver);
	  // search - order
	  searchPage.openFooterpage(driver, "Orders");
	  orderPage = PageGeneratorManager.getOrderPage(driver);
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
