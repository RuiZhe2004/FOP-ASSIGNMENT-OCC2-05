/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;
import java.util.Scanner;

/**
 *
 * @author ruizh
 */
public class L03Q05 {
    public static void main(String[] args) {
        System.out.println("ax + by = e and cx + dy = f");
        Scanner i = new Scanner(System.in);
        int a, b, c, d, e, f;
        System.out.print("Please enter the value of a: ");
        a = i.nextInt();
        
        System.out.print("Please enter the value of b: ");
        b = i.nextInt();
        
        System.out.print("Please enter the value of c: ");
        c = i.nextInt();
        
        System.out.print("Please enter the value of d: ");
        d = i.nextInt();
        
        System.out.print("Please enter the value of e: ");
        e = i.nextInt();
        
        System.out.print("Please enter the value of f: ");
        f = i.nextInt();
        
        int x, y;
        x = (((e*d)-(b*f))/((a*d)-(b*c)));
        y = (((a*f)-(e*c))/((a*d)-(b*c)));
        
        if (((a*d)-(b*c)) == 0){
            System.out.println("\nThe equation has no solution. Please try again.");
        }
        else{
            System.out.println("\nThe value of x is " + x + ".");
            System.out.println("The value of y is " + y + ".");
        }
    }
}
