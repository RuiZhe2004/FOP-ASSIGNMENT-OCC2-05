package Week06;
import java.util.Scanner;
import java.util.Random;

public class L06Q05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        boolean answer = true;
        int correct = 0;
        while (answer){
            int num1 = r.nextInt(0,13);
            int num2 = r.nextInt(0,13);
            System.out.println("Enter negative number to quit.");
            System.out.print(num1 + " x " + num2 + " = ");
            int ans = sc.nextInt();
            
            if (ans < 0){
                answer = false;
            }
            else 
                correct = multi(num1, num2, ans, correct);
        }
        System.out.println("Your score is " + correct);
    }
    
    public static int multi(int num1, int num2, int ans, int correct){
        
        if (num1 * num2 == ans){
            correct++;
        }
        return correct;
    }
}
