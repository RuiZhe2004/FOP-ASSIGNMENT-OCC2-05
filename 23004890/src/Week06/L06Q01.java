/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author ruizh
 */
public class L06Q01 {
    public static void main(String[] args) {
        System.out.println("The first 20 triangular number are: ");
        triangular(20);
        System.out.println("");
    }
    
    public static void triangular(int a){
        int total = 0;
        for (int i = 1; i <= a; i++){
            total = total + i;
            System.out.print(total + " ");
        }
            
    }
}
