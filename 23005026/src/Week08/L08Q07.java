/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week08;

/**
 *
 * @author lowji
 */
public class L08Q07 {
    public static void main(String[] args) {
        Money m = new Money(123.56);
        m.calculateNoteCent();
        System.out.println();
        
        Money n = new Money(999.99);
        n.calculateNoteCent();
        System.out.println();
        
        System.out.println(n.substract(m));
    }
    
    
}
