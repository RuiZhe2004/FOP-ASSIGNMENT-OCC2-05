
package Week04;

/**
 *
 * @author szeyu
 */
import java.util.*;
public class L04Q04 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the year : ");
        int year = input.nextInt();
        
        // the number of days from Jan to Aug
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31};
        
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            // leap year
            System.out.println("Leap Year");
            monthDays[1] = 29;
        }
        
        int firstDay;
        do{
            System.out.print("Enter the first day of the year : ");
            firstDay = input.nextInt();
        } while (!(firstDay >= 0 && firstDay <= 6));
        
        int mayFirstDay = firstDay;
        for(int i = 0; i < 4; i ++){
            mayFirstDay = (mayFirstDay + monthDays[i]) % 7;
        }
         System.out.println("may first day : " + mayFirstDay);
        
        String[] mayDay = new String[35];
        
        // to add all the last month day to array
        int dayCount = 0;
        for(int i = 30-mayFirstDay+1; i <= 30; i++){
            mayDay[dayCount] = "" + i; // convert to string
            dayCount++;
        }
        
        // to add all the single digit to array
        int i = 1;
        while(dayCount-mayFirstDay < 9){
            mayDay[dayCount] = "0" + i;
            i++;
            dayCount++;
        }
        
        // to add all the double digit to array
        i = 10;
        while(dayCount-mayFirstDay < 31){
            if(dayCount >= 35) {
                String[] expandedList = new String[mayDay.length + 1];
                System.arraycopy(mayDay, 0, expandedList, 0, mayDay.length);
                mayDay = expandedList;
            }
            mayDay[dayCount] = "" + i;
            i++;
            dayCount++;
        }
        
        // add next month day to array
        i = 1;
        while(dayCount < 35){
            mayDay[dayCount] = "0" + i;
            i++;
            dayCount++;
        }
        
        // check the array
//        for(int ct = 0; ct < 35; ct++){
//            System.out.println(mayDay[ct]);
//        }
        
        // Calender for May
        System.out.println(" __________________________________");
        System.out.println("|               May                |");
        System.out.println(" __________________________________");
        System.out.println("| Su | Mo | Tu | We | Th | Fr | Sa |");
        for (int day = 1; day <= 35; day++){
            if((day % 7) - 1 == 0){
                System.out.println();
                System.out.print("|");
            }
            System.out.print(" " + mayDay[day-1] + " |");
            
        }
        
        System.out.println();
        System.out.println();
        
        ////////////////////////////////////////////////////////////////////
        //////////////////        August         ////////////////////////////
        ////////////////////////////////////////////////////////////////////
        int augFirstDay = firstDay;
        for(i = 0; i < 7; i ++){
            augFirstDay = (augFirstDay + monthDays[i]) % 7;
        }
         System.out.println("Aug first day : " + augFirstDay);
        
        String[] augDay = new String[35];
        
        // to add all the last month day to array
        dayCount = 0;
        for(i = 31-augFirstDay+1; i <= 31; i++){
            augDay[dayCount] = "" + i; // convert to string
            dayCount++;
        }
        
        // to add all the single digit to array
        i = 1;
        while(dayCount-augFirstDay < 9){
            augDay[dayCount] = "0" + i;
            i++;
            dayCount++;
        }
        
        // to add all the double digit to array
        i = 10;
        while(dayCount-augFirstDay < 31){
            if(dayCount >= 35) {
                String[] expandedList = new String[augDay.length + 1];
                System.arraycopy(augDay, 0, expandedList, 0, augDay.length);
                augDay = expandedList;
            }
            augDay[dayCount] = "" + i;
            i++;
            dayCount++;
        }
        
        // add next month day to array
        i = 1;
        while(dayCount < 35){
            augDay[dayCount] = "0" + i;
            i++;
            dayCount++;
        }
        
        // check the array
//        for(int ct = 0; ct < 35; ct++){
//            System.out.println(augDay[ct]);
//        }
        
        // Calender for May
        System.out.println(" __________________________________");
        System.out.println("|               Aug                |");
        System.out.println(" __________________________________");
        System.out.println("| Su | Mo | Tu | We | Th | Fr | Sa |");
        for (int day = 1; day <= augDay.length; day++){
            if((day % 7) - 1 == 0){
                System.out.println();
                System.out.print("|");
            }
            System.out.print(" " + augDay[day-1] + " |");
            
        }
        
    }
}
