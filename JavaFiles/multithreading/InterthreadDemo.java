package multithreading;

/*
 * INTERTHREAD COMMUNICATION
 * --------------------------
 * THREAD1->TASK->RESULT->THREAD2
 * 
 * Done using wait(),notify(),notifyAll methods
 * wait(): block all other threads & inform them using notify()(if only 1 thread present) or notifyAll()(if more than 1 thred present)
 * These  methods need to be used in synchronized context only,else it throws "IllegalMonitorStateException"
 */
public class InterthreadDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadSum ts = new ThreadSum();
        ts.start(); // sum=0 since cpu 1st gives time to main thread
        synchronized (ts) {
            ts.wait();
        }
        System.out.println("sum is " + ts.sum);
    }
}
