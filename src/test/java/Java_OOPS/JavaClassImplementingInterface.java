package Java_OOPS;

public class JavaClassImplementingInterface implements Interfaces {
 //now this class is responsible to implement ALL of the methods in the Interfaces class

    //Main Method to run the test
    public static void main(String[] args) {
        //Create Object for the class
        JavaClassImplementingInterface objClass1 = new JavaClassImplementingInterface();
        objClass1.paycreditcard();
        objClass1.StandAloneMethod();
        Interfaces objClass2 = new JavaClassImplementingInterface();
        objClass2.checkingbalance();    //cannot access the StandAloneMethod with this object.
    }

    @Override
    public void paycreditcard() {
        //write code here
        System.out.println("paycreditcard method implemented");
    }

    @Override
    public void transferbalance() {
        //write code here
        System.out.println("transferbalance method implemented");
    }

    @Override
    public void checkingbalance() {
        //write code here
        System.out.println("checkingbalance method implemented");
    }

    public void StandAloneMethod() {
        System.out.println("StandAloneMethod method only exists in the Java Class");
    }
}
