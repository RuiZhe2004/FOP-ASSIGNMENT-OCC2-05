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
        //read and get the employee data
        String[][] employee = getEmployeeInput();
        
        //Get the last row of EmployeeID
        String lastEmpID = (employee[employee.length-1][0]).substring(1);
        int intlastEmpID = Integer.parseInt(lastEmpID);  //Convert to int so that can +1
        
        // employeeID Auto Increment
        intlastEmpID++;   //+1
        String strlatestEmpID = Integer.toString(intlastEmpID); //Convert int back to string
        String combinedlatestEmpID = ("0000"+intlastEmpID); 
        String extractlast4digit = combinedlatestEmpID.substring(combinedlatestEmpID.length()-4); //extract the last 4 digit from the string
        
        //Get substring last 4 digit
        String employeeID;
        employeeID = "E"+extractlast4digit;

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
