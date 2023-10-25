/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week01;

/**
 *
 * @author rz_rexton
 */
public class L01Q04 {
    public static void main(String[] args) {
        int[] amount = {2500, 1600, 2000, 2700, 3200, 800};
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun"};
        System.out.printf("\n%-10s%-19s\n","Month   |","Amount");
        System.out.println("-------  -------------------------------------");

        for (int i = 0; i < amount.length; i++) {
            amount[i] = amount[i] / 100;
        }

        for (int j = 0; j < amount.length; j++) {
            System.out.print(month[j] + "\t: ");     //print month from Jan to Jun
            for (int bullet = 0; bullet < amount[j]; bullet++) {    //print bullet
                System.out.print("$");
            }
            System.out.println(); // Add a newline after each month
        }
        System.out.println("-------  -------------------------------------");
        System.out.printf("%45s\n\n","Key: $ represents 100");
    } 
}
