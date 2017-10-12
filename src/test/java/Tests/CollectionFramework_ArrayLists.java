package Tests;

import java.util.ArrayList;

public class CollectionFramework_ArrayLists {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        //Define ArrayList (Default size will be 10 elements)
        ArrayList<String> arrStringArrayList = new ArrayList<String>();

        //Add items to the array
        arrStringArrayList.add("Item1");
        arrStringArrayList.add("Item2");
        arrStringArrayList.add("Item3");
        //add item to a specific index position in the array
        arrStringArrayList.add(3,"Item4");

        //Get the size of the array
        int arraySize = arrStringArrayList.size();
        System.out.println("Size of the array list is "+arraySize);

        //Get Item from Array based on index
        System.out.println("The item on index 1 is '"+arrStringArrayList.get(1)+"'");

        //Iterate through the array
        System.out.println("\nIterating through the array");
        for(int i=0; i<arraySize; i++) {
            System.out.println("Item On Index # " + i + " is '" + arrStringArrayList.get(i) + "'");
        }

        //Another way to iterate through the loop (more efficient code)
        System.out.println("\nSecond way of iterating through the array");
        for (String strItem : arrStringArrayList) {
            System.out.println("Item is "+strItem);
        }

        //Remove item from the list based on index
        // (will remove the last item in the list)
        arrStringArrayList.remove(arraySize-1);
        // (will remove the item at index 0
        arrStringArrayList.remove(0);
        System.out.println("\nSecond way of iterating through the array after two items are removed");
        for (String strItem : arrStringArrayList) {
            System.out.println("Item is "+strItem);
        }

        long endTime = System.currentTimeMillis();

        //Calculate duration
        long duration = endTime - startTime;
        System.out.println("Duration of the Linked List is = " + duration +" ms");
    }
}

