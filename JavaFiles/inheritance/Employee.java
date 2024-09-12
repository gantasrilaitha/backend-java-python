package inheritance;

// only single inheritance allowed in java
//a class with abstract method=Abstact Class
abstract class Employee { // abstract class should have atleast 1 abstract method.
    String id, name;

    Employee() {
    }

    Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {// if defined in child classes==Polymorphism
        System.out.println(this.id + this.name);
    }

    // definition of abstract method is specified in child classes.
    abstract int calc_bonus(int salary);
}
