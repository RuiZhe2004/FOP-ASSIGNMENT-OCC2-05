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
public class L02Q06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the amount of water in gram: ");
        double M = sc.nextInt()/1000;
        
        System.out.print("Enter the initial temperature in Fahrenheit: ");
        double i = (sc.nextDouble() -32)/1.8;
        
        System.out.print("Enter the final temperature in Fahrenheit: ");
        double f = (sc.nextDouble() -32)/1.8;
        
        double Q = M*(f-i)*4184;
        
        System.out.printf("The energy needed is %.6e\n", Q);
    }
}