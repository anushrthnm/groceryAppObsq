package commonUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class jsExecutorUtil 
{
	
  public void scrollandClick(WebDriver driver, WebElement elem)
  {
	  ((JavascriptExecutor) driver)
      .executeScript("arguments[0].click();", elem);
  }
  
  public void scrollIntoView(WebDriver driver, WebElement elem)
  {
	  ((JavascriptExecutor) driver)
      .executeScript("arguments[0].scrollIntoView(true);", elem);
  }
}
