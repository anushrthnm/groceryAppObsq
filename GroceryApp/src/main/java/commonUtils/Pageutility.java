package commonUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;

public class Pageutility 
{
	
	public void dropdownbyVisibleText(WebDriver driver, WebElement elem,String option)
    {
		Select sel= new Select(elem);
		sel.selectByVisibleText(option);
    }
	
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
    
    public void scrollandClick(WebDriver driver, WebElement elem)
    {
  	  ((JavascriptExecutor) driver)
        .executeScript("arguments[0].click();", elem);
    }
    
    public void scrollIntoView(WebDriver driver, WebElement elem)
    {
  	  ((JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView(true);", elem);
    }
	
}
