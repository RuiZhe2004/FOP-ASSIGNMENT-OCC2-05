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
public class L03Q03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sales volume:");
        double sv = sc.nextDouble();
        double com = 0;
        if (sv <= 100) {
            com = sv * 0.05;
        } else if (sv > 100 && sv <= 500) {
            com = sv * 0.075;
        } else if (sv > 500 && sv <= 1000) {
            com = sv * 0.1;
        } else {
            com = sv * 0.125;
        }
        System.out.printf("Your commision is RM%.2f", com);

    }

}
    

