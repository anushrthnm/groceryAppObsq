package commonUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;

public class ScreenshotUtils 
{
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException 
	{
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//timestamp capture

		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory
		
		if (!f1.exists()) 
		{
		f1.mkdirs(); //create folder if not exist
		}
		
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
		+ ".png"; //screenshot path creation
		
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination);
	}
}
