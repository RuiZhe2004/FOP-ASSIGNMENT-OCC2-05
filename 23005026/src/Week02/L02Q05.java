/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author lowji
 */
import java.util.Random;
public class L02Q05 {
    public static void main(String[] args) {
        Random rand = new Random();
        int num = rand.nextInt(10000);
        
        System.out.println("Generate random number is " + num);
        
        int sum = 0;
        while (num != 0) {
            int digit = num % 10;
            sum += digit;
            num /=10;
        }
        
        System.out.println("The sum of all digit in the number is " + sum);
    }
}
