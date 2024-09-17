package Static;

//static: accessed by with /without having a class instance(i.e object of class)
//        : memory allocated only 1 time
//        : any change made in static variables is reflected in all class instances
//instance: accessed only by objects
//         : memory allocated for each instance of class
//          :any change made is not reflected in other instances
public class MyClass {
    int m;// instance variable or non-static variable
    static int n;// class variable or static variable

    void xxx() { // instance method or non-static method
        m = 10;
        n = 20;
    }

    static void yyy() {// class method or static method
        // m = 30;// error: static mehods can access only other static members
        n = 40;
    }

    void display() {
        System.out.println("m=" + m + " " + "n=" + n);
    }
}
