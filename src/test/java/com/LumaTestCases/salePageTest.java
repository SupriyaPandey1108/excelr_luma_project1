package com.LumaTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.luma.page.salePage;

public class salePageTest {
	salePage sp;

	@BeforeMethod
	public void browserSetUp() {
		sp = new salePage();
		sp.Initialize();
	}

	@Test
	public void validate_numberOfSalesAvailable() {
		sp.identifyNumberOfSalesAvailable();
	}
	
	@Test
	public void validate_titleOfSalesAvailable() {
		AssertJUnit.assertTrue(sp.identifyTitleOfSales());
	}

	@AfterMethod
	public void closeBrowser() {
		sp.tearDown();
	}

}
