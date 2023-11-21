/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author rz_rexton
 */
//Write a Java method that returns a triangular number. A triangular number is defined
//as 1+2+3+…+ n. Then, write a Java program to use the method to display the first 20 triangular numbers.
public class L06Q01 {
    public static void main(String[] args) {
        int n=20;
        System.out.println("Trangle Numbers: ");
        for(int i = 1;i<=n; i++){
            System.out.print(TriangleNum(i)+" ");
        }
        System.out.println("");
    }
    public static int TriangleNum(int num){
        int sum = 0 ;
        for(int i=1;i<=num;i++){
           sum = (num * (num + 1)) / 2;
        }
        return sum;
    }
}
