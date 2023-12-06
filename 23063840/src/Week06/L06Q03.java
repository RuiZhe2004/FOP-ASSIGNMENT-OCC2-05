/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author User
 */
public class L06Q03 {
     public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter 10 integers.");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        reverse(arr);
    }

    public static void reverse(int[] rarr) {
        int j = 0;

        for (int i = rarr.length - 1; i > rarr.length / 2; i--) {

            rarr[i] = rarr[j] + rarr[i];
            rarr[j] = rarr[i] - rarr[j];
            rarr[i] = rarr[i] - rarr[j];
            j++;
        }

        for (int n = 0; n < rarr.length; n++) {
            System.out.print(rarr[n] + " ");
        }

    }
}


