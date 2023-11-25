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
public class L06Q02 {
    public static void main(String[] args) {
        Scanner i = new Scanner(System.in);
        System.out.print("Enter any character: ");
        char x = i.nextLine().charAt(0);
        multiPrint(9,x);
        System.out.println("");
        
        //Triangle
        System.out.println("Triangle: ");
        triangle(x);
        System.out.println("");
        
        //Diamond
        System.out.println("Diamond: ");
        diamond(x);
    }
    
    public static void multiPrint(int n, char c){
        for (int a = 0; a < n; a++){
            System.out.print(c + " ");
        }
    }
    
    public static void triangle(char c) {
        System.out.println("     "+c+"     ");
        System.out.println("   "+c+" "+c+" "+c+"   ");
        System.out.println(" "+c+" "+c+" "+c+" "+c+" "+c+" ");
    }
    
    public static void diamond(char c) {
        System.out.println("     "+c+"     ");
        System.out.println("   "+c+" "+c+" "+c+"   ");
        System.out.println(" "+c+" "+c+" "+c+" "+c+" "+c+" ");
        System.out.println(c+" "+c+" "+c+" "+c+" "+c+" "+c+" ");
        System.out.println(" "+c+" "+c+" "+c+" "+c+" "+c+" ");
        System.out.println("   "+c+" "+c+" "+c+"   ");
        System.out.println("     "+c+"     ");
    }
}
