package com.LumaTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.page.menPage;


public class menPageTest {

	menPage mp;
	
	@BeforeMethod
	public void browserSetUp() {
		mp = new menPage();
		mp.Initialize();
	}
	
	@Test
	public void validate_selectListView_MenTops() {
		AssertJUnit.assertTrue(mp.selectListView());
	}
	
	@Test
	public void validate_selectFilter_Style() {
		AssertJUnit.assertTrue(mp.selectFilterStyle());
	}
	
	@Test
	public void validate_selectFilter_Material() {
		AssertJUnit.assertTrue(mp.selectFilterMaterial());
	}
	
	@Test
	public void validate_clearAllFilter() {
		AssertJUnit.assertTrue(mp.clearAllFilter());
	}
	
	@AfterMethod
	public void closeBrowser() {
		mp.tearDown();
	}
	
}
