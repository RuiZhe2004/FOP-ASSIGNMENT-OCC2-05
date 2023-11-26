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
        String[][] employee = getEmployeeInput();
        
        // [0] to get salesEmployee
        // [1] to get managementEmployee
        String[][] salesEmployee = EmployeeIO.separateEmployee(employee)[0];
        String[][] managementEmployee = EmployeeIO.separateEmployee(employee)[1];
        
        
        System.out.println("Sales Employee:");
        for (int i = 0; i < salesEmployee.length; i++) {
            for (int j = 0; j < salesEmployee[i].length; j++) {
                System.out.print(salesEmployee[i][j] + " ");
            }
            System.out.println();  // Move to the next line after printing each row
        }
        System.out.println();
        System.out.println("Management Employee:");
        for (int i = 0; i < managementEmployee.length; i++) {
            for (int j = 0; j < managementEmployee[i].length; j++) {
                System.out.print(managementEmployee[i][j] + " ");
            }
            System.out.println();  // Move to the next line after printing each row
        }
    }
    
    public static String[][] getEmployeeInput() {
        String[][] employee = {{}};

        // Get an InputStream for the resource file employee.csv
        InputStream resourceStream = EmployeeIO.class.getResourceAsStream("/data/employee.csv");

        if (resourceStream != null) {
            // Convert the InputStream to a String
            String fileContent = StreamReaderHandler.convertStreamToString(resourceStream);

            // to remove the unused row
            fileContent = fileContent.replaceFirst("employeeId,employeeName,employeeStatus,password\\n", "");

            // Print or process the file content as needed
            System.out.println(fileContent);


            String[] lineSplit = fileContent.split("\\n");
            employee = new String[lineSplit.length][4];

            for(int line = 0; line < lineSplit.length; line++){
                employee[line] = lineSplit[line].split(",");
            }
            
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
        // [0] to get salesEmployee
        // [1] to get managementEmployee
        String[][][] separatedEmployee = {salesEmployee, managementEmployee};

        return separatedEmployee;
    }

}