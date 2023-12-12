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

public class L07Q03 {
    public static void main(String[] args) 
            throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("C:/Users/lowji/OneDrive/Documents/NetBeansProjects/wix1002-2023-occ2-lab-occ2-05/23005026/src/Week07/file.txt");
        BufferedReader br = new BufferedReader(fr);
        FileWriter writer = new FileWriter("reversed.txt");
        System.out.println();
        
        String temp = "";
        while ((temp = br.readLine()) != null) {
            System.out.println(temp);
            String reverse = "";
            
            //Reverse the text
            for (int i = temp.length() - 1; i >= 0; i--) {
                reverse = reverse + temp.charAt(i);
            }
            
            writer.write(reverse + "\n");
        }
        System.out.println();
        fr.close();
        br.close();
        writer.close();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/lowji/OneDrive/Documents/NetBeansProjects/wix1002-2023-occ2-lab-occ2-05/23005026/reversed.txt")); 
            String line = "";
            while ((line = reader.readLine()) != null) {
                // Process each line (reversed content)
                System.out.println(line);
            }
            fr.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        

    } 
}
