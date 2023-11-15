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
public class L05Q06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of row of Pascal Triangle to generate: ");
        int num = sc.nextInt();
        System.out.println("The Pascal Triangle with "+num+" row(s)");
        int[][] pascal = new int [num][num];
        
        for(int i = 0; i<pascal.length; i++){
            for(int j = 0; j<=i; j++){
                if(j == 0 || j == i){
                    pascal[i][j] = 1; //If you see the pattern,the first column confirm is 1 , and  (column num = row number) is always equals to 1
                }
                else{
                    pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];   //Find pattern [2][1] = [1][0]+[1][1]
                }                                                       //             [3][1] = [2][0]+[2][1]
            }                                                           //             [3][2] = [2][1]+[2][2]
        }
        //print the Pascal Triangle out
        for(int i = 0 ; i<pascal.length; i++){
            for(int j = 0; j<pascal[i].length; j++)
                System.out.printf("%-6d", pascal[i][j]);

            System.out.println();
        }
        
    }
}
