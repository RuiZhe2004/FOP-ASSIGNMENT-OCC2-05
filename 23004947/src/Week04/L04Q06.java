/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author rz_rexton
 */
import java.util.Random;
public class L04Q06 {
    public static void main(String[] args) {
        Random g = new Random();
        int num = Math.abs(g.nextInt());
        String numstr = Integer.toString(num); 
        int digitcount = numstr.length();
        System.out.println("Generated Number: "+ num);
        System.out.println("Number of digit(s): "+digitcount);
    }
}
