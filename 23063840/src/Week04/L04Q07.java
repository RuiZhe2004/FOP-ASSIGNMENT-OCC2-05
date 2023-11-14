/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author User
 */
import static java.lang.System.out;
import java.util.Formatter;

public class L04Q07 {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        out.println("Enter principal amount: ");
        int P = sc.nextInt();
        out.println("Enter interest in %: ");
        double i = sc.nextDouble();
        out.println("Enter total number of month(S): ");
        int N = sc.nextInt();
        double ti = 0;
        Formatter fmt = new Formatter();
        fmt.format("%-8s%15s%15s%15s%15s%15s\n", "Month", "Monthly Payment", "Princiapal", "Interest", "Unpaid Balance",
                "Total Interest");
        for (int a = 1; a <= N; a++) {
            double M = (P * (i / 1200)) / (1 - (Math.pow((1 + i / 1200), (N / -1))));
            double Cn = (M * Math.pow((1 + (i / 1200)), ((1 + (N - a)) / -1)));
            double Ln = M - Cn;
            double Rn = Ln / (i / 1200) - Cn;
            ti += Ln;
            fmt.format("%-8s%15.2f%15.2f%15.2f%15.2f%15.2f\n", a, M, Cn, Ln, Rn, ti);

        }
        out.println(fmt);
    }
}
