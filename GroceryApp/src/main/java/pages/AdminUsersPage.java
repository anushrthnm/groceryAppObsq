package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonUtils.Pageutility;
import commonUtils.WaitUtility;
import constants.ConstantClass;


public class AdminUsersPage 
{
	public WebDriver driver;
	Pageutility page;
	WaitUtility wait;
	

	@FindBy(xpath="//div[@class='small-box bg-info']//child::a[contains(@href,'admin/list-admin')]")WebElement adminmoreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement admin_new;
	@FindBy(xpath="//input[@id='username']")WebElement admin_uname;
	@FindBy(xpath="//input[@name='password']")WebElement admin_passwd;
	@FindBy(xpath="//button[@name='Create']")WebElement admin_save;
	@FindBy(xpath="//select[@name='user_type']")WebElement dropdwn_type;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//child::h5")WebElement alertmsg;
    @FindBy(xpath="//td[normalize-space()='Hinata']/parent::tr//a[contains(@href,'delete')]")WebElement delUser;
    @FindBy(xpath="//a[@onclick='click_button(2)']") WebElement admin_search;
    @FindBy(xpath="//input[@name='un']") WebElement admin_searchField;
    @FindBy(xpath="//select[@name='ut']")WebElement search_dropdown;
    @FindBy(xpath="//button[@name='Search']") WebElement admin_searchSubmit;
    @FindBy(xpath="//i[@class='fas fa-trash-alt']")WebElement delSearchAdmin;

	public AdminUsersPage(WebDriver driver) 
	{
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
	}
	
	public void clickonadminusers()
	{
	  adminmoreinfo.click();
	}
	
	public void clickonNew()
	{
	  admin_new.click();
	}
	
	public void enterdata(String username,String password)
	{
	  admin_uname.sendKeys(username);
	  admin_passwd.sendKeys(password);
	}
	
	public void performdropdown(WebDriver driver,String option)
	{
		Pageutility drop=new Pageutility();
		drop.dropdownbyVisibleText(driver,dropdwn_type,option);
	}
	
	public void savedata() 
	{	 
	  admin_save.click();
    }
	
	public void deleteExisting(String userName)
	{
		page=new Pageutility();
		wait=new WaitUtility();
		String xpath = String.format("//table //tbody //tr //td[contains(text(),'%s')]",userName);
		WebElement user= driver.findElement(By.xpath(xpath));
		
		page.scrollIntoView(driver, user);
		
		if(user.isDisplayed())
		{
			wait.waitForElementToBeClickable(driver,delUser);
			page.scrollIntoView(driver, delUser);
			delUser.click();
			page.acceptAlert(driver);
		}
	}
	
	public void clearAdmin(WebDriver driver,String username,String option)
	{
		page=new Pageutility();
		admin_search.click();
		admin_searchField.sendKeys(username);
		page.dropdownbyVisibleText(driver,search_dropdown,option);
		admin_searchSubmit.click();		
		
		 String xpath2 = String.format("//table//tbody//tr//td//span//center[contains(text(),'%s')]", ConstantClass.NoResult);

		    List<WebElement> noresult = driver.findElements(By.xpath(xpath2));

		    if(noresult.size() > 0)
		    {
		        // RESULT NOT FOUND displayed
		        System.out.println("No category present");
		    }
		    else
		    {
		        String xpath = String.format("//table//tbody//tr//td[contains(text(),'%s')]", username);
		        WebElement user = driver.findElement(By.xpath(xpath));

		        page.scrollIntoView(driver, user);
		        page.scrollIntoView(driver, delSearchAdmin);
		        delSearchAdmin.click();
		        page.acceptAlert(driver);
		    }
	}
}
