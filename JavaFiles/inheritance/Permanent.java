package inheritance;

public class Permanent extends Employee {
    Permanent() {
    }

    Permanent(String id, String name) {
        super(id, name);
    }

    int calc_bonus(int salary) {
        return 2 * salary;
    }

    void display() {// same method & same signature as in parent class==Method Overriding
                    // same method but different signature from parent class==Method Overloading
        System.out.println("permananet emp credentials" + this.id + this.name);
    }
}
