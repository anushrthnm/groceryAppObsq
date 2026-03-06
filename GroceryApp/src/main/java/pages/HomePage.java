package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.WaitUtility;

public class HomePage 
{
	public WebDriver driver;	
	
	@FindBy(xpath="//div[contains(@class,'small-box') and contains(normalize-space(),'Manage News')] //a")WebElement manageNews;
	@FindBy(xpath="//a[contains(text(),'Home')]") WebElement homenav;
	
	   public HomePage(WebDriver driver) 
	   {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	   }
	   
	   public HomePage pageSelect(String boxName) 
	   {
		   String xpath = String.format("//div[contains(@class,'small-box') and contains(normalize-space(),'%s')]//a",
			        boxName);
		   ((JavascriptExecutor) driver)
	        .executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
		   return this;
		    //driver.findElement(By.xpath(xpath)).click();
		}
	   
	   public HomePage manageNewsClick()
	   {
		   WaitUtility wait =new WaitUtility();
		   wait.waitForElementToBeClickable(driver,manageNews);
		   manageNews.click();
		   return this;
	   }
	   
	   public void homeNav()
	   {
		   homenav.click();
	   }
	
}
