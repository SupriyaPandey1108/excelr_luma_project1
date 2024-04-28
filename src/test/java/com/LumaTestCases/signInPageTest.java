package com.LumaTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.luma.page.signInPage;

public class signInPageTest {
	
	signInPage sp ;
	
	@BeforeMethod
	public void browserSetUp() {
		sp = new signInPage();
		sp.Initialize();
	}
	
	@Test
	public void validate_SignIn() {
		sp.signIn();
		String actMessage = sp.successLoginpage();
		String expMessage = "Welcome, Supriyaa Test!";
		AssertJUnit.assertEquals(actMessage, expMessage);
	}
	
	@Test
	public void validate_PasswordReset() {
		sp.forgotPassword();
		String actMessage = "If there is an account associated with supsy2000@gmail.com you will receive an email with a link to reset your password.";
		String expMessage = sp.passwordReset();
		AssertJUnit.assertEquals(actMessage, expMessage);
	}
	@AfterMethod
	public void closeBrowser() {
		sp.tearDown();
	}
}
