package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooter 
{
	public WebDriver driver;
	
	@FindBy(xpath="//a[contains(@href,'admin/Footertext/edit?edit=1')]//child::i[@class='fas fa-edit']")WebElement editicon;
	@FindBy(xpath="//textarea[@placeholder='Enter the Address']")WebElement address;
	@FindBy(xpath="//input[@name='email']")WebElement email;
	@FindBy(xpath="//input[@name='phone']")WebElement phoneno;
	@FindBy(xpath="//button[@name='Update']")WebElement updatebtn;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'][normalize-space()='More info']")WebElement alertmessage;


	public ManageFooter(WebDriver driver) 
	{ 
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	}


	public void editicon()
	{
		editicon.click();
	}

    public void dataFields(String addressText,String emailText,String phoneText)
   {
        address.clear();
        address.sendKeys(addressText);
        
        email.clear();
     	email.sendKeys(emailText);
     	
    	phoneno.clear();
    	phoneno.sendKeys(phoneText);
	}

	 public void update()
    {
	    updatebtn.click();
    }
	 
}
