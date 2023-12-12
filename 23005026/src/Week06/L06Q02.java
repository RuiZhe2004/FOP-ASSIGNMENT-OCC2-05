/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author lowjiaxin
 */
public class L06Q02 {
    public static void main(String[] args) {
        //triangle
        triangle(3,'c');
        
        //print a line
        System.out.println();
        
        //diamond
        triangle(3, 'c');
        terbalikTriangle(3, 'c');
    }
    
    public static void triangle(int n, char c) {
        for (int line = 1; line <= n; line++) {
            print(line, c);
        }
    }
        
    public static void terbalikTriangle (int n, char c) {
        for (int line = n; line >= 1; line--) {
            print(line, c);
        }             
    }

    
    public static void print(int line, char c) {
        for (int space = 1; space <= -1 * line + 4; space++) {
            System.out.print(" ");
        }
        for (int character = 1; character <= 2 * line -1; character++) {
            System.out.print(c);
        }
        System.out.println();        
    }
}
