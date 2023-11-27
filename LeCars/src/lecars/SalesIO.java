package lecars;

import lecars.StreamReaderHandler;
import java.io.*;
import java.time.LocalDateTime;

public class SalesIO {
    private String salesId;
    private LocalDateTime dateTime;
    private String carPlate;
    private String custId;
    private String employeeId;
    
    // Constructor
    public SalesIO(String salesId, LocalDateTime dateTime, String carPlate, String custId, String employeeId) {
        this.salesId = salesId;
        this.dateTime = dateTime;
        this.carPlate = carPlate;
        this.custId = custId;
        this.employeeId = employeeId;
    }
    
    public String getSalesId() {
        return salesId;
    }

    public LocalDateTime dateTime() {
        return dateTime;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public String getCustId() {
        return custId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }
    
    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }
    
    public void setCustId(String custId) {
        this.custId = custId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String toString(){
        return salesId+","+dateTime+","+carPlate+","+custId+","+employeeId;
    }
    
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
