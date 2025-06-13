package LinearCode;

import java.time.Duration;
//import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import java.time.Duration;
//import org.openqa.selenium.support.ui.Select;

public class ToolsQATesting {
	public static void main(String[] args) {
		WebDriver driver = null;
		String baseUrl = "https://demoqa.com/";

		try {
			// step-1 Launch the browser
			driver = DriverManager.getDriver("chrome"); // provide either chrome or edge

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// maximize the browser window
			driver.manage().window().maximize();
			driver.get(baseUrl);
			JavascriptExecutor js = (JavascriptExecutor) driver;
//			Actions actions = new Actions(driver);

			// step-2 to generate the alert and generate the alert
			WebElement tagCard = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div/div[3]"));
			// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", tagCard);
//    		WebElement tagCard = wait.until(ExpectedCondition.)
			js.executeScript("arguments[0].click();", tagCard);

			// dropDown.click();
			// WebElement alertTag = driver.findElement(By.xpath("//*[@id='item-1']"));
//    		System.out.println(alertTag);
			// js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',
			// block:'center'});", alertTag);
			// js.executeScript("arguments[0].click();", alertTag);
//    		alertTag.click();

//    		if (alertTag.isDisplayed()) {
//    		    alertTag.click();
//    		} else {
//    		    System.out.println("Element is not visible!");
//    		}
//    		if (alertTag.isDisplayed() && alertTag.isEnabled()) {
//    		    alertTag.click();
//    		} else {
//    		    System.out.println("Element is not visible or not enabled yet!");
//    		}

//    		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"item-1\"]/span"));
//    		System.out.println("Total matching elements found: " + elements.size());
//
//    		for (WebElement e : elements) {
//    		    System.out.println("Text: " + e.getText());
//    		    System.out.println("Is displayed? " + e.isDisplayed());
//    		    System.out.println("Is enabled? " + e.isEnabled());
//    		}

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement alertTag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Alerts']")));
			alertTag.click();

			driver.findElement(By.id("alertButton")).click();
			driver.switchTo().alert().accept();
//    		WebElement alertTag = wait.until(ExpectedConditions.elementToBeClickable(
//    			    By.xpath("//*[@id='item-1']"))); 
//    			alertTag.click();

			driver.navigate().to("https://demoqa.com/automation-practice-form");

			driver.findElement(By.id("firstName")).sendKeys("Abhay");
			driver.findElement(By.id("lastName")).sendKeys("Kumar");
			driver.findElement(By.id("userEmail")).sendKeys("abhay@gmail.com");
			driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")).click();
			driver.findElement(By.id("userNumber")).sendKeys("9876543234");
			WebElement dateInput = driver.findElement(By.id("dateOfBirthInput"));
			js.executeScript("arguments[0].value='2025-06-07';", dateInput);
			driver.findElement(By.id("subjectsInput")).sendKeys("Mat");
			WebElement element = driver.findElement(By.xpath("//*[contains(text(), 'Maths')]/parent::*"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			element.click();

//			actions.moveToElement(driver.findElement(By.xpath("//div[text()='Math']"))).click().perform();

//      		driver.findElement(By.xpath("")).click();
//      		driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();

			WebElement hobbiesCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
			driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\2403953\\Downloads\\Day-47.txt");
			js.executeScript("arguments[0].click();", hobbiesCheckbox);

			driver.findElement(By.id("currentAddress")).sendKeys("Ranchi");
			driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'NCR')]")).click();
//			driver.findElement(By.xpath("text()='NCR'")).click();
			
			driver.findElement(By.xpath("//*[@id=\"city\"]/div/div[1]")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Delhi')]")).click();
			WebElement submit = driver.findElement(By.id("submit"));
			js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", submit);
			submit.click();

//      	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//      		WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("closeLargeModal")));

			WebElement close = driver.findElement(By.id("closeLargeModal"));
			js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", close);

			if (close.isDisplayed()) {
				System.out.println("Test Passed");
				js.executeScript("arguments[0].click();", close);
				driver.navigate().to(baseUrl);
//				driver.quit();
			} else {
				System.out.println("Failed!");
				driver.quit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
};