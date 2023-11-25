/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author lowji
 */
import java.util.*;

public class L06Q06 {
    public static void main(String[] args) {
         int count = 0;
         System.out.println("Number is a palindromic prime: ");
         for (int i = 2; count < 20; i++) {
             if (palindromicPrime(i)) {
                 count++;
                 System.out.print(i + " ");
             }
         }           
         
         System.out.println("\n");
         int countEmirp = 0;
         
         System.out.println("Number is a EMIRP prime: ");
         for (int j = 2; countEmirp < 20; j++) {
             if(emirp(j)) {
                 countEmirp++;
                 System.out.print(j + " ");
             }         
         }

    }
    
    public static boolean emirp(int prime) {
        if (countFactors(prime) == 2) {
            int reversedPrime = reverse(prime);
            if (prime != reversedPrime) {
               if (countFactors(reversedPrime) == 2) {
                   return true;
               }               
            }
        }
        return false;
    }
    
    public static int reverse(int num) {
        int reverse = 0;
        while (num != 0) {
            int remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num /= 10;
        }
        return reverse;
    }
    
    public static boolean palindromicPrime (int prime) {
        if (countFactors(prime) == 2) {
            int reversedPrime = reverse(prime);
            if (prime == reversedPrime) {
               if (countFactors(reversedPrime) == 2) {
                   return true;
               }               
            }
        }
        return false;
    }
    
    
    
    public static int countFactors (int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }
}

