package BackOffice_ReSendMessage.BackOffice_ReSendMessage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class PDP_Re_SendMsg {

	public static WebDriver driver;
	public static String orderId="110022032874613";
	private static String convertDocumentToString(Document doc) {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();
            // below code to remove XML declaration
            // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            String output = writer.getBuffer().toString();
            return output;
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        
        return null;
    }
	
	private static Document convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder;  
        try  
        {  
            builder = factory.newDocumentBuilder();  
            Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) ); 
            return doc;
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        return null;
    }

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
    	//*******************Property File Change*****************************//
    	
    	File file = new File("C:\\Users\\esidvin\\Desktop\\Datafile.properties");
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//orderList= prop.getProperty("OrderList");
		String[]orderList = prop.get("OrderList").toString().split(",");
    	
    	//*******************Property File Change*****************************//
    	
//    	String[] orderList = {
//    			"190022160707088",
//    			"70022159512094"
//
//    			}; 
    	for(int i=0;i<orderList.length;i++)
    	{
    		
    		driver.findElement(By.xpath("((//nobr[contains(text(),'Order ID')]))[1]/parent::label/parent::span//following::input")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("((//nobr[contains(text(),'Order ID')]))[1]/parent::label/parent::span//following::input")).clear();
    	driver.findElement(By.xpath("((//nobr[contains(text(),'Order ID')]))[1]/parent::label/parent::span//following::input")).sendKeys(orderList[i]);
    	
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//td[@class='CwMEIDef'])[18]")).click();
    	
    	Thread.sleep(4000);
    	
    	driver.findElement(By.xpath("//div[contains(text(),'postpaid.EMA_NEW:ENTELChilePostPaidInterface/Set')]")).click();
    	
    	Thread.sleep(2000);
    	//Clicking on resend
    	driver.findElement(By.xpath("(//td[@class='CwMEIDef'])[23]")).click();
    	Thread.sleep(2000);
    	Actions actions2 = new Actions(driver);
    	Thread.sleep(3000);
    	WebElement elementLocator = driver.findElement(By.xpath("//div[@role=\"presentation\" and contains(string(),'xml')]"));
    	String xmlData=driver.findElement(By.xpath("//div[@role=\"presentation\" and contains(string(),'xml')]")).getText();
    	String modifiedXMLMessage=RemovePDPNodes(xmlData, "ENTELChilePostPaid:gprs");
    	actions2.doubleClick(elementLocator).perform();
    	
    	Thread.sleep(2000);
    	
    	
    	WebElement webl = driver.findElement(By.xpath("//textarea[@name='sendData']"));
    	webl.clear();
   	 
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	webl.click();
    	
    	js.executeScript("arguments[1].value = arguments[0]; ", modifiedXMLMessage, webl);
    	webl.sendKeys(Keys.END);
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("(//nobr[contains(text(),'Order ID')])[3]")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//nobr[contains(text(),'Order ID')])[3]/parent::label/parent::td/following::td//input")).sendKeys(orderList[i]);
    	
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
    	driver.findElement(By.xpath("//div[@eventproxy=\"page$dialog$$dialog$dialog_closeButton\"]")).click();
    
    	
    	System.out.println(xmlData);
    	}

	}
	
	public static String   RemovePDPNodes(String xmlMessage,String nodeName)
	{
		Document doc = convertStringToDocument(xmlMessage);	
		NodeList songList = doc.getElementsByTagName("ENTELChilePostPaid:gprs");
		System.out.println(songList.getLength());
		  for (int i = 0; i < songList.getLength(); i++) {

              Node node = songList.item(i);
              node.getParentNode().removeChild(node);
              
			
		}
		  songList = doc.getElementsByTagName("ENTELChilePostPaid:gprs");
			System.out.println(songList.getLength());
			  for (int i = 0; i < songList.getLength(); i++) {

	              Node node = songList.item(i);
	              node.getParentNode().removeChild(node);
	              
				
			}
		 String modifiedXML= convertDocumentToString(doc);
		 return modifiedXML;
	}

}
