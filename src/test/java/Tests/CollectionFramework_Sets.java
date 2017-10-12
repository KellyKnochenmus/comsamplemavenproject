package Tests;

import java.util.*;

public class CollectionFramework_Sets {

    public static void main(String[] args) {

        //Create a HashSet Type of Set - Does not maintain any order for the elements
        Set<String> hashSetElement = new HashSet<String>();
        //Add values to Set
        hashSetElement.add("Item2");
        hashSetElement.add("Item3");
        hashSetElement.add("Item1");
        hashSetElement.add("Item2");

        System.out.println(hashSetElement);

        System.out.println("Iteration Loop for HashSet Set");
        for(String strItem: hashSetElement) {
            System.out.println(strItem);
        }

        //LinkedHashSet – it maintains the order in which the elements are added
        Set<String> linkedHashSetElement = new LinkedHashSet<String>();
        linkedHashSetElement.add("Item2");
        linkedHashSetElement.add("Item3");
        linkedHashSetElement.add("Item1");
        linkedHashSetElement.add("Item2");

        System.out.println(linkedHashSetElement);

        System.out.println("Iteration Loop for LinkedHashSet Set");
        for(String strItem: linkedHashSetElement) {
            System.out.println(strItem);
        }
        //TreeSet - it maintains the natural sorting order (numerical, alphabetical)
        Set<String> treeSetElement = new TreeSet<String>();
        treeSetElement.add("Item2");
        treeSetElement.add("Item3");
        treeSetElement.add("Item1");
        treeSetElement.add("Item2");

        System.out.println(treeSetElement);

        System.out.println("Iteration Loop for Tree Set");
        for(String strItem: treeSetElement) {
            System.out.println(strItem);
        }

        //Create an Array List
        List<String> arrList = new ArrayList<String>();
        //Add values to List
        arrList.add("Item1");
        arrList.add("Item2");
        arrList.add("Item3");
        arrList.add("Item2");

        System.out.println(arrList);





    }
}
