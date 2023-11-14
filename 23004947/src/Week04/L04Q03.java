/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author rz_rexton
 */
import java.util.*;
public class L04Q03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a score (negative value to quit) :");
        int num = sc.nextInt();
        int min = num, max = num;
        int x =0,x2=0,N=0;
        while (num>0){
            x +=num;
            x2 +=(num*num);
            N++;
            
            if(num>0){
                if (num>max){
                    max = num;
                }
            
                if (num<min){
                    min = num;
                }        
                System.out.print("Enter a score (negative value to quit) :");
                num = sc.nextInt();
            }
        }
        double std = (double)Math.sqrt((x2-(x*x)/N)/(N-1));
        double ave = (double)x/N;
        System.out.println("Minimum Score: "+min);
        System.out.println("Maximum Score: "+ max);
        System.out.printf("Average Score: %.2f",ave);
        System.out.printf("\nStandard Deviation %.2f: ",std);
        System.out.println("");
    }
}
