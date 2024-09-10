package classes_and_objects;

public class BoxDemo {

    public static void main(String[] args) {
        Box b1 = new Box(); // default constructor(initialises all instance variables to 0)
        b1.ht = 3;
        b1.wt = 3;
        Box b2 = new Box(2, 4);
        Box b3 = new Box(1, 5);
        Box b4 = new Box(b3);
        System.out.println("volume of b1 " + b1.volume());
        System.out.println("volume of b2 " + b2.volume());
        System.out.println("volume of b4 " + b4.volume());
    }
}