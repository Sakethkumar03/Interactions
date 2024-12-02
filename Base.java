package com.testing.Project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	protected WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Title of the page
				driver.get("https://letcode.in/test");
				 Assert.assertTrue(driver.getTitle().contains("Testing Hub"));

				System.out.println("Title:- "+driver.getTitle());
	}
	
	
	@AfterClass
	public void quit() {
		driver.close();
		driver.quit();
		
	}
}
