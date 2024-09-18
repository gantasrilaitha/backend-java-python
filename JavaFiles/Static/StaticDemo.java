package Static;

//import Static.MyClass; //import a specific class from the package
//import Static.*;//import all classes under the package
import classes_and_objects.Box;

public class StaticDemo {
    public static void main(String[] args) {

        MyClass mc = new MyClass();
        Box bb = new Box(2, 8);
        System.out.println(bb.volume());
        mc.xxx();// m=10,n=20
        MyClass.yyy();// yyy is static-accessing from class
        mc.display();// m=10,n=40
        MyClass mc2 = new MyClass();
        mc2.display();// m=0, n=40
    }

}
