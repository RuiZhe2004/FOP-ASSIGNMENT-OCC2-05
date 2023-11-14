/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author rz_rexton
 */
import java.util.*;
public class L05Q01 {
    public static void main(String[] args) {
        Random g = new Random();
        Scanner sc = new Scanner(System.in);
        int total =0;
        
        System.out.print("Enter num of students: ");
        int N = sc.nextInt();
        int[] scores = new int[N];
        System.out.println("");
        
        System.out.println("Student | Score               ");
        for(int i=0;i<N;i++){
            scores[i] = g.nextInt(101);
            System.out.println("   "+(i+1)+"       "+scores[i]);
            total+=scores[i];
        }
        System.out.println("");
        int min = scores[0],max = scores[0];
        for(int i=0;i<scores.length-1;i++){
            if(scores[i+1]<min)
                min = scores[i+1];
            if(scores[i+1]>max)
                max = scores[i+1];
        }
        double average = (double)total/N;
        System.out.println("");
        System.out.println("Highest score: "+ max);
        System.out.println("Lowest score: "+min);
        System.out.printf("Average score: %.2f",average);
        System.out.println("");
     }
}

    

