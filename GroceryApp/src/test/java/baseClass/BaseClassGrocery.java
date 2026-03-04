package baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import commonUtils.ScreenshotUtility;
import commonUtils.WaitUtility;
import constants.ConstantClass;

public class BaseClassGrocery 
{
   public WebDriver driver;
   public FileInputStream file;
   public Properties prop;
	
    @BeforeMethod(alwaysRun=true)
    @Parameters("browser")
	public void brwsrInit(String browser) throws Exception
	{
    	try 
    	{
    		prop= new Properties();
    		file= new FileInputStream(ConstantClass.Property);
    		prop.load(file);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	
    	if(browser.equalsIgnoreCase("chrome"))
    	{
		   driver =new ChromeDriver();
    	}
    	else if(browser.equalsIgnoreCase("firefox"))
    	{
    		driver =new FirefoxDriver();
    	}
    	else if(browser.equalsIgnoreCase("edge"))
    	{
    		driver =new EdgeDriver();
    	}
    	else
    	{
    		throw new Exception("Invalid Browser");
    	}
//		driver.get(ConstClass.URL);
    	driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		driver.manage().window().maximize();
	}
    
    @AfterMethod
    public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility scrshot = new ScreenshotUtility();
			scrshot.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();
	}
}
