/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author lowji
 */
import java.util.Scanner;
public class L02Q02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter car price: ");
        float P = sc.nextFloat();
        System.out.print("Enter down payment: ");
        float D = sc.nextFloat();
        System.out.print("Enter interest rate(%): ");
        float R = sc.nextFloat();
        System.out.print("Enter loan duration in year: ");
        float Y = sc.nextFloat();
        
        float M = (P-D)*((1+(R*Y)/100)/(Y*12));
        
        System.out.printf("Monthly Payment: %.2f\n", M);
    }
}
