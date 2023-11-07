/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;

/**
 *
 * @author User
 */
import java.util.Scanner;
public class L03Q05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Crammer's rule\n" + "ax+by+=e,cx+dy=f; " + "x=(ed-bf)/(ad-bc) y=(af-ec)/(ad-bc)");
        System.out.print("Enter value for a: ");
        int a = sc.nextInt();
        System.out.print("Enter value for b: ");
        int b = sc.nextInt();
        System.out.print("Enter value for c: ");
        int c = sc.nextInt();
        System.out.print("Enter value for d: ");
        int d = sc.nextInt();
        System.out.print("Enter value for e: ");
        int e = sc.nextInt();
        System.out.print("Enter value for f: ");
        int f = sc.nextInt();
        double resultX, resultY;
        if (a * d - b * c == 0) {
            System.out.println("The equation has no solution");
        } else {
            resultX = (e * d - b * c) / (a * d - b * c);
            resultY = (a * f - e * c) / (a * d - b * c);
            System.out.println("The result of x is " + resultX);
            System.out.println("The result of y is " + resultY);
        }

    }

}
