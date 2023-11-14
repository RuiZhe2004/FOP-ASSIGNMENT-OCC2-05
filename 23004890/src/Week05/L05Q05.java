/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;
import java.util.*;

/**
 *
 * @author ruizh
 */
public class L05Q05 {
    public static void main(String[] args) {
        
        //Generate 20 random numbers
        Random a = new Random();
        int[] num = new int[20];
        System.out.println("A list of 20 random integer within 0 to 100");
        for (int i = 0; i < num.length; i++){
            num[i] = a.nextInt(0,101);
            if (i == (num.length-1))
                System.out.print(num[i]);
            else
                System.out.print(num[i] + ", ");
        }
        System.out.println("");
        
        //Bubble sort the 20 random numbers
        System.out.println("Array in descending order");
        for (int pass = 1; pass < num.length; pass++){
            for (int i = 0; i < num.length - 1; i++){
                if (num[i] < num[i+1]){
                    int hold = num[i];
                    num[i] = num[i+1];
                    num[i+1] = hold;
                }
            }
        }
        for (int i = 0; i < num.length; i++){
            if (i == (num.length-1))
                System.out.print(num[i]);
            else
                System.out.print(num[i] + ", ");
        }
        System.out.println("");
        
        //Prompt user to search
        Scanner b = new Scanner(System.in);
        System.out.print("Enter a number to search: ");
        int target = b.nextInt();
        boolean searchl = false;
        
        //Linear Search
        for (int counter = 0; counter < num.length; counter++){
            if (num[counter] == target){
                System.out.println(target + " found");
                System.out.println("Linear Search - " + (counter+1) + " loop(s)");
                searchl = true;
                break;
            }
        }
        if (!searchl)
            System.out.println(target + " not found");
        
        
        //Binary Search
        int low = 0;
        int high = num.length - 1;
        int middle;
        int loop = 1;
        boolean searchb = false;
        
        while (low <= high){
            middle = (low + high)/2;
            if (target == num[middle]){
                System.out.println(target + " found");
                System.out.println("Binary Search - " + loop + " loop(s)");
                searchb = true;
                break;
            }
            else if (target < num[middle]){
                low = middle + 1;
            }
            else{
                high = middle - 1;
            }
            loop++;
        }
        if (!searchb)
            System.out.println(target + " not found");
    }
}
