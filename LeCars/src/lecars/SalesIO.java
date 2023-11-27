package lecars;

import lecars.StreamReaderHandler;
import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class SalesIO {
    
    private static final DateTimeFormatter formatterWithZ = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
    private static final DateTimeFormatter formatterWithoutZ = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
    
    private String salesId;
    private OffsetDateTime dateTime;
    private String carPlate;
    private String custId;
    private String employeeId;
    
    // Constructor
    public SalesIO(String salesId, OffsetDateTime dateTime, String carPlate, String custId, String employeeId) {
        this.salesId = salesId;
        this.dateTime = dateTime;
        this.carPlate = carPlate;
        this.custId = custId;
        this.employeeId = employeeId;
    }
    
    public String getSalesId() {
        return salesId;
    }

    public OffsetDateTime dateTime() {
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
    
    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
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
        List<SalesIO> sales = getSalesInput();
        //addNewSales("test","testCustId","testEmployeeId");
    }
    
    public static List<SalesIO> getSalesInput() {
        List<SalesIO> sales = new ArrayList<>();

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
                        
            for (String line : lineSplit) {
                String[] attributes = line.split(",");

                // attributes 0 = salesId
                // attributes 1 = dateTime
                // attributes 2 = carPlate
                // attributes 3 = custId
                // attributes 4 = employeeId
                OffsetDateTime dateTime = null;

                try {
                    // try parsing with z
                    dateTime = OffsetDateTime.parse(attributes[1], formatterWithZ);
                } catch (DateTimeParseException e) {
                    System.out.println("Error parsing with Z. Trying without Z. String: " + attributes[1]);
                    e.printStackTrace();
                }

                // check if dateTime is still null and try parsing without z
                if (dateTime == null) {
                    try {
                        dateTime = OffsetDateTime.parse(attributes[1], formatterWithoutZ);
                    } catch (DateTimeParseException e2) {
                        System.out.println("Error parsing without Z. String: " + attributes[1]);
                        e2.printStackTrace();
                    }
                }

                
                SalesIO sale = new SalesIO(attributes[0], dateTime, attributes[2], attributes[3], attributes[4]);

                // Assign values using setter methods
                sale.setSalesId(attributes[0]);
                
                sale.setDateTime(dateTime);
                sale.setCarPlate(attributes[2]);
                sale.setCustId(attributes[3]);
                sale.setEmployeeId(attributes[4]);

                sales.add(sale);
            }
            
            
        } else {
            System.err.println("Resource file not found.");
        }
        return sales;        
    }
    
    public static void addNewSales(String carPlate, String custId, String employeeId){
        //read and get the sales data
        List<SalesIO> sales = getSalesInput();
        
        //Get the last row of SalesId
        String lastSalesId = sales.get(sales.size()-1).getSalesId();
        int intlastSalesId = Integer.parseInt(lastSalesId);  //Convert to int so that can +1
        
        // SalesId Auto Increment
        intlastSalesId++;   //+1
        String strlatestSalesId = Integer.toString(intlastSalesId); //Convert int back to string
        String combinedlatestEmpID = ("0000"+intlastSalesId); 
        String extractlast4digit = combinedlatestEmpID.substring(combinedlatestEmpID.length()-4); //extract the last 4 digit from the string
        
        //Get substring last 4 digit
        String salesId;
        salesId = "A"+extractlast4digit;
        
        try(FileWriter fw = new FileWriter("src/data/sales.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) // give access to println (coder friendly)
        {
            // get the current date time
            OffsetDateTime dateTime = OffsetDateTime.now();
            
            // construct an input string
            String lineOfData = salesId + "," + dateTime + "," + carPlate + "," + custId + "," + employeeId;
            out.println(lineOfData);
            
            out.close();
            System.out.println("Successfully wrote to the file.");
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
