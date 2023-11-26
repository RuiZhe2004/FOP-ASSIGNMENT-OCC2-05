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
import java.nio.charset.StandardCharsets;

import lecars.CustIO;
import lecars.EmployeeIO;
import lecars.VehicleIO;
import lecars.SalesIO;

public class LeCars {
    public static void main(String[] args) {
        String[][] cust = CustIO.getCustInput();        
        
        String[][] employee = EmployeeIO.getEmployeeInput();
        String[][] salesEmployee = EmployeeIO.separateEmployee(employee)[0];
        String[][] managementEmployee = EmployeeIO.separateEmployee(employee)[1];
        
        String[][] sales = SalesIO.getSalesInput();
        
        String[][] vehicle = VehicleIO.getVehicleInput();
        
               
    }
}
