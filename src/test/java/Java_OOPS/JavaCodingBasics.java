package Java_OOPS;

public class JavaCodingBasics {


    public static void main(String[] args) {

        //define integer variable for the sum calculation//
        int sum = 0;

        //define integer array//
        int a[] = {2, 5, 8, 7, 4};

        //expected result = 26//
        for (int i = 0; i < a.length; i++)    //will loop 5 times//
        {
            sum = sum + a[i];
            //print intermediate sum value//
            System.out.println("Intermediate sum = "+sum);

            //Print the index of the "8" value in the array
            if(a[i]==8) {
                System.out.println("Index of the '8' value in the array = "+i);
                break;
            }
        }

        //print final sum value//
        System.out.println("Final sum = "+sum);

    }
}
