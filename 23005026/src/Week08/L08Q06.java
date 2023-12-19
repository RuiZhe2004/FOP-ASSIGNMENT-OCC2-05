/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week08;

/**
 *
 * @author lowji
 */
public class L08Q06 {
    public static void main(String[] args) {
        BurgerStall a = new BurgerStall(123);
        a.sold(10);
        a.sold(20);
        a.displayStall();
        System.out.println();
        
        BurgerStall b = new BurgerStall(333);
        b.sold(50);
        b.displayStall();
        System.out.println();
        
        a.showAll();
    }
}
