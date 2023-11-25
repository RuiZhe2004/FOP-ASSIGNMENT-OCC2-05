/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecars;

/**
 *
 * @author rz_rexton
 */
import lecars.StreamReaderHandler;
import java.io.*;

public class EmployeeIO {
    public static void main(String[] args) {
        getEmployeeInput();
    }
    
    public static String[][] getEmployeeInput() {
        String[][] employee = {{}};

        // Get an InputStream for the resource file employee.csv
        InputStream resourceStreamEmployee = CustIO.class.getResourceAsStream("/data/employee.csv");

        if (resourceStreamEmployee != null) {
            // Convert the InputStream to a String
            String fileContentEmployee = StreamReaderHandler.convertStreamToString(resourceStreamEmployee);

            // to remove the unused row
            fileContentEmployee = fileContentEmployee.replaceFirst("employeeId,employeeName,employeeStatus,password\\n", "");

            // Print or process the file content as needed
            System.out.println(fileContentEmployee);


            String[] lineSplit = fileContentEmployee.split("\\n");
            employee = new String[lineSplit.length][4];

            for(int line = 0; line < lineSplit.length; line++){
                // line - 1 to not include the index name
                employee[line] = lineSplit[line].split(",");
            }

            // System.out.println(cust[lineSplit.length-1][0]);
            
        } else {
            System.err.println("Resource file not found.");
        }
        return employee;        
    }
    
    public static String[][][] separateEmployee(String[][] employee) {
        int numSalesEmployee = 0;
        int numManagementEmployee = 0;

        // Count the number of sales and management employees
        for (String[] emp : employee) {
            if ("1".equals(emp[2])) {
                numManagementEmployee++;
            } else {
                numSalesEmployee++;
            }
        }

        // Separate employees based on roles
        String[][] salesEmployee = new String[numSalesEmployee][];
        String[][] managementEmployee = new String[numManagementEmployee][];

        // Reset counters
        numSalesEmployee = 0;
        numManagementEmployee = 0;

        int ct = 0;
        while (ct < employee.length) {
            if ("0".equals(employee[ct][2])) {
                salesEmployee[numSalesEmployee] = employee[ct].clone();  // clone to avoid reference issues
                numSalesEmployee++;
            } else {
                managementEmployee[numManagementEmployee] = employee[ct].clone();  // clone to avoid reference issues
                numManagementEmployee++;
            }
            ct++;
        }

        // Create a 3D array to store the separated employees
        String[][][] separatedEmployee = {salesEmployee, managementEmployee};

        return separatedEmployee;
    }

}
