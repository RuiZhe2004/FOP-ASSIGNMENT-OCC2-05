/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author lowji
 */
import com.sun.tools.javac.code.Attribute;
import java.util.*; 

public class L05Q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int []scores = new int[n];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            scores[i] = rand.nextInt(101);
            sum += scores[i];
        }
        int avg = sum/n;
        
        for (int i = 0; i < n; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        
        System.out.println("List of scores:");
        System.out.println(Arrays.toString(scores));
        System.out.println("Highest score: " + max);
        System.out.println("Lowest score: " + min);
        System.out.println("Average score: " + avg);
    }
}
