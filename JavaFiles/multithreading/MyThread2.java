package multithreading;

public class MyThread2 extends Thread {
    Table t;

    MyThread2(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(6);

        /*
         * Thread tt = Thread.currentThread();
         * tt.setName("MY SECOND THREAD");
         * for (int i = 10; i >= 1; i--) {
         * System.out.println(tt.getName() + ":" + i);
         * try {
         * Thread.sleep(1000);
         * } catch (InterruptedException e) {
         * e.printStackTrace();
         * }
         * }
         */
    }
}
