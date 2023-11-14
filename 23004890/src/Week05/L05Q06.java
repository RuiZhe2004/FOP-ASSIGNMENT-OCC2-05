/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;
import java.util.Scanner;

/**
 *
 * @author ruizh
 */
public class L05Q06 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Enter the number of row of Pascal Triangle to generate: ");
        int row = a.nextInt();
        System.out.println("The Pascal Triangle with " + row + " row(s)");
        
        int[][] pascal = new int[row][row];
        for (int i = 0; i < pascal.length; i++){
            for (int j = 0; j <= i; j++){
                if (j==0 || j==i){
                    pascal[i][j] = 1;
                }
                else
                    pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
            }
        }
        for(int i = 0 ; i<pascal.length; i++){
            for(int j = 0; j<pascal[i].length; j++)
                System.out.printf("%-10d", pascal[i][j]);
            System.out.println();
        }
        
        
    }
    
}
