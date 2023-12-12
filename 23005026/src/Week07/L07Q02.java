/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week07;

/**
 *
 * @author lowji
 */
import java.util.Scanner;
import java.net.URL;
import java.io.*;
import java.net.URLConnection;

public class L07Q02 {
    public static void main(String[] args) {
         try {
            URL u = new URL("http://www.fsktm.um.edu.my");
            URLConnection cnn = u.openConnection();
            InputStream stream = cnn.getInputStream();
            Scanner in = new Scanner(stream);
            
            FileWriter out = new FileWriter("index.html");
            
            while (in.hasNextLine()) {
                String line = in.nextLine();
                out.write(line);
                out.write(System.lineSeparator());
            }
            
            in.close();
            out.close();
         }
         catch (IOException e) {
            System.out.println("IO Error:" + e.getMessage());
         }
        
    }
}
