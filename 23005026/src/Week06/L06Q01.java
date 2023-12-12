/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author lowji
 */
import java.util.*;

public class L06Q01 {
    public static void main(String[] args) {
        display();
    }
    
    public static int triangleNumber (int n) {
        int sum = 0;
        for (int i = 1; i <= n + 1; i++){
            sum = i*(i+1)/2;
        }
        return sum;
    }
    
    public static void display () {
        int n = 20;
        for (int i = 0; i < n; i ++) {
            System.out.println((i+1) + ". " + triangleNumber(i) + " ");
        }
    }
}
