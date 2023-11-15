/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author rz_rexton
 */
import java.util.*;
public class L05Q05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random g = new Random();
        int[] num = new int[20];
        System.out.println("A list of 20 random integer within 0 to 100");
        for (int i=0;i<num.length;i++){
            num[i] = g.nextInt(101);
            if (i==num.length-1){  //avoid printing last comma
                System.out.print(num[i]);
                break;
            }
            System.out.print(num[i]+", ");
        }
        System.out.println("");
        System.out.println("Array in desending order");
        
        //Bubble Sort
        int temp=0;
        for(int i=0;i<num.length-1;i++){
            for(int j=0;j<num.length-1;j++){
                if(num[j]<num[j+1]){
                    temp=num[j];
                    num[j]=num[j+1];
                    num[j+1]=temp;
                }
            }
        }
        
        //Print the sorted list out
        for (int i=0;i<num.length;i++){
            if (i==num.length-1){  //avoid printing last comma
                System.out.print(num[i]);
                break;
            }
            System.out.print(num[i]+", ");
        }
        System.out.println("");
        
        System.out.print("Enter a number to search: ");
        int search = sc.nextInt();
        
        //Linear search
        int linearloop =0;
        boolean foundlinear = false;
        for(int k=0;k<num.length;k++){
            if(search == num[k]){
                foundlinear = true;
                System.out.println(search+" is found");
                System.out.println("Linear search - "+linearloop+" loop(s)");
                break;
            }
            linearloop++;
        }
        if(!foundlinear){
            System.out.println(search +" is not found");
        }
        
        // Binary search
        int binaryloop = 0;
        boolean foundbinary = false;
        int low = 0, high = num.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (search == num[middle]) {
                System.out.println(search + " is found");
                System.out.println("Binary search - " + binaryloop + " loop(s)");
                foundbinary = true;
                break;
            } else if (search < num[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
            binaryloop++;
        }

        if (!foundbinary) {
            System.out.println(search + " is not found");
        }
    }
}
