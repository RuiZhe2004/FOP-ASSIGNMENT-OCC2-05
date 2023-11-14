/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author rz_rexton
 */
import java.util.*;
public class L05Q04 {
    public static void main(String[] args) {
        int[][] matrix = {{1,5,7} ,{3,6,9},{5,3,8}};
        System.out.println("3 by 3 Matrix");
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+"  "); 
            }
            System.out.println("");
        }

        int rows = 3;
        int cols = 3;
        int[][] rotatedMatrix = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotatedMatrix[j][rows - 1 - i] = matrix[i][j]; 
            } //when rotate 90 degree clockwise,position [i][j]becomes position [j][rows - 1 - i]
        }

        System.out.println("\nAfter rotates 90 degree clockwise");
        for (int i=0;i<rotatedMatrix.length;i++) {
            for (int j=0;j<rotatedMatrix[i].length;j++){
                System.out.print(rotatedMatrix[i][j]+"  "); 
            }
            System.out.println("");
        }
    }
}
