/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;
import java.util.*;
/**
 *
 * @author ruizh
 */
public class L05Q03 {
    public static void main(String[] args) {
        Scanner i = new Scanner(System.in);
        System.out.print("Please enter the number of employees: ");
        int employee;
        int total = 0;
        employee = i.nextInt();
        
        Random a = new Random();
        int[]hours = new int[7];
        for (int index = 0; index < employee; index++){
            System.out.print("Employee " + (index+1) +" : ");
            for (int counter = 0; counter < 7; counter++){
                hours[counter] = a.nextInt(1,9);
                System.out.print(hours[counter]+" ");
                total += hours[counter];
            }
            System.out.println("");
            System.out.print("Total working hours for employee " + (index+1) + " : " + total);
            total = 0;
            System.out.println("");
        }
        
    }
    
}
