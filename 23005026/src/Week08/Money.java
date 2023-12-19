/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week08;

/**
 *
 * @author lowji
 */
public class Money {
    private double amount;
    private double roundUpAmount;
    private int RM100;
    private int RM50;
    private int RM10;
    private int RM5;
    private int RM1;
    private int cent50;
    private int cent20;
    private int cent10;
    private int cent5;
    
    public Money(double amt) {
        System.out.println("Amount before round up: " + String.valueOf(amt));
        this.amount = roundAmount(amt);
        System.out.println("Amount after round up: " + this.amount);
    }
    
    public double getAmount() {
        return this.amount;
    }
    
    private double roundAmount(double amount) {
        double lastDecimal = amount * 100 % 10;
        double roundUp;
        if (lastDecimal >= 0 && lastDecimal <= 2) 
            roundUp = 0;
        else if (lastDecimal >= 3 && lastDecimal <= 7)
            roundUp = 5;
        else
            roundUp = 10;
        
        this.roundUpAmount = amount + (roundUp/100) - (lastDecimal/100) + 0.00000000001;
        return this.roundUpAmount;
    }
    
    public double substract(Money other) {
        return roundAmount(this.amount - other.getAmount());
    }
    
    public double addition (Money other) {
        return roundAmount(this.amount + other.getAmount());
    }
    
    public void calculateNoteCent () {
        while(this.roundUpAmount >= 100) {
            this.roundUpAmount -= 100;
            RM100++;
        }
        while(this.roundUpAmount >= 50) {
            this.roundUpAmount -= 50;
            RM50++;
        }
        while(this.roundUpAmount >= 10) {
            this.roundUpAmount -= 10;
            RM10++;
        }
        while(this.roundUpAmount >= 5) {
            this.roundUpAmount -= 5;
            RM5++;
        }
        while(this.roundUpAmount >= 1) {
            this.roundUpAmount -= 1;
            RM1++;
        }
        while(this.roundUpAmount >= 0.5) {
            this.roundUpAmount -= 0.5;
            cent50++;
        }
        while(this.roundUpAmount >= 0.2) {
            this.roundUpAmount -= 0.2;
            cent20++;
        }
        while(this.roundUpAmount >= 0.1) {
            this.roundUpAmount -= 0.1;
            cent10++;
        }
        while(this.roundUpAmount >= 0.05) {
            this.roundUpAmount -= 0.05;
            cent5++;
        }
        System.out.println("RM100 have " + RM100);
        System.out.println("RM50 have " + RM50);
        System.out.println("RM10 have " + RM10);
        System.out.println("RM5 have " + RM5);
        System.out.println("RM1 have " + RM1);
        
        System.out.println("50cent have " + cent50);
        System.out.println("20cent have " + cent20);
        System.out.println("10cent have " + cent10);
        System.out.println("5cent have " + cent5);
    }
}
