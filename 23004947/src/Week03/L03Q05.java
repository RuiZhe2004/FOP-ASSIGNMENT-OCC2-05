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
public class L03Q05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Crammer's rule: \n");
        
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        
        System.out.print("Enter c: ");
        double c = sc.nextDouble();
        
        System.out.print("Enter d: ");
        double d = sc.nextDouble();
        
        System.out.print("Enter e: ");
        double e = sc.nextDouble();
        
        System.out.print("Enter f: ");
        double f = sc.nextDouble();
        
        //Calculate x&y
        double x = (e*d-b*f)/(a*d-b*c);
        double y = (a*f-e*c)/(a*d-b*c);
        
        if ((a*d-b*c)==0)
            System.out.println("The equation has no solution");
        else
            System.out.println("x: "+x+"\ny: "+ y);
    }
}
