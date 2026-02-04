package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.baseClassGrocery;
import constants.excelUtil;
import pages.homePage;
import pages.loginPageFact;
import pages.manageNewsPage;


public class manageNewsPageTest extends baseClassGrocery
{

	loginPageFact login;
	homePage homepg;
	manageNewsPage news;

	@BeforeMethod
	 public void setUp() 
	{
	   login = new loginPageFact(driver);
	   homepg=new homePage(driver);
	   news=new manageNewsPage(driver);
	}
	
	@Test
	public void manageNews() throws IOException
	{
		String user=excelUtil.getStringData(1, 0, "loginData");
		String password=excelUtil.getStringData(1, 1, "loginData");	

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
