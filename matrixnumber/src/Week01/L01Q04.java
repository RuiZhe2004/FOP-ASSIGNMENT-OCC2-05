/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week01;

/**
 *
 * @author ruizh
 */
public class L01Q04 {
    public static void main(String[] args) {
        int[] amount = {2500, 1600, 2000, 2700, 3200, 800};
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun"};
        System.out.printf("%45s","Total Sales of Product A in 2016\n");
        
        for (int counter = 0; counter < amount.length; counter++) { 
            amount[counter] = amount[counter] / 100;
        }

        for (int i = 0; i < amount.length; i++) {
            System.out.printf(month[i] + " | ");     
            for (int sales = 0; sales < amount[i]; sales++) {    
                System.out.print("* ");
            }
            System.out.println(); //Switch the line for a new month
        }
        System.out.printf("%70s","Note: * represents RM100\n");
        
    }
}
  
