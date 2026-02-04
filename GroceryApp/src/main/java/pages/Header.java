package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.WaitUtility;

public class Header {
	public WebDriver driver;
	@FindBy(xpath = "//a[(@class='nav-link') and @data-toggle='dropdown']")
	WebElement nav;
	@FindBy(xpath = "//div [contains(@class,'dropdown-menu')] //a[contains(@href,'logout')]")
	WebElement logout;
	@FindBy(xpath = "//div[contains(@class,'dropdown-menu')]//a[contains(@href,'logout')]/preceding-sibling::a[1]")
	WebElement settings;

	public Header(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void headerDrop() 
	{
		WaitUtility wait =new WaitUtility();
		wait.waitForElementToBeClickable(driver,nav);
		nav.click();
	}

	public void logoutSelect() 
	{
		logout.click();
	}

	public void settingSelect() 
	{
		headerDrop();
		settings.click();
	}
}
