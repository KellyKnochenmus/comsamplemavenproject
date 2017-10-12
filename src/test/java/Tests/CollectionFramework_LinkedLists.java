package Tests;

import java.util.ArrayList;
import java.util.LinkedList;

public class CollectionFramework_LinkedLists {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        //Define LinkedList (Default size will be 10 elements)
        LinkedList<String> lstLinkedList = new LinkedList<String>();

        //Add items to the linked list
        lstLinkedList.add("Item1");
        lstLinkedList.add("Item2");
        lstLinkedList.add("Item3");

        //Get the size of the linked list
        int intListSize = lstLinkedList.size();
        System.out.println("Size of the linked list is " + intListSize);

        //Get Item from Linked List based on index
        System.out.println("The item on index 1 is '" + lstLinkedList.get(1) + "'");

        //Iterate through the array
        System.out.println("\nIterating through the linked list");
        for (int i = 0; i < intListSize; i++) {
            System.out.println("Item On Index # " + i + " is '" + lstLinkedList.get(i) + "'");
        }

        //Another way to iterate through the loop (more efficient code)
        System.out.println("\nSecond way of iterating through the linked list");
        for (String strItem : lstLinkedList) {
            System.out.println("Item is " + strItem);
        }

        //Remove item from the list based on index
        // (will remove the last item in the list)
        lstLinkedList.remove(intListSize - 1);
        // (will remove the item at index 0
        lstLinkedList.remove(0);
        System.out.println("\nSecond way of iterating through the linked list after two items are removed");
        for (String strItem : lstLinkedList) {
            System.out.println("Item is " + strItem);
        }

        long endTime = System.currentTimeMillis();

        //Calculate duration
        long duration = endTime - startTime;
        System.out.println("Duration of the Linked List is = " + duration +" ms");
    }
}
