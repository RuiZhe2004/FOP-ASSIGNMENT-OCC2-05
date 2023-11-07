/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author User
 */
public class L02Q01 {
    public static void main(String[] args) {
        java.util.Scanner sc= new java.util.Scanner(System.in);
        System.out.println("Please enter temperature in Fahrenheit.");
        float f=sc.nextFloat();
        double c=(f-32)/1.8;
        System.out.printf("\nThe temperature is %.2f" ,c);
        System.out.print(" degree Celsius.");
    }
    
}