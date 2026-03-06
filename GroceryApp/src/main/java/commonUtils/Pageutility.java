package commonUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Pageutility 
{
	
	public void dropdownbyVisibleText(WebDriver driver, WebElement elem,String option)
    {
		Select sel= new Select(elem);
		sel.selectByVisibleText(option);
    }
	
	public void dropdownSelectByValue(WebDriver driver, WebElement elem,String option) 
	{
		Select s = new Select(elem);
		s.selectByValue(option);
	}

	public void dropdownSelectByIndex(WebDriver driver, WebElement elem, int value) 
	{
		Select s = new Select(elem);
		s.selectByIndex(value);
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
    
    public void jssendKeys(WebDriver driver, WebElement element, String stringvalue) 
    {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='stringvalue';", element);
	}	

	public void actionClassDragAndDrop(WebDriver driver, WebElement element) 
	{
		Actions a = new Actions(driver);
		a.dragAndDrop(element, element).perform();
	}

	public void actionRightClick(WebDriver driver, WebElement element) 
	{
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}

	public void actionMouseHover(WebDriver driver, WebElement element) 
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	public void actionDoubleClick(WebDriver driver, WebElement element) 
	{
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
}
