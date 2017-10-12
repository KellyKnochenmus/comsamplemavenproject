package Tests;

public class WorkingWithDropDownListElements {

    //TODO

    /*
    import org.openqa.selenium.support.us.Select;

WebElement element = driver.findElement(By.id(“id”));

Select sel = new Select(element);

OR

Select sel = new Select(driver.findElement(By.id(“id”)));

Then to use the element:

Select by Index
sel.selectByIndex(2);

Select by Value
sel.selectByValue(“honda”);

Select by Visible Text
sel.selectByVisibleText(“Honda”);

To find all items in a drop down list element:

List<WebElement> options = sel.getOptions();

int size = options.size();

To get the text of each element:

for(int i=0; i<size; i++) {
	String optionText = options.get(i).getText();
}

     */


    //Multiple-Select Drop-down list elements
    /*
    import org.openqa.selenium.support.us.Select;

	//Define element
	WebElement element = driver.findElement(By.id.(“id”));

	//Create Select object
	Select sel = new Select(element);

	//Select an option in the list by value
	sel.selectByValue(“value”);

	//De-Select an option in the list by value
	sel.deselectByValue(“value”);

	//Select an option in the list by index
	sel.selectByIndex(0);

	//Select an option in the list by visible text
	sel.selectByVisibleText(“Text”);

	//Print all selected options
	List<WebElement> selectedOptions = sel.getAllSelectedOptions();
	for(WebElement option : selectedOptions) {
		System.out.println(option.getText());
	}

	//De-Select all option in the list
	sel.deselectAll();


     */








}
