/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author lowji
 */
import java.util.*;
public class L05Q03 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter n employees: ");
        int employee = sc.nextInt();
        int []workingHours = new int[employee];
        int sum = 0;
        
        for (int i = 0; i < employee; i++) {
            int hoursWork = rand.nextInt(8)+1;
            workingHours[i] = hoursWork;
            sum += hoursWork;
        }
        
        System.out.println("Work hours in seven days " + sum);
        for (int i = 0; i < employee; i++) {
            System.out.println("Employee " + (i+1) + " worked " + workingHours[i] + " total hours");
        }
    }
}
