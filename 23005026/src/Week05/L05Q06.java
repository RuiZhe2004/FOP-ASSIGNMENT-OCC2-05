/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author lowji
 */
import java.util.*; 

public class L05Q06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of row of Pascal Triangle to generate: ");
        int row = sc.nextInt();
        System.out.println("The Pascal Triangle with " + row + "(s)");
        
        int[][] arr = new int[row][row];
        
        
        //Initialize
        for( int i = 0; i < arr.length; i++) {            
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;
            }
        }        
        
        //Fill in
        for( int i = 0; i < arr.length; i++) {            
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j]; 
                }                                            
            }
        }
        
        //Printout
        for( int i = 0; i < arr.length; i++) { 
            System.out.println();
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }        
    }
}
