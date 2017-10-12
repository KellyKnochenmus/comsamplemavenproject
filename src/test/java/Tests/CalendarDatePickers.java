package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CalendarDatePickers {

    //instantiate the WebDriver and base URL
    public WebDriver driver;
    public String strBaseUrl1;
    public String strBaseUrl2;

    //This will run at the beginning of this test ONCE
    @BeforeClass
    public void beforeClassMethod() {
        //set chrome driver settings and launch browser
        System.setProperty("webdriver.chrome.driver", "/Applications/selenium-2.53.1/chromedriver");
        driver = new ChromeDriver();

        //Set Implicit Wait Time to 10 Seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Maximize browser
        driver.manage().window().maximize();

        //navigate to url
        //driver.get(strBaseUrl);
       // System.out.println("This is the Before Class Method");
    }


    //This doesn't work because the Depart Input Box element's id keeps changing with each page refresh.
/*    @Test
    public void selectCalendarDate_dividFormat() {
        System.out.println("Calendar Picker Method #1 - when calendar element uses div/id format");
        //specify url
        strBaseUrl1 = "https://www.kayak.com/";
        //navigate to url
        driver.get(strBaseUrl1);
        //click on the Depart text box to bring up the calendar element and wait until calendar is visible
        WebElement txtDepartTextBox = driver.findElement(By.("Depart"));
        txtDepartTextBox.click();
        WebDriverWait waitA = new WebDriverWait(driver,5);
        WebElement calendarLeftSide = waitA.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#hmja-depart_datepicker0-201709 > div")));
        //find the 4th row, 5th column cell in the left calendar table
        WebElement cellRow4Column5 = calendarLeftSide.findElement(By.cssSelector("div.weeks > div:nth-child(4) > div:nth-child(5) > div"));
        //get the text from that cell
        String strRow4Col5Text = cellRow4Column5.getText();
        System.out.println("The Value of Row 4 Column 5 Cell is "+strRow4Col5Text);
        //click on that cell to select it
        cellRow4Column5.click();
        //click on the Returning Text box to change the focus and wait for the Returning Calendar to be visible
        WebElement txtReturningTextBox = driver.findElement(By.cssSelector("#hmja-returnDate-input"));
        txtReturningTextBox.click();
        WebDriverWait wait2 = new WebDriverWait(driver,5);
        WebElement calDepartureCalendar = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#hmja-depart_datepicker0-201710")));
        //Capture the new value in the Departure Text Box
        String strSelectedDepartureDate = driver.findElement(By.cssSelector("#hmja-depart_date0-input")).getAttribute("value");
        System.out.println("The Selected Departure Date is "+strSelectedDepartureDate);
    }
*/

    @Test
    public void selectCalendarDate_tableFormat() {
        System.out.println("Calendar Picker Method #2 - when calendar element uses table format");
        //specify url
        strBaseUrl2 = "https://www.expedia.com/";
        //navigate to url
        driver.get(strBaseUrl2);
        //click on the "Departing" text box to bring up the calendar element and wait until calendar is visible
        WebElement txtDepartingTextBox = driver.findElement(By.cssSelector("#package-departing-hp-package"));
        txtDepartingTextBox.click();
        WebDriverWait wait1 = new WebDriverWait(driver,5);
        WebElement calendarLeftSide = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#package-departing-wrapper-hp-package > div > div > div:nth-child(4)")));
        //find the 4th row, 5th column cell in the left calendar table
        WebElement cellRow4Column5 = calendarLeftSide.findElement(By.cssSelector("table > tbody > tr:nth-child(4) > td:nth-child(5) > button"));
        //get the text from that cell
        String strRow4Col5Text = cellRow4Column5.getText();
        System.out.println("The Value of Row 4 Column 5 Cell is "+strRow4Col5Text);
        //click on that cell to select it
        cellRow4Column5.click();
        //click on the Returning Text box to change the focus and wait for the Returning Calendar to be visible
        WebElement txtReturningTextBox = driver.findElement(By.cssSelector("#package-returning-hp-package"));
        txtReturningTextBox.click();
        WebDriverWait wait2 = new WebDriverWait(driver,5);
        WebElement calDepartureCalendar = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#package-returning-wrapper-hp-package > div > div")));
        //Capture the new value in the Departure Text Box
        String strSelectedDepartureDate = driver.findElement(By.cssSelector("#package-departing-hp-package")).getAttribute("value");
        System.out.println("The Selected Departure Date is "+strSelectedDepartureDate);
   }

    //This will run at the end of this test ONCE
    @AfterClass
    public  void afterClassMethod() {
   //     System.out.println("This is the After Class Method");
        //close browser
        driver.quit();
    }

}
