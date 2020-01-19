package com.base.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.base.page.BasePage;
import com.base.page.Page;

public class BaseTest {
	
	WebDriver driver;
	public Page page;
	
	@BeforeMethod
	@Parameters(value="browser")
	public void setUpTest(String browser)
	{
		if(browser.equals("ff"))
			
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();
		
		driver.get("https://ui.freecrm.com/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		page=new BasePage(driver);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
