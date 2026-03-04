package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClassGrocery;
import commonUtils.ExcelUtility;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;


public class ManageNewsPageTest extends BaseClassGrocery
{

	LoginPage login;
	HomePage homepg;
	ManageNewsPage news;

	@BeforeMethod
	 public void setUp() 
	{
	   login = new LoginPage(driver);
	   homepg=new HomePage(driver);
	   news=new ManageNewsPage(driver);
	}
	
	@Test
	public void manageNews() throws IOException
	{
		String user=ExcelUtility.getStringData(1, 0, "loginData");
		String password=ExcelUtility.getStringData(1, 1, "loginData");	

		login.userNameInput(user);
		login.passwordInput(password);
		login.signIn();		

		homepg.pageSelect("Manage News");
		
		String title= news.pageTitle();				
		Assert.assertEquals(news.pageTitle(),"Manage News");
		
		news.addNews();
		news.enterNews("News Test");
		news.submitNews();
		
		Assert.assertTrue(news.alertPop().isDisplayed(), "Success message is not displayed");
		Assert.assertTrue(news.alertPop().getText().contains("News Created Successfully"));
		
		homepg.homeNav();
	}
	
}
