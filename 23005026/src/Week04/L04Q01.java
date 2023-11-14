/*
 * Write a program that accepts an integer from user. 
 * Then, display its entire factors in increasing order
 * 
 */
package Week04;

import java.util.Scanner;

/**
 *
 * @author lowji
 */
public class L04Q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int num = sc.nextInt();

        //int count =0;
        for (int i = 1; i <= num; i++){
            if (num % i == 0) {
                System.out.print(i);
                //count++;
                if (i != num) {
                    System.out.print(", ");
                }
            }
        }

    }
}
