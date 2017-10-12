package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;

public class ActionsSample {

public WebDriver driver;
public String strBaseUrl;
public String strBaseUrl2;
public String strBaseUrl3;
JavascriptExecutor jse;


@BeforeClass
    public void setUp() throws Exception {
    //set chrome driver settings and launch browser
    System.setProperty("webdriver.chrome.driver", "/Applications/selenium-2.53.1/chromedriver");
    driver = new ChromeDriver();

}

    @Test
    public void testMouseHoverActions() throws Exception {

        //specify url
        strBaseUrl = "http://letskodeit.teachable.com/p/practice";
        jse = (JavascriptExecutor)driver;
        //Set Implicit Wait Time to 10 Seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Maximize browser
        driver.manage().window().maximize();
        driver.get(strBaseUrl);
        jse.executeScript("window.scrollBy(0, 600)");
        Thread.sleep(2000);

        //Find the main element
        WebElement hoverMainElement = driver.findElement(By.id("mousehover"));

        //Declare the Actions class object
        Actions actionMouseHover = new Actions(driver);

        //Move the mouse to the main element
        actionMouseHover.moveToElement(hoverMainElement).perform();
        Thread.sleep(2000);

        //Find the hover sub element
        WebElement hoverSubElement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));

        //Click on the sub element
        actionMouseHover.moveToElement(hoverSubElement).click().perform();
}

    @Test
    public void testDragAndDropActions() throws Exception {
        //specify url
        strBaseUrl2 = "https://jqueryui.com/droppable/";
        driver.get(strBaseUrl2);
        Thread.sleep(2000);

        //Switch the focus to the iframe
        driver.switchTo().frame(0);

        //Find the draggable and droppable elements
        WebElement draggableElement = driver.findElement(By.id("draggable"));
        WebElement droppableElement = driver.findElement(By.id("droppable"));

        //Declare the Actions class object
        Actions actionDragAndDrop = new Actions(driver);

        //Drag and Drop Method
//        actionDragAndDrop.dragAndDrop(draggableElement, droppableElement).perform();
 //       Thread.sleep(2000);

        //Click and hold, move to element, release, build and perform Method
        actionDragAndDrop.clickAndHold(draggableElement).moveToElement(droppableElement).release().build().perform();

    }

    @Test
    public void testMoveSliderActions() throws Exception {
        //specify url
        strBaseUrl3 = "https://jqueryui.com/slider/";
        driver.get(strBaseUrl3);
        Thread.sleep(2000);

        //Switch the focus to the iframe
        driver.switchTo().frame(0);
        Thread.sleep(2000);

        //Find the slider handle element
        WebElement sliderHandleElement = driver.findElement(By.xpath(".//div[@id='slider']/span"));

        //Declare the Actions class object
        Actions actionMoveSlider = new Actions(driver);

        //Move the slider element
        actionMoveSlider.dragAndDropBy(sliderHandleElement,100,0).perform();
        Thread.sleep(2000);
    }

    @AfterClass
    public  void afterClassMethod() {
         //close browser
        driver.quit();
    }

}
