/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecars;

import java.io.*;
import javax.swing.JFileChooser;
import java.nio.charset.StandardCharsets;

public class StreamReaderHandler {
    
    /**
    * Convert InputStream to a String.
    *
    * <pre>
    * Pseudocode:
    * 1) Create a BufferedReader using the InputStream and UTF-8 encoding.
    * 2) Create a StringBuilder to store the converted String.
    * 3) Read each line from the BufferedReader and append it to the StringBuilder.
    * 4) Return the String from the StringBuilder.
    * </pre>
    *
    * @param is : the InputStream to convert to String
    * @return the converted String, or null if an IOException occurs
    */
   public static String convertStreamToString(InputStream is) {
       try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
           StringBuilder stringBuilder = new StringBuilder();
           String line;

           while ((line = reader.readLine()) != null) {
               stringBuilder.append(line).append("\n");
           }

           return stringBuilder.toString();
       } catch (IOException e) {
           e.printStackTrace();
           return null;
       }
   }

    /**
     * Copy the content of a selected CSV file to corresponding output file.
     *
     * <pre>
     * Pseudocode:
     * 1) Create a JFileChooser and display to the user.
     * 2) If the user selects a file, read each line from the selected CSV file.
     * 3) Write each line to the specified output file.
     * 4) Handle any IOExceptions that occur during file copying.
     * </pre>
     * 
     * @method copySelectedCsvFile
     * @param outputFilePath the path to the output file
     */
    public void copySelectedCsvFile(String outputFilePath) {
        // Use a file chooser to let the user select a CSV file
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        // Check if the user selected a file
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                 PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {

                // Read each line from the selected CSV file and write it to the output file
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.println(line);
                }

            } catch (IOException ex) {
                // Handle and print any IOException that occurs during file copying
                ex.printStackTrace();
            }
        }
    }
}
