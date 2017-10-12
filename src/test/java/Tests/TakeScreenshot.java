package Tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TakeScreenshot {

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

        //navigate to url
        driver.get(strBaseUrl);
        System.out.println("This is the Before Class Method");
    }

    //Generic Method to Calculate a Random String
    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    @Test
    public void TakeAndSaveScreenshot() throws IOException {
        System.out.println("Test Method 1");
        //Call the getRandomString method and generate a random filename with 8 characters; append with .png
        String strScreenshotFileName = getRandomString(8) + ".png";
        //Specify the location to save the screenshot file
        String strDirectory = "//Users//kknochenmus//Documents//udemy Courses//Selenium WebDriver with Java//Screenshots//";
        //Create full file path destination
        String strFullPath = strDirectory + strScreenshotFileName;
        System.out.println("The full name of the screenshot file is '"+strFullPath+"'");
        //Take Screenshot
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Copy screenshot to destination
        FileUtils.copyFile(sourceFile, new File(strFullPath));
    }

    //This will run at the end of this test ONCE
    @AfterClass
    public  void afterClassMethod() {
        System.out.println("This is the After Class Method");
        //close browser
        driver.quit();
    }


}
