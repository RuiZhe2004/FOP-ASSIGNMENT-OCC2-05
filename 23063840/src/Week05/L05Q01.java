/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author User
 */
import java.util.Random;
import java.util.Scanner;

public class L05Q01 {

    public static void main(String[] args) {
        Random r = new Random();
        System.out.println("Enter number od students.");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] student = new int[n];
        int high = 0, low = 100, sum = 0;
        for (int i = 0; i < n; i++) {
            student[i] = r.nextInt(101);
            if (high < student[i]) {
                high = student[i];
            }
            if (low > student[i]) {
                low = student[i];
            }
            sum += student[i];
            System.out.println("The score of student " + (i + 1) + " is " + student[i]);
        }
        System.out.println("The highest score is " + high);
        System.out.println("The lowest score is " + low);
        System.out.println("The average score is " + (double) (sum / n));

    }
}
