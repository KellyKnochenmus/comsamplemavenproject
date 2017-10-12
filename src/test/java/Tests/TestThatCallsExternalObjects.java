/*
*****************************************************************************
* Class Name:TestThatCallsExternalObjects
* Created: 9/8/17
* Author: Kelly Knochenmus
* Purpose: A framework for calling objects that exist in an external Java class file
*****************************************************************************
 */


/*BASIC WORKFLOW:
    1. import the external class
    2. create an object for the external class
    3. use that object to interact with variables and methods in that external class
 */

package Tests;

//import link to external class file
import Utilities.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestThatCallsExternalObjects {

   public WebDriver driver;
   public String strBaseUrl;

    @BeforeClass
    public void beforeClassMethod() {
        //set chrome driver settings and launch browser
        System.setProperty("webdriver.chrome.driver", "/Applications/selenium-2.53.1/chromedriver");
        driver = new ChromeDriver();
        //specify url
        strBaseUrl = "https://www.expedia.com/";
        //navigate to url
        driver.get(strBaseUrl);
        System.out.println("This is the Before Class Method");
    }

    @Test
    public void CallingExternalMethod() {
        int speed = 10;

        //instantiate object for external class file
        GenericMethods objGM = new GenericMethods(driver);
        //use the object to interact with the getElement method in the external class file
        WebElement btnFlightButton = objGM.getElement("//*[@id=\"tab-flight-tab-hp\"]","xpath");
        String strFlightButtonText = btnFlightButton.getText();

        System.out.println("The text value of the Flight Button is = '" + strFlightButtonText + "'");
    }

    @AfterClass
    public void afterClassMethod() {
        driver.quit();
    }

}
