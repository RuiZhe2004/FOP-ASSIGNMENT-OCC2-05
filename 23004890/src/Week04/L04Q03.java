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
public class L04Q03 {
    public static void main(String[] args) {
        Scanner i = new Scanner (System.in);
        System.out.print("Enter a score [negative score to quit]: ");
        
        double num, n, average; 
        //num is the marks entered
        //n is the number of subjects (number of marks entered)
        
        n = 1;
        //Since 1 mark is entered before this, the initial number of subject is 1
        
        num = i.nextDouble();
        
        double total = num;
        //total is the cumulative marks (to get the total marks)
        //In this case, the total mark is the first mark (since there is only one mark entered)
        
        double min = num;
        //min is the minimum mark entered
        //In this case, the minimum mark is the first mark (since there is only one mark entered)
        
        double max = num;
        //max is the maximum mark entered
        //In this case, the maximum mark is the first mark (since there is only one mark entered)
        
        double num2 = num*num;
        //num2 is num square
        
        double num2t = num2;
        //num2t is the summation of the num square
        //In this case, the summation of the num square is the square of first mark (since there is only one mark entered)
        
        while (num >= 0){
        //The system will continue running unless a negative score is entered
        
            System.out.print("Enter a score [negative score to quit]: ");
            num = i.nextInt();
            //The entering of consecutive marks
            
            if (num < 0)
                continue;
            //If the marks entered is less than 0 (negative number), skip and end the loop and directly continue with the next step
            
            while (num > max){
                max = num;
            }
            //If the new number entered is larger than the existing maximum number, replace the maximum number with the new number
            while (num < min){
                min = num;
            }
            //If the new number entered is less than the existing minimum number, replace the minimum number with the new number
            
            num2 = num*num;
            //Calculate the number square of the new number entered
            
            num2t += num2;
            /*The total of number square is calculated by 
                    The existing total of number square + new number square calculated
            */
            
            total += num;
            /*The total sum of number is calculated by 
                    The existing sum of number + new number 
            */
            
            n ++;
            //Add 1 to the number of subject
        }
        average = total/n;
        /*Formula to calculate the average marks
                    Total marks/ Number of subject
        */
        
        double total2 = total*total;
        //total2 is square of total (to be used in calculation of standard deviation)
        
        double numerator;
        numerator = num2t - (total2/n);
        //numerator inside the square root (according to formula)
        
        double sd = Math.sqrt(numerator/(n-1));
        //Calculation of the standard deviation (according to formula)
        
        //Output
        System.out.printf("\nTotal Score: %.2f\n", total);
        System.out.printf("Maximum Score: %.2f\n", max);
        System.out.printf("Minimum Score: %.2f\n", min);
        System.out.printf("Average Score: %.2f\n", average);
        System.out.printf("Standard Deviation: %.2f\n", sd);
    }
    
}
