/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author User
 */
public class L02Q04 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Please enter the number of seconds: ");
        int sec = sc.nextInt();
        int hour = sec / 3600;
        int min = (sec % 3600) / 60;
        int newsec = sec % 60;
        // int newsec=sec-hour*3600-min*60;
        // int min=(sec-hour*3600)/60;
        // int newsec=sec-hour*3600-min*60;
        System.out.println(sec + " seconds is " + hour + " hours, " + min + " minutes and " + newsec + " seconds.");
    }
}