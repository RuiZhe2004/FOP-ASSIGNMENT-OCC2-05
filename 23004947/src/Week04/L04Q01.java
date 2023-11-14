/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author rz_rexton
 */
import java.util.Scanner;
public class L04Q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        System.out.print("The factors are: ");
        for (int i = 1; i<=num;i++){
            if (num == i){
                System.out.print(i);
            }else if (num%i==0){
                System.out.print(i+", ");
            }
        }
        System.out.println("");
    }
}
