/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;

/**
 *
 * @author rz_rexton
 */
import java.util.Scanner;
public class L03Q03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Sales Volume: ");
        int saleVol = sc.nextInt();
        double commision;
        
        if (saleVol <= 100){
            commision = saleVol*0.05;
        }else if (saleVol >100 && saleVol<=500){
            commision = saleVol*0.075;
        }else if(saleVol >500 && saleVol<=1000){
            commision = saleVol*0.1;
        }else if (saleVol>1000);{
            commision = saleVol*0.125;
        }
    System.out.printf("Commision: %.2f%n",commision);
    }
}
