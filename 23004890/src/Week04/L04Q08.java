/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;
import java.util.Random;

/**
 *
 * @author ruizh
 */
public class L04Q08 {
    public static void main(String[] args) {
        Random i = new Random ();
        int num;
        num = i.nextInt(0,101);
        System.out.println("The first " + num + " prime number is: ");
        int counter = 0, factor = 1, fac = 1, index = 2;  
        //counter is the nth integer printed
        //index is the number checked
        //fac is the number of the factors
        
        while (counter < num){ 
                while (index > factor) {
                    if (index % factor == 0){
                        fac++;
                    }
                    factor++;
                    if (index == factor){
                        if (fac == 2){
                            System.out.println(index);
                            counter++;
                        }
                        if (counter == num){
                            break;
                        }
                        index++;
                        factor = 1;
                        fac = 1;
                    }
                }    
        }
    }
}
