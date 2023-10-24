
package Week02;

import java.util.Random;
public class L02Q05 {
    public static void main(String[] args) {
        Random g = new Random();
        int randomNum = g.nextInt(10001);
        System.out.println("Number generated: "+ randomNum);
        
        int sum =0;
        while(randomNum > 0){
            int i = randomNum%10;
            sum+=i;
            randomNum = randomNum / 10;
        }     
        System.out.println("Sum of the digits : " + sum);      
    }
    
}
