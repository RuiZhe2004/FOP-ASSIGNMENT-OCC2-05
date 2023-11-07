/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author lowji
 */
import java.util.Random;

public class L04Q06 {
    public static void main(String[] args) {
        Random rand = new Random();
        int count = 0;
        
        int num = rand.nextInt(Integer.MAX_VALUE);
        String str = String.valueOf(num);
        System.out.println("Number generated is " + str);
        System.out.println("Number of digits in the number is " + str.length());
        
    }
}
