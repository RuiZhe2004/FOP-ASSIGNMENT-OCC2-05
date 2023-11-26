package lecars;

import lecars.StreamReaderHandler;
import java.io.*;

public class SalesIO {
    public static void main(String[] args) {
        getSalesInput();
    }
    
    public static String[][] getSalesInput() {
        String[][] sales = {{}};

        // Get an InputStream for the resource file sales.csv
        InputStream resourceStream = SalesIO.class.getResourceAsStream("/data/sales.csv");

        if (resourceStream != null) {
            // Convert the InputStream to a String
            String fileContent = StreamReaderHandler.convertStreamToString(resourceStream);

            // to remove the unused row
            fileContent = fileContent.replaceFirst("salesId,dateTime,carPlate,custId,employeeId\\n", "");

            // Print or process the file content as needed
            System.out.println(fileContent);


            String[] lineSplit = fileContent.split("\\n");
            sales = new String[lineSplit.length][5];

            for(int line = 0; line < lineSplit.length; line++){
                sales[line] = lineSplit[line].split(",");
            }
            
        } else {
            System.err.println("Resource file not found.");
        }
        return sales;        
    }
    
    public static void addNewSales(String carPlate, String custID){
        
    }
}
