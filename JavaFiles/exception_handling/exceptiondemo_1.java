package exception_handling;

public class exceptiondemo_1 {
    public static void main(String[] args) { // java exceptiondemo_1.java 40 5--for cml args

        try {
            int x1 = Integer.parseInt(args[0]);
            int x2 = Integer.parseInt(args[1]);
            int res = x1 / x2;
            System.out.println(res);
            // int b = System.in.read(); // checked exceptions
        } catch (ArithmeticException e) {
            System.out.println("Division by 0 not possible");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Require only 2 numbers");
        } catch (NumberFormatException e) {
            System.out.println("Enter only numbers");
        } catch (RuntimeException e) {
            System.out.println("Runtime exception occured");
        } catch (Exception e) {// catch any type of exception
            // Exception is superclass of other types of exceptions
            System.out.println("Exception occured");
        }
        // catch (IOException e) {
        // e.printStackTrace();
        // }
        finally {
            System.out.println("program executed");
        }
    }
}
