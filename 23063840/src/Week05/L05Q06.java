/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author User
 */
import java.util.Scanner;

public class L05Q06 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of row of Pascal Triangle to generate: ");
        int n = input.nextInt();
        System.out.println("The Pascal Triangle with " + n + " row(s)");
        n++;
        int[][] pascal = new int[n][n];
        pascal[1][1] = 1;

        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                System.out.printf("%-4d", pascal[i][j]);
            }
            System.out.println("");
        }

    }

}