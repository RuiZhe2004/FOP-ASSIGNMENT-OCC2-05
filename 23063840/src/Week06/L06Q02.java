/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author User
 */
import java.util.Scanner;
public class L06Q02 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number.");
        int a = sc.nextInt();
        System.out.println("Enter a character.");
        char b = sc.next().charAt(0);
        multiPrint(a, b);

    }

    public static void multiPrint(int n, char c) {

        String empty = " ";
        // printing triangle
        for (int i = 1; i <= n; i++) {
            // System.out.printf("%15s",empty);
            for (int j = 1; j <= n - i; j++) {
                System.out.print(empty);
            }

            for (int m = 1; m <= i; m++) {
                System.out.print(c);
                System.out.print(c);
                if (m == i) {
                    System.out.println();
                }

            }

        }
        System.out.println("\n\n");
        // printing diamond
        for (int i = 1; i <= n; i++) {
            // System.out.printf("%15s",empty);
            for (int j = 0; j <= n - i; j++) {
                System.out.print(empty);
            }

            for (int m = 1; m <= i; m++) {
                System.out.print(c);
                System.out.print(c);
                if (m == i) {
                    System.out.println();
                }

            }
        }
        for (int i = 1; i <= n; i++) {
            for (int x = n - 1; x >= n - i; x--) {
                System.out.print(empty);
            }
            for (int m = n; m >= i; m--) {
                System.out.print(c);
                System.out.print(c);
                if (m == i) {
                    System.out.println();
                }

            }
        }
    }
}

