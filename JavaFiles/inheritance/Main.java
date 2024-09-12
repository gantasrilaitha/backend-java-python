package inheritance;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Permanent("1", "ab");
        Employee e2 = new Temporary("2", "cd");
        e1.display();
        e2.display();
        Employee e3 = new Temporary();
        System.out.println(e1.calc_bonus(100));
        System.out.println(e2.calc_bonus(200));
        e3.display(); // null , null
        System.out.println(e3.calc_bonus((300)));
    }
}
