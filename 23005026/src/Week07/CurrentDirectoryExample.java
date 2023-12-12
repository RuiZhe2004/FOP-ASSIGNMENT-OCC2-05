/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week07;

/**
 *
 * @author lowji
 */
import java.io.File;

public class CurrentDirectoryExample {
    public static void main(String[] args) {
        // Get the current working directory
        String currentDirectory = System.getProperty("user.dir");

        // Specify the file name or relative path
        String fileName = "text.txt";

        // Construct the absolute file path
        String filePath = currentDirectory + File.separator + fileName;

        // Use the file path to read or write the file
        // For example:
        // BufferedReader br = new BufferedReader(new FileReader(filePath));
        // ... (rest of your file processing code)

        // Print the absolute file path for demonstration
        System.out.println("Absolute File Path: " + filePath);
    }
}
