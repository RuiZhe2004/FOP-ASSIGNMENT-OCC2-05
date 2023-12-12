/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;
import java.util.Scanner;

/**
 *
 * @author ruizh
 */
public class L06Q04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int num1 = sc.nextInt();
        System.out.print("Enter number 2: ");
        int num2 = sc.nextInt();
        System.out.println("The GCD of " + num1 + " and " + num2 + " is " + GCD(num1,num2));
    }
    
    public static int GCD (int x, int y){
        int max, min;
        if (x > y){
            max = x; 
            min = y;
        }
        else {
            min = x;
            max = y;
        }
        
        if(max % min == 0)
            return min;
        
        return GCD(min, max%min);
        
 
    }
}
