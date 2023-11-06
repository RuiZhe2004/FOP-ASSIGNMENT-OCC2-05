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

public class L03Q06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of circle:");
        double r = sc.nextDouble();
        System.out.print("Enter coordinate x:");
        double x = sc.nextDouble();
        System.out.print("Enter coordinate y:");
        double y = sc.nextDouble();
        double distance = Math.sqrt(x * x + y * y);
        if (distance <= r) {
            System.out.println("The point is inside the circle");
        } else {
            System.out.println("The point is outside the circle");
        }

    }

}