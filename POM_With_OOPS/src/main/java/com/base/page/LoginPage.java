package com.base.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

	//page Locators
	private By userName=By.name("email");
	private By password=By.name("password");
	private By loginButton=By.xpath("//div[contains(text(),\"Login\") and @class=\"ui fluid large blue submit button\"]");
	 
	
	
	public WebElement getUserName() {
		return getElement( userName);
	}


	public WebElement getPassword() {
		return getElement(password);
	}


	public WebElement getLoginButton() {
		return getElement(loginButton);
	}


	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String GetLoginPageTitle()
	{
		return getPageTitle();
	}
	
	public HomePage doLogin(String userName,String password)
	{
		getUserName().sendKeys(userName);
		getPassword().sendKeys(password);
		getLoginButton().click();
		return getInstance(HomePage.class);
		
	}

}
