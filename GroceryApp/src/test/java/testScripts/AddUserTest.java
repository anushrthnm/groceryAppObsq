package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClassGrocery;
import commonUtils.ExcelUtility;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageNewsPage;

public class AddUserTest extends BaseClassGrocery {
	LoginPage login;
	HomePage homepg;
	ManageNewsPage news;
	ManageContactPage contact;
	AdminUsersPage add;

	@BeforeMethod
	public void setUp() {
		login = new LoginPage(driver);
		homepg = new HomePage(driver);
		news = new ManageNewsPage(driver);
		contact = new ManageContactPage(driver);
		add = new AdminUsersPage(driver);
	}

	@Test
	public void addUsers() throws IOException {
		String user = ExcelUtility.getStringData(1, 0, "loginData");
		String password = ExcelUtility.getStringData(1, 1, "loginData");

		login.userNameInput(user);
		login.passwordInput(password);
		login.signIn();

		homepg.pageSelect("Admin Users");

		add.clickonNew();

		add.enterdata(ExcelUtility.getStringData(1, 0, "AdminInfo"), ExcelUtility.getStringData(1, 1, "AdminInfo"));
		add.performdropdown(driver, ExcelUtility.getStringData(1, 2, "AdminInfo"));

		add.savedata();
		Assert.assertTrue(news.alertPop().getText().contains("Contact Updated Successfully"));
		
		homepg.homeNav();
		homepg.pageSelect("Admin Users");
		add.deleteExisting(ExcelUtility.getStringData(1, 0, "AdminInfo"));
		Assert.assertTrue(news.alertPop().getText().contains("User Deleted Successfully"));
	}
}
