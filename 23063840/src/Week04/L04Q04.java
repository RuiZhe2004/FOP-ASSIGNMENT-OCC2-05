/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author User
 */
import java.util.Formatter;
import static java.lang.System.out;

public class L04Q04 {

    public static void main(String[] args) {
        Formatter fmt = new Formatter();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int[] days = { 31, 31 };
        int spacem = 0, spacea = 0;
        out.println("Enter the year and the first day of the year(0 for Sunday,1 for Monday,...,6 for Saturday)");
        int year = sc.nextInt();
        int fdoy = sc.nextInt();
        String empty = "";
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            spacem = (fdoy + 2) % 7;
            spacea = (fdoy + 3) % 7;
        } else {
            spacem = (fdoy + 1) % 7;
            spacea = (fdoy + 2) % 7;
        }

        // calendar for May
        out.println("         May\t" + year);
        fmt.format("%15s%15s%15s%15s%15s%15s%15s\n", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
                "Saturday");
        out.print(fmt);
        for (int i = 0; i < spacem; i++) {
            out.printf("%15s", empty);
        }
        for (int a = 1; a <= days[0]; a++) {
            out.printf("%15d", a);
            if ((a + spacem) % 7 == 0) {
                out.println();
            }

        }

        // calendaar for August
        out.println();
        out.println("\n         August\t" + year);
        out.print(fmt);
        for (int i = 0; i < spacea; i++) {
            out.printf("%15s", empty);
        }
        for (int a = 1; a <= days[1]; a++) {
            out.printf("%15d", a);
            if ((a + spacea) % 7 == 0) {
                out.println();
            }
        }
    }
}
