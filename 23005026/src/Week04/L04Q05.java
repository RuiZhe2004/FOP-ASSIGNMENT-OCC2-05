/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author lowji
 */
import java.util.Random;

public class L04Q05 {
  public static void main(String[] args) {
    Random rand = new Random();
    int p1Sum = 0;
    int p2Sum = 0;

    while (true) {
      int p1 = rand.nextInt(6) + 1; 
      System.out.println("Player 1 dice: " + p1);
      p1Sum += p1;
      System.out.println("Player 1 sum: " + p1Sum);

      if (p1Sum >= 100) {
        System.out.println("Player 1 wins!");
        break;
      }

      if (p1 == 6) {
        p1Sum += 6;
        System.out.println("Player 1 rolls 6, scores extra 6 points");
        int extraRoll = rand.nextInt(6) + 1;
        System.out.println("Player 1 extra dice: " + extraRoll);
        p1Sum += extraRoll;
      }

      int p2 = rand.nextInt(6) + 1;
      System.out.println("Player 2 dice: " + p2);
      p2Sum += p2; 
      System.out.println("Player 2 sum: " + p2Sum);

      if (p2Sum >= 100) {
        System.out.println("Player 2 wins!");
        break; 
      }

      if (p2 == 6) {
        p2Sum += 6;
        System.out.println("Player 2 rolls 6, scores extra 6 points");
        int extraRoll = rand.nextInt(6) + 1;
        System.out.println("Player 2 extra dice: " + extraRoll); 
        p2Sum += extraRoll;
      }

      if (p1Sum < 100 && p2Sum < 100) continue;
    }
  }
}
