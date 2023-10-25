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

public class L02Q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter temperature in degree Fahrenheit: ");
        float fahrenheit = sc.nextFloat();
        float celcius = (fahrenheit -32)/1.8f;
        
        System.out.printf("%.2f\n",celcius);
    }
}
