/* This program will generates the first n prime number. n is an random integer within 0 to 100.
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author lowji
 */
import java.util.Random;

public class L04Q08 {
     public static void main (String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(101); 
        System.out.println("N is " + n);
        printPrimeNumbers(n);
    }
    
    public static void printPrimeNumbers (int max) {
        for (int i = 2; i < max; i++) {
            if(countFactors(i) == 2) {
                System.out.print(i + " ");
            }            
        }

    }
    
    public static int countFactors (int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count ++;
            }
        }
        return count;
    }
}
