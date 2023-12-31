package lecars;

import lecars.StreamReaderHandler;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = dateTime.format(formatter);
        return salesId+","+formattedDateTime+","+carPlate+","+custId+","+employeeId;
    }
    
    public static void main(String[] args) {
//        List<SalesIO> sales = getSalesInput();
//        //addNewSales("test","testCustId","testEmployeeId");
//        List<SalesIO> filteredSales = filterSalesByEmployeeId("E0014");
//        for (SalesIO sale : filteredSales) {            
//            System.out.println(sale.toString());
//        }
//        System.out.println();
//        System.out.printf("RM%.2f%n", getProfitByEmployeeId("E0012"));
//        
//        List<CustIO> cust = getcustInput();
//        List<CustIO> filteredCust = filterCustByEmployeeId("E0014");
//        for (CustIO customer : filteredCust) {            
//            System.out.println(customer.toString());
//        }
//        System.out.println();
//        
//        SalesIO searchByCustId = searchByCustId("C0014");
//        System.out.println("Target Customer: " + searchByCustId.toString());

//        List<SalesIO> sortedFilteredSales = filterSortedSalesByEmployeeId("E0014");
//        for (SalesIO sale : sortedFilteredSales) {            
//            System.out.println(sale.toString());
//        }
//        System.out.println();
//        
        Map<String, Double> aggregatedTotalSalesPriceByYearMonthByEmployeeId = aggregateTotalSalesPriceByYearMonthByEmployeeId("E0001");
//        // Output the aggregated sales by year and month
        for (Map.Entry<String, Double> entry : aggregatedTotalSalesPriceByYearMonthByEmployeeId.entrySet()) {
            System.out.println("Year-Month: " + entry.getKey() + ", Total Sales: " + entry.getValue());
        }

//        Map<String, Double> aggregatedProfitMarginByYearMonth = aggregateProfitMarginByYearMonth();
//        // Output the aggregated sales by year and month
//        for (Map.Entry<String, Double> entry : aggregatedProfitMarginByYearMonth.entrySet()) {
//            System.out.println("Year-Month: " + entry.getKey() + ", Total Sales: " + entry.getValue());
//        }

//        List<SalesIO> filteredSalesPriceRange = filterSalesPriceRange(150000);
//        for (SalesIO sale : filteredSalesPriceRange) {            
//            System.out.println(sale.toString());
//        }
        
//        List<SalesIO> filteredSalesPriceRangeByEmployeeId = filterSalesPriceRangeByEmployeeId(100005,"E0002");
//        for (SalesIO sale : filteredSalesPriceRangeByEmployeeId) {            
//            System.out.println(sale.toString());
//        }
    }
    
    /**
     * <pre>
     * To get the list of sales objects
     * Pseudocode
     * 1) Get the stream content from the sales.csv file and then convert to string
     * 2) remove the title
     * 3) split them line by line
     * 4) split them by ','
     * 5) store them into Sales Object according to their types
     * </pre>
     * 
     * @method    getSalesInput
     * @return   List<SalesIO>
     * @see      convertStreamToString()
     */
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
    
    /**
     * <pre>
     * To get the next unique sales ID according to autoincrement function
     * Pseudocode
     * 1) Get the list of sales objects
     * 2) If null list is obtains mean no record hence return the first ID which is A0001
     * 3) Find the last row
     * 4) Ignore the first char and read the integer after it
     * 5) Auto increment it
     * 6) return it
     * </pre>
     * 
     * @method   getNextUniqueSalesId
     * @return   List<SalesIO> sales - List of sales objects
     * @see      getSalesInput()
     */
    public static String getNextUniqueSalesId(){
        //read and get the sales data
        List<SalesIO> sales = getSalesInput();
        
        // if the sales is null mean no record
        if(sales == null){
            return "A0001";
        }
        
        // Get the last row of SalesId
        String lastSalesId = sales.get(sales.size() - 1).getSalesId();
        int intLastSalesId = Integer.parseInt(lastSalesId.substring(1)) + 1; // Increment and convert to int

        // SalesId Auto Increment
        String salesId = String.format("A%04d", intLastSalesId);
        return salesId;
    }
    
    /**
     * <pre>
     * To convert the current date time object to a string format
     * Pseudocode
     * 1) Get the current date time object
     * 2) Convert to String and then plus a 'Z' at the back
     * 3) return it
     * </pre>
     * 
     * @method   getCurrentDateTime
     * @return   String formattedDateTime - the datetime object in string which contain the 'Z' at the back
     */
    public static String getCurrentDateTime(){
        // get the current date time
        final OffsetDateTime dateTime = OffsetDateTime.now();
        // Format the OffsetDateTime
        String formattedDateTime = dateTime.format(formatter) + "Z";
        return formattedDateTime;
    }
    
    /**
     * <pre>
     * To add new sales object to sales.csv file
     * Pseudocode
     * 1) get the list of sales object
     * 2) get the next unique sales id
     * 3) convert the input data into a line of String
     * 4) append to the sales.csv file
     * </pre>
     * 
     * @method   addNewSales
     * @param    carPlate           the unique car plate of a vehicle
     * @param    custID             the unique id of a customer
     * @param    employeeId         the unique id of an employee
     * @param    formattedDateTime  date time object in string which contain the 'Z' at the back
     * @return   void
     * @see      getSalesInput()
     * @see      getNextUniqueSalesId()
     */
    public static void addNewSales(String carPlate, String custId, String employeeId, String formattedDateTime){
        try {
            //read and get the sales data
            List<SalesIO> sales = getSalesInput();

            String salesId = getNextUniqueSalesId();

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
    
    /**
     * <pre>
     * To get the number of sales by an employee
     * Pseudocode
     * 1) Get the list of all sales using the getSalesInput() method.
     * 2) Iterate through the list of sales and filter by the given employee ID.
     * 3) Return the filtered list of sales.
     * </pre>
     * 
     * @method   filterSalesByEmployeeId
     * @param    employeeId         the unique id of an employee
     * @return   List<SalesIO> filteredSales - the filtered sales by an employee
     * @see      getSalesInput()
     * @see      getEmployeeId()
     */
    //filtering 
    // by employeeId
    // can get the number of sales by employee
    public static List<SalesIO> filterSalesByEmployeeId(String employeeId) {
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
    
    /**
     * <pre>
     * To 
     * Pseudocode
     * 1) Get the list of sales for the given employee using the filterSalesByEmployeeId() method.
     * 2) Sort the list of sales by date/time in ascending order.
     * 3) Return the sorted list of sales.
     * </pre>
     * 
     * @method   filterSortedSalesByEmployeeId
     * @param    employeeId         the unique id of an employee
     * @return   List<SalesIO> sortedFilteredSales - the sorted filtered sales by an employee
     * @see      filterSalesByEmployeeId(String employeeId)
     */
    public static List<SalesIO> filterSortedSalesByEmployeeId(String employeeId) {
        List<SalesIO> sortedFilteredSales = filterSalesByEmployeeId(employeeId);
        
        Collections.sort(sortedFilteredSales, Comparator.comparing(SalesIO::dateTime));
        
        return sortedFilteredSales;
        
    }
    
    /**
     * Gets the total profit for a given employee.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of sales for the given employee using the filterSalesByEmployeeId() method.
     * 2) Initialize a variable to store the total profit.
     * 3) Iterate through the list of sales.
     * 4) For each sale, get the corresponding vehicle using the searchByVehicleCarPlate() method.
     * 5) If the vehicle is found, add the profit (sales price - acquire price) to the total profit.
     * 6) Return the total profit.
     * </pre>
     *
     * @param employeeId : filter employee ID
     * @return the total profit for the given employee
     * @see SalesIO#filterSalesByEmployeeId(String)
     * @see VehicleIO#searchByVehicleCarPlate(String)
     */
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
    
    /**
     * Aggregates the total sales price by year and month for a specific employee.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of sales for the given employee using the filterSortedSalesByEmployeeId() method.
     * 2) Initialize a map to store the aggregated sales for each year and month.
     * 3) Iterate through the list of sales.
     * 4) For each sale, get the corresponding vehicle using the searchBySoldVehicleCarPlate() method.
     * 5) If the vehicle is found, add the sales price to the existing total for the year and month, or initialize the total to the sales price if the year and month do not exist in the map.
     * 6) Return the map containing the aggregated sales price for each year and month.
     * </pre>
     *
     * @param employeeId : filter employee ID
     * @return a map containing the aggregated sales price for each year and month for the given employee
     * @see SalesIO#filterSortedSalesByEmployeeId(String)
     * @see VehicleIO#searchBySoldVehicleCarPlate(String)
     */
    // Aggregate the total sales price by year and month for a specific employee
    public static Map<String, Double> aggregateTotalSalesPriceByYearMonthByEmployeeId(String employeeId) {
        List<SalesIO> sortedFilteredSales = filterSortedSalesByEmployeeId(employeeId);

        // Use a Map to store the aggregated sales for each YearMonth
        Map<String, Double> aggregatedTotalSalesPriceByYearMonthByEmployeeId = new HashMap<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

        for (SalesIO sale : sortedFilteredSales) {
            System.out.println(sale.toString());
            VehicleIO vehicle = VehicleIO.searchBySoldVehicleCarPlate(sale.getCarPlate());
            if (vehicle != null) {
                // Parse the dateTime field into LocalDateTime
                OffsetDateTime saleDateTime = sale.dateTime();

                // Generate a key as "yyyy-MM" from the LocalDateTime
                String key = saleDateTime.format(formatter);

                // Add sales price to the existing total or initialize if not present
                aggregatedTotalSalesPriceByYearMonthByEmployeeId.merge(key, vehicle.getSalesPrice(), Double::sum);
            }
        }

        return aggregatedTotalSalesPriceByYearMonthByEmployeeId;
    }
    
    /**
     * Aggregates the profit margin by year and month.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all sales using the getSalesInput() method.
     * 2) Sort the list of sales by date/time in ascending order.
     * 3) Initialize a map to store the aggregated profit margin for each year and month.
     * 4) Iterate through the sorted list of sales.
     * 5) For each sale, get the corresponding vehicle using the searchBySoldVehicleCarPlate() method.
     * 6) If the vehicle is found, calculate the profit margin for the sale by subtracting the acquire price from the sales price.
     * 7) Parse the date/time field of the sale into a YearMonth object.
     * 8) Generate a key for the map using the YearMonth object.
     * 9) Add the profit margin for the sale to the existing total for the key, or initialize the total to the profit margin if the key does not exist.
     *10) Return the map containing the aggregated profit margin for each year and month.
     * </pre>
     *
     * @return a map containing the aggregated profit margin for each year and month
     * @see SalesIO#getSalesInput()
     * @see VehicleIO#searchBySoldVehicleCarPlate(String)
     */
    // Aggregate the profit margin by year and month
    public static Map<String, Double> aggregateProfitMarginByYearMonth() {
        List<SalesIO> sortedFilteredSales = getSalesInput();
        Collections.sort(sortedFilteredSales, Comparator.comparing(SalesIO::dateTime));

        // Use a Map to store the aggregated sales for each YearMonth
        Map<String, Double> aggregatedProfitMarginByYearMonth = new HashMap<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

        for (SalesIO sale : sortedFilteredSales) {
            VehicleIO vehicle = VehicleIO.searchBySoldVehicleCarPlate(sale.getCarPlate());
            if (vehicle != null) {
                // Parse the dateTime field into LocalDateTime
                OffsetDateTime saleDateTime = sale.dateTime();

                // Generate a key as "yyyy-MM" from the LocalDateTime
                String key = saleDateTime.format(formatter);
                
                // Add sales price to the existing total or initialize if not present
                aggregatedProfitMarginByYearMonth.merge(key, vehicle.getSalesPrice() - vehicle.getAcquirePrice(), Double::sum);
            }
        }

        return aggregatedProfitMarginByYearMonth;
    }
    
    /**
     * Searches for a sales record by customer ID.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all sales using the getSalesInput() method.
     * 2) Iterate through the list of sales and search for the sale with the given customer ID.
     * 3) Return the found sales record, or null if no such record is found.
     * </pre>
     *
     * @param custId : search for customer ID
     * @return the sales record with the given customer ID, or null if no such record is found
     * @see SalesIO#getSalesInput()
     */
    private static SalesIO searchByCustId(String custId) {
        List<SalesIO> sales = getSalesInput();
        
        for (SalesIO customer : sales) {
            if (customer.custId.equals(custId)) {
                return customer;
            }
        }
        return null;
    }
    
    /**
     * Filters the list of customers by a given employee ID.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all sales using the getSalesInput() method.
     * 2) Filter the list of sales by the given employee ID.
     * 3) Get the list of customer IDs from the filtered list of sales.
     * 4) Get the list of all customers using the getcustInput() method.
     * 5) Filter the list of customers by the list of customer IDs obtained in step 3.
     * 6) Return the filtered list of customers.
     * </pre>
     *
     * @param employeeID : filter employee ID
     * @return a list of customers associated with the given employee ID
     * @see SalesIO#getSalesInput()
     * @see CustIO#getcustInput()
     */
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
    
    /**
     * Filters the list of sales by a minimum sales price.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all sales using the getSalesInput() method.
     * 2) Get the list of all sold vehicles using the getSoldVehicleInput() method.
     * 3) Iterate through the list of sold vehicles and filter the sales based on the given price.
     * 4) Return the filtered list of sales.
     * </pre>
     *
     * @param priceAbove : filter minimum sales price
     * @return a list of sales with a sales price greater than or equal to the given price
     * @see SalesIO#getSalesInput()
     * @see VehicleIO#getSoldVehicleInput()
     */
    public static List<SalesIO> filterSalesPriceRange(double priceAbove) {
        List<SalesIO> filterSalesAbovePriceRange = new ArrayList<>();
        List<String> filteredCarPlateAboveSalesPriceRange = new ArrayList<>();
        List<SalesIO> sales = getSalesInput();
        List<VehicleIO> vehicles = VehicleIO.getSoldVehicleInput();
        
        for (VehicleIO vehicle : vehicles) {
            if(vehicle.getSalesPrice() >= priceAbove){
                filteredCarPlateAboveSalesPriceRange.add(vehicle.getCarPlate());
            }
        }
        
        for (SalesIO sale : sales){
            if(filteredCarPlateAboveSalesPriceRange.contains(sale.getCarPlate())){
                filterSalesAbovePriceRange.add(sale);
            }
        }

        return filterSalesAbovePriceRange;
    }
    
    /**
     * Filters the list of sales by a minimum sales price and employee ID.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of sales with a sales price greater than or equal to the given price using the filterSalesPriceRange() method.
     * 2) Iterate through the filtered list of sales and filter by the given employee ID.
     * 3) Return the filtered list of sales.
     * </pre>
     *
     * @param priceAbove : filter minimum sales price
     * @param employeeId : filter employee ID
     * @return a list of sales with a sales price greater than or equal to the given price and the given employee ID
     * @see SalesIO#filterSalesPriceRange(double)
     */
    public static List<SalesIO> filterSalesPriceRangeByEmployeeId(double priceAbove, String employeeId) {
        List<SalesIO> filterSalesAbovePriceRangeByEmployeeId = new ArrayList<>();
        List<SalesIO> filterSalesAbovePriceRange = filterSalesPriceRange(priceAbove);
        
        for (SalesIO sale : filterSalesAbovePriceRange){
            if(sale.getEmployeeId().equals(employeeId)){
                filterSalesAbovePriceRangeByEmployeeId.add(sale);
            }
        }
        
        return filterSalesAbovePriceRangeByEmployeeId;
    }
}
