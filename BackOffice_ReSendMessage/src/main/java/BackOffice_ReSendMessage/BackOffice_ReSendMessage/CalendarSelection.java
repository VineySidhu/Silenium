package BackOffice_ReSendMessage.BackOffice_ReSendMessage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelection {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("http://10.51.11.197:7005/eoc/login");
    	//driver.get("http://10.84.44.139:7005/eoc/login");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	
    	driver.findElement(By.id("isc_G")).sendKeys("bot_vineysidhu");
    	     
    	driver.findElement(By.id("isc_L")).sendKeys("bot_vineysidhu");
    	
    	
    	    Thread.sleep(2000);
    	driver.findElement(By.xpath("//td[@class='normal']")).click();
    	Thread.sleep(4000);
    	driver.findElement(By.id("isc_1I")).click();
    	
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//td[@class='CwMEIDef'])[10]")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//div[contains(text(),'Message Log')])")).click();
    	Thread.sleep(2000);
    	//setting time directly
    	driver.findElement(By.xpath("(//label[contains(string(),'Msg Time')][1]/parent::span//parent::td//input)[1]")).clear();
    	Thread.sleep(2000);
    	WebElement webl = driver.findElement(By.xpath("(//label[contains(string(),'Msg Time')][1]/parent::span//parent::td//input)[1]"));
   	 
    	JavascriptExecutor js = (JavascriptExecutor)driver;

    	webl.click();
    	js.executeScript("arguments[1].value = arguments[0]; ", "08/30/2022 10:20:10", webl);
   
    	
    	
    	//driver.findElement(By.xpath("(//label[contains(string(),'Msg Time')][1]/parent::span//parent::td//input)[1]")).sendKeys("08/30/2022 10:20:10");
    	//clicking on calendar control
//    	driver.findElement(By.xpath("//label[contains(string(),'Msg Time')][1]/parent::span//parent::td//following-sibling::table//img")).click();
//    	driver.findElement(By.xpath("//td[@class='dateChooserNavButton']")).click();
//    	
//    	List<WebElement>elementList=driver.findElements(By.xpath("//table[@class='menuTable'][1]//tr//td"));
//    	for(int i=0;i<elementList.size();i++)
//    	
//    		{
//    		if(elementList.get(i).getText().contains("Aug"))
//    		{
//    			System.out.println(elementList.get(i).getText());
//    			elementList.get(i).click();
//    		
//    		break;
//    		}
//    		
//    		
//    		}
//    	Thread.sleep(2000);
//    	driver.findElement(By.xpath("(//td[@class='dateChooserNavButton'])[3]")).click();
//    	
//    			List<WebElement>elementList2=driver.findElements(By.xpath("(//table[@class='menuTable'])[3]//tr//td"));
//    	    	for(int i=0;i<elementList2.size();i++)
//    	    	
//    	    		{
//    	    		if(elementList2.get(i).getText().contains("2022"))
//    	    		{
//    	    			System.out.println(elementList2.get(i).getText());
//    	    			elementList2.get(i).click();
//    	    		
//    	    		break;
//    	    		}
//    	    		
//    	    		
//    	    		}
//    	    	
//    	    	
//
//    	
//    	    	
//    	    Thread.sleep(2000);
//    	  //clicking on drop down
//	    	//driver.findElement(By.xpath("(//td[contains(string(),'Hour')])[2]//following-sibling::table//following-sibling::td")).click();
//	    	
//	        //selecting hours
//	    	driver.findElement(By.xpath("(//div[@class=\"selectItemText\"])[3]")).sendKeys("08");
////    	    List<WebElement>hoursList=driver.findElements(By.xpath("//td[@class='pickListCellDark']/parent::tr"));
////    	    for(int i=0;i<hoursList.size();i++)
////    	    {
////    	    	if(hoursList.get(i).getText().contains("08"))
////    	    	{
////    	    		System.out.println(hoursList.get(i).getText());
////    	    		hoursList.get(i).click();
////    	    		break;
////    	    	}    	    	
////    	    	
////    	    }
//    	    
//    	  //selecting date
//    	    List<WebElement>dateList=driver.findElements(By.xpath("(//div[@class='listGrid'])[2]//tr//td"));
//    	    for(int i=0;i<dateList.size();i++)
//    	    {
//    	    	if(dateList.get(i).getText().contains("30"))
//    	    	{
//    	    		System.out.println(dateList.get(i).getText());
//    	    		dateList.get(i).click();
//    	    		break;
//    	    	}
//    	    	
//    	    
//    	    }
//    	
	}

}
