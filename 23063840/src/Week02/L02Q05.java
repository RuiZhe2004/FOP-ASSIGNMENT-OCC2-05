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

public class L02Q05 {
    public static void main(String[] args) {
        Random r = new Random();
        int max = 10001;
        int num = r.nextInt(max);
        int sum = 0;
        System.out.println("The number is: " + num);
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        System.out.println("The sum of digits in the number is: " + sum);
    }

}