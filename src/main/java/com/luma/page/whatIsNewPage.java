package com.luma.page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.luma.base.LumaBase;

public class whatIsNewPage extends LumaBase{

		public int numberOfItemsAvailable() {
		driver.findElement(By.id("ui-id-3")).click();
		driver.findElement(By.xpath("//div[@class='categories-menu']/ul[1]/li/a[text()='Hoodies & Sweatshirts']")).click();
		List<WebElement> number = driver.findElements(By.xpath("//div[@class='products wrapper grid products-grid']/ol/li"));
		return number.size();
	}
	
	public boolean sortResultsByPrice() {
		
		WebElement dd = driver.findElement(By.id("sorter"));
		Select obj = new Select(dd);
		obj.selectByVisibleText("Price");
		List<WebElement> Prices = driver.findElements(By.xpath("//ol[@class='products list items product-items']/li/div/div/div/span/span/span/span"));
		ArrayList<String> ListOfPrices = new ArrayList<String>();
		for(WebElement optionElement : Prices)
		{
			ListOfPrices.add(optionElement.getText());
		}		
		ArrayList<String> tempList = new ArrayList<>(ListOfPrices);
		Collections.sort(tempList);
		boolean ifSortedAscending = ListOfPrices.equals(tempList);	
		if(ifSortedAscending) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getDetails() {
		driver.findElement(By.xpath("//div[@class='products wrapper grid products-grid']/ol/li[2]/div/div/strong/a")).click();
		driver.findElement(By.xpath("//div[@class='product info detailed']/div/div[1]/a")).click();
		String text1 = driver.findElement(By.xpath("//div[@class='product attribute description']/div/p[1]")).getText();
		return text1;
	}
	public String getPrice() {
		String Price = driver.findElement(By.xpath("//span[@id='product-price-1194']/span")).getText();
		return Price;
	}
	
	
}
