/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;
import java.util.Scanner;

/**
 *
 * @author ruizh
 */
public class L02Q04 {
    public static void main(String[] args){
        Scanner i = new Scanner (System.in);
        int time;
        System.out.print("Enter the number of seconds: ");
        time = i.nextInt();
        int hour; // for calculation of hours
        hour = time/3600;
        int min; // for calculation for minutes
        min = (time%3600)/60;
        int sec; //for calculation of seconds
        sec = (time%3600)%60;
        
        System.out.print (time + " seconds is " + hour + " hours, " + min + " minutes and " + sec + " seconds.\n");
 
    }
    
}
