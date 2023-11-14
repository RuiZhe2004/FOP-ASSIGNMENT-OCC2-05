/* Write a program that accepts an integer n from user and then sum the following series
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

import java.util.Scanner;

/**
 *
 * @author lowji
 */
public class L04Q02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int sum = 0;


        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                sum += j;
            }
        }       
        System.out.println(sum);        
    }
}
