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
public class L03Q06 {
    public static void main(String[] args) {
        Scanner i = new Scanner (System.in);
        int radius, x, y;
        System.out.print("Please enter the radius of the circle: ");
        radius = i.nextInt();
        
        System.out.print("Please enter the x-coordinate for the of the circle: ");
        x = i.nextInt();
        
        System.out.print("Please enter the y-coordinate for the of the circle: ");
        y = i.nextInt();
        
        int rad, coor;
        rad = radius * radius;
        coor = (x * x) + (y * y);
        
        if (rad > coor){
            System.out.println("The point (" + x + "," + y + ") is inside the circle centered at (0, 0).");
        }
        else if (rad == coor){
            System.out.println("The point (" + x + "," + y + ") is on the circle centered at (0, 0).");
        }
        else{
            System.out.println("The point (" + x + "," + y + ") is outside the circle centered at (0, 0).");
        }
    }
    
}
