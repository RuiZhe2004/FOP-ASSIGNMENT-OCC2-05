package Week06;

public class L06Q06 {
    public static void main(String[] args) {
        int count = 0;
        int i = 2;
        
        System.out.println("First 20 Palindromic Prime: ");
        while (count < 20) {
            if (palindromicprime(i)) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
        System.out.println("");
        
        count = 0;
        i = 2; 
        
        System.out.println("First 20 Emirp Prime :");
        while (count < 20) {
            if (emirp(i)) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
        System.out.println("");
    }

    public static boolean palindromicprime(int num) {
        return (palindrome(num) && prime(num));
    }

    public static boolean emirp(int num) {
        return (!palindrome(num) && prime(num) && prime(Reversed(num)));
    }

    public static int Reversed(int num) {
        int reverse = 0;
        while (num != 0) {
            int remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num /= 10;
        }
        return reverse;
    }

    public static boolean palindrome(int num) {
        return Reversed(num) == num;
    }

    public static boolean prime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
