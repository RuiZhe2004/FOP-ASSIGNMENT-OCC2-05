/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;
import java.util.Random;

/**
 *
 * @author ruizh
 */
public class L04Q05 {
    public static void main(String[] args) {
        Random a = new Random();
        int MIN = 1;
        int MAX = 7;
        
        int p1, p2, tp1 = 0, tp2 = 0;
        
        while ((tp1 < 100) && (tp2 < 100)){
            p1 = a.nextInt(MIN,MAX);
            p2 = a.nextInt(MIN,MAX);
            System.out.println("Player 1 this round: " + p1);
            System.out.println("Player 2 this round: " + p2);
            tp1 += p1;
            tp2 += p2;
            while (p1 == 6){
                p1 = a.nextInt(MIN,MAX);
                System.out.println("One more chance for Player 1: " + p1);
                tp1 += p1;
            }
            while (p2 == 6){
                p2 = a.nextInt(MIN,MAX);
                System.out.println("One more chance for Player 2: " + p2);
                tp2 += p2;
            }
            System.out.println("Player 1 overall: " + tp1);
            System.out.println("Player 2 overall: " + tp2 + "\n");
        }
        
        if (tp1 > tp2)
            System.out.println("Player 1 wins.");
        else if (tp2 > tp1)
            System.out.println("Player 2 wins.");
        else
            System.out.println("It is a tie.");
    }
    
}
