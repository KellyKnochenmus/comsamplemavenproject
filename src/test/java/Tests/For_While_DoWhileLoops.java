/*
*****************************************************************************
* Class Name:For_While_DoWhileLoops
* Created: 9/8/17
* Author: Kelly Knochenmus
* Purpose: A definition of For loops, while loops, and do while loops
*****************************************************************************
 */

package Tests;

public class For_While_DoWhileLoops {

    public static void main(String[] args) {

//FOR Loop
        //OPTION 1: Specify starting and ending value of loop
        for (int i = 0; i < 10; i++) {
			System.out.println("For Loop Option 1: The value of i: " + i);
		}

		//OPTION 2: Specify starting value of loop and run for all elements in an array
        int[] numbers = {10, 20, 30};
		for (int i = 0; i < numbers.length; i++) {
			System.out.println("For Loop Option 2: The value of index " + i + " is: " + numbers[i]);
		}

		//OPTION 3: To print each element in an array
        //int
        for (int number: numbers) {
            System.out.println("For Loop Option 3 - Int: The value is: " + number);
        }

        //string
        String[] cars = {"bmw", "audi", "honda"};
        for (String car: cars) {
            System.out.println("For Loop Option 3 - String: The value is '" + car + "'");
        }

        System.out.println("*********************************************");
        /*OUTPUT:
        For Loop Option 1: The value of i: 0
        For Loop Option 1: The value of i: 1
        For Loop Option 1: The value of i: 2
        For Loop Option 1: The value of i: 3
        For Loop Option 1: The value of i: 4
        For Loop Option 1: The value of i: 5
        For Loop Option 1: The value of i: 6
        For Loop Option 1: The value of i: 7
        For Loop Option 1: The value of i: 8
        For Loop Option 1: The value of i: 9
        For Loop Option 2: The value of index 0 is: 10
        For Loop Option 2: The value of index 1 is: 20
        For Loop Option 2: The value of index 2 is: 30
        For Loop Option 3 - Int: The value is: 10
        For Loop Option 3 - Int: The value is: 20
        For Loop Option 3 - Int: The value is: 30
        For Loop Option 3 - String: The value is 'bmw'
        For Loop Option 3 - String: The value is 'audi'
        For Loop Option 3 - String: The value is 'honda'
         */

//WHILE Loop
        int i = 1;

        //this loop will start with i=1, immediately increase it it to i=2, the if i < 20 BUT NOT 17, it will print
        //when i = 17, it will not print the line, and will instead continue to the next iteration
		while (i < 20) {
			//System.out.println(i);
			i++;
			if (i == 17) {
				continue;
			}
			System.out.println("Value of i " + i);
		}
		System.out.println("Outside loop...");
        System.out.println("*********************************************");

        /*OUTPUT:
        Value of i 2
        Value of i 3
        Value of i 4
        Value of i 5
        Value of i 6
        Value of i 7
        Value of i 8
        Value of i 9
        Value of i 10
        Value of i 11
        Value of i 12
        Value of i 13
        Value of i 14
        Value of i 15
        Value of i 16
        Value of i 18
        Value of i 19
        Value of i 20
        Outside loop...
		 */

//DO WHILE Loop
        int j = 1;

        //this loop will start with i=1, will print, will then increase i to 2
        //will then evaluate if i < 10 and if true, will continue the loop until i = 10

        do {
            System.out.println("do while loop, j = "+j);
            j++;

        } while (j < 10);

        /*OUTPUT:
        do while loop, j = 1
        do while loop, j = 2
        do while loop, j = 3
        do while loop, j = 4
        do while loop, j = 5
        do while loop, j = 6
        do while loop, j = 7
        do while loop, j = 8
        do while loop, j = 9
        */
    }
}


