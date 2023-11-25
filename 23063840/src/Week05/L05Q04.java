/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author User
 */
public class L05Q04 {

      public static void main(String[] args) {
        int[][] matrix = { { 1, 5, 7 },
                { 3, 6, 9 },
                { 5, 3, 8 } };
        System.out.println("3 by 3 matrix");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("After rotates 90 degree clockwise");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                System.out.print(matrix[j][i] + "  ");
            }
            System.out.println();
        }

    }

}
