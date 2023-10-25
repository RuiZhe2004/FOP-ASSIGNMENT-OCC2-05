/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author lowji
 */
import java.util.Random;
public class L02Q03 {
    public static void main(String[] args) {
        Random rand = new Random();
        
        float sum = 0;
        for (int i = 1; i < 4; i++) {
            int num = rand.nextInt(41)+10;
            sum = sum + num;
            System.out.printf("Number %d: %d\n",i , num);
        }
        
        float avg = sum / 3;
        System.out.printf("Sum of numbers: %.0f\n", sum);
        System.out.printf("Average of numbers: %.2f\n", avg);
        
    }
}