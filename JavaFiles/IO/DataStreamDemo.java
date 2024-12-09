package IO;

import java.io.*;

public class DataStreamDemo {
    public static void main(String[] args) throws IOException { // IOException: Input/Output operation fails or is interrupted. 
        FileReader reader = new FileReader("D:/BACKEND-JAVA_PYTHON/backend-java-python/JavaFiles/IO/file2.txt");
        int n;
        while ((n = reader.read()) != -1) {// -1 indicates EOF
            System.out.println((char) n);
        }
        reader.close();
    }
    /*
     * public static void main(String[] args) throws IOException {
     * FileWriter fw = new FileWriter("file3.txt");
     * BufferedWriter bw = new BufferedWriter(fw);
     * String sw = "JAVA OOPS";
     * bw.write(sw);
     * System.out.println("file3 created");
     * bw.close();
     * fw.close();
     * 
     * }
     */

    /*
     * public static void main(String[] args) throws IOException {
     * // FileOutputStream fos = new FileOutputStream("file2.txt");
     * // DataOutputStream dos = new DataOutputStream(fos);
     * FileInputStream fis = new
     * FileInputStream("backend-java-python/JavaFiles/IO/file2.txtfile2.txt");
     * DataInputStream dis = new DataInputStream(fis);
     * int n = dis.readInt();
     * System.out.println(n);// 10
     * String s2 = dis.readUTF();
     * System.out.println(s2);// Hello
     * System.out.println(dis.readDouble());// 2.13
     * // dos.writeInt(10);
     * // dos.writeUTF("Hello");
     * // dos.writeDouble(2.13);
     * // System.out.println("file2 created");
     * // dos.close();
     * // fos.close();
     * dis.close();
     * fis.close();
     * }
     */

}
