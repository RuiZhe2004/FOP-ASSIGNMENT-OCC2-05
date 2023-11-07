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
public class L04Q06 {
    public static void main(String[] args) {
        int num;
        num = (int)(Math.random()*(Integer.MAX_VALUE + 0));
        //(int)(Math.random() * ((upperbound - lowerbound) + 1) + lowerbound)
        /*
        In this case, ((upperbound - lowerbound) + 1) + 0  
        (Integer.MAX_VALUE - 0) + 1
        **Integer.MAX_VALUE is a constant in the Integer class of java.lang package that specifies that stores 
        the maximum possible value for any integer variable in Java. **
        */
        
        System.out.println("Random number generated: " + num);
        String nums;
        nums = Integer.toString(num);
        int count;
        count = nums.length();
        System.out.println("Number of digits in the integer: " + count);
    }
}