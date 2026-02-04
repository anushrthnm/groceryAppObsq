package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.baseClassGrocery;
import constants.excelUtil;
import pages.adminUsers;
import pages.homePage;
import pages.loginPageFact;
import pages.manageContact;
import pages.manageNewsPage;

public class AddUserTest extends baseClassGrocery {
	loginPageFact login;
	homePage homepg;
	manageNewsPage news;
	manageContact contact;
	adminUsers add;

	@BeforeMethod
	public void setUp() {
		login = new loginPageFact(driver);
		homepg = new homePage(driver);
		news = new manageNewsPage(driver);
		contact = new manageContact(driver);
		add = new adminUsers(driver);
	}

	@Test
	public void addUsers() throws IOException {
		String user = excelUtil.getStringData(1, 0, "loginData");
		String password = excelUtil.getStringData(1, 1, "loginData");

		login.userNameInput(user);
		login.passwordInput(password);
		login.signIn();

		homepg.pageSelect("Admin Users");

		add.clickonNew();

		add.enterdata(excelUtil.getStringData(1, 0, "AdminInfo"), excelUtil.getStringData(1, 1, "AdminInfo"));
		add.performdropdown(driver, excelUtil.getStringData(1, 2, "AdminInfo"));

		add.savedata();
		Assert.assertTrue(news.alertPop().getText().contains("Contact Updated Successfully"));
	}
}
