package multithreading;

public class RunnableThread implements Runnable {
    // priority lies in range[1,10];
    // IllegalArgumrntException (runtime exception) thrown of priority is out of
    // range [1,10].
    public static final int MIN_PRIORITY = 1;
    public static final int NORM_PRIORITY = 5;// default priority
    public static final int MAX_PRIORITY = 10;

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " ");
        }
    }

    public void start() {
        // logic
        run();
    }

}
