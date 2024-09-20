package IO;

import java.io.*;

//Serialzable is Marker Interface(doesnt contain any methods)
public class Book implements Serializable {
    int bno;
    String bname;

    public Book() {

    }

    public Book(int bno, String bname) {
        this.bno = bno;
        this.bname = bname;
    }

    public String toString() {
        return "Book No: " + bno + ", Book Name: " + bname;
    }

}
