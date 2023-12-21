/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecars;

import java.io.*;
import javax.swing.JFileChooser;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author szeyu
 */
public class StreamReaderHandler {
    
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
    // method that allows the user to select a CSV file using a JFileChooser. The selected CSV file's contents are then copied to a specified output file.
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
