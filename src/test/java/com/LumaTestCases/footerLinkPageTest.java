package com.LumaTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.luma.page.footerLinksPage;

public class footerLinkPageTest {
	
	footerLinksPage fl;
	
	@BeforeMethod
	public void browserSetUp() {
		fl = new footerLinksPage();
		fl.Initialize();
	}
	
	@Test
	public void validate_totalNumber_Of_FooterLinks() {
		int expLinkCount = 8;
		int actLinkCount = fl.footerLinks();
		AssertJUnit.assertEquals(expLinkCount, actLinkCount);
	}
		
	@Test
	public void validate_FooterLink_Notes() {
		String exptitle = "Magento 2 Store(Sandbox site) - Notes - Software Testing Board";
		String acttitle = fl.notes();
		AssertJUnit.assertEquals(exptitle, acttitle);
	}
	
	@AfterMethod
	public void closeBrowser() {
		fl.tearDown();
	}

}
