/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author rz_rexton
 */
public class L06Q02 {
    public static void main(String[] args) {
        
        //Print triangle shape
        System.out.println("Triangle: \n");
        multiPrint(1,'c');
        multiPrint(2,'c');
        multiPrint(3,'c');
        System.out.println("");
        
        System.out.println("-----------------------------");
        
        System.out.println("Diamond: \n");
        System.out.print("  ");
        multiPrint(1,'c');
        System.out.print(" ");
        multiPrint(3,'c');
        multiPrint(5,'c');
        System.out.print(" ");
        multiPrint(3,'c');
        System.out.print("  ");
        multiPrint(1,'c');
    }
    
    public static void multiPrint(int n, char c){
        for(int i = 0; i < n; i++){
            System.out.print(c);
        }
        System.out.println();
    }
}
