package IO;

import java.io.*;

/*
Searlisation: writing objects onto datafile
Desearlisation: reading objects from datafile
ObjectOutputStream: write an object onto datafile using writeObject()
ObjectInputStream: read an object from datafile using readObject()
Searlizable Interface: to srialise an object of a class, else throws "NotSerializableException"
 */
public class SerialisationDemo {
    public static void main(String[] args) throws Exception {
        // Serialization
        FileOutputStream fos = new FileOutputStream("boox.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Book book1 = new Book(124, "Oreilly");
        oos.writeObject(book1);
        oos.close();
        fos.close();

        // Deserialzation
        FileInputStream fis = new FileInputStream("boox.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Book b1 = (Book) ois.readObject();
        System.out.println("Deserialized book: " + b1);// due to toString() invoked implicitly: IO.Book@b1a58a3
        ois.close();
        fis.close();
    }

}
