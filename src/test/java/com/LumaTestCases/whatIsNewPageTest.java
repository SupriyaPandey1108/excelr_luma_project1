package com.LumaTestCases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.luma.page.whatIsNewPage;

public class whatIsNewPageTest {

	whatIsNewPage np;

	@BeforeMethod
	public void browserSetUp() {
		np = new whatIsNewPage();
		np.Initialize();
	}
	
	@Test
	public void validate_NumberOf_new_ItemsAdded() {
		int expNum = 12;
		int actNum = np.numberOfItemsAvailable();
		AssertJUnit.assertEquals(expNum, actNum);		
	}
	
	@Test
	public void validate_sortResults_ByPrice() {
		np.numberOfItemsAvailable();
		boolean actResult = np.sortResultsByPrice();
		boolean expResult = true;
		AssertJUnit.assertEquals(actResult, expResult);		
		
	}
	
//	@Test
//	public void validate_product_details() {
//		np.numberOfItemsAvailable();
//		String expLabel [] = {"Style", "Material", "Pattern", "Climate"};
//		List<WebElement> actLabel = np.getProductLabelDetails();		
//		Assert.assertEquals(expLabel, actLabel);
//		String expData [] = {"Sweatshirt, Pullover", "Fleece, Polyester, Spandex", "Solid", "Cool, Indoor, Mild"};
//		List<WebElement> actData = np.getProductDataDetails();		
//		Assert.assertEquals(expData, actData);		
//	}
	
	@Test
	public void validate_details() {
		np.numberOfItemsAvailable();
		String expText = "Getting chilly before class starts? Wear the Eos on your way to and from yoga for a cute and cozy warmup piece. Reach for its reliable comfort and enjoy a super-soft blend of fabrics finished in sporty style that includes a hidden kangaroo pocket.";
		String actText = np.getDetails();
		AssertJUnit.assertEquals(expText, actText);
		String expPrice = "$54.00";
		String actPrice = np.getPrice();
		AssertJUnit.assertEquals(expPrice, actPrice);
	}
	
	
	
	@AfterMethod
	public void closeBrowser() {
		np.tearDown();
	}
}
