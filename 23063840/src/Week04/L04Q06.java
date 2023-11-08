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

public class L04Q06 {
    public static void main(String[] args) {
        Random random = new Random();

        // Generate a non-negative random integer
        int randomNumber = random.nextInt(Integer.MAX_VALUE);

        System.out.println("Random Number: " + randomNumber);

        // Calculate the number of digits in the integer
        int numberOfDigits = 0;
        int tempNumber = randomNumber;

        // Handle the case when the random number is 0
        if (tempNumber == 0) {
            numberOfDigits = 1;
        } else {
            while (tempNumber > 0) {
                tempNumber /= 10;
                numberOfDigits++;
            }
        }

        System.out.println("Number of Digits: " + numberOfDigits);
    }
}
