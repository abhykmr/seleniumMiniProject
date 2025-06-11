package testNGapproach;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverSetup {
      public static WebDriver getDriver(String browser) {
    	  WebDriver driver;
    	  if(browser.equalsIgnoreCase("chrome")) {
//    		  WebDriverManager.chromeDriver().setup();
    		  driver = new ChromeDriver();
    	  } else if(browser.equalsIgnoreCase("edge")) {
//    		  WebDriverManager.edgeDriver().setup();
    		  driver = new EdgeDriver();
    	  } else {
    		  throw new IllegalArgumentException("Browser not supported");
    	  }
    	  return driver;
      }
}
