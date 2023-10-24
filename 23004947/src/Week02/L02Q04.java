
package Week02;

import java.util.Scanner;
public class L02Q04 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number of seconds: ");
        int second = sc.nextInt();
        
        int hour = second/3600;
        int minute = second%3600/60;
        int remainsec = second%60;
        System.out.println(second +" seconds is "+ hour+" hours, " + minute+" minutes and "+ remainsec+" seconds");
    }
}
