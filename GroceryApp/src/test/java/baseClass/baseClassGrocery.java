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

import commonUtils.ScreenshotUtils;
import commonUtils.WaitUtility;
import constants.ConstClass;

public class baseClassGrocery 
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
    		file= new FileInputStream(ConstClass.Property);
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
		driver.get(ConstClass.URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		driver.manage().window().maximize();
	}
    
    @AfterMethod
    public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtils scrshot = new ScreenshotUtils();
			scrshot.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();
	}
}
