/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;

/**
 *
 * @author rz_rexton
 */
import java.util.Scanner;
public class L03Q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two integer number: ");
        String input = sc.nextLine();
        String[] numbers = input.split(" "); // split by spaces
        
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        
        System.out.print("Enter the operand: ");
        char operand = sc.next().charAt(0);
        int value = 0;
        
        switch(operand){
            case '+':
                value = num1+num2;
                break;
            case '-':
                value = num1-num2;
                break;
            case '*':
                value = num1*num2;
                break;
            case '/':
                value = num1/num2;
                break;
        }
        System.out.println(num1 + " " + operand +" "+ num2+" = "+ value);
    }
}
