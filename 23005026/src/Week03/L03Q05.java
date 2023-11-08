/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;

import java.util.Scanner;

/**
 *
 * @author lowji
 */
public class L03Q05 {

    static int prompt (String input) {
        Scanner sc = new Scanner(System.in);
        System.out.print(input);
        return sc.nextInt();
    }

    public static void main(String[] args) {
        int a, b, c, d, e, f, x, y;

        // Initialize all variables to 0
        //a = b = c = d = e = f = x = y = 0;

        Scanner sc = new Scanner(System.in);

        a = prompt("Enter a: ");
        b = prompt("Enter b: ");
        c = prompt("Enter c: ");
        d = prompt("Enter d: ");
        e = prompt("Enter e: ");
        f = prompt("Enter f: ");
        

        if ((a * d - b * c) != 0) {
            x = (e * d - b * f) / (a * d - b * c);
            y = (a * f - e * c) / (a * d - b * c);

            System.out.println("The value of x is "+ x);
            System.out.println("The value of y is "+ y);
        } else {
            System.out.println("The equation has no solution.");
        }

   }    
}
