package Tests;

import Utilities.ExcelUtility_ReadFromXL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class DataDriven_UsingTestNGDataProvider {

    public WebDriver driver;
    public static final String strURL = "http://letskodeit.com";
    public static final String strFilePath = "//Users//kknochenmus//Desktop//";
    public static final String strFileName = "InvalidLogin.xlsx";

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
        ExcelUtility_ReadFromXL.setExcelFile(strFilePath + strFileName, "Sheet1");
    }

    //go to the Excel sheet and get the Test Data
    @DataProvider(name = "loginData")
    public Object[][] dataProvider() {
        Object[][] objTestData = ExcelUtility_ReadFromXL.getTestData("Invalid_Login");
        return objTestData;
    }

    //read the data from the Data Provider (that read it from the Excel file)
    @Test(dataProvider="loginData")
    public void testUsingExcel(String strUserName, String strPassword) throws Exception {
        //Click login button
        driver.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Login')]")).click();
        Thread.sleep(2000);

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
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}
