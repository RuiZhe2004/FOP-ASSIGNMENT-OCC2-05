/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author User
 */
public class L02Q02 {
    public static void main(String[] args) {
        java.util.Scanner sc= new java.util.Scanner(System.in);
        System.out.println("Plesae entr the price of car.");
        float p=sc.nextFloat();
        System.out.println("Plesae entr the down payment.");
        float d=sc.nextFloat();
        System.out.println("Plesae entr the interest rate in %.");
        float r=sc.nextFloat();
        System.out.println("Plesae entr the loan duration in year.");
        float y=sc.nextFloat();
       
        float m=(p-d)*(1+r*y/100)/(y*12);
        System.out.printf("The monthly payment is RM%.2f",m);
    }
}
