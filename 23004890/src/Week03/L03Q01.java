/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;
import java.util.Scanner;

/**
 *
 * @author ruizh
 */
public class L03Q01 {
        public static void main(String[] args){
        // For numbers part
        Scanner i = new Scanner (System.in);
        System.out.print ("Enter two integer number: ");
        int[] num = new int[2];
        for (int nums = 0; nums < 2; nums ++){
            num[nums] = i.nextInt();
        }
        
        //For operation Parts
        Scanner j = new Scanner (System.in);
        System.out.print ("Enter the operand: ");
        String ope;
        ope = j.nextLine();
        char operand;
        operand = ope.charAt(0);
        
        switch (operand) {
            case '+':
                int ansa; // ansa is answer for addition
                ansa = num[0] + num[1];
                System.out.print (String.format("%d %c %d", num[0], operand, num[1]));
                System.out.print (" = " + ansa + "\n");
                break;
            case '-':
                int anss; // anss is answer for subtraction
                anss = num[0] - num[1];
                System.out.print (String.format("%d %c %d", num[0], operand, num[1]));
                System.out.print (" = " + anss + "\n");
                break;
            case '*':
                int ansm; // ansm is answer for multiplication
                ansm = num[0] * num[1];
                System.out.print (String.format("%d %c %d", num[0], operand, num[1]));
                System.out.print (" = " + ansm + "\n");
                break;
            case '/':
                int ansd; // ansd is answer for division
                ansd = num[0] / num[1];
                System.out.print (String.format("%d %c %d", num[0], operand, num[1]));
                System.out.print (" = " + ansd + "\n");
                break;
            case '%':
                int ansr; // ansr is answer for remainder
                ansr = num[0] % num[1];
                System.out.print (String.format("%d %c %d", num[0], operand, num[1]));
                System.out.print (" = " + ansr + "\n");
                break;
            default:
                System.out.print ("System error. Please retry again.\n");
                break;
        }
    }
}
