/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week01;

/**
 *
 * @author jiale
 */
public class L01Q04 {
    public static void main (String[] args){
        int[] sales = {2500, 1600, 2000, 2700, 3200, 800};
        String[] month = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN"};
        
        System.out.printf("%45s","TOTAL SALES OF PRODUCT A IN 2016\n");
        
        for (int counter = 0; counter < sales.length; counter++){
            sales[counter] = sales[counter]/100;
        }
        
        for (int i = 0; i < sales.length; i++){
            System.out.print( month[i] + " | ");
                    for (int graphic = 0; graphic < sales[i]; graphic++ ){
                        System.out.print("* ");
                    }
            System.out.println();//New line for each month
        }
        
        System.out.printf("%71s", "Note: * repesents RM100\n\n");
                    
        
        }
        
    }
