package com.luma.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.luma.base.LumaBase;

public class menPage extends LumaBase {

	
	public void selectMensTopSection() {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//ul[@id='ui-id-2']/li[3]/a"))).perform();
		WebElement ele = driver.findElement(By.id("ui-id-17"));
		act.moveToElement(ele).perform();
		ele.click();
	}
	public boolean selectListView() {
		selectMensTopSection();
		driver.findElement(By.id("mode-list")).click();
		return driver.findElement(By.xpath("//div[@class='products wrapper list products-list']/ol/li[1]/div/div/strong/a")).isDisplayed();
	}
	
	public boolean selectFilterStyle() {
		selectMensTopSection();
		driver.findElement(By.xpath("//div[@class='filter-options-item']/div[text()='Style']")).click();
		driver.findElement(By.xpath("//div[@class='filter-options-item allow active']/div[2]/ol/li[5]/a")).click();
		boolean filterSubTitle = driver.findElement(By.xpath("//strong[text()='Now Shopping by']")).isDisplayed();
		boolean filterValue = driver.findElement(By.xpath("//span[text()='Heavy Duty']")).isDisplayed();
		if (filterValue == filterSubTitle) {
			return true;
		}
		else return false;
	}
	
	public boolean selectFilterMaterial() {
		selectMensTopSection();
		driver.findElement(By.xpath("//div[@class='filter-options-title'][text()='Material']")).click();
		driver.findElement(By.xpath("//div[@class='filter-options-item allow active']/div[2]/ol/li[2]/a")).click();
		boolean filterSubTitle = driver.findElement(By.xpath("//strong[text()='Now Shopping by']")).isDisplayed();
		boolean filterValue = driver.findElement(By.xpath("//span[text()='Cotton']")).isDisplayed();
		if (filterValue == filterSubTitle) {
			return true;
		}
		else return false;
	}
	
	public boolean clearAllFilter() {
		selectFilterMaterial();
		driver.findElement(By.linkText("Clear All")).click();
		return true;
	}
	
}
