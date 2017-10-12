package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchWindow_SwitchiFrameFocus {

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
        strBaseUrl = "http://letskodeit.teachable.com/p/practice";
        //Set Implicit Wait Time to 10 Seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Maximize browser
        driver.manage().window().maximize();

        //navigate to url
        driver.get(strBaseUrl);
      //  System.out.println("This is the Before Class Method");
    }


    @Test
    public void SwitchWindowFocus() {

        //Get handle of parent handle
        String strParentHandle = driver.getWindowHandle();
        System.out.println("Parent Handle = '" + strParentHandle + "");

        //Find and click on the Open Window button
        WebElement btnOpenWindowButton = driver.findElement(By.cssSelector("#openwindow"));
        btnOpenWindowButton.click();

        //Get all handles
        Set<String> strAllHandles = driver.getWindowHandles();
        System.out.println("All Handles = '" + strAllHandles + "");

        //Switch between handles
        for(String handle: strAllHandles) {
            System.out.println(handle);
            if(!handle.equals(strParentHandle)) {
                driver.switchTo().window(handle);
            }
        }

        //Find and interact with element on new window
        WebElement searchbox = driver.findElement(By.id("search-courses"));
        searchbox.sendKeys("python");
        //Switch back to the parent window
        System.out.println("Opened and Switched Focus to New Browser Window");

        //Close New Window
        driver.close();

        //Switch focus back to default window
        driver.switchTo().window(strParentHandle);
    }

    @Test
    public void switchIFrame() {
        //Switch to the iframe (by name or id)
        driver.switchTo().frame("courses-iframe");

        //Switch to the iframe by number
        //driver.switchTo().frame(0);

        //Find and interact with elements in the iframe
        WebElement searchbox = driver.findElement(By.id("search-courses"));
        searchbox.sendKeys("python");
        System.out.println("Switched Focus to iFrame within Browser Window");
        //Return the focus back to the default window
        driver.switchTo().defaultContent();
    }


    //This will run at the end of this test ONCE
    @AfterClass
    public  void afterClassMethod() {
        System.out.println("This is the After Class Method");
        //close browser
        driver.quit();
    }
}
