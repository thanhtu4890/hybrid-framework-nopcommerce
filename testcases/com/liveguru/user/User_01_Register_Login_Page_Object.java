package com.liveguru.user;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashBoardPageObject;

public class User_01_Register_Login_Page_Object extends BaseTest {
	
	
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashBoardPageObject myDashBoardPage;
	
  @Parameters({"browser","appUrl"})
  
  @BeforeClass
  public void beforeClass(String browsername, String appURL) {
	  driver = getBrowserDriver(browsername, appURL);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }
  
  @Test
  public void TC_01_Login_Empty_Email_Password() {
	  
	  homePage = new HomePageObject(driver);
	  loginPage = homePage.clickToFooterMyAccountLink();
	  loginPage.loginToSystem("", "");
	  assertEquals(loginPage.getEmailEmptyMessage(), "This is a required field.");
  }
  
  @Test
  public void TC_02_Login_Invalid_Email_Format() {
	  loginPage.refreshPage(driver);
	  loginPage.loginToSystem("12312.@wa.com", "123123");
	  assertEquals(loginPage.getEmailInvalidFormatMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
  }
  
  @Test(description = "password < 6 chars")
  public void TC_03_Login_Invalid_Password_Format() {
	  loginPage.refreshPage(driver);
	  loginPage.loginToSystem("qatest@yopmail.com", "12312");
	  assertEquals(loginPage.getPasswordInvalidFormatMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
  }
  
  @Test(description = "email not exist")
  public void TC_04_Login_Incorrect_Email() {
	  loginPage.refreshPage(driver);
	  loginPage.loginToSystem("qatest@yopmail.com", "123125");
	  assertEquals(loginPage.getLoginValidationMessage(), "Invalid login or password.");
  }
  
  @Test(description = "email not exist")
  public void TC_05_Login_Incorrect_Password() {
	  loginPage.refreshPage(driver);
	  loginPage.loginToSystem("qa@yopmail.com", "111111");
	  assertEquals(loginPage.getLoginValidationMessage(), "Invalid login or password.");
  }
  
  @Test
  public void TC_06_Valid_Email_Password() {
	  loginPage.refreshPage(driver);
	  loginPage.loginToSystem("qa@yopmail.com", "123123");
	  MyDashBoardPageObject myDashBoardPage = new MyDashBoardPageObject(driver);
	  assertTrue(myDashBoardPage.isMyDashBoardHeaderDisplay());
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
