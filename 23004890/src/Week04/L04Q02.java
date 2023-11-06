/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;
import java.util.Scanner;

/**
 *
 * @author ruizh
 */
public class L04Q02 {
    public static void main(String[] args) {
        Scanner i = new Scanner (System.in);
        System.out.print("Enter an Integer: ");
        int num, sum, tsum;
        //sum is variable for the particular sum for that particular number only
        //tsum is variable for the total sum by adding all sum of the number
  
        num = i.nextInt();
        sum = 0; //Initialise sum to 0
        tsum = 0; //Initialise total sum to 0
        System.out.print("The total sum is ");
        
        for (int j=0; j <= num; j++){
            sum = sum + j;
            /*
            For example, 
            Initially, 0 + 1 = 1,
            2nd calculation, 1 + 2 = 3,
            3rd calculation, 3 + 3 = 6,
            4th calculation, 6 + 4 = 10, ......
            */
            tsum = tsum + sum;
            /*
            For example, 
            Initially, 0 + 1 = 1,
            2nd calculation, 1 + 3 = 4,
            3rd calculation, 4 + 6 = 10,
            4th calculation, 10 + 10 = 20, ......
            */
        }
        System.out.println (tsum + ".");
    }
}
