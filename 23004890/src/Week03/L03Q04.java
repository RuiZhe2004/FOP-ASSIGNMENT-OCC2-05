/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;
import java.util.Random;

/**
 *
 * @author ruizh
 */
public class L03Q04 { 
    public static void main(String[] args) {
    
    Random i = new Random();
    int MIN = 1;
    int MAX = 7;
    int poneone, ptwoone, ponetwo, ptwotwo;
    poneone = i.nextInt(MIN,MAX);
    ponetwo = i.nextInt(MIN,MAX);
    
    ptwoone = i.nextInt(MIN,MAX);
    ptwotwo = i.nextInt(MIN,MAX);
    
    int tpone, tptwo;
    tpone = poneone + ponetwo;
    tptwo = ptwoone + ptwotwo;
    
    System.out.println("Player 1: " + poneone + " + " + ponetwo + " = " + tpone);
    System.out.println("Player 2: " + ptwoone + " + " + ptwotwo + " = " + tptwo);
    
    if (tpone > tptwo){
        System.out.println("Player 1 wins.");
    }
    else if (tpone == tptwo){
        System.out.println("It's a tie.");
    }
    else{
        System.out.println("Player 2 wins.");
    }
    
    }
    
}
