package commonUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;

public class commonUtils 
{
	
	public void dropdownbyVisibleText(WebDriver driver, WebElement elem,String option)
    {
		Select sel= new Select(elem);
		sel.selectByVisibleText(option);
    }
	
}
