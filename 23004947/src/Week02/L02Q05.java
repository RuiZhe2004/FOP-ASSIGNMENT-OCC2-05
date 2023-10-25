/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;
/**
 *
 * @author rz_rexton
 */
import java.util.Random;
public class L02Q05 {
    public static void main(String[] args) {
        Random g = new Random();
        int randomNum = g.nextInt(10001);
        System.out.println("Number generated: "+ randomNum);
        
        int sum =0;
        while(randomNum > 0){
            int i = randomNum%10;
            sum+=i;
            randomNum = randomNum / 10;
        }     
        System.out.println("Sum of the digits : " + sum);      
    }
    
}
