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
	FormPage formPage;

	@BeforeClass
	public void browserSetup() {
		driver = WebDriverManager.getDriver("chrome");
		driver.manage().window().maximize();
		driver.get(baseUrl);
		alertPage = new AlertPage(driver);
		homePage = new HomePage(driver);
		formPage = new FormPage(driver);
	}
	
	@Test(priority=1)
	public void generateAlert() {
		homePage.clickAlertCard();
		alertPage.clickAlertMenu();
		alertPage.triggerAlert();
		
	}
	
	@Test(priority=2)
	public void submitForm() {
		driver.navigate().to("https://demoqa.com/automation-practice-form");
		formPage.sendName();
	}
	
	
	@AfterClass
	public void closeBrowser() {
		//
	}
	
}
