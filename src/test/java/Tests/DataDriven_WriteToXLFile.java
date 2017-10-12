package Tests;

import Utilities.ExcelUtility_WriteToXL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class DataDriven_WriteToXLFile {
    public WebDriver driver;
    public static final String strURL = "http://letskodeit.com";
    public static final String strFilePath = "//Users//kknochenmus//Desktop//";
    public static final String strFileName = "WriteToExcel.xlsx";

    @BeforeClass
    public void setUp() throws Exception {
        //set chrome driver settings and launch browser
        System.setProperty("webdriver.chrome.driver", "/Applications/selenium-2.53.1/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Navigate to web page
        driver.get(strURL);
        driver.findElement(By.xpath("//*[@id=\"i90scv3glabel\"]")).click();
        //Tell the code about the location of Excel file
        ExcelUtility_WriteToXL.setExcelFile(strFilePath + strFileName, "Sheet1");

        //Click login button
        driver.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Login')]")).click();
        Thread.sleep(2000);
    }

    @Test
    public void writeToExcel() throws Exception {
        //Get number of rows in the data sheet
        int intNumberOfRows = ExcelUtility_WriteToXL.getNumberOfRows(strFilePath + strFileName, "Sheet1");
        System.out.println("Number of Rows in Spreadsheet = " + intNumberOfRows);

        //Loop through all rows in spreadsheet
        for (int i = 1; i < intNumberOfRows; i++) {
            //Get the username and password from the Excel file
            String strUserName = ExcelUtility_WriteToXL.getCellData(i, 0);
            String strPassword = ExcelUtility_WriteToXL.getCellData(i, 1);

            //Enter username
            driver.findElement(By.id("user_email")).sendKeys(strUserName);
            //Enter password
            driver.findElement(By.id("user_password")).sendKeys(strPassword);
            //Click Login Button
            driver.findElement(By.name("commit")).click();
            Thread.sleep(2000);

            //Find if error message exists
            boolean result = driver.findElements(By.xpath("//form[@id='new_user']//div[3]")).size() != 0;
            Assert.assertTrue(result);

            //Write the test result back to the Excel file
            ExcelUtility_WriteToXL.setCellData("Pass", i, 2, strFilePath, strFileName);
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}
