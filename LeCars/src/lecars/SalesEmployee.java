/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecars;

/**
 *
 * @author szeyu
 */

import java.io.*;

public class SalesEmployee extends EmployeeIO {
    public static void main(String[] args) {
        registerNewUser("test","test");
    }
    public static void registerNewUser(String employeeName, String password){
        // employeeID Auto Increment
        String employeeID;
        employeeID = "E0016";
        
        // status always 0 as a sales employee
        final String status = "0";
        
        try(FileWriter fw = new FileWriter("src/data/employee.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) // give access to println (coder friendly)
        {
            String lineOfData = employeeID + "," + employeeName + "," + status + "," + password;
            out.println(lineOfData);
            
            out.close();
            System.out.println("Successfully wrote to the file.");
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
}
