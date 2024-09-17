package Static;

public class StaticDemo {
    public static void main(String[] args) {
        MyClass mc = new MyClass();
        mc.xxx();// m=10,n=20
        MyClass.yyy();// yyy is static-accessing from class
        mc.display();// m=10,n=40
        MyClass mc2 = new MyClass();
        mc2.display();// m=0, n=40
    }

}
