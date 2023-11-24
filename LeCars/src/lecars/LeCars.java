package lecars;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class LeCars {
    public static void main(String[] args) {

            // Get an InputStream for the resource file cust.csv
            InputStream resourceStreamCust = LeCars.class.getResourceAsStream("/data/cust.csv");
               
            if (resourceStreamCust != null) {
                // Convert the InputStream to a String
                String fileContentCust = convertStreamToString(resourceStreamCust);
                
                // to remove the unused row
                fileContentCust = fileContentCust.replaceFirst("custId,custName,phoneNum,postcode\\n", "");
                
                // Print or process the file content as needed
                System.out.println(fileContentCust);
                
                
                String[] lineSplit = fileContentCust.split("\\n");
                String[][] cust = new String[lineSplit.length][4];
                
                for(int line = 0; line < lineSplit.length; line++){
                    // line - 1 to not include the index name
                    cust[line] = lineSplit[line].split(",");
                }
                
                // System.out.println(cust[lineSplit.length-1][0]);
                
                
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
