package com.liveguru.user;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashBoardPageObject;

public class User_01_Register_Login_Page_Object {
	
	String ProjectPath = System.getProperty("user.dir");
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashBoardPageObject myDashBoardPage;
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", ProjectPath + "\\browserDrivers\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.manage().window().maximize();
  }
  
  @Test
  public void TC_01_Login_Empty_Email_Password() {
	  driver.get("http://live.techpanda.org/index.php/");
	  homePage = new HomePageObject(driver);
	  homePage.clickToFooterMyAccountLink();
	  loginPage = new LoginPageObject(driver);
	  loginPage.enterEmail("");
	  loginPage.enterPassword("");
	  loginPage.clickLoginButton();
	  assertEquals(loginPage.getEmailValidationMessage(), "");
  }
  
  @Test
  public void TC_02_Login_Invalid_Email_Format() {
	  loginPage.refreshPage(driver);
	  loginPage.enterEmail("12312.@wa.com");
	  loginPage.enterPassword("123123");
	  loginPage.clickLoginButton();
	  assertEquals(loginPage.getEmailValidationMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
  }
  
  @Test(description = "password < 6 chars")
  public void TC_03_Login_Invalid_Password_Format() {
	  loginPage.refreshPage(driver);
	  loginPage.enterEmail("12312.@wa.com");
	  loginPage.enterPassword("123123");
	  loginPage.clickLoginButton();
	  assertEquals(loginPage.getPasswordValidationMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
  }
  
  @Test(description = "email not exist")
  public void TC_04_Login_Incorrect_Email() {
	  loginPage.refreshPage(driver);
	  loginPage.enterEmail("12312.@wa.com");
	  loginPage.enterPassword("123123");
	  loginPage.clickLoginButton();
	  assertEquals(loginPage.getLoginValidationMessage(), "Invalid login or password.");
  }
  
  @Test(description = "email not exist")
  public void TC_05_Login_Incorrect_Password() {
	  loginPage.refreshPage(driver);
	  loginPage.enterEmail("qa@yopmail.com");
	  loginPage.enterPassword("111111");
	  loginPage.clickLoginButton();
	  assertEquals(loginPage.getLoginValidationMessage(), "Invalid login or password.");
  }
  
  @Test
  public void TC_06_Valid_Email_Password() {
	  loginPage.refreshPage(driver);
	  loginPage.enterEmail("qa@yopmail.com");
	  loginPage.enterPassword("123123");
	  loginPage.clickLoginButton();
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
