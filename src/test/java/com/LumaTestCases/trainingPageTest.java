package com.LumaTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.luma.page.trainingPage;

public class trainingPageTest {

	
trainingPage tp;
	
	@BeforeMethod
	public void browserSetUp() {
		tp = new trainingPage();
		tp.Initialize();
	}
		
	@Test
	public void validate_identify_ListOf_Training_Videos() {
		AssertJUnit.assertTrue(tp.identifyListOfTrainingVideos());
	}
		
	@AfterMethod
	public void closeBrowser() {
		tp.tearDown();
	}
	
}
