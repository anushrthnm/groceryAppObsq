package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.commonUtils;

public class adminUsers 
{
	public WebDriver driver;

	@FindBy(xpath="//div[@class='small-box bg-info']//child::a[contains(@href,'admin/list-admin')]")WebElement adminmoreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement admin_new;
	@FindBy(xpath="//input[@id='username']")WebElement admin_uname;
	@FindBy(xpath="//input[@name='password']")WebElement admin_passwd;
	@FindBy(xpath="//button[@name='Create']")WebElement admin_save;
	@FindBy(xpath="//select[@name='user_type']")WebElement dropdwn_type;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//child::h5")WebElement alertmsg;


	public adminUsers(WebDriver driver) 
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
		commonUtils drop=new commonUtils();
		drop.dropdownbyVisibleText(driver,dropdwn_type,option);
	}
	
	public void savedata() 
	{	 
	  admin_save.click();
    }
}
