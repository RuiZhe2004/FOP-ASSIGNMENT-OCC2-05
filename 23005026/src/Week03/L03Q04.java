/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;

import java.util.Random;

/**
 *
 * @author lowji
 */
public class L03Q04 {
    public static void main(String[] args) {
        Random rand = new Random();
        
        //Round 1
        int p1R1 = rand.nextInt(1,6+1);
        int p2R1 = rand.nextInt(1,6+1);
        
        System.out.println("----------Round 1---------");
        System.out.printf("Player 1 get %d \nPlayer 2 get %d \n", p1R1, p2R1);
        
        //Round 2
        int p1R2 = rand.nextInt(1,6+1);
        int p2R2 = rand.nextInt(1,6+1);
        
        System.out.println("----------Round 2---------");
        System.out.printf("Player 1 get %d \nPlayer 2 get %d \n", p1R2, p2R2);
        
        //total score
        int sumP1 = p1R1 + p1R2;
        int sumP2 = p2R1 + p2R2;
        
        switch (Integer.compare(sumP1,sumP2)) {
            case 1:
                System.out.println("\nPlayer 1 win the game");
                break;
            case -1:
                System.out.println("\nPlayer 2 win the game");
                break;
            default: 
                System.out.println("Draw");
                break;
        }
    }    
}
