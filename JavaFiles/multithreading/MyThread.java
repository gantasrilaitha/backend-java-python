package multithreading;

//create threads
//1. by creating a class which extends Thread Class->NOT RECOMENDED (the subclass running a thread cant inherit from main Thread class which is aldredy running another task/thread)
//2. by creating a class which implments Runnable Interface

//Thread Class Methods
//1.Thread currentThread(): details of current thread
//2.void start(): thread is triggered & is ready to run(runnable state--thread is waiting for cpu time)
//3.void run(): thard is running after it gets dedicated cpu time(running state)
//4.void setName(String name): to set name of thread
//5.String getName(): get name of the thread
//6.void setPriority(int): set the priority of thread
//7.int getPriority():get priority of the thread
//8.void sleep(long) : sleep duration 
//9.String toString(): to get string format of a object

//Ways to stop a running thread
//1. terminate run() method
//2. have boolean variable deciding on continuation of thread
//3. set() method that can be invoked by other thread

public class MyThread extends Thread {// Thraed belongs to java.lang package
    // Thread is a concrete class(class that is fully implemented)
    Table t;

    MyThread(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(5);

        /*
         * System.out.println("I am a thread");
         * Thread tt = Thread.currentThread();// [#21,Thread-0,5,main]
         * System.out.println(tt);
         * tt.setName("MY FIRST THREAD");
         * 
         * for (int i = 1; i <= 10; i++) {
         * System.out.println(tt.getName() + ":" + i);
         * try {
         * Thread.sleep(1000);
         * } catch (InterruptedException e) {
         * e.printStackTrace();
         * }
         * }
         */

        /*
         * System.out.println(tt);
         * System.out.println(tt.getName());// MY FIRST THREAD
         * tt.setPriority(7);
         * System.out.println(tt);// [#21,MY FIRST THREAD,7,main]
         * System.out.println(tt.getPriority());// 7
         */
    }
}
