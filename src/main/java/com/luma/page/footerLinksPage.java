package com.luma.page;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.luma.base.LumaBase;

public class footerLinksPage extends LumaBase{
	
	public int footerLinks() {
	List<WebElement> url1 = driver.findElements(By.xpath("//div[@class='footer content']/div/div/ul/li/a"));
	int url1Count = url1.size();
	List<WebElement> url2 = driver.findElements(By.xpath("//ul[@class='footer links']/li/a"));
	int url2Count = url2.size();
	return url1Count + url2Count;		
}
	
	public String notes() {
		driver.findElement(By.xpath("//div[@class='footer content']/div/div/ul/li[1]/a")).click();		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		it.next();
		String cwhandle = it.next();
		driver.switchTo().window(cwhandle);
		return driver.getTitle();	
	}
	
	

}
