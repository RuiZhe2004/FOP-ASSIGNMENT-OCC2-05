/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author User
 */
public class L06Q04 {
     public static void main(String[] args) {
        System.out.println("GCD(24,8) = " + gcd(24, 8));
        System.out.println("");
        System.out.println("GCD(200,625) = " + gcd(200, 625));

    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;

        System.out.println(b + " mod " + a + " = " + b % a); // for display purpose
        return gcd(b % a, a);
    }
}

