/*
*****************************************************************************
* Class Name:VariableTypesInJava
* Created: 9/8/17
* Author: Kelly Knochenmus
* Purpose: A definition of all of the variable types in Java, plus Strings
*****************************************************************************
 */

package Tests;

public class VariableTypesInJava_PlusStrings {

//MOST COMMON VARIABLES:
// int = integer = numbers
// string = text
// boolean = true or false


    //Variables
    public static void main(String[] args) {
		/*
		 * Byte
		 * Min: -128
		 * Max: 127
		 * Default: 0
		 */
            byte myByte = 100;
            System.out.println("Byte Value: " + myByte);

		/*
		 * Short
		 * Min: -32,768
		 * Max: 32,767
		 * Default: 0
		 */
            short myShort = 10000;
            System.out.println("Short Value: " + myShort);

		/*
		 * int
		 * Min: -2,147,483,648
		 * Max: 2,147,483,647
		 * Default: 0
		 */
            int MyInt = 10000000;
            System.out.println("Int Value: " + MyInt);

		/*
		 * long
		 * Min: -2^63
		 * Max: 2^63 -1
		 * Default: 0
		 */
            long myLong = 100000000000000000L;
            System.out.println("Long Value: " + myLong);

		/*
		 * float
		 * Default: 0.0f
		 */
            float myFloat = 20.0f;
            System.out.println("Float Value: " + myFloat);

		 /*
		  * double
		  * Default: 0.0d
		  */
            double myDouble = 21.0;
            System.out.println("Double Value: " + myDouble);

		 /*
		  * boolean
		  * false and true
		  * Default: false
		  */
            boolean myBoolean = true;
            System.out.println("Boolean Value: " + myBoolean);

		 /*
		  * char
		  * Min: 0
		  * Max: 65,535
		  */
            char myChar = 'a';
            System.out.println("Char Value: " + myChar);

        System.out.println("*************************************************");

//Strings

//Most Common String Modifiers:
// .contains = searches for the value anywhere in the string
// .equals = must match exactly
// .trim = removes leading and trailing spaces
// .substring = pulls a substring out of a string, based on starting position and length of substring
// .toLowerCase or .toUpperCase = to change the capitalization of the string

        String str = "This is the test string";

        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = "Welcome";
        String str4 = "";
        String str5 = "            Spaces all around     ";
        String str6 = "Hello";

        System.out.println("Length of the string is: " + str.length());
        System.out.println("Character at index 2 is: " + str.charAt(2));
        System.out.println(str.concat(" This is the appended string"));
        System.out.println("Contains check 1: " + str.contains("is"));
        System.out.println("Contains check 2: " + str.contains("si"));
        System.out.println("Starts with check 1: " + str.startsWith("This"));
        System.out.println("Starts with check 2: " + str.startsWith("is"));
        System.out.println("Ends with check 2: " + str.endsWith("string"));
        System.out.println("Ends with check 2: " + str.endsWith("is"));
        System.out.println("Check contents are equal: " + str1.equals(str2));
        System.out.println("Check contents are equal: " + str1.equals(str3));
        System.out.println("Index of 'h' is: " + str.indexOf('h'));
        System.out.println("Check if string is empty 1: " + str.isEmpty());
        System.out.println("Check if string is empty 2: " + str4.isEmpty());
        System.out.println("Trim the leading and trailing spaces: " + str5.trim());
        System.out.println("Replace Example: " + str6.replace('e', 'a'));

        System.out.println("Substring Example 1: " + str.substring(5));
        System.out.println("Substring Example 2: " + str.substring(5, 10));

        char[] charArray = str.toCharArray();
        for (int i = 0; i<charArray.length; i++) {
            System.out.println("Index " + i + " is: " + charArray[i]);
        }

        System.out.println("Lower case: " + str.toLowerCase());
        System.out.println("Upper case: " + str.toUpperCase());
    }
}


