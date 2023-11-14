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
public class L04Q07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter principal amount: ");
        int P = sc.nextInt(); //Principal
        
        System.out.print("Enter interest in %: ");
        int i = sc.nextInt();
        double h = (double)i/(12*100); 
        
        System.out.print("Enter total number of month(s): ");
        int N = sc.nextInt();
        double M = ((double)P*h)/(1-Math.pow((1+h),-N)); //Monthly payment
        
        System.out.printf("%-12s %-25s %-18s %-18s %-23s %-23s\n", "Month", "Monthly Payment", "Principal", "Interest","Unpaid Balance", "Total Interest");
        double totalinterest=0;
        
        for(int j=1 ; j<=N ; j++){
            double C = M*(Math.pow((1+h),-(1+N-j))); //Calculate Principal portion due
            double L = M-C; //Calculate interest due
            double R = L/h-C; //Calculate remaning principal balance due
            totalinterest += L;
            System.out.printf("%-12d %15.2f %19.2f %17.2f %24.2f %23.2f\n",j,M,C,L,R,totalinterest);
        }
        
    }
}
