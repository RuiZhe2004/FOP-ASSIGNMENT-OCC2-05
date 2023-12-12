/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author User
 */
public class L06Q06 {
        public static void main(String[] args) {
        System.out.println("First 20 palindromic prime: ");
        int n = 2, cnt = 0;
        while (cnt < 20) {
            if (isPalindromicPrime(n)) {
                System.out.print(n + " ");
                cnt++;
            }
            n++;
        }
        System.out.println("\nFirst 20 emirp: ");
        n = 2;
        cnt = 0;
        while (cnt < 20) {
            if (isEmirp(n)) {
                System.out.print(n + " ");
                cnt++;
            }
            n++;
        }
        System.out.println("");
    }

    public static boolean isPalindromicPrime(int num) {
        if (!isPrime(num)) {
            return false;
        } else {
            return num == reverseNum(num);
        }
    }

    public static boolean isEmirp(int num) {
        if (!isPrime(num)) {
            return false;
        } else {
            int reversedNum = reverseNum(num);
            return isPrime(reversedNum) && num != reversedNum;
        }
    }

    public static boolean isPrime(int num) {
        boolean isPrime = true;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static int reverseNum(int num) {
        int reversedNum = 0;

        // reverse method1 (formula)
        for (int i = num; i != 0; i /= 10) {
            reversedNum = reversedNum * 10 + i % 10;
        }
        return reversedNum;
    }

}

