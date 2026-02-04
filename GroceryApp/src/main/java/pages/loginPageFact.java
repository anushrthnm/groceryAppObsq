package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageFact 
{
	public WebDriver driver;
	
   @FindBy(xpath="//input[@name='username']")WebElement user;
   @FindBy(xpath="//input[@name='password']")WebElement passwd;
   @FindBy(xpath="//button[contains(text(),'Sign In')]")WebElement signin;
   @FindBy(xpath="//p[text()='Dashboard']")WebElement dashbrd;
   @FindBy(xpath="//div[contains(@class,'alert-danger')]")WebElement alerp;
   @FindBy(xpath="//p[contains(text(),'Sign in to start your session')]")WebElement signText;
 
 //div[contains(@class,'alert-danger')]//h5
   public loginPageFact(WebDriver driver) 
   {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
   }
   
   public void userNameInput(String user2)
   {
	   user.sendKeys(user2);
   }
   
   public void passwordInput(String password)
   {
	   passwd.sendKeys(password);
   }
   
   public void signIn()
   {
	   signin.click();
   }
   
   public boolean homepageCheck()
   {
	 return dashbrd.isDisplayed();
   }
   
   public String alertPop()
   {
	   String alertmsg=alerp.getAttribute("textContent");
	   return alertmsg.replace("×", "").replace("Alert!", "").replaceAll("\\s+", " ");
   }
   
   public String userfieldVal()
   {
	   return user.getAttribute("validationMessage");
   }
   
   public String passfieldVal()
   {
	   return passwd.getAttribute("validationMessage");
   }
   
   public String signInPageText()
   {
	   return signText.getText();
   }
 
}
