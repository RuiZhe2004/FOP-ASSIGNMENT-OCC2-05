/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecars;

/**
 *
 * @author szeyu & rz_rexton
 */

import java.io.*;
import java.util.List;
import static lecars.EmployeeIO.getEmployeeInput;


public class SalesEmployee extends EmployeeIO {
    public static void main(String[] args) {
        registerNewUser("test","test");
    }
    
    public SalesEmployee(String employeeId, String employeeName, int employeeStatus, String password) {
        super(employeeId, employeeName, employeeStatus, password); // Calls the superclass constructor
    }
    
        public static void registerNewUser(String employeeName, String password) {
            // Read and get the employee data
            List<EmployeeIO> employees = getEmployeeInput();

            // Check if the list is empty or not
            String employeeID;
            if (!employees.isEmpty()) {
                // Get the last employee's ID
                String lastEmpID = employees.get(employees.size() - 1).getEmployeeId();
                int intLastEmpID = Integer.parseInt(lastEmpID.substring(1)); // Increment the ID

                // employeeID Auto Increment
                intLastEmpID++;   //+1
                String strlatestEmpID = Integer.toString(intLastEmpID); //Convert int back to string
                String combinedlatestEmpID = ("0000"+intLastEmpID); 
                String extractlast4digit = combinedlatestEmpID.substring(combinedlatestEmpID.length()-4); //extract the last 4 digit from the string

                //Get substring last 4 digit
                employeeID = "E"+extractlast4digit;

            // Status is always "0" as a sales employee
            final String status = "0";

            try (FileWriter fw = new FileWriter("src/data/employee.csv", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {

                String lineOfData = employeeID + "," + employeeName + "," + status + "," + password;
                out.println(lineOfData);

                System.out.println("Successfully wrote to the file.");

            } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }
        }
    }
}
