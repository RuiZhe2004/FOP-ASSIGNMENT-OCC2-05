package lecars;

/**
 *
 * @author ruizh
 */
import lecars.StreamReaderHandler;
import java.io.*;
import java.util.*;

public class CustIO {
    public String custId;
    private String custName;
    private String phoneNum;
    private String postcode;
    
    public CustIO(String custId, String custName, String phoneNum, String postcode) {
        this.custId = custId;
        this.custName = custName;
        this.phoneNum = phoneNum;
        this.postcode = postcode;
    }
    
    public String getCustId() {
        return custId;
    }

    public String getCustName() {
        return custName;
    }

    public String getphoneNum() {
        return phoneNum;
    }

    public String getpostcode() {
        return postcode;
    }
    
    public void setcustId(String custId) {
        this.custId = custId;
    }

    public void setcustName(String custName) {
        this.custName = custName;
    }

    public void setphoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setpostcode(String postcode) {
        this.postcode = postcode;
    }
    
    public String toString(){
        return custId+", "+custName+", "+phoneNum+", "+postcode;
    }
    
    public static void main(String[] args) {
        List<CustIO> cust = getcustInput();
        
        System.out.println("Customer: ");
        List<CustIO> fullcust = cust;
        for (CustIO customer : fullcust){
            System.out.println(customer.toString());
        }
        
        System.out.println();
        CustIO targetCustomer = searchCustByPostcode("11600");
        System.out.println("Target Customer : " + targetCustomer.toString());
    }
    
    /**
     * Read and parses customer data from a CSV file, including customer ID, name, phone number, and postcode.
     *
     * <pre>
     * Pseudocode:
     * 1) Get an InputStream for the resource file cust.csv.
     * 2) Convert the InputStream to a String.
     * 3) Remove the first line (header row) from the String.
     * 4) Split the String into lines.
     * 5) For each line, split it into attributes.
     * 6) Create a CustIO object for each set of attributes.
     * 7) Add the CustIO object to a list.
     * 8) Return the list of CustIO objects.
     * </pre>
     *
     * @method getcustInput
     * @return A list of CustIO objects representing the customers in the CSV file.
     * @see CustIO
     */
    public static List<CustIO> getcustInput() {
        List<CustIO> cust = new ArrayList<>();

        // Get an InputStream for the resource file employee.csv
        InputStream resourceStream = CustIO.class.getResourceAsStream("/data/cust.csv");

        if (resourceStream != null) {
            // Convert the InputStream to a String
            String fileContent = StreamReaderHandler.convertStreamToString(resourceStream);

            // to remove the unused row
            fileContent = fileContent.replaceFirst("custId,custName,phoneNum,postcode\\n", "");

            // Print or process the file content as needed
            //System.out.println(fileContent);

            //split content
            String[] lineSplit = fileContent.split("\\n");

            for (String line : lineSplit) {
                String[] attributes = line.split(",");

                // attributes 0 = custId
                // attributes 1 = custName
                // attributes 2 = phoneNum
                // attributes 3 = postcode
                CustIO customer = new CustIO(attributes[0], attributes[1], attributes[2], attributes[3]);


                // Assign values using setter methods
                customer.setcustId(attributes[0]);
                customer.setcustName(attributes[1]);
                customer.setphoneNum(attributes[2]);
                customer.setpostcode(attributes[3]);

                cust.add(customer);
            }

            
        } else {
            System.err.println("Resource file not found.");
        }
        return cust;        
    }
    
    /**
     * Search for a customer by name.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all customers using the getcustInput() method.
     * 2) Iterate through the list of customers and search for the customer with the given name.
     * 3) Return the found customer, or null if no such customer is found.
     * </pre>
     *
     * @param custName : search for the name of the customer
     * @return the customer with the given name, or null if no such customer is found
     * @see CustIO#getcustInput()
     */
    // search by customer name
    private static CustIO searchCustByName(String custName) {
        
        // read and get all the data of employees
        List<CustIO> cust = getcustInput();
        
        for (CustIO customer : cust) {
            if (customer.custName.equals(custName)) {
                return customer;
            }
        }
        return null;
    }
    
