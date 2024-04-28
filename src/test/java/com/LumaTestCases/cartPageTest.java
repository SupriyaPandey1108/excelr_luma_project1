package com.LumaTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.luma.page.cartPage;

public class cartPageTest {
	cartPage cp;
	
	@BeforeMethod
	public void browserSetUp() {
		cp = new cartPage();
		cp.Initialize();
	}
	
	@Test 
	public void validate_addToCart() {
		 String actMsg = cp.addToCart();
		 String expMsg = "You added Olivia 1/4 Zip Light Jacket to your shopping cart.";
		 AssertJUnit.assertEquals(actMsg, expMsg);
	}
	
	@Test 
	public void validate_negative_AddToCart() {
		String expError = "This is a required field.";
		String actError = cp.negativeAddToCart();
		AssertJUnit.assertEquals(actError, expError);
	}
	
	@Test 
	public void validate_get_Total_CartAmount() {
		String expAmount = "$77.00";
		String actAmount = cp.getTotalCartAmount();
		AssertJUnit.assertEquals(expAmount, actAmount);		
	}
	
	@Test
	public void validate_get_Total_NumberOf_Items_InCart() {
		String expAmount = "1 Item in Cart";
		String actAmount = cp.getTotalNumberOfItemsInCart();
		AssertJUnit.assertEquals(expAmount, actAmount);		
	}
	
	@Test
	public void validate_delete_Item_From_Cart() {
		String expMsg = "You have no items in your shopping cart.";
		String actMsg = cp.deleteItemFromCart();
		AssertJUnit.assertEquals(expMsg, actMsg);		
	}
	
	@Test
	public void validate_placeOrder() {
		String actMsg = cp.placeOrder();
		String expMsg = "Thank you for your purchase!";
		AssertJUnit.assertEquals(actMsg, expMsg);
		String actTitle = cp.getSuccessTitle();
		String expTitle = "Success Page";
		AssertJUnit.assertEquals(expTitle, actTitle);
	}
	
	@AfterMethod
	public void closeBrowser() {
		cp.tearDown();
	}
	
}
