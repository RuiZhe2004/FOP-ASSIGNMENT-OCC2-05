/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author rz_rexton
 */
import java.util.*;
public class L05Q02 {
    public static void main(String[] args) {
        Random g = new Random();
        int num[] = new int[10];

        for (int i = 0; i < num.length; i++) {
            num[i] = g.nextInt(21);
            
            // Check for duplicates in previous elements
            for (int j = 0; j < i; j++) {
                
                // If a duplicate is found, regenerate the random number
                while (num[i] == num[j]) {
                    num[i] = g.nextInt(21);
                }
            }
        }

        System.out.print("10 non-duplicate random integers: ");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println("");
    }
}






