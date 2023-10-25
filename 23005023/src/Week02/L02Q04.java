/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author szeyu
 */
import java.util.Scanner;
public class L02Q04 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of seconds: ");
        int second = input.nextInt();
        
        int hour = second / 3600;
        int minute = (second % 3600) / 60;
        second = second % 60;
        
        System.out.println(second + " seconds is " + hour + " hours, " + minute + " minutes and " + second + " seconds");
        
    }
}
