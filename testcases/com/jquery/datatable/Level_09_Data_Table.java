package com.jquery.datatable;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.JQuery.HomePageObject;
import pageObjects.JQuery.PageGeneratorManager;

public class Level_09_Data_Table extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	
	
	@Parameters({ "browser","appUrl" })
	
	@BeforeClass
	 public void beforeClass(String browsername, String appURL) {
		  driver = getBrowserDriver(browsername, appURL);
		  homePage=PageGeneratorManager.getHomePage(driver);	
	  }
	
	
	public void TC_01_Paging() {
		
		homePage.openPageByNumber("15");
		assertTrue(homePage.isPageNumberActive("15"));
		
		homePage.openPageByNumber("5");
		assertTrue(homePage.isPageNumberActive("5"));
		
		homePage.openPageByNumber("20");
		assertTrue(homePage.isPageNumberActive("20"));
	}
	

	public void TC_02_Input() {
		// Input texbox
		homePage.inputToHeaderTextboxByName("Females" , "434000");
		homePage.inputToHeaderTextboxByName("Males" , "451000");
		homePage.inputToHeaderTextboxByName("Country" , "Afghanistan");
	}
	

	public void TC_03_Actions() {
		// Click Icon
		homePage.clickToIconByCountryName("Afghanistan","remove");
		homePage.clickToIconByCountryName("Algeria","remove");
		
		homePage.clickToIconByCountryName("AFRICA","edit");
		homePage.refreshPage(driver);
		homePage.sleepInSecond(3);
		homePage.clickToIconByCountryName("Aruba","edit");
		homePage.refreshPage(driver);
		homePage.sleepInSecond(2);
		//Verify row value

	}
	

	public void TC_04_Verify_Row_Value() {
		// Click Icon
		homePage.inputToHeaderTextboxByName("Country" , "Afghanistan");
		assertTrue(homePage.isRowValueDisplay("384187","Afghanistan"));
		
		homePage.inputToHeaderTextboxByName("Country" , "Albania");
		assertTrue(homePage.isRowValueDisplay("24128","Albania"));
		//Verify row value

	}
	
	
	public void TC_05_Input_To_Row() {
		// Click Icon
		homePage.inputToTextBoxByRowNumber("Contact Person", "3" , "QA Test");
		homePage.sleepInSecond(2);
		homePage.inputToTextBoxByRowNumber("Order Placed", "1" , "2");
		homePage.sleepInSecond(2);
		homePage.inputToTextBoxByRowNumber("Company", "2" , "Apple");
		homePage.sleepInSecond(2);
	}
	
	@Test
	public void TC_06_Click_Icon_At_Row() {
		// Click Icon
		homePage.clickToIconByRowNumber("2", "Move Up");
		homePage.clickToIconByRowNumber("3", "Remove Current Row");
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
	}
	
}
