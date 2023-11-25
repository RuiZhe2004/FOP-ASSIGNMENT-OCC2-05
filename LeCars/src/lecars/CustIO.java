package lecars;

import lecars.StreamReaderHandler;
import java.io.*;

public class CustIO {
    public static void main(String[] args) {
        getCustInput();
    }
    
    public static String[][] getCustInput() {
        String[][] cust = {{}};

        // Get an InputStream for the resource file cust.csv
        InputStream resourceStreamCust = CustIO.class.getResourceAsStream("/data/cust.csv");

        if (resourceStreamCust != null) {
            // Convert the InputStream to a String
            String fileContentCust = StreamReaderHandler.convertStreamToString(resourceStreamCust);

            // to remove the unused row
            fileContentCust = fileContentCust.replaceFirst("custId,custName,phoneNum,postcode\\n", "");

            // Print or process the file content as needed
            System.out.println(fileContentCust);


            String[] lineSplit = fileContentCust.split("\\n");
            cust = new String[lineSplit.length][4];

            for(int line = 0; line < lineSplit.length; line++){
                // line - 1 to not include the index name
                cust[line] = lineSplit[line].split(",");
            }

            // System.out.println(cust[lineSplit.length-1][0]);
            
        } else {
            System.err.println("Resource file not found.");
        }
        return cust;        
    }
}
