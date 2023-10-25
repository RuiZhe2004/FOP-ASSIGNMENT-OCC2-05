/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;
import java.util.Random;
import java.text.DecimalFormat;

/**
 *
 * @author ruizh
 */
public class L02Q03 {
    private static final DecimalFormat decfor = new DecimalFormat ("0.00");
    public static void main(String[] args){        
            Random a = new Random();
            int num1, num2, num3;
            int MIN = 10;
            int MAX = 51;
            num1 = a.nextInt(MIN,MAX);
            num2 = a.nextInt(MIN,MAX);
            num3 = a.nextInt(MIN,MAX);
            
            System.out.println("The random numbers are " + num1 + ", " + num2 + ", "+ num3 + "." );
            
            double sum;
            sum = num1 + num2 + num3;
            System.out.println("The sum of the three generated random numbers is " + sum + ".");
            
            double average;
            average = sum/3;
            System.out.println("The average of the three generated random numbers is " + decfor.format(average) + ".");
            
    }
    
}
