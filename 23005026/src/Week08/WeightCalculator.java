/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week08;

/**
 *
 * @author lowji
 */
import java.util.*;

public class WeightCalculator {
    private int age;
    private double height;
    private static Scanner sc = new Scanner(System.in);
    
    public void input() {
        System.out.print("Enter your age: ");
        this.age = sc.nextInt();
        System.out.print("Enter your height: ");
        this.height = sc.nextDouble();
    }
    
    public void calWeight() {
        this.age = age;
        this.height = height;
        double weight = (height - 100 + (age/10)) * 0.9;
        System.out.println("Age: " + age + "\nHeight: " + height + " cm" + "\nRecommended weight: " + weight + " kg");
    }
}
