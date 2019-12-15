package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[@class=\"ui header item mb5 light-black\"]")
	WebElement contactsLabel;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='value' and @placeholder=\"Email address\"]")
	WebElement company;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	
	
	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	
	public void selectContactsByName(String name) throws InterruptedException{
		Thread.sleep(2000);
		String element_path="//td[contains(text(),'"+name+"')]//parent::td//preceding-sibling::td//label";
		WebElement element = driver.findElement(By.xpath(element_path));

		Actions actions = new Actions(driver);
		Thread.sleep(2000);

		actions.moveToElement(element).click().perform();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]//parent::td//preceding-sibling::td//input")).click();
	}
	
	
	public void createNewContact(String ftName, String ltName, String email) throws InterruptedException{
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(email);
		
		saveBtn.click();
		Thread.sleep(2000);
		
	}
	
	
	
	

}
