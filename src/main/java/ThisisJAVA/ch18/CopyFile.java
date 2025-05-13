package ThisisJAVA.ch18;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the file name");
        String filepath = br.readLine();

        String copy = "/Users/ahranah/Desktop/Screenshot/copy.png";

        System.out.println("Original file path is: "+filepath);
        System.out.println("Copy file path is: "+copy);

        //String ofp = "/Users/ahranah/Desktop/Screenshot/ire_3.png";

    }
}
