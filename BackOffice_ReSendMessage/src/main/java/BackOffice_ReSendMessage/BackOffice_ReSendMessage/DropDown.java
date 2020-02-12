package BackOffice_ReSendMessage.BackOffice_ReSendMessage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get("http://10.51.11.198:7005/eoc/login");
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
    	//driver.findElement(By.xpath("(//nobr[contains(text(),'Interface')])[1]/parent::label/parent::span/parent::td//table//td")).click();
    	Thread.sleep(200);
    	//driver.findElement(By.xpath("//table[@class=\"listTable\"]//tr//td//div[contains(text(),'ContractWrite')]")).click();
    	
    	//List<WebElement>elementList=driver.findElements(By.xpath("//table[@class='menuTable'][1]//tr//td"));
    	Thread.sleep(2000);
    	//clearing msg time
    	driver.findElement(By.xpath("(//nobr[contains(text(),'Msg Time')])[1]/parent::label//following::table//input[@type='TEXT']")).clear();
    	
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("((//nobr[contains(text(),'Order ID')]))[1]/parent::label/parent::span//following::input")).sendKeys("100021560626831");
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//td[@class='CwMEIDef'])[18]")).click();
    	
    	Thread.sleep(4000);
    	Actions actions = new Actions(driver);
    	//WebElement elementLocator = driver.findElement(By.xpath("//div[@class='vScrollThumb']"));
    	//actions.dragAndDropBy(driver.findElement(By.xpath("//img[@class=\"vScrollEnd\"]"), 0, 50);
    	actions.clickAndHold(driver.findElement(By.xpath("//img[@class=\"vScrollEnd\"]"))).perform();
    	Thread.sleep(8000);
    	driver.findElement(By.xpath("//div[contains(text(),'ContractWriteService')]/parent::td/parent::tr")).click();
    	
    	Thread.sleep(2000);
    	//Clicking on resend
    	driver.findElement(By.xpath("(//td[@class='CwMEIDef'])[23]")).click();
    	
    	String[] myStringArray = {"CONTR0054227397",
    			"CONTR0049016181"}; 
    	for(int i=0;i<myStringArray.length;i++)
    	{
    		Thread.sleep(2000);
        	Actions actions2 = new Actions(driver);
        	WebElement elementLocator = driver.findElement(By.xpath("//div[@role=\"presentation\" and contains(string(),'xml')]"));
        	actions2.doubleClick(elementLocator).perform();
        	
        	Thread.sleep(2000);
        	
        	
    	String contract=myStringArray[i];
    	String xmlMessage="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
    			"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header><cwl_fullStack.bscsSecurity:Security xmlns:cwl_fullStack.bscsSecurity=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><cwl_fullStack.bscsSecurity:UsernameToken><cwl_fullStack.bscsSecurity:Username>ADMX</cwl_fullStack.bscsSecurity:Username><cwl_fullStack.bscsSecurity:Password>ADMX</cwl_fullStack.bscsSecurity:Password></cwl_fullStack.bscsSecurity:UsernameToken></cwl_fullStack.bscsSecurity:Security></soapenv:Header><soapenv:Body><billingAdapterEOC.BSCSAdapter.contractWrite:contractWriteRequest xmlns:billingAdapterEOC.BSCSAdapter.contractWrite=\"http://ericsson.com/services/ws_CIL_7/contractwrite\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:billingAdapterEOC.BSCSAdapter.sessionChange=\"http://ericsson.com/services/ws_CIL_7/sessionchange\"><billingAdapterEOC.BSCSAdapter.contractWrite:inputAttributes><billingAdapterEOC.BSCSAdapter.contractWrite:coStatus>3</billingAdapterEOC.BSCSAdapter.contractWrite:coStatus><billingAdapterEOC.BSCSAdapter.contractWrite:reasonShdes>S2</billingAdapterEOC.BSCSAdapter.contractWrite:reasonShdes><billingAdapterEOC.BSCSAdapter.contractWrite:coIdPub>"+contract+"</billingAdapterEOC.BSCSAdapter.contractWrite:coIdPub></billingAdapterEOC.BSCSAdapter.contractWrite:inputAttributes><billingAdapterEOC.BSCSAdapter.contractWrite:sessionChangeRequest><billingAdapterEOC.BSCSAdapter.sessionChange:values><billingAdapterEOC.BSCSAdapter.sessionChange:item><billingAdapterEOC.BSCSAdapter.sessionChange:key>BU_ID</billingAdapterEOC.BSCSAdapter.sessionChange:key><billingAdapterEOC.BSCSAdapter.sessionChange:value>2</billingAdapterEOC.BSCSAdapter.sessionChange:value></billingAdapterEOC.BSCSAdapter.sessionChange:item></billingAdapterEOC.BSCSAdapter.sessionChange:values></billingAdapterEOC.BSCSAdapter.contractWrite:sessionChangeRequest></billingAdapterEOC.BSCSAdapter.contractWrite:contractWriteRequest></soapenv:Body></soapenv:Envelope>\r\n" ;
    	    	//providing XML in the box**************************
    	//********Sending XML data line by line*************************
    	//driver.findElement(By.xpath("//textarea[@name='sendData']")).sendKeys(xmlMessage);
    	//Thread.sleep(2000);
    	//********Sending XML data line by line*************************
    	//driver.findElement(By.xpath("//textarea[@name='sendData']")).click();
    	WebElement webl = driver.findElement(By.xpath("//textarea[@name='sendData']"));
    	webl.clear();
   	 
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	webl.click();
    	
    	js.executeScript("arguments[1].value = arguments[0]; ", xmlMessage, webl);
    	webl.sendKeys(Keys.END);
    	Thread.sleep(3000);
    	
    	
    	driver.findElement(By.xpath("(//nobr[contains(text(),'Order ID')])[3]")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//td[@class='CwMEIDef'])[27]")).click();
    	Thread.sleep(4000);
    	//Setting explicit wait
    	WebDriverWait wait=new WebDriverWait(driver, 20);
    	WebElement popUp;
    	popUp=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'re')]")));
    	//wait.until(ExpectedConditions.elementToBeClickable(By.id<locator>));
    	//driver.findElement(By.xpath("//td[contains(text(),'re')]")).click();
    	popUp.click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//td[@class='buttonRounded']")).click();
    	
    	
    	
    	}
   	
    	
    	driver.close();
    	

	}

}
