package com.luma.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.luma.base.LumaBase;

public class trainingPage extends LumaBase {

	public boolean identifyListOfTrainingVideos() {
		driver.findElement(By.id("ui-id-7")).click();
		List<WebElement> listOftags = driver.findElements(By.xpath("//div[@class='blocks-promo']/a/span/strong"));
		ArrayList<String> actual = new ArrayList<>();
		ArrayList<String> expected = new ArrayList<>();
		expected.add("Motivate yourself." + "\n" + "Reach goals." + "\n" + "Boost ambition." + "\n" + "Max fitness." + "\n" + "Upgrade lifestyle.");
		expected.add("Before creating Luma, pro trainer Erin Renny helped world-class athletes reach peak fitness");
		expected.add("Training on demand");
		for (WebElement webElement : listOftags) {
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
