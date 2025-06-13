package LinearCode;



import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class JSExecute {
    public static void main(String[] args) {
        WebDriver driver = null;
        String baseUrl = "https://demoqa.com/";

        try {
            // Step 1: Launch the browser
            driver = DriverManager.getDriver("chrome");
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(baseUrl);

            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Navigate to Alerts section using JS
            WebElement tagCard = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div/div[3]"));
            js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", tagCard);
            js.executeScript("arguments[0].click();", tagCard);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement alertTag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Alerts']")));
            js.executeScript("arguments[0].click();", alertTag);

            WebElement alertBtn = driver.findElement(By.id("alertButton"));
            js.executeScript("arguments[0].click();", alertBtn);
            driver.switchTo().alert().accept();

            // Navigate to form
            driver.navigate().to("https://demoqa.com/automation-practice-form");

            // Fill form using JS
            js.executeScript("document.getElementById('firstName').value='Abhay';");
            js.executeScript("document.getElementById('lastName').value='Kumar';");
            js.executeScript("document.getElementById('userEmail').value='abhay@gmail.com';");

            WebElement genderRadio = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"));
            js.executeScript("arguments[0].click();", genderRadio);

            js.executeScript("document.getElementById('userNumber').value='9876543234';");
            js.executeScript("document.getElementById('dateOfBirthInput').value='07 Jun 2025';");
            driver.findElement(By.id("subjectsInput")).sendKeys("Mat");
			WebElement element = driver.findElement(By.xpath("//*[contains(text(), 'Maths')]/parent::*"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			element.click();

            WebElement hobbiesCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
            js.executeScript("arguments[0].click();", hobbiesCheckbox);

            WebElement upload = driver.findElement(By.id("uploadPicture"));
            upload.sendKeys("C:\\Users\\2403953\\Downloads\\Day-47.txt"); // cannot use JS to upload file

            js.executeScript("document.getElementById('currentAddress').value='Ranchi';");

            driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'NCR')]")).click();
//		
			
			driver.findElement(By.xpath("//*[@id=\"city\"]/div/div[1]")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'Delhi')]")).click();

            // Submit
            WebElement submit = driver.findElement(By.id("submit"));
            js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", submit);
            js.executeScript("arguments[0].click();", submit);

            // Close Modal
            WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("closeLargeModal")));
            js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", close);

            if ((Boolean) js.executeScript("return arguments[0].offsetParent !== null;", close)) {
                System.out.println("Test Passed");
                Thread.sleep(3000);
                js.executeScript("arguments[0].click();", close);
                driver.navigate().to(baseUrl);
//                driver.quit();
            } else {
                System.out.println("Failed!");
                driver.quit();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
