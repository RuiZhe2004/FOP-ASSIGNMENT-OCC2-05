/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author ruizh
 */
public class L05Q01 {
    public static void main(String[] args) {
        Scanner i = new Scanner (System.in);
        Random j = new Random ();
        System.out.print("Please enter the number of students: ");
        double total = 0.00;
        int student = i.nextInt();
        int[] marks = new int[student];
        for (int count = 0; count < marks.length; count++){
            marks[count] = j.nextInt(0,101);
            System.out.print(marks[count] + " "); 
            total += marks[count];
        }
        System.out.println("");
        
        int min = marks[0], max = marks[0];
        for (int counter = 1; counter < marks.length; counter++){
            if (marks[counter] < min){
                min = marks[counter];
            }
            if (marks[counter] >  max){
                max = marks[counter];
            }
        }
        System.out.println("The highest score is " + max);
        System.out.println("The lowest score is " + min);
        
        double average = total/student;
        
        System.out.printf("The average score is %.2f\n", average);
        
    }
}
