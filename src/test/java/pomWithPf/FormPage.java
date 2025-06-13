package pomWithPf;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

public class FormPage {

    WebDriver driver;
    JavascriptExecutor js;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // Locators using Page Factory
    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(xpath = "//*[@id='genterWrapper']/div[2]/div[1]/label")
    WebElement gender;

    @FindBy(id = "userNumber")
    WebElement userNumber;

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    @FindBy(xpath = "//*[contains(text(), 'Maths')]/parent::*")
    WebElement mathsSubject;

    @FindBy(id = "hobbies-checkbox-1")
    WebElement hobbiesCheckbox;

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(xpath = "//*[@id='state']/div/div[1]")
    WebElement stateDropdown;

    @FindBy(xpath = "//*[contains(text(), 'NCR')]")
    WebElement stateOption;

    @FindBy(xpath = "//*[@id='city']/div/div[1]")
    WebElement cityDropdown;

    @FindBy(xpath = "//*[contains(text(), 'Delhi')]")
    WebElement cityOption;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(id = "closeLargeModal")
    WebElement closeButton;

    // Actions
    public void navigateToForm(String baseUrl) {
        driver.navigate().to(baseUrl);
    }

    public void sendFirstName(String fName) {
        scrollIntoView(firstName);
        firstName.sendKeys(fName);
    }

    public void sendLastName(String lName) {
        scrollIntoView(lastName);
        lastName.sendKeys(lName);
    }

    public void sendEmail(String email) {
        scrollIntoView(userEmail);
        userEmail.sendKeys(email);
    }

    public void selectGender() {
        scrollIntoView(gender);
        js.executeScript("arguments[0].click();", gender);
    }

    public void sendPhoneNumber(String phoneNumber) {
        scrollIntoView(userNumber);
        userNumber.sendKeys(phoneNumber);
    }

    public void sendDateOfBirth(String dob) {
        scrollIntoView(dateOfBirthInput);
        js.executeScript("arguments[0].value='" + dob + "';", dateOfBirthInput);
    }

    public void sendSubject(String subject) {
        scrollIntoView(subjectsInput);
        subjectsInput.sendKeys(subject);
        scrollIntoView(mathsSubject);
        js.executeScript("arguments[0].click();", mathsSubject);
    }

    public void selectHobby() {
        scrollIntoView(hobbiesCheckbox);
        js.executeScript("arguments[0].click();", hobbiesCheckbox);
    }

    public void uploadFile(String filePath) {
        scrollIntoView(uploadPicture);
        uploadPicture.sendKeys(filePath);
    }

    public void sendAddress(String address) {
        scrollIntoView(currentAddress);
        currentAddress.sendKeys(address);
    }

    public void selectState(String state) {
        scrollIntoView(stateDropdown);
        stateDropdown.click();
        WebElement stateOptionElement = driver.findElement(By.xpath("//*[contains(text(), '" + state + "')]"));
        scrollIntoView(stateOptionElement);
        stateOptionElement.click();
    }


    public void selectCity(String city) {
        scrollIntoView(cityDropdown);
        cityDropdown.click();
        driver.findElement(By.xpath("//*[contains(text(), '" + city + "')]")).click();
    }

    public void submitForm() {
        scrollIntoView(submitButton);
        js.executeScript("arguments[0].click();", submitButton);
    }

    public void closeModal(String baseUrl) {
        scrollIntoView(closeButton);
        if (closeButton.isDisplayed()) {
            System.out.println("Test Passed");
            js.executeScript("arguments[0].click();", closeButton);
            driver.navigate().to(baseUrl);
        } else {
            System.out.println("Failed!");
        }
    }

    // Utility method to scroll elements into view
    private void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'})", element);
    }
}
