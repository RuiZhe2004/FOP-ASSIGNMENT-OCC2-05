/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author User
 */
public class L06Q01 {
    public static void main(String[] args) {
        // L6Q1 obj=new L6Q1();

        int x = 20;
        // System.out.println(obj.tri(x));
        System.out.println(tri(x));
    }

    public static int tri(int a) {
        int b = 0;
        for (int i = 1; i <= a; i++) {
            b += i;

        }
        return b;
    }
}

