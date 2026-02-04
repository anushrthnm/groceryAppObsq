package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.fileUpload;

public class manageCategory 
{
	public WebDriver driver;

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//i[@class='fas fa-arrow-circle-right']")WebElement categoryinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement category_new;
	@FindBy(xpath="//input[@name='category']")WebElement category_name;
	@FindBy(xpath="//li[@id='134-selectable']")WebElement discount;
	@FindBy(xpath="//input[@id='main_img']")WebElement addfile;
	@FindBy(xpath="//button[text()='Save']")WebElement Save;


	public manageCategory(WebDriver driver) 
	{
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
	}

	public void categorySelect(String boxName) 
	{

		   String xpath = String.format("//div[contains(@class,'small-box') and contains(normalize-space(),'%s')]//a",
			        boxName);
		   WebElement catgry= driver.findElement(By.xpath(xpath));
		   ((JavascriptExecutor) driver)
	        .executeScript("arguments[0].click();", catgry);	    
	}

	public void clickonnew()
	{
	  category_new.click();
	}

	public void adddata(String catName)
	{
	  category_name.sendKeys(catName);
	  discount.click();
	}
	
	public void addfile(String filepath)
	{
	  fileUpload fileupload=new fileUpload();
	  fileupload.withSendKeys(addfile, filepath);
	}
	
	public void savedata()
	{
		((JavascriptExecutor) driver)
        .executeScript("arguments[0].click();",Save);
	}
}
