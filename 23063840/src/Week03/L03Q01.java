/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;

/**
 *
 * @author User
 */
import java.util.Scanner;

public class L03Q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two integer number:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Enter the operand");
        char c = sc.next().charAt(0);
        int result = 0;
        if (c == '+'){
            result = a + b;
        } else if (c == '-') {
            result = a - b;
        } else if (c == '*') {
            result = a * b;
        } else if (c == '%') {
            result = a % b;
        } else if (c == '/') {
            result = a / b;
        }
        System.out.println(a + " " + c + " " + b + " = " + result);
    }
}

