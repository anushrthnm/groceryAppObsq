package commonUtils;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;


public class WaitUtility 
{
   public static final int IMPLICITWAIT =10;
   public static final int EXPLICIT_WAIT = 5;
   public static final int PAGE_LOAD_WAIT = 5;
   
   public void waitForElementToBeClickable(WebDriver driver,WebElement element) 
   {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
   }
   
   public void WaitForElement(WebDriver driver, WebElement target) 
   {		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		        .withTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT))
		        .pollingEvery(Duration.ofSeconds(PAGE_LOAD_WAIT))
		        .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(target));
	}
   
   public void waitforElementVisibility(WebDriver driver, WebElement target) 
   {		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		        .withTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT))
		        .pollingEvery(Duration.ofSeconds(PAGE_LOAD_WAIT))
		        .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(target));
	} 
	
}
