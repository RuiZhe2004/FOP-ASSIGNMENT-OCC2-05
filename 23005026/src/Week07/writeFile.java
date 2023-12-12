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

public class writeFile {
    public static void main(String[] args) {
        try {
            // Create an array to store course codes and names
            String[][] persons = {
                    {"John", "25", "M"},
                    {"Alice", "23", "F"},
                    {"Jane", "30", "F"},
                    {"Stuart", "42", "M"}
            };

            // Create DataOutputStream to write data to a binary file
            DataOutputStream outStream = new DataOutputStream(new FileOutputStream("person.dat"));
            
            outStream.writeInt(persons.length);

            for (String[] person : persons) {
                    //Write name, age & gender
                    outStream.writeUTF(person[0]);
                    outStream.writeInt(Integer.parseInt(person[1])); // Write course code or name
                    outStream.writeChar(person[2].charAt(0));
            }

            // Close the DataOutputStream
            outStream.close();

            System.out.println("Course data written to person.dat.");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing person data to file.");
        }        
    }
}
