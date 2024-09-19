package multithreading;

public class ThreadSum extends Thread {
    int sum;

    public void run() {
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        synchronized (this) {
            notify();
        }
    }

}
