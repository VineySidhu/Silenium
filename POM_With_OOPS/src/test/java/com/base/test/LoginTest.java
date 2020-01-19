package com.base.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.base.page.HomePage;
import com.base.page.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest()
	{
		String title=page.getInstance(LoginPage.class).GetLoginPageTitle();
		
		Assert.assertEquals(title, "Cogmento CRM");
		
	}
	
	@Test()
	public void doLoginTest() throws InterruptedException
	{
		
		HomePage homePage= page.getInstance(LoginPage.class).doLogin("viney.sidhu@gmail.com", "Test@123");
		
		String homePageTitle=homePage.getHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
	}
	

}
