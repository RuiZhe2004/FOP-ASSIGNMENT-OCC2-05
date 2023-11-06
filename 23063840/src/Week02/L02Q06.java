/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author User
 */
public class L02Q06 {
    public static void main(String[] args) {
        java.util.Scanner sc= new java.util.Scanner(System.in);
        System.out.print("Enter the amount of water in gram: ");
        float wg=sc.nextInt();
        System.out.print("Enter the initial temperature in Fahrenheit: ");
        float it=sc.nextFloat();
        System.out.print("Enter the final temperature in Fahrenheit: ");
        float ft=sc.nextFloat();
        double itc=(it-32)/1.8;
        double ftc=(ft-32)/1.8;
        double eng=wg/1000*(ftc-itc)*4184;
        int sum=0;
        while(eng>9){
            eng=eng/10;
            sum++;
        }
        System.out.printf("\nThe energy needed is %.6f",eng);
        System.out.printf("e+%02d",sum);
    }
    
}
