package lecars;

import lecars.StreamReaderHandler;
import java.io.*;

public class VehicleIO {
    public static void main(String[] args) {
        getVehicleInput();
    }
    
    public static String[][] getVehicleInput() {
        String[][] vehicle = {{}};

        // Get an InputStream for the resource file vehicle.csv
        InputStream resourceStream = SalesIO.class.getResourceAsStream("/data/vehicle.csv");

        if (resourceStream != null) {
            // Convert the InputStream to a String
            String fileContent = StreamReaderHandler.convertStreamToString(resourceStream);

            // to remove the unused row
            fileContent = fileContent.replaceFirst("carPlate,carModel,acquirePrice,carStatus,salesPrice\\n", "");

            // Print or process the file content as needed
            System.out.println(fileContent);


            String[] lineSplit = fileContent.split("\\n");
            vehicle = new String[lineSplit.length][5];

            for(int line = 0; line < lineSplit.length; line++){
                // line - 1 to not include the index name
                vehicle[line] = lineSplit[line].split(",");
            }
            
        } else {
            System.err.println("Resource file not found.");
        }
        return vehicle;        
    }
}
