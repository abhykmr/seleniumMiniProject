package pomWithPf;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class InvokeTest {
	
	WebDriver driver;
	String baseUrl = "https://demoqa.com";
	AlertPage alertPage;
	HomePage homePage;

	@BeforeClass
	public void browserSetup() {
		driver = WebDriverManager.getDriver("chrome");
		driver.manage().window().maximize();
		driver.get(baseUrl);
		alertPage = new AlertPage(driver);
		homePage = new HomePage(driver);
	}
	
	@Test(priority=1)
	public void generateAlert() {
		homePage.clickAlertCard();
		alertPage.clickAlertMenu();
		alertPage.triggerAlert();
		
	}
	
	
	
	
	@AfterClass
	public void closeBrowser() {
		//
	}
	
}
