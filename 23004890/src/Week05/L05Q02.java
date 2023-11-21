/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;
import java.util.Random;

/**
 *
 * @author ruizh
 */

public class L05Q02 {
    public static void main(String[] args) {
        Random i = new Random();
        int[] num = new int[10];
        for (int counter = 0; counter < num.length; counter++){
            num[counter] = i.nextInt(0,21);
            for (int index = 0; index < counter; index++){
                while (num[counter] == num[index]){
                    num[counter] = i.nextInt(0,21);
                }
            }
            System.out.print(num[counter] + " ");
        }
    }
}
