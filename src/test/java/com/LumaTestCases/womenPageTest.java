package com.LumaTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.page.signInPage;
import com.luma.page.womenPage;

public class womenPageTest {

	womenPage wp;
	signInPage sp;
	
	@BeforeMethod
	public void browserSetUp() {
		wp = new womenPage();
		sp = new signInPage();
		wp.Initialize();
	}
	
	@Test
	public void validate_select_WomenJacket_Option() {
		String expTitle = "Jackets - Tops - Women";
		String actTitle = wp.selectJacket();
		AssertJUnit.assertEquals(expTitle, actTitle);
	}
	
	@Test
	public void validate_selectSizeOfJacket() {
		String expSize = "XS";
		String actSize = wp.selectSizeOfJacket();
		AssertJUnit.assertEquals(expSize, actSize);
	}
	
	@Test
	public void validate_selectColorOfJacket() {
		String expColor = "Purple";
		String actColor = wp.selectColorOfJacket();
		AssertJUnit.assertEquals(expColor, actColor);
	}
	
	@Test
	public void validate_selectQuantityOfJacket() {
		String expQuan = "2";
		String actQuan = wp.selectQuantity();
		AssertJUnit.assertEquals(expQuan, actQuan);
	}
	
	@Test
	public void validate_addToWishList() {
		sp.signIn();
		String actmessage = wp.addToWishList();
		String expmessage = "Olivia 1/4 Zip Light Jacket has been added to your Wish List. Click here to continue shopping.";
		AssertJUnit.assertEquals(actmessage, expmessage);
	}
	
	@AfterMethod
	public void closeBrowser() {
		wp.tearDown();
	}
}
