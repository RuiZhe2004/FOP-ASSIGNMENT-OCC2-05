/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;
import java. util.Scanner;

/**
 *
 * @author ruizh
 */
public class L04Q04 {
    public static void main(String[] args) {
        Scanner i = new Scanner (System.in);
        System.out.print("Enter the year: ");
        int year, firstday, month;
        year = i.nextInt();
        System.out.print("Enter the first day of the year ");
        System.out.print("(0 for Sunday, 1 for Monday, ......, 6 for Saturday): ");
        firstday = i.nextInt();
        
        System.out.println("\nYear " + year);
        
        String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        
        //January
        System.out.println("\n" + months[0]);
        for (int counter1 = 1; counter1 < 32; counter1++){
            System.out.println(months[0] + " " + counter1 + " | " + days[firstday]);
            if (firstday == 6){
            firstday -= 7;
            }
            firstday++;
        }
        
        //February
        System.out.println("\n" + months[1]);
        if (((year % 4)==0 ) && ((year % 100)!=0)){
            for (int counter2 = 1; counter2 < 30; counter2++){
            System.out.println(months[1] + " " + counter2 + " | " + days[firstday]);
            if (firstday == 6){
            firstday -= 7;
            }
            firstday++;
            }
        }
        else{
            for (int counter2 = 1; counter2 < 29; counter2++){
            System.out.println(months[1] + " " + counter2 + " | " + days[firstday]);
            if (firstday == 6){
            firstday -= 7;
            }
            firstday++;
            }     
        }    
        
        //March
        System.out.println("\n" + months[2]);
        for (int counter3 = 1; counter3 < 32; counter3++){
            System.out.println(months[2] + " " + counter3 + " | " + days[firstday]);
            if (firstday == 6){
            firstday -= 7;
            }
            firstday++;
        }
        
        //April
        System.out.println("\n" + months[3]);
        for (int counter4 = 1; counter4 < 31; counter4++){
            System.out.println(months[3] + " " + counter4 + " | " + days[firstday]);
            if (firstday == 6){
            firstday -= 7;
            }
            firstday++;
        }
        
        //May
        System.out.println("\n" + months[4]);
        for (int counter5 = 1; counter5 < 32; counter5++){
            System.out.println(months[4] + " " + counter5 + " | " + days[firstday]);
            if (firstday == 6){
            firstday -= 7;
            }
            firstday++;
        }
        
        //June
        System.out.println("\n" + months[5]);
        for (int counter6 = 1; counter6 < 31; counter6++){
            System.out.println(months[5] + " " + counter6 + " | " + days[firstday]);
            if (firstday == 6){
            firstday -= 7;
            }
            firstday++;
        }
        
        //July
        System.out.println("\n" + months[6]);
        for (int counter7 = 1; counter7 < 32; counter7++){
            System.out.println(months[6] + " " + counter7 + " | " + days[firstday]);
            if (firstday == 6){
            firstday -= 7;
            }
            firstday++;
        }
        
        //August
        System.out.println("\n" + months[7]);
        for (int counter8 = 1; counter8 < 32; counter8++){
            System.out.println(months[7] + " " + counter8 + " | " + days[firstday]);
            if (firstday == 6){
            firstday -= 7;
            }
            firstday++;
        }
        
        //September
        System.out.println("\n" + months[8]);
        for (int counter9 = 1; counter9 < 31; counter9++){
            System.out.println(months[8] + " " + counter9 + " | " + days[firstday]);
            if (firstday == 6){
            firstday -= 7;
            }
            firstday++;
        }
        
        //October
        System.out.println("\n" + months[9]);
        for (int counter10 = 1; counter10 < 32; counter10++){
            System.out.println(months[9] + " " + counter10 + " | " + days[firstday]);
            if (firstday == 6){
            firstday -= 7;
            }
            firstday++;
        }
        
        //November
        System.out.println("\n" + months[10]);
        for (int counter11 = 1; counter11 < 31; counter11++){
            System.out.println(months[10] + " " + counter11 + " | " + days[firstday]);
            if (firstday == 6){
            firstday -= 7;
            }
            firstday++;
        }
        
        //December
        System.out.println("\n" + months[11]);
        for (int counter12 = 1; counter12 < 32; counter12++){
            System.out.println(months[11] + " " + counter12 + " | " + days[firstday]);
            if (firstday == 6){
            firstday -= 7;
            }
            firstday++;
        }
    }
}
    

