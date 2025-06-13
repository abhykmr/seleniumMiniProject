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
		driver = WebDriverManager.getDriver("edge");
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
		 formPage.sendFirstName("Abhay");
	        formPage.sendLastName("Kumar");
	        formPage.sendEmail("abhay@gmail.com");

	        formPage.selectGender();
	        formPage.sendPhoneNumber("9876543234");
	        formPage.sendDateOfBirth("2025-06-07");

	        formPage.sendSubject("Mat");

	        formPage.selectHobby();
	        formPage.uploadFile("C:\\Users\\2403953\\Downloads\\Day-47.txt");

	        formPage.sendAddress("Ranchi");

	        formPage.selectState("NCR");
	        formPage.selectCity("Delhi");

	        formPage.submitForm();
	        formPage.closeModal("https://demoqa.com");
		
	}
	
	
	@AfterClass
	public void closeBrowser() {
		//
	}
	
}
