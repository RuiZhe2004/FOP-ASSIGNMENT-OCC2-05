/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author rz_rexton
 */
import java.util.Random;

public class L04Q08 {
    public static void main(String[] args) {
        Random g = new Random();
        int n = g.nextInt(101); // Random integer from 0 to 100
        System.out.println("The first " + n + " prime numbers: ");
        int count = 0;
        int i = 2;

        while (count < n) {
            boolean isPrime = true;

            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(i);
                count++;
            }
            i++; // Move to the next number
        }
    }
}
