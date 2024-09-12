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

    void display() {
        System.out.println("permananet emp credentials" + this.id + this.name);
    }
}
