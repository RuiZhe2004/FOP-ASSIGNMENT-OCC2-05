/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author lowji
 */
public class L05Q04 {
    public static void main(String[] args) {
        int[][] arr = {{1, 5, 7}, {3, 6, 9}, {5, 3, 8}};
        printMatrix(arr);
        System.out.println();
        transpose(arr);
        reverse(arr);
        printMatrix(arr);
        
    }
    
    static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }        
    }
    
    static void transpose(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr[i].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
    
    public static void reverse(int[][] arr) {
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            while (left < right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }                    
        }
    }
}
