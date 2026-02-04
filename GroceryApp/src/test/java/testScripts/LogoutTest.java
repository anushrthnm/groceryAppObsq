package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.baseClassGrocery;
import constants.ConstClass;
import constants.excelUtil;
import pages.Header;
import pages.homePage;
import pages.loginPageFact;
import pages.manageCategory;
import pages.manageNewsPage;

public class LogoutTest extends baseClassGrocery
{
	loginPageFact login;
	homePage homepg;
	Header head;
	manageNewsPage news;
	
	@BeforeMethod
	 public void setUp() 
	{
	   login = new loginPageFact(driver);
	   homepg=new homePage(driver);
	   news=new manageNewsPage(driver);
       head=new Header(driver);
	}
	
	@Test
	public void logoutTest() throws IOException
	{
		String user=excelUtil.getStringData(1, 0, "loginData");
		String password=excelUtil.getStringData(1, 1, "loginData");	

		login.userNameInput(user);
		login.passwordInput(password);
		login.signIn();		

		head.headerDrop(); 
        head.logoutSelect();
		Assert.assertTrue(login.signInPageText().contains("Sign in to start your session"));	
	}
}
