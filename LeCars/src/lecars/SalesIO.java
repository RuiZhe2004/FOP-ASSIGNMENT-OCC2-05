package lecars;

import lecars.StreamReaderHandler;
import lecars.EmployeeIO;
import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;


public class SalesIO {
    
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
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
        List<SalesIO> filteredSales = filterSalesByEmployeeId("E0014");
        for (SalesIO sale : filteredSales) {            
            System.out.println(sale.toString());
        }
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
            //System.out.println(fileContent);


            String[] lineSplit = fileContent.split("\\n");
                        
            for (String line : lineSplit) {
                String[] attributes = line.split(",");

                // attributes 0 = salesId
                // attributes 1 = dateTime
                // attributes 2 = carPlate
                // attributes 3 = custId
                // attributes 4 = employeeId
                OffsetDateTime dateTime = OffsetDateTime.parse(attributes[1]);

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
        try {
            //read and get the sales data
            List<SalesIO> sales = getSalesInput();

            // Get the last row of SalesId
            String lastSalesId = sales.get(sales.size() - 1).getSalesId();
            int intLastSalesId = Integer.parseInt(lastSalesId.substring(1)) + 1; // Increment and convert to int

            // SalesId Auto Increment
            String salesId = String.format("A%04d", intLastSalesId);

            // get the current date time
            final OffsetDateTime dateTime = OffsetDateTime.now();
            // Format the OffsetDateTime
            String formattedDateTime = dateTime.format(formatter) + "Z";

            // Construct an input string
            String lineOfData = String.format("%s,%s,%s,%s,%s", salesId, formattedDateTime, carPlate, custId, employeeId);

            try(FileWriter fw = new FileWriter("src/data/sales.csv", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) // give access to println (coder friendly)
            {
                out.println(lineOfData);

                out.close();
                System.out.println("Successfully wrote to the file.");

            } 
        } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
        }
    }
    
    //filtering 
    // by employeeId
    private static List<SalesIO> filterSalesByEmployeeId(String employeeId) {
        List<SalesIO> filteredSales = new ArrayList<>();;
        List<SalesIO> sales = getSalesInput();
        for (SalesIO sale : sales) {
            //so that it stops lol,:3
            if (sale.getEmployeeId().equals(employeeId)) {
                // System.out.println("Employee with employee Id " + employeeId + ": " + sale.toString());
                filteredSales.add(sale);
            }
        }
        return filteredSales;
    }
}
