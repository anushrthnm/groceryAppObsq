package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.alertUtil;
import commonUtils.fileUpload;
import commonUtils.jsExecutorUtil;

public class manageCategory 
{
	public WebDriver driver;
	jsExecutorUtil js;
	alertUtil alert;

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//i[@class='fas fa-arrow-circle-right']")WebElement categoryinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement category_new;
	@FindBy(xpath="//input[@name='category']")WebElement category_name;
	@FindBy(xpath="//li[@id='134-selectable']")WebElement discount;
	@FindBy(xpath="//input[@id='main_img']")WebElement addfile;
	@FindBy(xpath="//button[text()='Save']")WebElement Save;
	@FindBy(xpath="//td[normalize-space()='Hinata']/parent::tr//a[contains(@href,'delete')]")WebElement delUser;


	public manageCategory(WebDriver driver) 
	{
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
	}

	public void categorySelect(String boxName) 
	{
		js=new jsExecutorUtil();
		String xpath = String.format("//div[contains(@class,'small-box') and contains(normalize-space(),'%s')]//a",
			        boxName);
		WebElement catgry= driver.findElement(By.xpath(xpath));
		js.scrollandClick(driver, catgry);  
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
		js=new jsExecutorUtil();
		js.scrollandClick(driver, Save);
	}
	
	public void deleteExCatgry(String userName)
	{
		js=new jsExecutorUtil();
		alert=new alertUtil();
		
		String xpath = String.format("//table //tbody //tr //td[contains(text(),'%s')]",userName);
		WebElement user= driver.findElement(By.xpath(xpath));
		
		js.scrollIntoView(driver, user);
		
		if(user.isDisplayed())
		{
			delUser.click();
			alert.acceptAlert(driver);
		}
	}	
}
