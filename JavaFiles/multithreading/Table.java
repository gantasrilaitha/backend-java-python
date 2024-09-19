package multithreading;

public class Table {
    // making methods synchronous using synchronozed
    synchronized void printTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + "*" + i + "=" + (n * i));
        }
    }

}
