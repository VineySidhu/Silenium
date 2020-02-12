package BackOffice_ReSendMessage.BackOffice_ReSendMessage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Calendar_Java_Script {

	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.spicejet.com/");
    	
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	
    	driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
    	Thread.sleep(2000);
    	
    	WebElement element=driver.findElement(By.id("ctl00_mainContent_txt_Fromdate"));
    	String value="02-02-2020";
    	SetDate(driver, element, value);
    	
    	Thread.sleep(2000);
    	driver.findElement(By.id("travelOptions")).click();
    	
    	
    	
    	

	}
	
	public static void SetDate(WebDriver driver,WebElement element,String value)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		   //String script="arguments[0].setAttribute('value','"+value+"');";
		js.executeScript("arguments[0].setAttribute('value','"+value+"');", element);
	
	}

}
