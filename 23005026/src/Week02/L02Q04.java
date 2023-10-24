/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author lowji
 */
import java.util.Scanner;
public class L02Q04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of seconds: ");
        int sec = sc.nextInt();
        
        int hr = sec/3600;
        int min = (sec-hr*3600)/60;
        int leftSec = sec - hr*3600 - min*60;
        
        System.out.printf("%d seconds is %d hours, %d minutes and %d seconds\n", sec, hr, min, leftSec);
    }
}
