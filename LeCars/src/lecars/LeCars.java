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

public class LeCars {
    public static void main(String[] args) {
        String[][] cust = CustIO.getCustInput();
        System.out.println(cust[0][0]);
        
        String[][] employee = EmployeeIO.getEmployeeInput();
        System.out.println(employee[0][0]);
        
        String[][] salesEmployee = EmployeeIO.separateEmployee(employee)[0];
        String[][] managementEmployee = EmployeeIO.separateEmployee(employee)[1];
        
        for (int i = 0; i < salesEmployee.length; i++) {
            for (int j = 0; j < salesEmployee[i].length; j++) {
                System.out.print(salesEmployee[i][j] + " ");
            }
            System.out.println();  // Move to the next line after printing each row
        }
        System.out.println();
        for (int i = 0; i < managementEmployee.length; i++) {
            for (int j = 0; j < managementEmployee[i].length; j++) {
                System.out.print(managementEmployee[i][j] + " ");
            }
            System.out.println();  // Move to the next line after printing each row
        }

       
    }
}
