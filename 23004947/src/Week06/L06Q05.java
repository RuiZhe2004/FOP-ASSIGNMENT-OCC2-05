/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author rz_rexton
 */
import java.util.*;
public class L06Q05 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random g = new Random();
        boolean state = true;
        int score =0;
        while (state){
            System.out.println("Enter negative number to quit. ");
            int x = g.nextInt(13);
            int y = g.nextInt(13);
            System.out.print(x+" x "+y+" = ");
            int value = sc.nextInt();
            if (value<0){;
                state = false;
            }
            else{
                score = Score(x,y,value,score);  
            }
        }
        System.out.println("Your score is "+ score);
    }
    
    public static int Score(int x,int y,int ans,int score){
        if (ans == x*y){
            score++;
        }    
        return score;
    }
}
