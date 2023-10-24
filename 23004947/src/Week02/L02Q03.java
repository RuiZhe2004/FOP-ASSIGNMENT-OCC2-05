
package Week02;

import java.util.Random;
public class L02Q03 {
    public static void main(String[] args) {
        final int MAX = 51;
        final int MIN = 10;
        Random g = new Random();
        int num1= g.nextInt(MIN,MAX);
        int num2= g.nextInt(MIN,MAX);
        int num3= g.nextInt(MIN,MAX);
        int sum = num1+num2+num3;
        double ave = (double) sum/3;
        System.out.println("First num: "+ num1);
        System.out.println("Second num: "+ num2);
        System.out.println("Third num: "+ num3);
        System.out.println("Sum of the numbers: "+ sum);
        System.out.printf("%s%.2f","Average : ",ave);
        System.out.println();
        
    }
    
}
