package com.luma.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.luma.base.LumaBase;

public class gearPage extends LumaBase{

	public boolean identifyHotSellers() {
		driver.findElement(By.id("ui-id-6")).click();
		List<WebElement> hotSellerItems = driver.findElements(By.xpath("//div[@class='products-grid grid']/ol/li/div/div[@class='product-item-details']/strong/a"));
		ArrayList<String> actual = new ArrayList<>();
		ArrayList<String> expected = new ArrayList<>();
		expected.add("Fusion Backpack");
		expected.add("Push It Messenger Bag");
		expected.add("Affirm Water Bottle");
		expected.add("Sprite Yoga Companion Kit");
		for (WebElement webElement : hotSellerItems) {
			actual.add(webElement.getText());
		}
		boolean ifEqual = actual.equals(expected);
		if (ifEqual) {
			return true;
		} else {
			return false;
		}
	}
	
}
