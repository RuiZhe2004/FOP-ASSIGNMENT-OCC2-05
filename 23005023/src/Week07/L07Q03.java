/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week07;

/**
 *
 * @author szeyu
 */
import java.io.*;

public class L07Q03 {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/Week07/Lab07/order.txt"));
            PrintWriter out = new PrintWriter(new FileOutputStream("src/Week07/Lab07/reverse.txt"));
            String line;
            while((line = in.readLine()) != null){
                StringBuilder reverseBuilder = new StringBuilder(line);
                String reversedStr = reverseBuilder.reverse().toString();
                out.println(reversedStr);
            }
            
            in.close();
            out.close();
        } catch (IOException e){
            System.out.println("Error with file input");
        }
    }
}
