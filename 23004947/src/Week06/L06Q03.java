/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author rz_rexton
 */
public class L06Q03 {
    public static void main(String[] args) {
        int[] number = {123,7675,9845,8908,7383,7894,6532,2347,9864,3257};
        System.out.print("Original numbers: ");
        for (int i = 0; i < number.length; i++){
            System.out.print(number[i] + " ");
        }
        System.out.println("");
        
        ReverseNum(number);
        
        System.out.print("Reversed numbers: ");
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i] + " ");
        }
        System.out.println("");
    }
    
        public static void ReverseNum(int[] number) {
        for (int i = 0; i < number.length; i++) {
            int reverse = 0;
            int temp = number[i];
            while (temp != 0) {
                reverse = reverse * 10 + temp % 10;
                temp /= 10;
            }
            number[i] = reverse;
        }
    }
}
