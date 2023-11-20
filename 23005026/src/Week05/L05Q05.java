/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author lowji
 */
import java.util.*;

public class L05Q05 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        
        Integer[] arr = new Integer[20];
        
        for (int i = 0; i < arr.length; i++) {
            int num = rand.nextInt(101);
            arr[i] = num;
        }
        
        System.out.println("A list of 20 random integer within 0 to 100");
        printIntegers(arr);
        
        System.out.println();
        System.out.println("\nArray in descending order");
        Arrays.sort(arr, Collections.reverseOrder());
        printIntegers(arr);
        System.out.println();
        
        System.out.print("Enter a number to search: ");
        int num = sc.nextInt();
        linearSearch(num, arr);
        binarySearch(num, arr); 
        
    }
    
    public static void printIntegers (Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }                
    }
    
    
    public static void linearSearch (int n, Integer[] arr) {
        int i = 0;
        int count = 0;
        //boolean found = false;
        do{
            i++;
            count++;
            if(count == arr.length - 1) {
                if (arr[i] != n) {
                    System.out.println(n + " is not found");
                    //found = false;
                    break;
                }              
            }
            
            if (arr[i] == n) {
                    System.out.println(n + " is found");
                    //found = true;
                    break;
            }  
        }while (n != arr[i]);
        
        
        System.out.println("Linear Search - " + count + " loop(s)");
    }
    
    static void binarySearch(int n, Integer[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int count = 0;
        int mid;
        boolean found = false;

        while (right >= left) {
            count++; 
            mid = (right + left) / 2;
            if (arr[mid] == n) {
                found = true;
                break; 
            } else if (arr[mid] > n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (found) {
            System.out.println(n + " is found");
            System.out.println("Binary Search - " + count + " loop(s)");
        } else {
            System.out.println(n + " is not found");
            System.out.println("Binary Search - " + count + " loop(s)");
        }

    }   
}
