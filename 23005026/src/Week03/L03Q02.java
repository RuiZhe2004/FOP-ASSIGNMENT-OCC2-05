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
public class L03Q02 {
    public static void main(String[] args) {
        
        Random rand = new Random();
        String[] word = {"zero", "one", "two", "three", "four", "five"};
        
        int generateNumber = rand.nextInt(word.length);
        System.out.printf("%d is %s.\n", generateNumber, word[generateNumber]);
        
    }    
}
