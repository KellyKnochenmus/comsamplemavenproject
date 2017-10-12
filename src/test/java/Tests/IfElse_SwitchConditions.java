/*
*****************************************************************************
* Class Name:IfElse_SwitchConditions
* Created: 9/8/17
* Author: Kelly Knochenmus
* Purpose: A definition of if/else and switch case conditions in Java
*****************************************************************************
 */

package Tests;

public class IfElse_SwitchConditions {

    public static void main(String[] args) {

//If/Else Condition
        int score = 91;
        String grade;

        if (score > 90) {
            grade = "A";
        } else if (score > 80) {
            grade = "B";
        } else {
            grade = "C";
        }

        System.out.println("Score is: " + score);
        System.out.println("Grade is: " + grade);


//Calling a Switch/Case Condition
        int numDays = numOfDays(2016, 2);
        System.out.println("Number of days in given year and month are: " + numDays);
    }



//Switch/Case Method
    static int numOfDays(int year, int month) {
        int numDays = 0;

        switch (month) {
            case 1:
                numDays = 31;
                break;
            case 2:
                // Update the condition to match the correct calculation for leap years
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    numDays = 29;
                } else {
                    numDays = 28;
                }
                break;
            case 3:
                numDays = 31;
                break;
            case 4:
                numDays = 30;
                break;
            case 5:
                numDays = 31;
                break;
            case 6:
                numDays = 30;
                break;
            case 7:
                numDays = 31;
                break;
            case 8:
                numDays = 31;
                break;
            case 9:
                numDays = 30;
                break;
            case 10:
                numDays = 31;
                break;
            case 11:
                numDays = 30;
                break;
            case 12:
                numDays = 31;
                break;
            default:
                System.out.println("Invalid Month");
                break;
        }
        return numDays;
    }
}

