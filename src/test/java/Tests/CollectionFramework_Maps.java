package Tests;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CollectionFramework_Maps {

    public static void main(String[] args) {
        //Create a HashMap Map element
        Map<Integer, String> hashMapElement = new HashMap<Integer, String>();

        //Add items to the map with key and value (key must be unique)
        hashMapElement.put(1, "Item2");
        hashMapElement.put(6, "Item3");
        hashMapElement.put(4, "Item1");
        hashMapElement.put(8, "Item2");

        //get the value of the element with a specified key
        String strValueofHashMap = hashMapElement.get(1);
        System.out.println("Value of Key Item 1 is '"+strValueofHashMap + "'");

        //get the value of the element with a specified key that does not exist, will return null
        String strValueofHashMap2 = hashMapElement.get(2);
        System.out.println("Value of Key Item 2 is '"+strValueofHashMap2 + "'");

        //If you repeat a key, it will be replaced by the latest value for that key
        String strValueofHashMap3 = hashMapElement.get(1);
        System.out.println("Beginning Value for Key Item 1 is '"+strValueofHashMap3 + "'");
        hashMapElement.put(1, "NewItem");
        String strValueofHashMap4 = hashMapElement.get(1);
        System.out.println("New Value for Key Item 1 is '"+strValueofHashMap4 + "'");

        //Iterate through all of the entries in the HashMap Element (Key and Value)
        System.out.println("Iterate through all entries in the HashMap, Key and Value");
        for(Map.Entry<Integer, String> itemPairEntry: hashMapElement.entrySet()) {
            int intKey = itemPairEntry.getKey();
            String strValue = itemPairEntry.getValue();
            System.out.println("Key: " + intKey + ", value: " + strValue);
        }

        //Iterate through just the key set
        System.out.println("Iterate through all entries in the HashMap, using the Key Set");
        for(Integer intKey: hashMapElement.keySet()) {
            String strValue = hashMapElement.get(intKey);
            System.out.println("Key: " + intKey + ", value: " + strValue);
        }

        //Create a LinkedHashMap Map element - maintains the order in which the elements are added
        Map<Integer, String> linkedHashMapElement = new LinkedHashMap<Integer, String>();
        linkedHashMapElement.put(1, "Item2");
        linkedHashMapElement.put(6, "Item3");
        linkedHashMapElement.put(4, "Item1");

        //Iterate through just the key set
        System.out.println("Iterate through all entries in the LinkedHashMap, using the Key Set");
        for(Integer intKey: linkedHashMapElement.keySet()) {
            String strValue = linkedHashMapElement.get(intKey);
            System.out.println("Key: " + intKey + ", value: " + strValue);
        }

        //Create a TreeMap Map element - maintains the natural sorting order (numerical, alphabetical)
        Map<Integer, String> treeMapElement = new TreeMap<Integer, String>();
        treeMapElement.put(1, "Item2");
        treeMapElement.put(6, "Item3");
        treeMapElement.put(4, "Item1");

        //Iterate through just the key set
        System.out.println("Iterate through all entries in the TreeMap, using the Key Set");
        for(Integer intKey: treeMapElement.keySet()) {
            String strValue = treeMapElement.get(intKey);
            System.out.println("Key: " + intKey + ", value: " + strValue);
        }
    }
}
