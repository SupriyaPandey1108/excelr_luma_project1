package com.luma.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.luma.base.LumaBase;

public class cartPage extends LumaBase {
	
	womenPage p = new womenPage();
		

	public String addToCart() {
		p. selectJacket();
		driver.findElement(By.linkText("Olivia 1/4 Zip Light Jacket")).click();
		driver.findElement(By.id("option-label-size-143-item-166")).click();
		driver.findElement(By.id("option-label-color-93-item-57")).click();		
		driver.findElement(By.id("product-addtocart-button")).click();
		String successMessage = driver.findElement(By.xpath("//div[@class='message-success success message']/div")).getText();
		return successMessage;
	}
	
	public String negativeAddToCart() {
		p.selectJacket();
		driver.findElement(By.linkText("Olivia 1/4 Zip Light Jacket")).click();
		driver.findElement(By.id("product-addtocart-button")).click();
		Utility.Screenshot.captureScreenshot("Negative_addToCart", driver);
		String error1 = driver.findElement(By.id("super_attribute[93]-error")).getText();
		String error2 = driver.findElement(By.id("super_attribute[93]-error")).getText();
		if (error1.equals(error2)) {
			return error1;
		} else {
			return "Fail";
		}
	}
	
	public String getTotalCartAmount() {
		addToCart();
		driver.findElement(By.xpath("//a[@class='action showcart']")).click();
		return driver.findElement(By.xpath("//span[@class='price-wrapper']/span[@class='price']")).getText();
	}
	
	public String getTotalNumberOfItemsInCart() {
		addToCart();
		driver.findElement(By.xpath("//a[@class='action showcart']")).click();
		return driver.findElement(By.xpath("//div[@class='items-total']")).getText();
	}
	
	public String deleteItemFromCart() {
		addToCart();
		driver.findElement(By.xpath("//a[@class='action showcart']/span[2]")).click();
		driver.findElement(By.xpath("//a[@class='action delete']")).click();
		driver.findElement(By.xpath("//div[@class='modals-wrapper']/aside[2]/div[2]/footer/button[2]")).click();
		return driver.findElement(By.xpath("//strong[@class='subtitle empty']")).getText();
	}
	
	public String placeOrder() {		
		addToCart();
		driver.findElement(By.xpath("//a[@class='action showcart']/span[2]")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("top-cart-btn-checkout")))).click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("top-cart-btn-checkout")).click();
		driver.findElement(By.id("customer-email")).sendKeys("testing123@gmail.com");
		driver.findElement(By.name("firstname")).sendKeys("test");
		driver.findElement(By.name("lastname")).sendKeys("TestLast");
		driver.findElement(By.name("street[0]")).sendKeys("Home 12343 A2-84, India");
		driver.findElement(By.name("city")).sendKeys("Bangalore");
		WebElement dd = driver.findElement(By.name("region_id"));
		Select obj = new Select(dd);
		obj.selectByVisibleText("Alaska");
		driver.findElement(By.name("postcode")).sendKeys("12345");
		driver.findElement(By.name("telephone")).sendKeys("6547653987");
		driver.findElement(By.xpath("//span[@class='price'][text()='$0.00']/parent::span/parent::td/preceding-sibling::td/input")).click();
		driver.findElement(By.xpath("//button[@class='button action continue primary']")).click();
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@title='Place Order']/span")))).click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[@title='Place Order']/span")).click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")).getText();
	}
	
	public String getSuccessTitle() {
		return driver.getTitle();
	}
}
