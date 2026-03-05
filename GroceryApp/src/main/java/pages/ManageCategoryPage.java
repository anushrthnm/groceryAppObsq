package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.FileuploadUtility;
import commonUtils.Pageutility;
import commonUtils.WaitUtility;
import constants.ConstantClass;

public class ManageCategoryPage 
{
	public WebDriver driver;
	Pageutility page;
	WaitUtility wait;

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//i[@class='fas fa-arrow-circle-right']")WebElement categoryinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement category_new;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement category_search;
	@FindBy(xpath="//input[@name='un']") WebElement category_searchField;
	@FindBy(xpath="//button[@name='Search']") WebElement category_searchSubmit;
	@FindBy(xpath="//input[@name='category']")WebElement category_name;
	@FindBy(xpath="//li[@id='134-selectable']")WebElement discount;
	@FindBy(xpath="//input[@id='main_img']")WebElement addfile;
	@FindBy(xpath="//button[text()='Save']")WebElement Save;
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")WebElement delSearchCategory;
	

	public ManageCategoryPage(WebDriver driver) 
	{
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
	}

	public void categorySelect(String boxName) 
	{
		page=new Pageutility();
		String xpath = String.format("//div[contains(@class,'small-box') and contains(normalize-space(),'%s')]//a",
			        boxName);
		WebElement catgry= driver.findElement(By.xpath(xpath));
		page.scrollandClick(driver, catgry);  
	}

	public void clickonnew()
	{
	  category_new.click();
	}
	
	public void clearExisting(String catName)
	{
		page=new Pageutility();
		category_search.click();
		category_searchField.sendKeys(catName);		
		category_searchSubmit.click();		
		
		 String xpath2 = String.format("//table//tbody//tr//td//span//center[contains(text(),'%s')]", ConstantClass.NoResult);

		    List<WebElement> noresult = driver.findElements(By.xpath(xpath2));

		    if(noresult.size() > 0)
		    {
		        // RESULT NOT FOUND displayed
		        System.out.println("No category present");
		    }
		    else
		    {
		        String xpath = String.format("//table//tbody//tr//td[contains(text(),'%s')]", catName);
		        WebElement user = driver.findElement(By.xpath(xpath));

		        page.scrollIntoView(driver, user);
		        delSearchCategory.click();
		        page.acceptAlert(driver);
		    }
	}

	public void adddata(String catName)
	{
	  category_name.sendKeys(catName);
	  discount.click();
	}
	
	public void addfile(String filepath)
	{
	  FileuploadUtility fileupload=new FileuploadUtility();
	  fileupload.withSendKeys(addfile, filepath);
	}
	
	public void savedata()
	{
		page=new Pageutility();
		page.scrollandClick(driver, Save);
	}
	
	public void deleteExCatgry(String userName)
	{
		page=new Pageutility();
		wait=new WaitUtility();
		
		String xpath = String.format("//table //tbody //tr //td[contains(text(),'%s')]",userName);
		WebElement user= driver.findElement(By.xpath(xpath));
		
		page.scrollIntoView(driver, user);
		
		String delButton=String.format("//td[normalize-space()='%s']/parent::tr//a[contains(@href,'delete')]",userName);
		WebElement delUser= driver.findElement(By.xpath(delButton));
		if(user.isDisplayed())
		{
			wait.waitForElementToBeClickable(driver,delUser);
			delUser.click();
			page.acceptAlert(driver);
		}
	}	
}
