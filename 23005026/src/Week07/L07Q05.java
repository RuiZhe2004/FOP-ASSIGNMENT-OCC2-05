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
public class L07Q05 {
    public static void main(String[] args) {
        try {
            DataInputStream inStream = new DataInputStream(new FileInputStream("person.dat"));
            
            int length = inStream.readInt();
            
            String[][] persons = new String[length][3];
            
            //Read each name, age & gender from dat. file
            for (int i = 0; i < length; i++) {
                persons[i][0] = inStream.readUTF();
                persons[i][1] = String.valueOf(inStream.readInt());
                persons[i][2] = String.valueOf(inStream.readChar());
            }
            
            //Close the DataInputStream
            inStream.close();
            
            //Bubble sort
            for(int pass = 0; pass < length - 1; pass++) {
                for(int j = 0; j < length - pass - 1; j++) {
                    if(persons[j][0].compareTo(persons[j+1][0]) > 0) {
                        String[] temp = persons[j];
                        persons[j] = persons[j+1];
                        persons[j + 1] = temp;
                    }
                }
            }
            
            //Arrays.toString(persons);
            //Print name, age & gender
            for (int i = 0; i < length; i++) {
                System.out.println("Name: " + persons[i][0]);
                System.out.println("Age: " + persons[i][1]);
                System.out.println("Gender: " + (persons[i][2].equals("M")? "Male": "Female"));
                System.out.println("-----------------------");                        
            }
            
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading person data from file.");
        }
    }
}
