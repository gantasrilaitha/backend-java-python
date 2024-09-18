package exception_handling;

public class custom_exception {
    public static void main(String[] args) {
        Customer c = new Customer();
        try {
            c.setAge(11);
        } catch (AgeException e) {
            System.out.println(e);// invokes toString() implicitly
            // e.getMessage()-->returns only the msg when exception is handled
            // e.printStrackTrace()-->displays stack history that caused the exception to
            // occur
        }
    }
}
