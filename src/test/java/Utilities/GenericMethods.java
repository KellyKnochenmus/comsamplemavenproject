/*
*****************************************************************************
* Class Name: Generic Methods
* Created: 9/8/17
* Author: Kelly Knochenmus
* Purpose: To store all generic methods that will be used by multiple tests
*****************************************************************************
 */

package Utilities;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {

    WebDriver driver;

    //Instatiate the WebDriver
    public GenericMethods(WebDriver driver) {
        this.driver = driver;
    }


    //Generic Method to Find Elements based on locator and type
    public WebElement getElement(String locator, String type) {
        type = type.toLowerCase();
        if (type.equals("id")) {
            System.out.println("Element found with id: " + locator);
            return this.driver.findElement(By.id(locator));
        }
        else if (type.equals("name")) {
            System.out.println("Element found with name: " + locator);
            return this.driver.findElement(By.name(locator));
        }
        else if (type.equals("xpath")) {
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElement(By.xpath(locator));
        }
        else if (type.equals("css")) {
            System.out.println("Element found with css: " + locator);
            return this.driver.findElement(By.cssSelector(locator));
        }
        else if (type.equals("classname")) {
            System.out.println("Element found with classname: " + locator);
            return this.driver.findElement(By.className(locator));
        }
        else if (type.equals("tagname")) {
            System.out.println("Element found with tagname: " + locator);
            return this.driver.findElement(By.tagName(locator));
        }
        else if (type.equals("linktext")) {
            System.out.println("Element found with link text: " + locator);
            return this.driver.findElement(By.linkText(locator));
        }
        else if (type.equals("partiallinktext")) {
            System.out.println("Element found with partial link text: " + locator);
            return this.driver.findElement(By.partialLinkText(locator));
        }
        else {
            System.out.println("Locator type not supported");
            return null;
        }
    }

    //Generic Method to Find List Elements based on locator and type
    public List<WebElement> getElementList(String locator, String type) {
        type = type.toLowerCase();
        List<WebElement> elementList = new ArrayList<WebElement>();
        if (type.equals("id")) {
            elementList = this.driver.findElements(By.id(locator));
        }
        else if (type.equals("name")) {
            elementList = this.driver.findElements(By.name(locator));
        }
        else if (type.equals("xpath")) {
            elementList = this.driver.findElements(By.xpath(locator));
        }
        else if (type.equals("css")) {
            elementList = this.driver.findElements(By.cssSelector(locator));
        }
        else if (type.equals("classname")) {
            elementList = this.driver.findElements(By.className(locator));
        }
        else if (type.equals("tagname")) {
            elementList = this.driver.findElements(By.tagName(locator));
        }
        else if (type.equals("linktext")) {
            elementList = this.driver.findElements(By.linkText(locator));
        }
        else if (type.equals("partiallinktext")) {
            elementList = this.driver.findElements(By.partialLinkText(locator));
        }
        else {
            System.out.println("Locator type not supported");
        }
        if (elementList.isEmpty()) {
            System.out.println("Element not found with " + type +": " + locator);

        } else {
            System.out.println("Element found with " + type +": " + locator);
        }
        return elementList;
    }

    //Generic Method to Determine if an Element is Present on the Webpage
    public boolean isElementPresent(String locator, String type) {
        List<WebElement> elementList = getElementList(locator, type);

        int size = elementList.size();

        if (size > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    //Generic Method to Wait for an Element to Be Visible
    public WebElement waitForElementToBeVisible(By locator, int timeout) {
        WebElement element = null;
        try {
            System.out.println("Waiting for Maximum amount of time: " + timeout +" SECONDS for element to become visible");
            WebDriverWait wait = new WebDriverWait(driver, 3);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("Element appeared on the web page");
        }catch(Exception e) {
            System.out.println("Element did not appear on the web page");
        }
        return element;
    }

    //Generic Method to Find and Click on an Element When it is Clickable
    public void clickWhenReady(By locator, int timeout) {
        WebElement element = null;
        try {
            System.out.println("Waiting for Maximum amount of time: " + timeout +" SECONDS for element to become clickable");
            WebDriverWait wait = new WebDriverWait(driver, 3);
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            System.out.println("Element clicked on the web page");
        }catch(Exception e) {
            System.out.println("Element did not appear on the web page");
        }
    }

    //Generic Method to Calculate a Random String
    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i=0; i<length; i++) {
            int index = (int) Math.random() * characters.length();
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    //Generic Method to Find Parent and Sibling Elements
//TODO
    /*XPath for the Login Link:

.//a[@href=’/sign_in’]

XPath for the parent of the Login Link:
.//a[@href=’/sign_in’]//parent::li

XPath for the Practice link:
.//a[@href=’/sign_in’]//parent::li//preceding-sibling::li

XPath for the next sibling link (specify which one with a number)
.//a[@href=’/sign_in’]//parent::li//preceding-sibling::li//following-sibling::li[1]
*/

}

    //Generic Method to Determine if an Element is Visible (Displayed) on the Webpage
//TODO
/*
WebElement textbox = driver.findElement(“By.id(“displayed-text”));

Boolean true or false:

Boolean result = textbox.isDisplayed();

if(result) {continues if true (displayed) }

if(!result) {continues if false (hidden) }

 */

/*
    //To get text from a web element:
        element.getText();

     //To get the value of an attribute for a web element:
        String strNewStringVariable = element.getAttribute("attributeName");


*/


//To find all links on a page
/*



 */
