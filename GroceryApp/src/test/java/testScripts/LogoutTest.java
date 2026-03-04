package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClassGrocery;
import commonUtils.ExcelUtility;
import constants.ConstantClass;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import pages.ManageNewsPage;

public class LogoutTest extends BaseClassGrocery
{
	LoginPage login;
	HomePage homepg;
	HeaderPage head;
	ManageNewsPage news;
	
	@BeforeMethod
	 public void setUp() 
	{
	   login = new LoginPage(driver);
	   homepg=new HomePage(driver);
	   news=new ManageNewsPage(driver);
       head=new HeaderPage(driver);
	}
	
	@Test
	public void logoutTest() throws IOException
	{
		String user=ExcelUtility.getStringData(1, 0, "loginData");
		String password=ExcelUtility.getStringData(1, 1, "loginData");	

		login.userNameInput(user);
		login.passwordInput(password);
		login.signIn();		

		head.headerDrop(); 
        head.logoutSelect();
		Assert.assertTrue(login.signInPageText().contains("Sign in to start your session"));	
	}
}
