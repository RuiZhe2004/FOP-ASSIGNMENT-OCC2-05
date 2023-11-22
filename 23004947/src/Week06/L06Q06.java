/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author rz_rexton
 */
public class L06Q06 {
    public static void main(String[] args) {
        int count = 0;
        int i = 2; // Start from the first prime number
        
        System.out.println("First 20 Palindromic Prime :");
        while (count < 20) {
            if (palindromicprime(i)) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
        System.out.println("\n");
        
        count = 0;
        i = 2; // Reset count and i for emirp primes
        
        System.out.println("First 20 Emirp Prime :");
        while (count < 20) {
            if (emirp(i)) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
        System.out.println("\n");
    }

    public static boolean palindromicprime(int num) {
        return (palindrome(num) && prime(num));
    }

    public static boolean emirp(int num) {
        return (!palindrome(num) && prime(num) && prime(Reversed(num)));
    }

    public static int Reversed(int num) {
        int reverse = 0;
        while (num != 0) {
            int rmd = num % 10;
            reverse = reverse * 10 + rmd;
            num /= 10;
        }
        return reverse;
    }

    public static boolean palindrome(int num) {
        return Reversed(num) == num;
    }

    public static boolean prime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
