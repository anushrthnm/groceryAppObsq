package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.WaitUtility;

public class ManageNewsPage 
{
	public WebDriver driver;
	@FindBy(xpath="//h1[normalize-space()='Manage News']")WebElement pageTitle;
	@FindBy(xpath="//div //a[contains(text(),'New')]")WebElement news;
	@FindBy(xpath="//textarea[contains(@id, 'news')]")WebElement newstext;
	@FindBy(xpath="//button[contains(text(),'Save')]")WebElement submit;
	@FindBy(xpath="//a[contains(text(),'Cancel')]")WebElement cancel;
	@FindBy(xpath="//div[contains(@class,'alert-success')]")WebElement alersucc;
	
	//h1[normalize-space()='Manage News']
	 public ManageNewsPage(WebDriver driver) 
	{
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	 
	 public String pageTitle()
	 {
		 String page=pageTitle.getText().trim();
		  return page;
	 }
	 
	  public ManageNewsPage addNews()
	  {
		  news.click();
		  return this;
	  }
	  
	  public ManageNewsPage enterNews(String news)
	  {
		  newstext.sendKeys(news);
		  return this;
	  }
	  
	  public ManageNewsPage submitNews()
	  {
		  submit.click();
		  return this;
	  }
	  
	  public ManageNewsPage cancelButton()
	  {
		  cancel.click();
		  return this;
	  }
	  
	  public WebElement alertPop()
	   {
		   
		   return alersucc;
	   }
}
