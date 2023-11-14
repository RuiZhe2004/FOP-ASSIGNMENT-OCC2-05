/* This program will calculates the minimum, maximum, average and standard deviation (s) of the exam score in a subject. 
 * The program will accepts the score and quit if negative score is enter
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author lowji
 */
import java.util.Scanner;

public class L04Q03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double sumX = 0;
        double sqrSumX = 0;
        double sqrX =0;
        double std = 0;
        double var = 0;
        int n = 0;
        double minScore = Double.MAX_VALUE;
        double maxScore = 0;
        double avg;
        double temp = 0;
        
        boolean isNegative = false;
        
        do {
            System.out.print("Enter a score [negative score to quit]: ");
            double score = sc.nextDouble();
            if (score < 0) {
                isNegative = true;
            } else {
                n +=1;
                sumX = sumX + score;
                temp = score;
                sqrX += temp*temp;
                minScore = Math.min(minScore, score);
                maxScore = Math.max(maxScore, score); 
            }
        } while (isNegative == false);
        
        sqrSumX = Math.pow(sumX, 2);
        var = (sqrX - (sqrSumX/n))/(n-1);
        std = Math.sqrt(var);
        avg = (double) (sumX/n);
        
        System.out.println("dunno what is this");
        System.out.println("Minimum Score: " + minScore);
        System.out.println("Maximum Score: " + maxScore);
        System.out.println("Average Score: " + avg);
        System.out.printf("Standard Deviation: %.2f\n", std);
    }
}
