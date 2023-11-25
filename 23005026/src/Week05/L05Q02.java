/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author lowji
 */
import java.util.*;

public class L05Q02 {
    public static void main(String[] args) {
        Random rand = new Random();        

        int []non = new int[10];
        boolean []flags = new boolean[21];
        
        Arrays.fill(flags, false);
        
        
        for (int i = 0; i < non.length; i++) {
            int num = rand.nextInt(21);
            
            if (!flags[num]) {
                flags[num] = true;
                non[i] = num;
            }
        }
        
        System.out.println(Arrays.toString(non));
    }
}
