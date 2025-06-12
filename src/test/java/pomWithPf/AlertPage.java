package pomWithPf;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AlertPage {
	
	  WebDriver driver;
	  JavascriptExecutor js;
      public AlertPage(WebDriver driver) {
    	  this.driver = driver;
    	  this.js = (JavascriptExecutor) driver;
    	  PageFactory.initElements(driver, this);
      }
      
      
      @FindBy(id="alertButton") WebElement alertButton;
      @FindBy(xpath="//*[text()='Alerts']") WebElement alertMenu;
      
      public void clickAlertMenu() {
    	  js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'})", alertMenu);
    	  alertMenu.click();
    	 
      }
      public void triggerAlert() {
    	  js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'})", alertButton);
    	  alertButton.click();
    	  driver.switchTo().alert().accept();
      }
}
