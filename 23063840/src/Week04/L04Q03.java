/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author User
 */
public class L04Q03 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter a score[negative score to quit]: ");
        int a = sc.nextInt();
        double sum = a;
        int min = a;
        int max = a;
        double xsq = a * a;
        double avg = 0;
        double sd = 0;
        double sumsq = 0;
        for (int i = 2; a >= 0; i++) {
            System.out.print("Enter a score[negatuve score to quit]: ");
            a = sc.nextInt();
            if (a >= 0) {
                if (min > a) {
                    min = a;
                }
                if (max < a) {
                    max = a;
                }
                sum += a;
                avg = sum / i;
                xsq += a * a;
                sumsq = sum * sum / i;
            } else {
                xsq = (xsq - sumsq) / (i - 2);
                sd = Math.sqrt(xsq);
            }
        }
        System.out.print("\n" + xsq);
        // System.out.print("\n"+sumsq);
        System.out.print("\nMinimun Score: " + min);
        System.out.print("\nMaximum Score: " + max);
        System.out.printf("\nAverage Score: %.2f", avg);
        System.out.printf("\nStandard Deviation: %.2f", sd);
    }
}
