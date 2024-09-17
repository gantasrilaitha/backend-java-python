package Scanner;

import java.util.Scanner;

// nextInt() =>to read int value from stdin
// nextLong() =>"...." long"...."
// nextFloat() =>"...." float"...."
// nextDouble() =>"...."double"...."
// next() =>"...." read String value without spaces"...."
// nextLine() =>"...." read String value with spaces"...."

public class scanner_class {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter len");
        int l = s.nextInt();
        System.out.println("Enter breadth");
        int b = s.nextInt();
        System.out.println(l * b);
    }
}