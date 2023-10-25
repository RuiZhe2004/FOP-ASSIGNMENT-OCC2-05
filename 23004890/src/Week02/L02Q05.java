/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;
import java.util.Random;

/**
 *
 * @author ruizh
 */
public class L02Q05 {
   
    public static void main(String[] args){
        Random a = new Random();
        int num;
        int MIN = 0;
        int MAX = 10001;
        num = a.nextInt(MIN,MAX);
        System.out.print("The random number generated is "+ num +".\n");
        int sum = 0; // Variable for the sum of digits
        while (num > 0){ 
        /* 
        Here I use the addition of remainder of number when divided by 10.
        As we are only finding the sum of the digits, the sequence of adding is not important.
        For an example: For digit 789, 7+8+9 is same as 9+8+7.
        By dividing the number by 10, we can get the remainder each time, which is the last digit in the number.
        By dividing the quotient by 10 again and repeat it until quotient becomes 0, we can get all the digits in the number as remainder.
        By adding all the remainder along the way, we can get the sum of digits in the number.            
        */
            int remainder;
            remainder = num%10;
            sum = sum + remainder;
            num = num/10;
        }
        System.out.print("The sum of the digits in the random number generated is " + sum + ".\n");
    }

}
