/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week08;

/**
 *
 * @author lowji
 */
public class BankAccount {
    private String name;
    private int ic;
    private double balance;
    
    public BankAccount(String name, int ic,double balance) {
        this.name = name;
        this.ic = ic;
        this.balance = balance;
        System.out.println("Bank acount: \n" + "Name: " + name + "\nIC: " + ic + "\nBalance: " + balance);
    }
        
    
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposit: " + amount);
        System.out.println("Current Balance: " + this.balance);
    }
    
    public void withDraw(double amount) {
        if(this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdraw: " + amount);
            System.out.println("Current balance: " + this.balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}
    

