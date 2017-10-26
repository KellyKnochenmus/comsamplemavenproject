package AddlJavaCode;

public class CarDemoTestScript {

    public static void main(String[] args) {


        //Create and initialize the object (calls to the Car.java class file)
        Car bmw = new Car();

        //Set the Make Attribute by calling the "Setter" method
        bmw.setMake("Honda");
        System.out.println("Get Make Value = " + bmw.getMake());


        Car benz = new Car();
        benz.setYear(2016);
        //benz.year=5555;
        System.out.println("Get Year Value = " + benz.getYear());

    }

}
