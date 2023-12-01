/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecars;

/**
 *
 * @author rz_rexton
 */
import java.io.*;
import java.util.List;
import static lecars.EmployeeIO.getEmployeeInput;
import static lecars.EmployeeIO.filterEmployeeByStatus;

public class ManageEmployee {
    public static void main(String[] args) {
    }

    private static void NewManageEmployee(String employeeId, String employeeName) {
        
        //load the list of all employees
        List<EmployeeIO> employees = getEmployeeInput();
        
        boolean found = false; //flag for found employee
        boolean alreadyManagementLevel = false; //flag for already management level
        String targetemp = ""; 

        for (EmployeeIO employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {  //if employeeid inserted found
                found = true;
                if (employee.getEmployeeStatus() == 1) {   //when status is already 1
                    alreadyManagementLevel = true;
                    targetemp = employee.getEmployeeName();   //save the found employee name
                    break;
                } else {
                    employee.setEmployeeStatus(1);   //set the status to 1
                    targetemp = employee.getEmployeeName(); //save the found employee name
                    break;
                }
            }
        }

        try {
            File file = new File("src/data/employee.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            // Write header row
            writer.write("employeeId,employeeName,employeeStatus,password\n");

            // Rewrite the original employee details after the target employee status is changed
            for (EmployeeIO employee : employees) {
                writer.write(employee.toString() + "\n");
            }

            writer.close();

            if (!alreadyManagementLevel && !found) {
                System.out.println("Employee with ID " + employeeId + " and name " + employeeName + " are not found.");
            } else if (alreadyManagementLevel) {
                System.out.println("Employee with ID " + employeeId + ", " + targetemp + " is already a management level employee.");
            } else {
                System.out.println("Employee with ID " + employeeId + ", " + targetemp + " has been updated to a management level employee.");
            }
        } catch (IOException e) {
            e.printStackTrace();  //catches any IOException that might occur during file writing operations.
        }
    }
}