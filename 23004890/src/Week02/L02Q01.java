/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;
import java.util.Scanner;
import java.text.DecimalFormat; //constructor of the DecimalFormat class 

/**
 *
 * @author ruizh
 */
public class L02Q01 {
    private static final DecimalFormat decfor = new DecimalFormat("0.00"); // set the format needed (2dp)
    public static void main(String[] args){
        Scanner i = new Scanner(System.in); //i is variable for keyboard
        double tempf; //tempf is variable for temperature in unit Farenheit
        System.out.print ("Please enter temperature in degree Farenheit: ");
        tempf = i.nextDouble();
        double tempc; //tempc is variable for temperature in degree Celsius
        tempc = (tempf-32)/1.8;
        System.out.println("The temperature " + decfor.format(tempf) + " Farenheit is equal to " + decfor.format(tempc) + " Celsius.");
    }
}  

