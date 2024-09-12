package inheritance;

public class Temporary extends Employee {
    Temporary() {
    }

    Temporary(String id, String name) {
        super(id, name);
    }

    int calc_bonus(int salary) {
        return 3 * salary;
    }

    void display() {
        System.out.println("temporary emp credentials" + this.id + this.name);
    }
}
