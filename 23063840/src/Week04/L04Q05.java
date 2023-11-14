/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author User
 */
import java.util.Random;
import java.util.Scanner;

public class L04Q05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int player1Score = 0;
        int player2Score = 0;
        int currentPlayer = 1;

        while (true) {
            System.out.println("Player " + currentPlayer + "'s turn. Press Enter to roll the dice.");
            scanner.nextLine();

            int diceRoll = random.nextInt(6) + 1;
            System.out.println("You rolled a " + diceRoll);

            if (diceRoll == 6) {
                System.out.println("You scored 6 points and get another turn!");
                if (currentPlayer == 1) {
                    player1Score += 6;
                } else {
                    player2Score += 6;
                }
            } else {
                if (currentPlayer == 1) {
                    player1Score += diceRoll;
                } else {
                    player2Score += diceRoll;
                }
            }

            System.out.println("Player 1's score: " + player1Score);
            System.out.println("Player 2's score: " + player2Score);

            if (player1Score >= 100) {
                System.out.println("Player 1 wins!");
                break;
            } else if (player2Score >= 100) {
                System.out.println("Player 2 wins!");
                break;
            }

            // Switch to the other player's turn
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }

        scanner.close();
    }
}