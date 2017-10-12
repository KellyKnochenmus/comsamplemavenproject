package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebDriverEventListeners_FiringClass {

    //instantiate the WebDriver and base URL
    public WebDriver driver;
    public String strBaseUrl;


    //This will run at the beginning of this test ONCE
    @BeforeClass
    public void beforeClassMethod() {
        //set chrome driver settings and launch browser
        System.setProperty("webdriver.chrome.driver", "/Applications/selenium-2.53.1/chromedriver");
        driver = new ChromeDriver();
        //specify url
        strBaseUrl = "https://www.expedia.com/";
        //Set Implicit Wait Time to 10 Seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Maximize browser
        driver.manage().window().maximize();
    }

     @Test
     public void UseWDEListeners() {
        //create object for EventFiringWebDriver and for the WebDRiverEventListenerClass java class file
        EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
        WebDriverEventListenerClass wdelc = new WebDriverEventListenerClass();
        //register the eDriver to the WDELC java class
        eDriver.register(wdelc);

         //navigate to url
         eDriver.get(strBaseUrl);
         eDriver.findElement(By.id("tab-flight-tab-hp")).click();
    }

    @AfterClass
    public void afterClassMethod() {
        driver.quit();
    }

}
