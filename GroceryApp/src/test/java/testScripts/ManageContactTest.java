package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.baseClassGrocery;
import constants.excelUtil;
import pages.ManageFooter;
import pages.homePage;
import pages.loginPageFact;
import pages.manageContact;
import pages.manageNewsPage;

public class ManageContactTest extends baseClassGrocery
{
	loginPageFact login;
	homePage homepg;
	manageNewsPage news;
	manageContact contact;

	@BeforeMethod
	 public void setUp() 
	{
	   login = new loginPageFact(driver);
	   homepg=new homePage(driver);
	   news=new manageNewsPage(driver);
	   contact= new manageContact(driver);
	}
	
	@Test
	public void manageCategory() throws IOException
	{
		String user=excelUtil.getStringData(1, 0, "loginData");
		String password=excelUtil.getStringData(1, 1, "loginData");	

		login.userNameInput(user);
		login.passwordInput(password);
		login.signIn();		

		homepg.pageSelect("Manage Contact");
		
		contact.clickonedit();
		contact.updatePhone(excelUtil.getStringData(1, 0, "ContactData"));
		contact.updatedata();
		Assert.assertTrue(news.alertPop().getText().contains("Contact Updated Successfully"));
	}
}
