package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import constants.excelUtil;
import baseClass.baseClassGrocery;
import pages.ManageFooter;
import pages.homePage;
import pages.loginPageFact;
import pages.manageNewsPage;

public class manageFooterText extends baseClassGrocery
{
	loginPageFact login;
	homePage homepg;
	ManageFooter footer;
	manageNewsPage news;

	@BeforeMethod
	 public void setUp() 
	{
	   login = new loginPageFact(driver);
	   homepg=new homePage(driver);
	   footer=new ManageFooter(driver);
	   news=new manageNewsPage(driver);
	}
	
	@Test
	public void manageFooter() throws IOException
	{
		String user=excelUtil.getStringData(1, 0, "loginData");
		String password=excelUtil.getStringData(1, 1, "loginData");	

		login.userNameInput(user);
		login.passwordInput(password);
		login.signIn();		

		homepg.pageSelect("Manage Footer Text");
		
		footer.editicon();
		footer.dataFields(excelUtil.getStringData(1, 0, "FooterData"), 
				excelUtil.getStringData(1, 1, "FooterData"), 
				excelUtil.getStringData(1, 2, "FooterData"));
		footer.update();
		Assert.assertTrue(news.alertPop().getText().contains("Footer Text Updated Successfully"));
	}
}
