/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;

import java.util.Scanner;

/**
 *
 * @author lowji
 */
public class L03Q03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the sales volume: RM");
        double sale = sc.nextDouble();
        
        double com = 0;
        
        if (sale <= 100){
            com = sale * 0.05;
        } else if (sale > 100 && sale <= 500) {
            com = sale * 0.075;
        } else if (sale > 500 && sale <= 1000) {
            com = sale * 0.1;
        } else if (sale > 1000) {
            com = sale * 0.125;
        } else {
            System.out.println("sales is invalid");
        }
        
        System.out.printf("Commision: RM%.2f\n", com);
    }    
}
