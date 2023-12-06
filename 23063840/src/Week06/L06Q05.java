/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author User
 */
import java.util.*;
public class L06Q05 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int mark = 0;
        for (int c = 1; c > 0;) {
            int a = r.nextInt(13);
            int b = r.nextInt(13);
            System.out.println("Enter negative number to quit.");
            System.out.println(a + " x " + b + " = ");
            c = sc.nextInt();
            if (Ans(a, b, c)) {
                mark++;
            }
        }
        System.out.println("Your Score is " + mark);
    }

    public static boolean Ans(int x, int y, int z) {
        return (z == y * x);
    }
}
