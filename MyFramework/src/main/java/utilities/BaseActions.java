package utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class BaseActions 
{
	
	public static WebDriver driver;
	
	 Read_Write_ConfigFile obj = new Read_Write_ConfigFile();
	 ListenersImplementation ListenersImplementationObj = new ListenersImplementation();
	
	
	public void getDriver()
	{
		String browser = System.getProperty("browser");
		String appUrl = obj.getValueFromConfigFile("config", "app.url");
		System.out.println("url is "+appUrl);
		String runLocal = System.getProperty("runLocal");
		if(runLocal.equals("false"))
		{
			
		}
		else
		{
			if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "src//test//resources//drivers//chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browser.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "src//test//resources//drivers//geckodriver.exe");
				driver = new FirefoxDriver();	
			}
			else if(browser.equals("ie"))
			{
				System.setProperty("webdriver.ie.driver", "src//test//resources//drivers//IEDriverServer.exe");
				DesiredCapabilities capab = new DesiredCapabilities();
				 capab.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				 driver = new InternetExplorerDriver(capab); 
			}
		}
		driver.get(appUrl);
		waitForPageToLoad();
		driver.manage().window().maximize();
		ListenersImplementationObj.logger.log(LogStatus.INFO, "launched the app with url "+appUrl);
	}
	
	public void selectRadioButton(WebElement rb,String rbName)
	{
		try
		{
			waitForPageToLoad();
			rb.click();
			ListenersImplementationObj.logger.log(LogStatus.INFO, "selected the radio button "+rbName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ListenersImplementationObj.logger.log(LogStatus.ERROR,"unable to select the radio button "+rbName+" and the exception trace is "+e.getMessage());
			Assert.fail();
		}
	}
	
	public void clickLink(WebElement link,String linkName)
	{
		try
		{
			waitForPageToLoad();
			link.click();
			ListenersImplementationObj.logger.log(LogStatus.INFO, "clicked the link "+linkName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ListenersImplementationObj.logger.log(LogStatus.ERROR,"unable to select the link "+linkName+" and the exception trace is "+e.getMessage());
			Assert.fail();
		}
	}
	
	public  void clickButton(WebElement button,String buttonName)
	{
		try
		{
			waitForPageToLoad();
			button.click();
			ListenersImplementationObj.logger.log(LogStatus.INFO, "clicked the button "+buttonName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ListenersImplementationObj.logger.log(LogStatus.ERROR,"unable to select the button "+buttonName+" and the exception trace is "+e.getMessage());
			Assert.fail();
		}
	}
	
	public  void setText(WebElement field,String value,String fieldName)
	{
		try
		{
			waitForPageToLoad();
			field.click();
			field.clear();
			field.sendKeys(value);
			ListenersImplementationObj.logger.log(LogStatus.INFO, "entered the value "+value+" into the field "+fieldName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ListenersImplementationObj.logger.log(LogStatus.ERROR,"unable to set value "+value+" for the field "+fieldName+" and the exception trace is "+e.getMessage());
			Assert.fail();
		}
	}
	
	public  void validateActualAndExpectedMsg(String acutalMsg,String expMsg)
	{
		try
		{
			if(acutalMsg.equals(expMsg))
			{
				ListenersImplementationObj.logger.log(LogStatus.PASS,"actual message '"+acutalMsg+"' and expected message '"+expMsg+"' are same");
			}
			else
			{
				ListenersImplementationObj.logger.log(LogStatus.FAIL,"actual message '"+acutalMsg+"' and expected message '"+expMsg+"' are not the same");
				Assert.assertEquals(acutalMsg, expMsg);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ListenersImplementationObj.logger.log(LogStatus.ERROR,"unable to validate the actual and expected messages and the exception trace is "+e.getMessage());
			Assert.fail();
		}
	}
	
	
	public static void waitForPageToLoad()
	{/*
		try
		{
			Boolean readyStateComplete = false;
			do
			{
				Thread.sleep(1000);
			}
			while(!readyStateComplete);
			{
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				readyStateComplete = ((String) executor.executeScript("return document.readyState")).equals("complete");
			}
		}
		catch(Exception e)
		{
			
		}
	*/}

}
