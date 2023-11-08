/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author User
 */
public class L04Q02 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter an Integer: ");
        int a = sc.nextInt();
        int nterm = 0;
        int sum = 0;
        for (int i = 1; i <= a; i++) {
            nterm = nterm + i;
            sum = sum + nterm;
        }
        System.out.printf("The sum is " + sum);

    }

}