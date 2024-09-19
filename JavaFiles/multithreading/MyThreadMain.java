package multithreading;

public class MyThreadMain {
    public static void main(String[] args) {
        Table t = new Table();
        MyThread t1 = new MyThread(t);
        t1.start();
        MyThread2 t2 = new MyThread2(t);
        t2.start();

        /*
         * // main-thraed group
         * MyThread t = new MyThread();// Thread-0
         * t.start();// creates thread & invokes the run()
         * MyThread2 t1 = new MyThread2();// we dont know which thread will be running
         * 1st since it depends on cpu
         * // availability
         * t1.start();// Thread-1
         * // [#21,Thread-0,5,main]=[thread no.,thraed name, priority, thread group]
         */
    }

}
