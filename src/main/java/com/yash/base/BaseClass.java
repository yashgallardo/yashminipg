package com.yash.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.yash.utils.ConfigReader;

public class BaseClass {
	public static WebDriver driver;
	public WebElement element =null;
	String driverPath = "../browserdrivers/";
	
	static ConfigReader prop = new ConfigReader();
	
@BeforeTest
	
	public void launchbrowser() throws IOException {

	String browserName = prop.TestProperties("BROWSER_NAME");
	
		
		if (browserName.equals("chrome")) {
			String path = driverPath + "chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			String path = driverPath + "geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", path);
			driver = new FirefoxDriver();
		} else
		{
			System.out.println("select driver");
		}
				
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.TestProperties("URL"));
		
		
	}
	
@AfterTest
public void closebrowser() {
	driver.close();
	System.out.println("Browser closed.....");
}

}
