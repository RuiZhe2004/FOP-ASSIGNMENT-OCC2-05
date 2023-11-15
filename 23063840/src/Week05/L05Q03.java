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
import java.util.Random;
import static java.lang.System.out;

public class L05Q03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        out.print("\n\nEnter amount of employees.");
        int N = sc.nextInt();
        int hours[][] = new int[N][7];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            out.println("Employee " + (i + 1) + " :");
            for (int j = 0; j < 7; j++) {
                hours[i][j] = r.nextInt(8) + 1;
                out.println("Day " + (j + 1) + " : " + hours[i][j] + " hours.");
                sum += hours[i][j];
            }
            out.println("Total :" + sum + " hours.\n");

            sum = 0;
        }
    }

}