package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import baseClass.BaseClassGrocery;
import commonUtils.ExcelUtility;
import pages.LoginPage;

public class LoginTest extends BaseClassGrocery
{
	    LoginPage login;

	@BeforeMethod
	 public void setUp() 
	{
	   login = new LoginPage(driver);
	}
	
//	@Test(dataProvider="loginProvider",description="valid login")
	@Test
	public void validLogin() throws IOException
	{
		String user=ExcelUtility.getStringData(1, 0, "loginData");
		String password=ExcelUtility.getStringData(1, 1, "loginData");
		
		login.userNameInput(user);
		login.passwordInput(password);
		login.signIn();
		
		boolean home= login.homepageCheck();
		Assert.assertTrue(home);
	}
	
	@Test
	public void invalidLogin() throws IOException
	{
		String user=ExcelUtility.getStringData(2, 0, "loginData");
		String password=ExcelUtility.getStringData(2, 1, "loginData");
		
		login.userNameInput(user);
		login.passwordInput(password);
		login.signIn();
		
		String alert= login.alertPop().trim();
		System.out.println(alert);
		Assert.assertEquals(alert,"Invalid Username/Password");
	}
	
	@Test
	public void nousernameLogin() throws IOException
	{
		String user=ExcelUtility.getStringData(3, 0, "loginData");
		String password=ExcelUtility.getStringData(3, 1, "loginData");
		
		login.userNameInput(user);
		login.passwordInput(password);
		login.signIn();
	
		String usemsg=login.userfieldVal();
		Assert.assertEquals(usemsg,"Please fill out this field.");

	}
	
	@Test
	public void nopasswdLogin() throws IOException
	{
		String user=ExcelUtility.getStringData(4, 0, "loginData");
		String password=ExcelUtility.getStringData(4, 1, "loginData");
		
		login.userNameInput(user);
		login.passwordInput(password);
		login.signIn();
		
		String passmsg=login.passfieldVal();
		Assert.assertEquals(passmsg,"Please fill out this field.");
	}
	
	@Test
	public void nocredLogin() throws IOException
	{
		String user=ExcelUtility.getStringData(5, 0, "loginData");
		String password=ExcelUtility.getStringData(5, 1, "loginData");
		
		login.userNameInput(user);
		login.passwordInput(password);
		login.signIn();
		
		String usemsg=login.userfieldVal();
		Assert.assertEquals(usemsg,"Please fill out this field.");
	}
}
