/*
*****************************************************************************
* Class Name:Arrays_ListElements
* Created: 9/8/17
* Author: Kelly Knochenmus
* Purpose: A definition of arrays and list elements in Java
*****************************************************************************
 */


//ARRAYS - can be int or String
//          index starts at 0
//          Common actions against arrays:
//              arrayName.length;   finds how many elements are in the array
//              use in a for loop to iterate through all the elements in the array



package Tests;

import java.util.Arrays;

public class Arrays_ListElements {

    public  void Arrays() {

//NOTE: Index value starts at 0 for an array
//      Arrays can be integer or string types

    //Array Definition - METHOD #1
        int[] myIntArray1;
        myIntArray1 = new int[10];
        myIntArray1[0] = 100;
		myIntArray1[1] = 90;

    //Array Definition - METHOD #2 (preferred)
        int[] myIntArray2 = {100, 90};


    //Print the value of a specific array element based on index
        System.out.println("0 index: " + myIntArray1[0]);
        System.out.println("1st index: " + myIntArray1[1]);


     //String arrays
        String[] myStringArray1 = {"bmw", "audi", "honda"};
        System.out.println("0 index: " + myStringArray1[0]);
        System.out.println("1st index: " + myStringArray1[1]);
        System.out.println("2nd index: " + myStringArray1[2]);


    //Finding the number of elements in an array
        int len1 = myIntArray1.length;
        int len2 = myStringArray1.length;

        System.out.println("Int array length: " + len1);
        System.out.println("String array length: " + len2);


   //Loop through the elements of the array
        for (int i = 0; i < len1; i++){
            System.out.println(myIntArray1[i]);
        }

    //Sort an array
        Arrays.sort(myIntArray1);

    //Copy an array to a new one
        //System.arraycopy(src, srcPos, dest, destPos, length);

    }


    public void ListElements() {
//TODO

        /*
        List<WebElement> radioButtons = driver.findElements(By.xpath(“//”));
To find the number of elements in the list:

Int size = radioButtons.size();

Then use a for loop to cycle through the list of elements.

Example:

For (int i=0; i<size; i++) {
	isChecked = radioButtons.get(i).isSelected();

	if(!isChecked) {
		radioButtons.get(i).click();
}

         */




    }


}
