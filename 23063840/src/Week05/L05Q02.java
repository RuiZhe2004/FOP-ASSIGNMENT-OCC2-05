/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author User
 */
import java.util.Random;

public class L05Q02 {

    public static void main(String[] args) {
        Random r = new Random();
        boolean[] check = new boolean[21];
        int n[] = new int[10];
        int x;

        for (int i = 0; i < n.length;) {
            x = r.nextInt(21);
            if (check[x] == false) {
                check[x] = true;
                n[i] = x;
                System.out.println(n[i]);
                i++;
            }
        }

    }
}
