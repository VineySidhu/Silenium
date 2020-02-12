package Panel360_Automation.Panel360_Automation;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */

public class App 
{
	public static WebDriver driver;
	public static List<WebElement>headingList;
	public static  List<WebElement>dataList;
	public static List<MSISDN_Details>MSISD_Details;
	
	public List<String>MSISDNs= Arrays.asList("56971046620",
			"56942458689",
			"56976219679",
			"56966281951",
			"56963978372",
			"56942752296",
			"56972106731",
			"56978033391",
			"56966878867",
			"56981297818",
			"56934407665",
			"56932794570",
			"56940690247",
			"56956260734",
			"56933954306",
			"56934467352"
);
	
	public static void Click(String xPath)
    {
    	driver.findElement(By.xpath(xPath)).click();
    }
	public void LoginToPage() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
    	options.addArguments("headless");
    	 driver = new ChromeDriver(options);
    	driver.get("http://vision360.entel.cl/panelpostpago/home.php");
    	
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	
    	driver.findElement(By.id("login")).sendKeys("ERI_VSIDHU");
    	
    	//lapass
    	driver.findElement(By.id("password")).sendKeys("Kevin@3939");
    	
    	Thread.sleep(2000);
    	driver.findElement(By.id("ingresar")).click();
    	Thread.sleep(2000);
    	
	}
	
	public void GetMSISDNStatus() throws InterruptedException
	{
		for (int j=0;j<MSISDNs.size();j++)
		{
		
		driver.findElement(By.xpath("//*[@id=\"inputdata\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"inputdata\"]")).sendKeys(MSISDNs.get(j));
    	
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//*[@id=\"enviar\"]")).click();
    	
    	headingList= driver.findElements(By.xpath("//*[@id=\"idtbl_50\"]/thead/tr"));
    	   dataList=(driver.findElements(By.xpath("//*[@id=\"idtbl_50\"]/tbody[2]/tr[1]//td"))); 
    	   
	    	   for(int i=0;i<dataList.size();i++)
	    	{
	    		System.out.print(dataList.get(i).getText()+" ");
	    	}
	    	   System.out.println("\n");
		}
	}
	
	public void PrintStatus()
	{
		 System.out.println("MSISDN DONANTE RECEPTOR FECHA");
	    	
	}
    public static void main( String[] args ) throws InterruptedException
    {
        App obj=new App();
        obj.LoginToPage();
        System.out.println("MSISDN DONANTE RECEPTOR FECHA");
        obj.GetMSISDNStatus();
        driver.close();
        
    }
    
}
