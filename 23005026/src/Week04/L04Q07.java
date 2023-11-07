/* This is a program that used to calculate mortgage loan.
 * The program will create the amortization table with equal total payment plan.
 * 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author lowji
 */
import java.util.Scanner;

public class L04Q07 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      
      double totalInterest = 0;
      
      System.out.print("Enter principal amount: ");
      double principal = sc.nextDouble();
      
      System.out.print("Enter interest in %: ");
      double interest = sc.nextDouble();
      
      System.out.print("Enter total number of month(s): ");
      double month = sc.nextDouble();
      
      double monthlyPayment = (principal * (interest/12/100)) / (1 - Math.pow(1 + (interest/12/100), -1 * month));;
      //System.out.print(monthlyPayment);
      
      System.out.printf("%5s %21s %18s %16s %23s %23s\n", "Month", "Monthly Payment", "Principal", "Interest", "Unpaid Balance", "Total Interest");
      
      for (int i = 1; i <= month; i++) {
         double principalPortionDue = monthlyPayment * Math.pow(1 + (interest/12/100), -1 * (1 + month - i));
         double monthlyInterestDue = monthlyPayment - principalPortionDue;
         double unpaidBalance = (monthlyInterestDue / (interest/12/100)) - principalPortionDue;
         totalInterest = totalInterest + monthlyInterestDue;
         
         System.out.printf("%5d %21.2f %18.2f %16.2f %23.2f %23.2f\n", i, monthlyPayment, principalPortionDue, monthlyInterestDue, unpaidBalance, totalInterest);
      }
   }
}
