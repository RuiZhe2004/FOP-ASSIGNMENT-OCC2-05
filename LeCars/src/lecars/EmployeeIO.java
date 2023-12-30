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
    
    //without pw
    public EmployeeIO(String employeeId, String employeeName, int employeeStatus) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeStatus = employeeStatus;
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
    
    /**
     * Reads and parses employee data from a CSV file, including employee ID, name, status, and password.
     *
     * <pre>
     * Pseudocode:
     * 1) Get an InputStream for the resource file employee.csv.
     * 2) Convert the InputStream to a String.
     * 3) Remove the first line (header row) from the String.
     * 4) Split the String into lines.
     * 5) For each line, split it into attributes.
     * 6) Parse the attributes to create an EmployeeIO object.
     * 7) Add the EmployeeIO object to a list.
     * 8) Return the list of EmployeeIO objects.
     * </pre>
     *
     * @method getEmployeeInput
     * @return A list of EmployeeIO objects representing the employees in the CSV file.
     * @see EmployeeIO
     */
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
    
    
    /**
     * Reads and parses employee data from a CSV file, including employee ID, name, and status, but not password.
     *
     * <pre>
     * Pseudocode:
     * 1) Get an InputStream for the resource file employee.csv.
     * 2) Convert the InputStream to a String.
     * 3) Remove the first line (header row) from the String.
     * 4) Split the String into lines.
     * 5) For each line, split it into attributes.
     * 6) Ensure there are enough attributes to create an EmployeeIO object.
     * 7) Create an EmployeeIO object without the password.
     * 8) Assign values to the EmployeeIO object using setter methods.
     * 9) Add the EmployeeIO object to a list.
     * 10) Return the list of EmployeeIO objects.
     * </pre>
     *
     * @method getEmployeeInputwithoutpw
     * @return A list of EmployeeIO objects representing the employees in the CSV file, without passwords.
     * @see EmployeeIO
     */
    public static List<EmployeeIO> getEmployeeInputwithoutpw() {
        List<EmployeeIO> employees = new ArrayList<>();

        // Get an InputStream for the resource file employee.csv
        InputStream resourceStream = EmployeeIO.class.getResourceAsStream("/data/employee.csv");

        if (resourceStream != null) {
            // Convert the InputStream to a String
            String fileContent = StreamReaderHandler.convertStreamToString(resourceStream);

            // Remove the unused row
            fileContent = fileContent.replaceFirst("employeeId,employeeName,employeeStatus,password\\n", "");

            // Split content
            String[] lineSplit = fileContent.split("\\n");

            for (String line : lineSplit) {
                String[] attributes = line.split(",");

                // Ensure there are enough attributes to create an EmployeeIO object
                if (attributes.length >= 4) {
                    // Create EmployeeIO without including the password
                    EmployeeIO employee = new EmployeeIO(attributes[0], attributes[1], Integer.parseInt(attributes[2]));

                    // Assign values using setter methods
                    employee.setEmployeeId(attributes[0]);
                    employee.setEmployeeName(attributes[1]);
                    employee.setEmployeeStatus(Integer.parseInt(attributes[2]));

                    employees.add(employee);
                }
            }
        } else {
            System.err.println("Resource file not found.");
        }
    return employees;
    }

    /**
     * Filters the list of employees by the given status.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all employees using the getEmployeeInput() method.
     * 2) Iterate through the list of employees and filter by the given status.
     * 3) Return the filtered list of employees.
     * </pre>
     *
     * @param status the status to filter by
     * @return a list of employees with the given status
     * @see EmployeeIO#getEmployeeInput()
     */
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
    
    /**
     * Searches for an employee by employee name.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all employees using the getEmployeeInput() method.
     * 2) Iterate through the list of employees and search for the employee with the given name.
     * 3) Return the found employee, or null if no such employee is found.
     * </pre>
     *
     * @param employeeName the name of the employee to search for
     * @return the employee with the given name, or null if no such employee is found
     * @see EmployeeIO#getEmployeeInput()
     */
    // searching
    // by employee name
    public static EmployeeIO searchEmployeeByEmployeeName(String employeeName) {
        // read and get all the data of employees
        List<EmployeeIO> employees = getEmployeeInput();
        
        for (EmployeeIO employee : employees) {
            //so that it stops lol,:3
            if (employee.getEmployeeName().equals(employeeName)) {
                return employee;
            }
        }
        return null;
    }
    
    /**
     * Searches for an employee by employee ID.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all employees using the getEmployeeInput() method.
     * 2) Iterate through the list of employees and search for the employee with the given ID.
     * 3) Return the found employee, or null if no such employee is found.
     * </pre>
     *
     * @param employeeId the ID of the employee to search for
     * @return the employee with the given ID, or null if no such employee is found
     * @see EmployeeIO#getEmployeeInput()
     */
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
    
    /**
     * Validates a user's login credentials.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all employees using the getEmployeeInput() method.
     * 2) Iterate through the list of employees and search for the employee with the given username and password.
     * 3) If a matching employee is found, return the employee's status.
     * 4) If no matching employee is found, return -1.
     * </pre>
     *
     * @param enteredUsername the username entered by the user
     * @param enteredPassword the password entered by the user
     * @return the employee's status if the credentials are valid, or -1 if the credentials are invalid
     * @see EmployeeIO#getEmployeeInput()
     */
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
