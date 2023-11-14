/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author rz_rexton
 */
import java.util.Scanner;
public class L04Q02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input an integer: ");
        int num = sc.nextInt();
        int sum1 = 0, sum2 = 0,sum3 = 0;
        for(int i=1;i<=num;i++){
            sum1+=i;
            //when 1, sum1 = 1
            //when 2, sum1 = 1+2
            //when 3, sum1 = 1+2+3
            
            sum2 +=sum1;
            //when 1, sum2 = 0+1
            //when 2, sum2 = 1+(1+2)
            //when 3, sum2 = 1+(1+2)+(1+2+3)
        }
        System.out.println(sum2);
    }
    
}
