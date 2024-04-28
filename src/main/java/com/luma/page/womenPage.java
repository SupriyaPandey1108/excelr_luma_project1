package com.luma.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.luma.base.LumaBase;

public class womenPage extends LumaBase {
	
	
			
	public String selectJacket() {
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//ul[@id='ui-id-2']/li[2]/a"))).perform();
		act.moveToElement(driver.findElement(By.id("ui-id-9"))).perform();
		WebElement ele3 = driver.findElement(By.id("ui-id-11"));
		act.moveToElement(ele3).perform();
		ele3.click();
		return driver.getTitle();
	}
	
	public String selectSizeOfJacket() {
		selectJacket();
		driver.findElement(By.linkText("Olivia 1/4 Zip Light Jacket")).click();
		driver.findElement(By.id("option-label-size-143-item-166")).click();
		return driver.findElement(By.xpath("//div[@class='swatch-attribute size']/span[2]")).getText();
	}
	
	public String selectColorOfJacket() {
		js = (JavascriptExecutor) driver;
		selectJacket();
		driver.findElement(By.linkText("Olivia 1/4 Zip Light Jacket")).click();
		driver.findElement(By.id("option-label-color-93-item-57")).click();
		js.executeScript("window.scrollBy(0,250)", "");
		return driver.findElement(By.xpath("//div[@class='swatch-attribute color']/span[2]")).getText();
		
	}
	
	public String selectQuantity() {
		js = (JavascriptExecutor) driver;
		selectJacket();
		driver.findElement(By.linkText("Olivia 1/4 Zip Light Jacket")).click();
		js.executeScript("window.scrollBy(0,250)", "");
		WebElement quantity = driver.findElement(By.name("qty"));
		quantity.clear();
		quantity.sendKeys("2");
		return driver.findElement(By.xpath("//div[@class='field qty']/div/input")).getAttribute("value");
	}
	
	public String addToWishList() {
		selectJacket();
		driver.findElement(By.linkText("Olivia 1/4 Zip Light Jacket")).click();
		driver.findElement(By.xpath("//div[@class='product-social-links']/div/a[@class='action towishlist']/span")).click();
		String wishListMessage = driver.findElement(By.xpath("//div[@class='message-success success message']/div")).getText();
		return wishListMessage;
	}
}
