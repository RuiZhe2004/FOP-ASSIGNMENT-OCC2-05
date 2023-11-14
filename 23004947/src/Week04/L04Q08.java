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
        int num = g.nextInt(101); // Random integer from 0 to 100
        System.out.println("The first " + num + " prime numbers: ");
        int count = 0;
        int i = 2;

        while (count < num) { //help to meet the required num of prime number
            boolean isPrime = true; //using this function helps me to print out prime num that is verified

            for (int j = 2; j <= i / 2; j++) { //using i/2 helps to include 2 & 3 as prime number
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(i);
                count++;
            }
            i++; // Use other factor to check prime number
        }
    }
}
