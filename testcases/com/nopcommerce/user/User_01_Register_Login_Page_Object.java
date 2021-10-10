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
import pageObjects.nopCommerce.RegisterPageObject;

public class User_01_Register_Login_Page_Object {
	
	String ProjectPath = System.getProperty("user.dir");
	WebDriver driver;
	String emailAddress;
	String password;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	LoginPageObject loginPage;
  
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
	// Step 1: Click Register
	  homePage.clickToRegisterLink();
	  registerPage = new RegisterPageObject(driver);
	// Step 2: Select Gender
	  registerPage.clickGenderMaleRadioButton();
	// Step 3: Input Firstname
	  registerPage.enterFirstName("John");
	// Step 4: Input Lastname
	  registerPage.enterLastName("Snow");
	// Step 5: Input Email
	  registerPage.enterEmail(emailAddress);
	// Step 6: Input Password
	  registerPage.enterPassword(password);
	// Step 7: Input Confirm Password
	  registerPage.enterConfirmPassword(password);
	// Step 8: Click Register button
	  registerPage.clickRegisterButton();
	// Step 9: Verify success register mess displays
	  assertTrue(registerPage.isSuccessMessageDisplayed());
	  
	// Step 10: Click logout button
	  registerPage.clickLogoutLink();
	  homePage = new HomePageObject(driver);
	  // Step 11: Verify home page slider display
	  assertTrue(homePage.isHomePageSliderDisplayed());
  }
  
  @Test
  public void TC_02_Login_To_System() {
	  //Step1: Click Login link
	  homePage.clickToLoginLink();
	  loginPage = new LoginPageObject(driver);
	  
	//Step2: Input Email
	  loginPage.enterEmail(emailAddress);
	//Step3: Input Password
	  loginPage.enterPassword(password);
	//Step4: Click Login button
	  loginPage.clickLoginButton();
	  homePage = new HomePageObject(driver);
	
	 //Step5: Verify HomePage Logo Display
	  assertTrue(homePage.isHomePageSliderDisplayed());
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
