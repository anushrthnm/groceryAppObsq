package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import baseClass.baseClassGrocery;
import constants.ConstClass;
import constants.excelUtil;
import pages.homePage;
import pages.loginPageFact;
import pages.manageCategory;
import pages.manageNewsPage;

public class ManageCategoryTest extends baseClassGrocery
{
	loginPageFact login;
	homePage homepg;
	manageCategory catgry;
	manageNewsPage news;
	
	@BeforeMethod
	 public void setUp() 
	{
	   login = new loginPageFact(driver);
	   homepg=new homePage(driver);
	   news=new manageNewsPage(driver);
	   catgry=new manageCategory(driver);
	}
	
	@Test
	public void manageCategoryTest() throws IOException
	{
		String user=excelUtil.getStringData(1, 0, "loginData");
		String password=excelUtil.getStringData(1, 1, "loginData");	

		login.userNameInput(user);
		login.passwordInput(password);
		login.signIn();		

		homepg.pageSelect("Manage Category");
		
		catgry.clickonnew();
		catgry.adddata(excelUtil.getStringData(1, 0, "CategoryData"));
		catgry.addfile(ConstClass.ImagePath);
		catgry.savedata();
		Assert.assertTrue(news.alertPop().getText().contains("Category Created Successfully"));
		
	}
}
