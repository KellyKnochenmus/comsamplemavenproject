package Tests;

import Utilities.ExcelUtility_ReadFromXL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.cssSelector;

public class PerformanceTest_UsingSystemTime {

    public WebDriver driver;
    public String strBaseUrl = "https://www.expedia.com";
    long startTime;
    long endTime;
    long duration;
    double seconds;

    @BeforeClass
    public void setUp() throws Exception {
        //set chrome driver settings and launch browser
        System.setProperty("webdriver.chrome.driver", "/Applications/selenium-2.53.1/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void searchFlightPerformanceTest() throws Exception {
        startTime = System.currentTimeMillis();
        //Navigate to web page
        driver.get(strBaseUrl);

        //Click Flights button
        driver.findElement(By.cssSelector("#tab-flight-tab-hp > span.tab-label")).click();
        Thread.sleep(2000);

        //Enter data for Flying From, Flying To, Departing, Returning fields
        driver.findElement(By.cssSelector("#flight-origin-hp-flight")).sendKeys("New York");
        driver.findElement(By.cssSelector("#flight-destination-hp-flight")).sendKeys("DFW");
        driver.findElement(By.cssSelector("#flight-departing-hp-flight")).sendKeys("12/12/2017");
        driver.findElement(By.cssSelector("#flight-returning-hp-flight")).clear();
        driver.findElement(By.cssSelector("#flight-returning-hp-flight")).sendKeys("12/15/2017");

        //Click the Search Button
        driver.findElement(By.cssSelector("#gcw-flights-form-hp-flight > div:nth-child(22) > label > button")).click();
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        seconds = (double)duration/1000.0;
        System.out.println("Start Time = '"+startTime+"'");
        System.out.println("End Time = '"+endTime+"'");
        System.out.println("Duration = '"+duration+"' in Milliseconds");
        System.out.println("Search for Flights Load Duration = '"+seconds+"' in Seconds");
    }

    @Test
    public void LoadPagePerformanceTest() throws Exception {
        startTime = System.currentTimeMillis();
        //Navigate to web page
        driver.get(strBaseUrl);
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        seconds = (double)duration/1000.0;
        System.out.println("Start Time = '"+startTime+"'");
        System.out.println("End Time = '"+endTime+"'");
        System.out.println("Duration = '"+duration+"' in Milliseconds");
        System.out.println("Home Page Load Duration = '"+seconds+"' in Seconds");
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}
