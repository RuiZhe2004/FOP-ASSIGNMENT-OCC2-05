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

public class Number {
   private static int[] number;
   private Random r = new Random();
   
   public Number () {
      number = new int[10];
      for (int i = 1; i <= 10; i++) {
         number[i-1] = r.nextInt(101);
      }
   }
   
   public Number (int n) {
      number = new int[n];
      for (int i = 1; i <= n; i++) {
         number[i-1] = r.nextInt(101); 
      }
   }
   
   public Number (int n, int range) {
      number = new int[n];
      for (int i = 1; i <= n; i++) {
         number[i-1] = r.nextInt(range + 1); 
      }
   }
   
//all the item of the array, 
//the even number, 
//the prime number, 

//the square number

   public void getEven() {
      int count = 0;
      ArrayList<Integer> even = new ArrayList<>();
      for (int i = 0; i < number.length; i++) {
         if (number[i] % 2 == 0) {
            even.add(number[i]);
         }
      }
      if (even.size() == 0) {
         System.out.println("null");
      } else {
         System.out.println("Even numbers: " + even);
      }
   }
   
   public void primeNumber() {
      ArrayList<Integer> prime = new ArrayList<>();
      
      for (int i = 0; i < number.length; i++) {   
         if (number[i] <= 1) 
            continue;        
                
         boolean isPrime = true;
         
         for (int j = 2; j < Math.sqrt(number[i]); j++) {
            if (number[i] % j == 0) {
               isPrime = false;
               break;
            } 
         }
         if(isPrime) {
            prime.add(number[i]);
         }
      }  
      
      if (prime.size() == 0) {
         System.out.println("null");
      } else {
         System.out.println("Prime numbers: " + prime);
      }
   }
   
   
//the maximum number, the minimum number, 
//the average, 
   public void showStat() {
      int sum = 0;
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      
      for (int i = 0; i < number.length; i++) {
         if (number[i] < min) min = number[i];
         if (number[i] > max) max = number[i];
         sum += number[i];
      }
      
      double avg = (double) sum / number.length;
      
      System.out.println("Maximum number: " + min);
      System.out.println("Minimum number: " + max);
      System.out.println("Average: " + avg);
   }
   
   //check squareNumber got many other approaches...
   public void squareNumber() {
      ArrayList<Integer> square = new ArrayList<>();
      for (int i = 0; i < number.length; i++) {
         int sqrt = (int) Math.sqrt(number[i]);
         if (sqrt * sqrt == number[i]) {
            square.add(number[i]);
         }
      }
      System.out.print("Square number: " + square);
   }
   
   public void displayAll() {
      System.out.print("Display all the numbers in the array: ");
      for (int i = 0; i < number.length; i++) {
         System.out.print(number[i]);
         if(i < number.length - 1) {
            System.out.print(", ");
         }
      }
      System.out.println("\n"); 
      
      System.out.println("Following are the even numbers in the array: ");
      getEven();
      System.out.println(); 
      
      System.out.println("Following are the prime numbers in the array: ");
      primeNumber();
      System.out.println(); 
      
      System.out.println("Following are the statistics in the array: ");
      showStat();
      System.out.println(); 
      
      System.out.println("Following are the square numbers in the array: ");
      squareNumber();
      System.out.println(); 
   }
}