    /**
     * Search for a customer by customer ID.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all customers using the getcustInput() method.
     * 2) Iterate through the list of customers and search for the customer with the given ID.
     * 3) Return the found customer, or null if no such customer is found.
     * </pre>
     *
     * @param custId : search for the ID of the customer
     * @return the customer with the given ID, or null if no such customer is found
     * @see CustIO#getcustInput()
     */
    // search by customer ID
    public static CustIO searchCustById(String custId) {
        
        List<CustIO> cust = getcustInput();
        
        for (CustIO customer : cust) {
           
            if (customer.custId.equals(custId)) {
                return customer;
            }
        }
        return null;
    }
    
    /**
     * Search for a customer by phone number.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all customers using the getcustInput() method.
     * 2) Iterate through the list of customers and search for the customer with the given phone number.
     * 3) Return the found customer, or null if no such customer is found.
     * </pre>
     *
     * @param phoneNum : search for the phone number of the customer
     * @return the customer with the given phone number, or null if no such customer is found
     * @see CustIO#getcustInput()
     */
    // search by hp no
    private static CustIO searchCustByHPno(String phoneNum) {
        
        List<CustIO> cust = getcustInput();
        
        for (CustIO customer : cust) {
           
            if (customer.phoneNum.equals(phoneNum)) {
                return customer;
            }
        }
        return null;
    }
    
    /**
     * Search for a customer by postcode.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all customers using the getcustInput() method.
     * 2) Iterate through the list of customers and search for the customer with the given postcode.
     * 3) Return the found customer, or null if no such customer is found.
     * </pre>
     *
     * @param custpostcode : search for the postcode of the customer
     * @return the customer with the given postcode, or null if no such customer is found
     * @see CustIO#getcustInput()
     */
    // search by postcode
    private static CustIO searchCustByPostcode(String custpostcode) {
        
        List<CustIO> cust = getcustInput();
        
        for (CustIO customer : cust) {
            if (customer.postcode.equals(custpostcode)) {
                return customer;
            }
        }
        
        return null;
    }
    
    /**
     * Generate the next unique customer ID.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all existing customers using the getcustInput() method.
     * 2) Get the last customer ID from the list.
     * 3) Increment the last customer ID by 1.
     * 4) Format the new customer ID as "CXXXX", where XXXX is the 4-digit customer ID.
     * 5) Return the new customer ID.
     * </pre>
     *
     * @return the next unique customer ID
     * @see CustIO#getcustInput()
     */
    public static String getNextUniqueCustId(){
        //read and get the sales data
        List<CustIO> cust = getcustInput();

        // Get the last row of SalesId
        String lastCustId = cust.get(cust.size() - 1).getCustId();
        int LastCustId = Integer.parseInt(lastCustId.substring(1)) + 1; 

        String nextCustId = String.format("C%04d", LastCustId);
        
        return nextCustId;
    }
    
    /**
     * Add a new customer to the customer CSV file.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all existing customers using the getcustInput() method.
     * 2) Generate a new unique customer ID.
     * 3) Create a new customer record in CSV format.
     * 4) Open the customer CSV file in append mode.
     * 5) Write the new customer record to the file.
     * 6) Close the file.
     * </pre>
     *
     * @param custName : name of the new customer
     * @param phoneNum : phone number of the new customer
     * @param postcode : postcode of the new customer
     * @see CustIO#getcustInput()
     */
    // add new customer by increasing ID
    public static void addNewCust(String custName, String phoneNum, String postcode){
        try {
            List<CustIO> cust = getcustInput(); 

            String nextCustId = getNextUniqueCustId();

            String newData = String.format("%s,%s,%s,%s", nextCustId, custName, phoneNum, postcode);

            try(FileWriter fw = new FileWriter("src/data/cust.csv", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(newData);

                out.close();
                System.out.println("Successfully wrote to the file.");

            } 
        } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
        }
    }
}
