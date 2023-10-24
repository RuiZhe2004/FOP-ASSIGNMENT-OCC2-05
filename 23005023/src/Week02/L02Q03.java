/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author szeyu
 */
import java.util.Random;
public class L02Q03 {
    public static void main(String[] args){
        Random random = new Random();
        int sum = 0;
        for(int i = 0; i < 3; i++){
            int randomVal = random.nextInt(41) + 10;
            System.out.println(randomVal);
            sum += randomVal;
        }
        
        double average = sum/3;
        
        System.out.println("Sum : " + sum);
        System.out.printf("Average : %.2f%n", average);
    }
}
