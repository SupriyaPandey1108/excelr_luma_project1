
package com.luma.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LumaBase {

	public static WebDriver driver;
	public static Properties prop;
	public static JavascriptExecutor js;

	//Launching browser
	public void Initialize() {
		
		readPropertyFile();
		
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("IE")){
			driver = new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

	}

	public void readPropertyFile() {

		String configPath = "./src/main/java/config/config.properties";
		try {
			FileReader read = new FileReader(configPath);
			prop = new Properties();
			prop.load(read);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//Closing browser
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
