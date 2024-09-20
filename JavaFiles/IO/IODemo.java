package IO;

import java.io.*;

/*IO=Input Output
-used for new data files
-writing data onto data files
opening existing data files
reading data from data files
closing the files

STREAM:flow of data(byte stram & char stream)
 *
 */

//output stream -->for reading
//input stream -->for writing
public class IODemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("file1.txt");
        BufferedOutputStream baos = new BufferedOutputStream(fos);
        FileInputStream fis = new FileInputStream("file1.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        int size = fis.available();
        // byte[] buffer=new byte(size);
        // fis.read(buffer);
        // String sr=new String(buffer);//converts byte[] to string
        String s = "java is oo language";
        baos.write(s.getBytes());
        fos.write(s.getBytes());
        System.out.println("file created");
        baos.close();
        fos.close();
        bis.close();
    }
}
