/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;
import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author ruizh
 */
public class L04Q07 {
    public static void main(String[] args) {
        Scanner i = new Scanner (System.in);
        System.out.print("Enter principal amount: ");
        double principal, interest, monthlyPayment, principalPortion, interestDue, balance, totalInterest;
        principal = i.nextDouble();
        System.out.print("Enter interest in %: ");
        interest = i.nextDouble();
        System.out.print("Enter total number of month(s): ");
        int month;
        month = i.nextInt();
        monthlyPayment = ((principal)*(interest/1200))/(1-Math.pow((1+(interest/1200)),-month));
        totalInterest = 0.00;
        
        System.out.printf("Month  |  Monthly Payment  |  Principal  |  Interest  |  Unpaid Balance  |  Total Interest\n");
        
        for (int counter = 1; counter < month + 1; counter++){
            principalPortion = monthlyPayment * (Math.pow((1+(interest/1200)),-(1+month-counter)));
            interestDue = monthlyPayment - principalPortion;
            balance = (interestDue/(interest/1200)) - principalPortion;
            totalInterest += interestDue;
            System.out.printf("%d \t\t%10.2f  \t %8.2f \t%7.2f   \t  %9.2f \t %14.2f\n", counter, monthlyPayment, principalPortion, interestDue, balance, totalInterest);
        }
            
    }
}
