/*
*****************************************************************************
* Class Name: SampleFirefoxTest
* Created: 9/8/17
* Author: Kelly Knochenmus
* Purpose: A basic Selenium Test Using Gecko Driver and TestNG
*****************************************************************************
 */

package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SampleFirefoxTest_Basic {

    //instantiate the WebDriver and base URL
    public WebDriver driver;
    public String strBaseUrl;


    //This will run at the beginning of this test ONCE
    @BeforeClass
    public void beforeClassMethod() {
        //set chrome driver settings and launch browser
        System.setProperty("webdriver.gecko.driver","/Applications/selenium-java-3.5.3/geckodriver");
        driver = new FirefoxDriver();
        //specify url
        strBaseUrl = "https://www.expedia.com/";
        //Set Implicit Wait Time to 10 Seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Maximize browser
        driver.manage().window().maximize();
        //navigate to url
        driver.get(strBaseUrl);
        System.out.println("This is the Before Class Method");
    }


    @Test
    public void chromeTest1() {
        System.out.println("Test Method 1");
    }


    @Test
    public void chromeTest2() {
        System.out.println("Test Method 2");
    }


    //This will run at the end of this test ONCE
    @AfterClass
    public  void afterClassMethod() {
        System.out.println("This is the After Class Method");
        //close browser
        driver.quit();
    }

}
