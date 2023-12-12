/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;
import java.util.Random;
/**
 *
 * @author ruizh
 */
public class L06Q03 {
    public static void main(String[] args) {
        Random r = new Random();
        int num[] = new int[10];
        System.out.println("Numbers generated: ");
        for (int i = 0; i < 10; i++){
            num[i] = r.nextInt(0,Integer.MAX_VALUE);
            System.out.print(num[i] + " ");
        }
        System.out.println("");
        System.out.println("Reversed Number: ");
        revert(num);
        reverse(num);
    }
    
    public static void revert(int[] num){
        int left = 0;
        int right = num.length - 1;
        int temp;
        while (left <= right) {
            temp = num[left];
            num[left] = num[right];
            num[right] = temp;
            left++;
            right--;
        }
    }
    
    public static void reverse(int[] num){
        for (int i = 0; i < num.length; i++){
        
            int reverse = 0;
            int temp = num[i];
            while (temp != 0) {
                reverse = reverse * 10 + temp % 10;
                temp /= 10;
            }
            num[i] = reverse;
            System.out.print(num[i] + " ");
        }
        System.out.println("");
    }
    
}
                    
                
                
            