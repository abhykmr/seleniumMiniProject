package pomWithPf;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class FormPage {
	
	  WebDriver driver;
	  JavascriptExecutor js;
      public FormPage(WebDriver driver) {
    	  this.driver = driver;
    	  this.js = (JavascriptExecutor) driver;
    	  PageFactory.initElements(driver, this);
      }
      
      
      @FindBy(id="firstName") WebElement name;
      
      public void sendName() {
    	  js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'})", name);
    	  name.sendKeys("Abhay");
    	 
      }
}

