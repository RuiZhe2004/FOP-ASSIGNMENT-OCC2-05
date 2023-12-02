package lecars;

import lecars.StreamReaderHandler;
import lecars.EmployeeIO;
import lecars.VehicleIO;
import static lecars.CustIO.*;
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
        System.out.println();
        System.out.printf("RM%.2f%n", getProfitByEmployeeId("E0012"));
        
        List<CustIO> cust = getcustInput();
        List<CustIO> filteredCust = filterCustByEmployeeId("E0014");
        for (CustIO customer : filteredCust) {            
            System.out.println(customer.toString());
        }
        System.out.println();
        
        SalesIO searchByCustId = searchByCustId("C0014");
        System.out.println("Target Customer: " + searchByCustId.toString());
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
    // can get the number of sales by employee
    private static List<SalesIO> filterSalesByEmployeeId(String employeeId) {
        List<SalesIO> filteredSales = new ArrayList<>();
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
    
    // get the profit by EmployeeId
    private static double getProfitByEmployeeId(String employeeId) {
        List<SalesIO> filteredSales = filterSalesByEmployeeId(employeeId);

        double profit = 0;
        for (SalesIO sale : filteredSales) {
            VehicleIO vehicle = VehicleIO.searchByVehicleCarPlate(sale.getCarPlate());
            if (vehicle != null){
                profit += vehicle.getSalesPrice() - vehicle.getAcquirePrice();
            }
        }
        return profit;
    }
    
    private static SalesIO searchByCustId(String custId) {
        List<SalesIO> sales = getSalesInput();
        
        for (SalesIO customer : sales) {
            if (customer.custId.equals(custId)) {
                return customer;
            }
        }
        return null;
    }
    
    public static List<CustIO> filterCustByEmployeeId(String employeeID) {
        List<SalesIO> filteredCustID = new ArrayList<>();
        List<SalesIO> sales = getSalesInput();
        
        // Filter by employeeID first
        for (SalesIO customer : sales) {
            if (customer.employeeId.equals(employeeID)) {
                filteredCustID.add(customer);
            }
        }
        
        // Get Only the custID from the filtered list
        List<String> custIDs = new ArrayList<>();
        for (SalesIO custIDonly : filteredCustID) {
            custIDs.add(custIDonly.custId);
        }
        
        // Filter by custID get from the SalesIO
        List<CustIO> CustListByEmployeeID = new ArrayList<>();
        List<CustIO> cust = getcustInput();
        
        for (String filteredCustId : custIDs) {
            for (CustIO CustInfo : cust) {
                if (CustInfo.custId.equals(filteredCustId)) {
                    CustListByEmployeeID.add(CustInfo);
                }
            }
        }

        return CustListByEmployeeID;
    }
}
