/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author ooiru
 */
import java.util.*;

public class L04Q05 {
    public static void main(String[] args) {
        Random g = new Random();
        Scanner sc = new Scanner(System.in);
        int player1score = 0, player2score = 0;

        while (player1score < 100 && player2score < 100) {
            System.out.println("It's Player 1's turn to roll the dice");
            boolean validInput1 = false;

            while (!validInput1) {
                System.out.print("Input 1 to roll the dice: ");
                int p1 = sc.nextInt();

                if (p1 == 1) {
                    validInput1 = true;
                } else {
                    System.out.println("Invalid input. Please enter 1 to roll the dice.");
                }
            }

            int scorep1 = g.nextInt(6) + 1;
            System.out.println("You roll a " + scorep1);
            
            if (scorep1 == 6) {
                System.out.println("Congratulations, you roll a 6!");
                player1score += 6;
                System.out.println("Total score: " + player1score);
                System.out.println("Player 1 gets another turn.");
                continue; // another turn
            }

            player1score += scorep1;
            System.out.println("Total score: " + player1score);
            System.out.println("");

            if (player1score >= 100) {
                System.out.println("Player 1 wins!");
                break;
            }

            System.out.println("It's Player 2's turn to roll the dice");
            boolean validInput2 = false;

            while (!validInput2) {
                System.out.print("Input 1 to roll the dice: ");
                int p2 = sc.nextInt();

                if (p2 == 1) {
                    validInput2 = true;
                } else {
                    System.out.println("Invalid input. Please enter 1 to roll the dice.");
                }
            }

            int scorep2 = g.nextInt(6) + 1;
            System.out.println("You roll a " + scorep2);

            if (scorep2 == 6) {
                System.out.println("Congratulations, you roll a 6!");
                player2score += 6;
                System.out.println("Total score: " + player2score);
                System.out.println("Player 2 gets another turn.");
                continue; // another turn
            }

            player2score += scorep2;
            System.out.println("Total score: " + player2score);
            System.out.println("");

            if (player2score >= 100) {
                System.out.println("Player 2 wins!");
                break;
            }
        }
    }
}
    

