/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week07;

/**
 *
 * @author lowji
 */
import java.io.*;
import java.util.*;

public class L07Q04 {
    public static void main(String[] args) {
        try {
            int countCharacter = 0;
            int countWord = 0;
            int countLines = 0;
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\lowji\\OneDrive\\Documents\\NetBeansProjects\\wix1002-2023-occ2-lab-occ2-05\\23005026\\src\\Week07\\text_1.txt"));
            
            String line = br.readLine();
            while(line != null) {
                countLines++;
                String[] words = line.split("\\s+");
                countWord += words.length;
                
                for (String word : words) {
                    countCharacter += word.length();
                    countCharacter += word.length() -1;
                }
                
                line = br.readLine();
            }
            
            br.close();
            System.out.println("No of characters: " + countCharacter);
            System.out.println("No of words: " + countWord);
            System.out.println("No of lines: " + countLines);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
