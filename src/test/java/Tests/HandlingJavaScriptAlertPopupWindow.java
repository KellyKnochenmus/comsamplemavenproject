package Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HandlingJavaScriptAlertPopupWindow {

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
        System.out.println("This is the Before Class Method");
    }


    @Test
    public void displayAlert() {
        driver.findElement(By.id("name")).sendKeys("Kelly");
        driver.findElement(By.id("alertbtn")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Alert alert1 = driver.switchTo().alert();
        //Click OK
        alert1.accept();
        //No Cancel Button on this type of Alert Box
        System.out.println("This method clicked OK on a Display Alert Button");
    }


    @Test
    public void confirmAlert() {
        driver.findElement(By.id("name")).sendKeys("Kelly");
        driver.findElement(By.id("confirmbtn")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Alert alert2 = driver.switchTo().alert();
        //Click OK
        //alert2.accept();
        //Click Cancel
        alert2.dismiss();
        System.out.println("This method clicked Cancel on a Confirm Alert Button");
    }

    //This will run at the end of this test ONCE
    @AfterClass
    public  void afterClassMethod() {
        System.out.println("This is the After Class Method");
        //close browser
        driver.quit();
    }


}
