/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week08;

/**
 *
 * @author lowji
 */
public class BurgerStall {
    private int id;
    private int sold;
    private static int sum;
    
    public BurgerStall(int id) {
        this.id = id;
        this.sold = 0;
    }
    
    public void sold(int daySold) {
        this.sold += daySold;
        sum += daySold;
    }
    
    public void displayStall() {
        System.out.println("Burger stall ID: " + String.valueOf(this.id));
        System.out.println("Burger sold for Stall " + this.id + " is " + this.sold);
    }
    
    public void showAll() {
        System.out.println("Total burger sold " + sum);
    }
}
