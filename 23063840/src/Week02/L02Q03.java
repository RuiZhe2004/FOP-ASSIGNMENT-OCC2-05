/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author User
 */
import java.util.Random;

public class L02Q03 {
    public static void main(String[] args) {
        Random r = new Random();
        int max = 41;
        int num1 = r.nextInt(max) + 10;
        int num2 = r.nextInt(max) + 10;
        int num3 = r.nextInt(max) + 10;
        int sum = num1 + num2 + num3;
        double avr = sum / 3.0;
        System.out.println("First number is " + num1);
        System.out.println("Second number is " + num2);
        System.out.println("Third number is " + num3);
        System.out.println("Sum of three numbers is " + sum);
        System.out.printf("The average is %.2f", avr);
    }

}