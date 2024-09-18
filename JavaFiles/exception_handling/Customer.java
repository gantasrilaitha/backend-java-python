package exception_handling;

public class Customer {

    void setAge(int age) throws AgeException {
        if (age < 18 || age > 60) {
            throw new AgeException("age not in range");
        } else {
            System.out.println("age in range");
        }

    }
}
