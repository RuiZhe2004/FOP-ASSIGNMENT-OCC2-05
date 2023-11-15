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
import java.util.Scanner;

public class L05Q05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("A list of 20 random integer within 0 to 100");
        int[] n = new int[20];
        for (int i = 0; i < n.length; i++) {
            n[i] = r.nextInt(101);
            System.out.print(n[i] + ", ");

        }

        for (int j = 1; j < n.length; j++) {
            for (int i = 0; i < n.length - j; i++) {
                if (n[i] < n[i + 1]) {
                    n[i] = n[i] + n[i + 1];
                    n[i + 1] = n[i] - n[i + 1];
                    n[i] = n[i] - n[i + 1];
                }
            }
        }
        System.out.println("\nArray in descending order");
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + ", ");

        }

        System.out.println("\nEnter a number to search: ");
        int x = sc.nextInt();

        for (int i = 0; i < n.length; i++) {
            if (n[i] == x) {
                System.out.println(x + " found");
                System.out.println("Linear search - " + (i + 1) + " loop(s).");
                break;
            }
            if (i == n.length - 1) {
                System.out.println(x + " not found");
                System.out.println("Linear search - " + (i + 1) + " loop(s).");
            }
        }

        int low = 0;
        int high = n.length - 1;
        int middle;
        int ctr = 1;
        boolean Bfound = false;
        while (low <= high) {
            middle = (low + high) / 2;
            if (x == n[middle]) {
                Bfound = true;
                break;
            } else if (x > n[middle]) {
                high = middle - 1;

            } else {
                low = middle + 1;
            }
            ctr++;
        }

        System.out.println(x + (Bfound ? "" : " not ") + "found");
        System.out.println("Binary Search - " + ctr + " loop(s)");
    }
}
