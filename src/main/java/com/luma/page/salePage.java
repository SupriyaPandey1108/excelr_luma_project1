package com.luma.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.luma.base.LumaBase;

public class salePage extends LumaBase{

	
	public int identifyNumberOfSalesAvailable() {
		driver.findElement(By.id("ui-id-8")).click();
		List<WebElement> t2 = driver.findElements(By.xpath("//span[@class='content']"));
		return t2.size();
	}
	
	public boolean identifyTitleOfSales() {
		driver.findElement(By.id("ui-id-8")).click();
		List<WebElement> t2 = driver.findElements(By.xpath("//span[@class='content']"));
		ArrayList<String> actual = new ArrayList<>();
		ArrayList<String> expected = new ArrayList<>();
		for (WebElement webElement : t2) {
			actual.add(webElement.getText());
		}
		expected.add("Women’s Deals" + "\n" + "Pristine prices on pants, tanks and bras." + "\n" + "Shop Women’s Deals");
		expected.add("Men’s Bargains" + "\n" + "Stretch your budget with active attire" + "\n" + "Shop Men’s Deals");
		expected.add("Luma Gear Steals" + "\n" + "Your best efforts deserve a deal" + "\n" + "Shop Luma Gear");
		expected.add("20% OFF" + "\n" + "Every $200-plus purchase!");
		expected.add("Spend $50 or more — shipping is free!" + "\n" + "Buy more, save more");
		expected.add("You can't have too many tees" + "\n" + "4 tees for the price of 3. Right now" + "\n" + "Tees on sale");
		boolean ifEqual = actual.equals(expected);
		if (ifEqual) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
}
