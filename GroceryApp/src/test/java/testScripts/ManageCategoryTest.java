package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import baseClass.BaseClassGrocery;
import commonUtils.ExcelUtility;
import constants.ConstantClass;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import pages.ManageNewsPage;

public class ManageCategoryTest extends BaseClassGrocery
{
	LoginPage login;
	HomePage homepg;
	ManageCategoryPage catgry;
	ManageNewsPage news;
	
	@BeforeMethod
	 public void setUp() 
	{
	   login = new LoginPage(driver);
	   homepg=new HomePage(driver);
	   news=new ManageNewsPage(driver);
	   catgry=new ManageCategoryPage(driver);
	}
	
	@Test
	public void manageCategoryTest() throws IOException
	{
		String user=ExcelUtility.getStringData(1, 0, "loginData");
		String password=ExcelUtility.getStringData(1, 1, "loginData");	

		login.userNameInput(user);
		login.passwordInput(password);
		login.signIn();		

		homepg.pageSelect("Manage Category");
		
		catgry.clearExisting(ExcelUtility.getStringData(1, 0, "CategoryData"));
		
		catgry.clickonnew();
		catgry.adddata(ExcelUtility.getStringData(1, 0, "CategoryData"));
		catgry.addfile(ConstantClass.ImagePath);
		catgry.savedata();
		Assert.assertTrue(news.alertPop().getText().contains("Category Created Successfully"));
		
		homepg.homeNav();
		homepg.pageSelect("Manage Category");
		
		catgry.deleteExCatgry(ExcelUtility.getStringData(1, 0, "CategoryData"));
		Assert.assertTrue(news.alertPop().getText().contains("Category Deleted Successfully"));
	}
}
