package testNGapproach;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

//import com.beust.jcommander.Parameters;

public class TestCode {
	WebDriver driver;
	JavascriptExecutor js;
	Actions actions;
	WebDriverWait wait;

	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String br) {
		driver = DriverSetup.getDriver(br);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://demoqa.com/");
	}
	

	@Test(priority = 1)
	public void navigateToAlertsSection() {
		WebElement tagCard = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[3]/div/div[3]"));
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", tagCard);
		js.executeScript("arguments[0].click();", tagCard);

		WebElement alertTag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Alerts']")));
		js.executeScript("arguments[0].click();", alertTag);

		WebElement alertButton = driver.findElement(By.id("alertButton"));
		js.executeScript("arguments[0].click();", alertButton);
		driver.switchTo().alert().accept();
	}

	@Test(priority = 2)
	public void fillPracticeForm() throws InterruptedException {
		driver.navigate().to("https://demoqa.com/automation-practice-form");

		js.executeScript("document.getElementById('firstName').value='Abhay';");
		js.executeScript("document.getElementById('lastName').value='Kumar';");
		js.executeScript("document.getElementById('userEmail').value='abhay@gmail.com';");

		WebElement gender = driver.findElement(By.xpath("//*[@id='genterWrapper']/div[2]/div[1]/label"));
		js.executeScript("arguments[0].click();", gender);

		js.executeScript("document.getElementById('userNumber').value='9876543234';");
		WebElement dateInput = driver.findElement(By.id("dateOfBirthInput"));
		js.executeScript("arguments[0].value='2025-06-07';", dateInput);

//		WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
//		js.executeScript("arguments[0].value='Math';", subjectsInput);
//		actions.moveToElement(driver.findElement(By.xpath("//div[text()='Math']"))).click().perform();

		WebElement hobbiesCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
		js.executeScript("arguments[0].click();", hobbiesCheckbox);

		driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\2403953\\Downloads\\Day-47.txt");

		js.executeScript("document.getElementById('currentAddress').value='Ranchi';");

		WebElement submit = driver.findElement(By.id("submit"));
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", submit);
		js.executeScript("arguments[0].click();", submit);

		WebElement close = driver.findElement(By.id("closeLargeModal"));
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", close);

		if (close.isDisplayed()) {
			System.out.println("Test Passed");
			js.executeScript("arguments[0].click();", close);
		} else {
			System.out.println("Failed!");
		}
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
