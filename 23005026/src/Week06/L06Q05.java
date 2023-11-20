/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author lowji
 */
import java.util.*;

public class L06Q05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        //System.out.println("Enter negative number to quit.");
        boolean quit = true;
        int score = 0;
        while (quit) {
            int a = rand.nextInt(13);
            int b = rand.nextInt(13); 
            
            System.out.println("Enter negative number to quit.");
            System.out.print(a + " × " + b + " = ");
            
            int c = sc.nextInt();
            score += game(a, b, c);
            
            if (c == -1) {
                System.out.println("Your score is " + score);
                quit = false;
            }            
        }
        
    }
    
    public static int game (int a, int b, int c) {        
        int ans = a * b;
        int score = 0;
        if (ans == c) {
            score++;
            return score;
        }
        return score;
    }
}
