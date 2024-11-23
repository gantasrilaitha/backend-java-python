package singleton;

public class Main {
    public static void main(String[] args) {
        // Get the single instance of Printer
        Printer printer1 = Printer.getInstance();
        Printer printer2 = Printer.getInstance();

        // Call the print method using the first instance
        printer1.print();

        // Check if both instances are the same
        if (printer1 == printer2) {
            System.out.println("printer1 and printer2 are the same instance.");
        } else {
            System.out.println("printer1 and printer2 are different instances.");
        }
    }
}
