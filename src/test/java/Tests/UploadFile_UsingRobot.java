package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class UploadFile_UsingRobot {

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
        strBaseUrl = "https://www.gmail.com/";
        //Set Implicit Wait Time to 10 Seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Maximize browser
        driver.manage().window().maximize();

        //navigate to url
        driver.get(strBaseUrl);
        //System.out.println("This is the Before Class Method");
    }


    @Test
    public void Upload() throws AWTException {
        //find the element for the desired google account
    //    WebElement btnGoogleAcctButton = driver.findElement(By.cssSelector("#view_container > form > div.mbekbe.bxPAYd > div > div > div > ul.sIznTe.pggQ5e > li:nth-child(7) > div > div.wDzjuc.hPcO1c"));
      //  btnGoogleAcctButton.click();

    //    try {
    //        Thread.sleep(3000);
    //    } catch (InterruptedException e) {
    //        e.printStackTrace();
    //    }

        //find the element for username, password and Next buttons
        WebElement txtUsernameTextBox = driver.findElement(By.cssSelector("#identifierId"));
        txtUsernameTextBox.sendKeys("kelly.user3@gmail.com");
        WebElement btnNextButton1 = driver.findElement(By.cssSelector("#identifierNext > content"));
        btnNextButton1.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement txtPasswordTextBox = driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input"));
        txtPasswordTextBox.sendKeys("passw0rd!");
        WebElement btnNextButton2 = driver.findElement(By.cssSelector("#passwordNext > content > span"));
        btnNextButton2.click();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Click Compose Button
        //#\3a 36 > div > div
        WebElement btnComposeButton = driver.findElement(By.cssSelector("#\\3a 36 > div > div"));
        btnComposeButton.click();

        //Enter To and Subject Fields then Click on the Attach File Button
        WebElement txtToField = driver.findElement(By.id(":89"));
//        WebElement txtToField = driver.findElement(By.id(":84"));
        txtToField.sendKeys("kelly.user3@gmail.com");
        WebElement txtSubjectField = driver.findElement(By.className("aoT"));
        txtSubjectField.sendKeys("File Upload Test");
        WebElement lnkAttachFileLink = driver.findElement(By.id(":9f"));
        lnkAttachFileLink.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Specify file path to add
        String strFilePath = "TestUploadFile";
        StringSelection stringSelection = new StringSelection(strFilePath);
        //Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        //Instantiate the robot object
        Robot robot = new Robot();

        // Cmd + Tab to change the focus to the File Upload dialog window
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_TAB);
        //Wait 2 seconds
        robot.delay(2000);

        //Open the Go To dialog (Cmd + Shift + G )
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);
        robot.delay(2000);

        //Paste the clipboard value here
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(2000);

        //Hit Enter Key TWICE
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(6000);

        //Click Send Button
        WebElement btnSendButton = driver.findElement(By.cssSelector("#\\3a 7i"));
        btnSendButton.click();

    }

    //This will run at the end of this test ONCE
    @AfterClass
    public  void afterClassMethod() {
        System.out.println("This is the After Class Method");
        //close browser
        driver.quit();
    }

}
