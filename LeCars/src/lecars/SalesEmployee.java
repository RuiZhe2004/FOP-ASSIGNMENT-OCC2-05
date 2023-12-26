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
        registerNewUser("Hekk","test");

        SalesEmployee.login("Ahmad bin Abdullah", "3f7g9h2k");
    }
    
    public SalesEmployee(String employeeId, String employeeName, int employeeStatus, String password) {
        super(employeeId, employeeName, employeeStatus, password); // Calls the superclass constructor
    }
    
    public static String registerNewUser(String employeeName, String password) {
        // Read and get the employee data
        List<EmployeeIO> employees = getEmployeeInput();
            
        //Check is there any duplicate employeeName when register new employee
        //convert the employees list to stream
        boolean isDuplicate = employees.stream()
                    
        //lamda expression:  Make it case insensitive , if case sensitive can use 'equalsIgnoreCase'
        //for each employee -> do the following
        .anyMatch(employee -> employee.getEmployeeName().equals(employeeName));

        if (isDuplicate) {
            System.out.println("Username has been taken.");
            return "Username has been taken.";
        } 
        else {
            
            // by default the first employee is E0001
            String employeeID = "E0001";
            
            // Status is always "0" as a sales employee
            final String status = "0";
            
            // Check if the list is empty or not
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
            } 
            
            try (FileWriter fw = new FileWriter("src/data/employee.csv", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
                
            String lineOfData = String.format("%s,%s,%s,%s", employeeID, employeeName, status, password);
            out.println(lineOfData);
            System.out.println("Successfully wrote to the file.");
            return "Success";

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                return "An error occurred.";
            }
        }
    }
    
    public static void login(String enteredUsername, String enteredPassword) {
        
        if (EmployeeIO.validateLogin(enteredUsername, enteredPassword) == 0) {
            System.out.println("Sales Employee Login successful!");
        } else if (EmployeeIO.validateLogin(enteredUsername, enteredPassword) == 1) {
            System.out.println("Management Employee Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}