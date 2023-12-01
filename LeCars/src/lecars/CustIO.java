package lecars;

/**
 *
 * @author ruizh
 */
import lecars.StreamReaderHandler;
import java.io.*;
import java.util.*;

public class CustIO {
    private String custId;
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
    
    // search by customer ID
    private static CustIO searchCustById(String custId) {
        
        List<CustIO> cust = getcustInput();
        
        for (CustIO customer : cust) {
           
            if (customer.custId.equals(custId)) {
                return customer;
            }
        }
        return null;
    }
    
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
    // add new customer by increasing ID
    public static void addNewCust(String custName, String phoneNum, String postcode){
        try {
            List<CustIO> cust = getcustInput();

            String lastCustId = cust.get(cust.size() - 1).getCustId();
            int LastCustId = Integer.parseInt(lastCustId.substring(1)) + 1; 

            String nextCustId = String.format("C%04d", LastCustId);

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
