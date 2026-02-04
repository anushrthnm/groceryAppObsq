package commonUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class alertUtil 
{
	public  void acceptAlert(WebDriver driver) 
	{
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public  void dismissAlert(WebDriver driver) 
    {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public  String getAlertText(WebDriver driver) 
    {
        return driver.switchTo().alert().getText();
    }
}
