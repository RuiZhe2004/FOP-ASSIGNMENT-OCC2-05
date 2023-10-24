/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;
/**
 *
 * @author rz_rexton
 */
import java.util.Scanner;
public class L02Q02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Price of car(RM) : ");
        double P = sc.nextDouble();
        
        System.out.print("Down payment(RM) : ");
        double D = sc.nextDouble();
        
        System.out.print("Interest rate (%) : ");
        double R = sc.nextDouble();
        
        System.out.print("Loan duration(year) : ");
        double Y = sc.nextDouble();
        System.out.println();
        
        double M = (P-D)*(1+R*Y/100)/(Y*12);
        System.out.printf("%s%.2f","Monthly Payment: ",M);
        System.out.println();
        
    }
}
