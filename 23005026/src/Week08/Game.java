/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week08;

/**
 *
 * @author lowji
 */
import java.util.*;
public class Game {
    private String name;
    private int score;
    private static Random r = new Random();
    
    public Game(String name) {
        this.name = name;
        this.score = 0;
    }
    
    public String getName() {
        return this.name;
    }

    public void rollDice() {
        int dice = r.nextInt(6)+1;
        this.score += dice;
        System.out.println(name + " rolled " + dice + " - Current score: " + this.score);
    }
    
    public boolean won() {
        return this.score >= 100;
    }
}
