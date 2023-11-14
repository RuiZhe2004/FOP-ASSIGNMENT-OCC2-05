/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author ruizh
 */
public class L05Q04 {
    public static void main(String[] args) {
        int[][] matrix = {{1,5,7},{3,6,9},{5,3,8}};
        System.out.println("3 by 3 Matrix");
        for(int counter = 0; counter < matrix.length; counter++){
            for(int index = 0; index < matrix[counter].length; index++){
                System.out.printf("%-3d",(matrix[counter][index]));
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("After rotates 90 degrees clockwise");
        int temp = 0;
        for(int rows = 0; rows < matrix.length; rows++){
            for(int columns = rows; columns < matrix.length; columns++){
                temp = matrix[rows][columns];
                matrix[rows][columns] = matrix[columns][rows]; 
                matrix[columns][rows] = temp; 
            }  
        }
        int temp2=0;
        for(int rows = 0; rows < matrix.length; rows++){
            temp2 = matrix[rows][0];
            matrix[rows][0] = matrix[rows][2];
            matrix[rows][2] = temp2;
        }

        for(int rows = 0; rows < matrix.length; rows++){
            for(int columns = 0; columns < matrix[rows].length; columns++)
            System.out.printf("%-3d",(matrix[rows][columns]));
            System.out.println("");
         }
        
    }
}
