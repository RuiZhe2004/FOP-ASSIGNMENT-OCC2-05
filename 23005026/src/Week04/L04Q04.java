/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author lowjiaxin
 */
import java.util.Scanner;

public class L04Q04 {

   public static void main (String[] args) {
      int year = 2023;
      int firstDay = 0;
      int sum = 0;
      int []daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      
      if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
         daysPerMonth[1] = 29;
      }
         
      
      //MAY
      int may = 4;
      for (int i = 0; i < may; i++) {
         sum += daysPerMonth[i];
      }          
      //get the first day of the next month
      int firstMayDay = (firstDay + sum) % 7;
      
      
      //AUGUST
      int aug = 7;
      sum = 0;
      for (int i = 0; i < aug; i++) {
         sum += daysPerMonth[i];
      }       
      int firstAugDay = (firstDay + sum) % 7;
            
      
      DisplayCalendar(firstMayDay, year, may);
      DisplayCalendar(firstAugDay, year, aug);
   }
   
   public static void DisplayCalendar (int firstDay, int year, int month) {
      
      String []nameOfMonth = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      String nameMonth = nameOfMonth[month];
 
      System.out.println("\tCalendar" + year + " " + nameMonth);
      System.out.printf("%4s %4s %4s %4s %4s %4s %4s", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
      System.out.println(); 
      
      int daysInMonth = getDaysInMonth(year, month);
     
      //print the space before first day in month
      for (int i = 0; i < firstDay; i++) {
          System.out.print("     ");
      }        
     
      int currentDay = 1;
      
      //print the first week in month
      for (int dayOfFirstWeek = firstDay; dayOfFirstWeek < 7; dayOfFirstWeek++) {
          System.out.printf("%4d ", currentDay);
          currentDay++;
      }        
     
      //go to next line
      System.out.println(); 
      
      while (currentDay <= daysInMonth) {
          for (int dayOfWeek = 0; dayOfWeek < 7 && currentDay <= daysInMonth; dayOfWeek++) {
              System.out.printf("%4d ", currentDay);
              currentDay++;
          }
          System.out.println(); // Start a new row
      }
         
    }    
      
   public static boolean LeapYear (int year) {
      return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);        
   }    
   
   public static int getDaysInMonth(int year, int month) {
      int[] daysInMonth = {31, (LeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      return daysInMonth[month];
   }   
}