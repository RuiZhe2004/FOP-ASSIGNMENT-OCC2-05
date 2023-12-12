/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author lowji
 */

public class L06Q04 {

    public static void main(String[] args) {
        int a = 24;
        int b = 8;
        int g = gcd(a, b);
        int temp = 0;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }        
        System.out.println("GCD of " + a + " and " + b + " is " + g);
        
        a = 200;
        b = 625;
        g = gcd(a, b);
        // prerequisite: a > b
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }        
        System.out.println(a + " " + b);
        System.out.println("GCD of " + a + " and " + b + " is " + g);
               
    }
    
    public static int gcd(int a, int b) {
        if (b == 0) 
            return a;
        else
            return gcd(b, a%b);
    }    
        

}
