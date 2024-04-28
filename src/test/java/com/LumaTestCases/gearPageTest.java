package com.LumaTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.page.gearPage;


public class gearPageTest {

gearPage gp;
	
	@BeforeMethod
	public void browserSetUp() {
		gp = new gearPage();
		gp.Initialize();
	}
		
	@Test
	public void validate_identifyHotSellers() {
		AssertJUnit.assertTrue(gp.identifyHotSellers());
	}
		
	@AfterMethod
	public void closeBrowser() {
		gp.tearDown();
	}
	
	
}
