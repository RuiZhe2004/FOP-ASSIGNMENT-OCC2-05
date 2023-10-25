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
public class L02Q06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount of water in gram: ");
        int mass = sc.nextInt();
        
        System.out.print("Enter the initial temperature in Fahrenheit: ");
        double initemp = sc.nextDouble();
        initemp=(initemp-32)/1.8;
        
        System.out.print("Enter the final temperature in Fahrenheit: ");
        double finaltemp = sc.nextDouble();
        finaltemp = (finaltemp-32)/1.8;
        
        //Calculation:
        int M = mass/1000;
        double Q = M*(finaltemp - initemp)*4184;
        
        System.out.printf("The energy needed is %e%n",Q);
    }
    
}
