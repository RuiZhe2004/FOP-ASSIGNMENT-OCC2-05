
package Week02;

import java.util.Scanner;
public class L02Q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter temperature in degree Fahranheit : ");
        double Fahranheit = sc.nextDouble();
        double Celcius = (Fahranheit -32)/1.8;
        System.out.printf("%.2f %s %s %.2f %s%n",Fahranheit,"degree Fahranheit","=", Celcius, "degree Celcius");          
    }   
}
