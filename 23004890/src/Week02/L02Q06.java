/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author ruizh
 */
public class L02Q06 {
    public static void main(String[] args){
        Scanner i = new Scanner (System.in);
        
        //Weight in gram
        int weightg;
        System.out.print("Enter the amount of water in gram: ");
        weightg = i.nextInt();
        
        //Weight in kilogram
        double weightkg;
        weightkg = weightg/1000;
        
        //Initial Temperature in Farenheit
        double itempf;
        System.out.print("Enter the initial temperature in Farenheit: ");
        itempf = i.nextDouble();
        
        //Initial Temperature in Celsius
        double itempc;
        itempc = (itempf - 32)/1.8;
        
        //Final Temperature in Farenheit
        double ftempf;
        System.out.print("Enter the final temperature in Farenheit: ");
        ftempf = i.nextDouble();
        
        //final Temperature in Celsius
        double ftempc;
        ftempc = (ftempf - 32)/1.8;
        
        //formula to calculate energy
        double energy;
        energy = weightkg * (ftempc - itempc) * 4184 ;
        
        ///create Formatter class object
        Formatter j = new Formatter();
 
        // %e format specifier
        // It prints the number in Scientific Notation
        // with lowercase alphabets
        j.format("%e", energy);
        
        //output
        System.out.print("The energy needed is " + j + ".\n");
        
        
    }
}
