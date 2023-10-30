/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;

/**
 *
 * @author rz_rexton
 */
import java.util.Scanner;
public class L03Q06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of circle(cm): ");
        double radius = sc.nextDouble();
        
        System.out.print("\nEnter the x-coordinate of a point: ");
        double x = sc.nextDouble();
        
        System.out.print("\nEnter the y-coordinate of the same point: ");
        double y = sc.nextDouble();
        
        if ( (y*y) + (x*x) >(radius*radius))
            System.out.println("The point is outside the circle. ");
        else
            System.out.println("The point is inside the circle.");
    }
}
