package com.base.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element=null;
		try
		{
			element=driver.findElement(locator);
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		
	}

	@Override
	public void waitForPageTitle(String title) {
		try
		{
		wait.until(ExpectedConditions.titleContains(title));
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		
	}

}
