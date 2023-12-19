/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week08;

/**
 *
 * @author lowji
 */
public class L08Q02 {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Dummy Dumb", 123456, 3000);
        acc.deposit(3000);
        acc.withDraw(1000);
    }
}
