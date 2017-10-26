package AddlJavaCode;

public class Car {

    //ATTRIBUTES

    //color
    private String color;
    //make
    private String make;
    //model
    private String model;
    //year
    private int year;


   //METHODS/BEHAVIORS

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year < 2000) {
            this.year = year;
        } else {
            System.out.println("This is not a valid vehicle year");
        }
    }

    public void increaseSpeed() {
        System.out.println("Increasing the speed");
    }


    //Setter to set the make of the vehicle//
    public void setMake(String strMake) {
        make = strMake;
    }

    //Getter to get the value of the make attribute//
    public String getMake() {
        return this.make;
    }

}
