/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;
import java.util.Scanner;

/**
 *
 * @author ruizh
 */
public class L04Q01 {
    public static void main(String[] args) {
        Scanner i = new Scanner (System.in);
        System.out.print("Enter an Integer: ");
        int num;
        num = i.nextInt();
        
        System.out.print("The factors are: " );
        //跳脱思维 不一定要在loop里面才print这句话
        //Think out of box, not compulsory to print this inside loop
        
        for (int j = 1 ; j <= num ; j++){
        /*
            j is the factor, as any number divide 0 will get an error, direct start from 1
            The max factor can get is the number itself
        */
            if (num == j)
                System.out.println(j);
        /*
            We know that the number itself is the largest factor of the number
            The list of factors will stop at the number itself, so just print the factor ( as variable j ) without a comma
        */
            else if (num % j == 0){
                System.out.print( j + ", ");
        /*
            In the previous step, we know that j is the possible factor of the integer, ranging from 1 to the number itself
            If the remainder by dividing the number with the possible factor is 0, means it is the factor of the number
            Thus, need to print the number with a comma, as it is not the last factor yet
        */        
            }  
        }
    }
}

