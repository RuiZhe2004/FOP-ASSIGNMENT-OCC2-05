/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author szeyu
 */
public class L06Q01 {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++){
            System.out.print(triangularNum(i) + " ");
        }
        System.out.println();
    }
    
    public static int triangularNum(int number){
        int total = 0;
        for (int ct = 1; ct <= number; ct++){
            total += ct;
        }
        return total;
    }
}
