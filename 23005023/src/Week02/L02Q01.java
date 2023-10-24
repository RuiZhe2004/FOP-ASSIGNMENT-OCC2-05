/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author szeyu
 */
import java.util.Scanner;
public class L02Q01 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the temperature in degree Fahrenheit: ");
        double fahrenheit = input.nextDouble();
        System.out.println();
        
        double celsius = (fahrenheit-32)/1.8;
        System.out.printf("Celsius = %.2f%n", celsius);
    }
}
