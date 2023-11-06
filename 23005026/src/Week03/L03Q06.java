/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;

import java.util.Scanner;

/**
 *
 * @author lowji
 */
public class L03Q06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double xCenter = 0;
        double yCenter = 0;
        
        System.out.print("Enter x coordinate: ");
        double x = sc.nextDouble();
        System.out.print("Enter y coordinate: ");
        double y = sc.nextDouble();
        System.out.print("Enter radius of circle: ");
        double rad = sc.nextDouble();
        
        double dist = Math.hypot(x - xCenter, y - yCenter);
        //double dist = Math.sqrt((double)(x-xCenter)*(x-xCenter)+  (double) (y-yCenter)*(y-yCenter));
        
        if (rad > dist) {
            System.out.println("The point is inside of cirle");
        } else {
            System.out.println("The point is outside of circle");
        }
    }    
}
