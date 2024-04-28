package com.luma.page;

import org.openqa.selenium.By;

import com.luma.base.LumaBase;

public class signInPage extends LumaBase {
	
	public void signIn() {
		driver.findElement(By.partialLinkText("Sign In")).click();
		driver.findElement(By.name("login[username]")).sendKeys("supsy2000@gmail.com");
		driver.findElement(By.name("login[password]")).sendKeys("aabbcc#123");
		driver.findElement(By.id("send2")).click();
	}
	
	public String successLoginpage() {
		
		return driver.findElement(By.xpath("//span[@class='logged-in']")).getText();
	}
	
	public void forgotPassword() {
		driver.findElement(By.partialLinkText("Sign In")).click();
		driver.findElement(By.xpath("//a[@class='action remind']/span")).click();
		driver.findElement(By.id("email_address")).sendKeys("supsy2000@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")).click();
	}
	
	public String passwordReset() {
		return driver.findElement(By.xpath("//div[@class='page messages']/div/div/div/div[text()='If there is an account associated with supsy2000@gmail.com you will receive an email with a link to reset your password.']")).getText();
	}
}
