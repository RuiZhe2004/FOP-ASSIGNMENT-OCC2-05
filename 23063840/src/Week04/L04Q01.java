/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author User
 */
import java.util.Scanner;

public class L04Q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer:");
        int a = sc.nextInt();
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                System.out.print(" " + i);
                if (i != a) {
                    System.out.print(",");
                }

            }
        }

    }

}
