package com.LumaTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.luma.page.createAccountPage;


public class createAccoutPageTest {

	createAccountPage ca;
	
	@BeforeMethod
	public void browserSetUp() {
		ca = new createAccountPage();
		ca.Initialize();
	}
	
	@Test
	public void Validate_Negative_CreateAccount() {
		ca.createAccountNegative();
		String expErrorMessage = "This is a required field.";
		String actErrorMessage = ca.errorMessage();
		AssertJUnit.assertEquals(actErrorMessage, expErrorMessage);
	}
	
	@Test
	public void validate_CreateAccount() {
		ca.createAccount();
		String expMessage = "Thank you for registering with Main Website Store.";
		String actMessage = ca.successMessage();
		AssertJUnit.assertEquals(expMessage, actMessage);
	}
	
	@DataProvider
	public Object[][] getExcelData() {
		String filePath = "./TestData.xlsx";
		String sheetName = "CreateAccount";
		return Utility.ExcelData.getData(filePath, sheetName);
		}
	
	@AfterMethod
	public void closeBrowser() {
		ca.tearDown();
	}
}
