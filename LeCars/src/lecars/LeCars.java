package lecars;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class LeCars {
    public static void main(String[] args) {
            // Get an InputStream for the resource file
            InputStream resourceStream = LeCars.class.getResourceAsStream("/data/cust.csv");
               
            if (resourceStream != null) {
                // Convert the InputStream to a String
                String fileContent = convertStreamToString(resourceStream);
                
                // Print or process the file content as needed
                System.out.println(fileContent);
            } else {
                System.err.println("Resource file not found.");
            }
    }

    private static String convertStreamToString(InputStream is) {
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
}
