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
public class L05Q03 {
    public static void main(String[] args) {
        Random g = new Random();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Number of employees: ");
        int employee = sc.nextInt();
        
        //Make a row and column for employees(N) and workhours(7 becoz 7 days)
        int work[][] = new int[employee][7];
        //Make an array for the total workhours
        int total[] = new int[employee];
        
        //Generate random workhours for all the employees for 7 days
        for(int i=0;i<work.length;i++){
            for(int j=0;j<work[i].length;j++){
                work[i][j]=g.nextInt(8)+1;
                total[i]+=work[i][j];
            }
        }
        
        System.out.printf("%10s |%25s | %5s","Employee","Work Hours in Seven Days","Total Work Hours");
        for(int z=0;z<work.length;z++){
            System.out.printf("\n%10d     ",(z+1));
            for(int x=0;x<work[z].length;x++){
                System.out.print(work[z][x]+"  ");
            }
            System.out.printf(" %12s",total[z]);
        }
        System.out.println("");
    }
}
