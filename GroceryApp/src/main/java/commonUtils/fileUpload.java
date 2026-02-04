package commonUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class fileUpload 
{

	public void withSendKeys(WebElement elemt,String path)
	{
		elemt.sendKeys(path);
	}
	

	public void withRobotKeys(WebElement elemt,String path) throws AWTException
	{
		StringSelection obj=new StringSelection("C:\\Users\\Admin\\Downloads\\UserManual-Electricity bill.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj,null);//pass object of string selection and null
		Robot r= new Robot();
		r.delay(2500);
		r.keyPress(KeyEvent.VK_CONTROL);//keyevent is a classin robot class,VK is virtual key
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);		
	}
}
