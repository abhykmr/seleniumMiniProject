package pomWithPf;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    
	WebDriver driver;
	JavascriptExecutor js;
	public HomePage(WebDriver driver) {
		 this.driver = driver;
		 this.js = (JavascriptExecutor) driver;
   	  PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='app']/div/div/div[2]/div/div[3]/div/div[3]") WebElement alertCard;
	
	public void clickAlertCard() {
		js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'})", alertCard);
		js.executeScript("arguments[0].click()", alertCard);
	}
}
