/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 *
 * @author ruizh
 */
public class L03Q03 {
    private static final DecimalFormat decfor = new DecimalFormat ("0.00");
    public static void main(String[] args) {
        Scanner i = new Scanner (System.in);
        int sales;
        System.out.print("Please enter the sales volume (in RM): ");
        sales = i.nextInt();
        double commission;
        
        if (sales >= 0 && sales <= 100){
            commission = sales * 0.05;
            System.out.println("The commission is RM " + decfor.format(commission) + ".\n");
        }
        else if (sales > 100 && sales <= 500){    
        commission = sales * 0.075;
            System.out.println("The commission is RM " + decfor.format(commission) + ".\n");
        }
        else if (sales > 500 && sales <= 1000){    
        commission = sales * 0.1;
            System.out.println("The commission is RM " + decfor.format(commission) + ".\n");
        }
        else if (sales > 1000){    
        commission = sales * 0.125;
            System.out.println("The commission is RM " + decfor.format(commission) + ".\n");
        }
        else{
            System.out.println("System error. Please try again.");
        }
        
    }
    
}
