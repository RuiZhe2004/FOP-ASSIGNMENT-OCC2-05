/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 *
 * @author ruizh
 */
public class L02Q02 {
    private static final DecimalFormat decfor = new DecimalFormat ("0.00");
    public static void main(String[] args){
        Scanner i = new Scanner (System.in);
        double price; // price is variable for the price of the car
        System.out.print("Please enter the price of the car (in RM)    : ");
        price = i.nextDouble();
        double dp; // dp is variable for down payment
        System.out.print("Please enter the down payment paid (in RM)   : ");
        dp = i.nextDouble();
        double ir; // ir is variable for interest rate
        System.out.print("Please enter the interest rate charged (in %): ");
        ir = i.nextDouble();
        double duration; // duration is variable for loan duration in unit year
        System.out.print("Please enter the loan duration (in years)    : ");
        duration = i.nextDouble();
        double payment; // payment is variable for the monthly payment needed
        payment = ((price-dp)*(1+ ir*duration/100))/(duration*12);
        System.out.println("\nThe monthly payment of car loan needed is RM" + decfor.format(payment) +".\n");
        
    }
        
    
}
