/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;

import java.util.Scanner;

/**
 *
 * @author lowji
 */
public class L03Q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     
        System.out.print("Enter two integer number: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        
        System.out.print("Enter the operand: ");
        char operand = sc.next().charAt(0);
        
        int result = 0;
        
        switch (operand) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Subtraction: " + (num1/num2));
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Mult");
                break;
            case '/':
                result = num1 / num2;
                System.out.println("");
                break;
            case '%':
                result = num1 % num2;
                System.out.println("");
                break;                 
        }
        
        System.out.printf("%d / %d = %d\n", num1, num2, result);
                
    }    
}
