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

public class L07Q04 {
    public static void main(String[] args) {
        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/Week07/Lab07/lecturer.txt"));
            String line;
            while((line = in.readLine()) != null){
                charCount += line.length();
                
                String[] words = line.split("\\s+");
                wordCount += words.length;
                
                lineCount++;
            }
            
            System.out.println("Number of char: " + charCount);
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of line: " + lineCount);
            
        } catch (IOException e){
            System.out.println("Error with file input");
        }
    }
}
