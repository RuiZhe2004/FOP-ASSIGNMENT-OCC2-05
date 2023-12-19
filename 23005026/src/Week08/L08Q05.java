/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week08;

/**
 *
 * @author lowji
 */
public class L08Q05 {
    public static void main(String[] args) {
        Game p1 = new Game("player 1");
        Game p2 = new Game("player 2");
        
        while(true) {
            p1.rollDice();
            if(p1.won()) {
                System.out.println(p1.getName() + " won!");
                break;
            }
            
            p2.rollDice();
            if(p2.won()) {
                System.out.println(p2.getName() + " won!");
                break;
            }
        }
        
    }
}
