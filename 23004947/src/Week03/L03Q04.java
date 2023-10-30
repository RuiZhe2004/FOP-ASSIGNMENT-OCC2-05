/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;

/**
 *
 * @author rz_rexton
 */
import java.util.Random;
import java.util.Scanner;
public class L03Q04 {
    public static void main(String[] args) {
        int player1sc = 0, player2sc=0;
        Scanner sc = new Scanner(System.in);
        Random g = new Random();
        
            // Player 1
            System.out.println("It's Player 1's turn to roll the dice");
            int p1Round1Score = 0;

            for (int roll = 1; roll < 3; roll++) {
                System.out.print("Type 0 to roll the dice: ");
                int r1p1 = sc.nextInt();
                if (r1p1 == 0) {
                    int diceround1p1 = g.nextInt(6) + 1;
                    System.out.println("Player 1's score for roll " + roll + ": " + diceround1p1);
                    System.out.println("");
                    p1Round1Score += diceround1p1;
                }
            }
            

            player1sc += p1Round1Score;
            System.out.println("Player 1's total score " + ": " + p1Round1Score);

            // Player 2
            System.out.println("\nIt's Player 2's turn to roll the dice");
            int p2Round2Score = 0;

            for (int roll = 1; roll < 3; roll++) {
                System.out.print("Player 2, type 0 to roll the dice: ");
                int r1p2 = sc.nextInt();
                if (r1p2 == 0) {
                    int diceround1p2 = g.nextInt(6) + 1;
                    System.out.println("Player 2's score for roll " + roll + ": " + diceround1p2);
                    System.out.println("");
                    p2Round2Score += diceround1p2;
                }
            }

            player2sc += p2Round2Score;
            System.out.println("Player 2's total score for round " + ": " + p2Round2Score);
            
            //Display Winner
            System.out.println("\n\nGame Over!");
            System.out.println("Player 1's total score: " + player1sc);
            System.out.println("Player 2's total score: " + player2sc);

            if (player1sc > player2sc) {
                System.out.println("Player 1 wins!");
            } else if (player2sc > player1sc) {
                System.out.println("Player 2 wins!");
            } else {
                System.out.println("It's a tie!");
            }
        }
    }
