package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClassGrocery;
import commonUtils.ExcelUtility;
import pages.ManageFooterPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;

public class ManageFooterTextTest extends BaseClassGrocery
{
	LoginPage login;
	HomePage homepg;
	ManageFooterPage footer;
	ManageNewsPage news;

	@BeforeMethod
	 public void setUp() 
	{
	   login = new LoginPage(driver);
	   homepg=new HomePage(driver);
	   footer=new ManageFooterPage(driver);
	   news=new ManageNewsPage(driver);
	}
	
	@Test
	public void manageFooter() throws IOException
	{
		String user=ExcelUtility.getStringData(1, 0, "loginData");
		String password=ExcelUtility.getStringData(1, 1, "loginData");	

		login.userNameInput(user);
		login.passwordInput(password);
		login.signIn();		

		homepg.pageSelect("Manage Footer Text");
		
		footer.editicon();
		footer.dataFields(ExcelUtility.getStringData(1, 0, "FooterData"), 
				ExcelUtility.getStringData(1, 1, "FooterData"), 
				ExcelUtility.getStringData(1, 2, "FooterData"));
		footer.update();
		Assert.assertTrue(news.alertPop().getText().contains("Footer Text Updated Successfully"));
	}
}
