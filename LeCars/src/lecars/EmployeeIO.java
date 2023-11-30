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
import java.util.*;

public class EmployeeIO {

    private String employeeId;
    private String employeeName;
    private int employeeStatus;
    private String password;
    
    // Constructor
    public EmployeeIO(String employeeId, String employeeName, int employeeStatus, String password) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeStatus = employeeStatus;
        this.password = password;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeStatus() {
        return employeeStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeStatus(int employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //add toString method to customize ur output instead of array location
    public String toString(){
        return employeeId+","+employeeName+","+employeeStatus+","+password;
    }
    
    public static void main(String[] args) {
        List<EmployeeIO> employees = getEmployeeInput();
        System.out.println("");
        
        System.out.println("Management Employees");
        List<EmployeeIO> managementEmployees = filterEmployeeByStatus(1);
        for (EmployeeIO employee : managementEmployees) {            
            System.out.println(employee.toString());
        }
        System.out.println();
        System.out.println("Sales Employees");
        List<EmployeeIO> salesEmployees = filterEmployeeByStatus(0);
        for (EmployeeIO employee : salesEmployees) {            
            System.out.println(employee.toString());
        }
        
        System.out.println();
        EmployeeIO targetEmployee = searchEmployeeByEmployeeId("E0015");
        System.out.println("Target Employee : " + targetEmployee.toString());
    }
    
    public static List<EmployeeIO> getEmployeeInput() {
        List<EmployeeIO> employees = new ArrayList<>();

        // Get an InputStream for the resource file employee.csv
        InputStream resourceStream = EmployeeIO.class.getResourceAsStream("/data/employee.csv");

        if (resourceStream != null) {
            // Convert the InputStream to a String
            String fileContent = StreamReaderHandler.convertStreamToString(resourceStream);

            // to remove the unused row
            fileContent = fileContent.replaceFirst("employeeId,employeeName,employeeStatus,password\\n", "");

            // Print or process the file content as needed
            //System.out.println(fileContent);

            //split content
            String[] lineSplit = fileContent.split("\\n");

            for (String line : lineSplit) {
                String[] attributes = line.split(",");

                // attributes 0 = employeeId
                // attributes 1 = employeeName
                // attributes 2 = employeeStatus
                // attributes 3 = password
                EmployeeIO employee = new EmployeeIO(attributes[0], attributes[1],
                        Integer.parseInt(attributes[2]),attributes[3]);


                // Assign values using setter methods
                employee.setEmployeeId(attributes[0]);
                employee.setEmployeeName(attributes[1]);
                employee.setEmployeeStatus(Integer.parseInt(attributes[2]));
                employee.setPassword(attributes[3]);

                employees.add(employee);
            }

            
        } else {
            System.err.println("Resource file not found.");
        }
        return employees;        
    }
    
    //filtering 
    // by status
    public static List<EmployeeIO> filterEmployeeByStatus(int status) {
        List<EmployeeIO> filteredEmployee = new ArrayList<>();;
        
        // read and get all the data of employees
        List<EmployeeIO> employees = getEmployeeInput();
        
        for (EmployeeIO employee : employees) {
            //so that it stops lol,:3
            if (employee.employeeStatus==status) {
                // System.out.println("Employee with status " + status + ": " + employee.toString());
                filteredEmployee.add(employee);
            }
        }
        
        return filteredEmployee;
    }
    
    // searching
    // by employee name
    private static EmployeeIO searchEmployeeByEmployeeName(String employeeName) {
        // read and get all the data of employees
        List<EmployeeIO> employees = getEmployeeInput();
        
        for (EmployeeIO employee : employees) {
            //so that it stops lol,:3
            if (employee.employeeName.equals(employeeName)) {
                return employee;
            }
        }
        return null;
    }
    
    // searching
    // by employee id
    private static EmployeeIO searchEmployeeByEmployeeId(String employeeId) {
        // read and get all the data of employees
        List<EmployeeIO> employees = getEmployeeInput();
        
        for (EmployeeIO employee : employees) {
            //so that it stops lol,:3
            if (employee.employeeId.equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }
    
    public static int validateLogin(String enteredUsername, String enteredPassword) {
        // read and get all the data of employees
        List<EmployeeIO> employees = getEmployeeInput();
        
        for (EmployeeIO employee : employees) {
            if (employee.getEmployeeName().equals(enteredUsername) && employee.getPassword().equals(enteredPassword)) {
                // Matching credentials found
                // return its status
                return employee.getEmployeeStatus();
            }
        }
        return -1; // No matching credentials found
    }
}
