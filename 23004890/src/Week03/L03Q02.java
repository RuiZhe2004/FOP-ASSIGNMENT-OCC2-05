/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;
import java.util.Random;

/**
 *
 * @author ruizh
 */
public class L03Q02 {
    public static void main (String[] args){
        Random a = new Random();
        int num;
        int MAX = 6;
        num = a.nextInt(MAX);
        
        switch (num) {
            case 0:
                System.out.print("0 is zero.\n");
                break;
            case 1:
                System.out.print("1 is one.\n");
                break;
            case 2:
                System.out.print("2 is two.\n");
                break;
            case 3:
                System.out.print("3 is three.\n");
                break;
            case 4:
                System.out.print("4 is four.\n");
                break;
            case 5:
                System.out.print("5 is five.\n");
                break;  
        }
      
    }
    
}
