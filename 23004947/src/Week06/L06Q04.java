/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week06;

/**
 *
 * @author rz_rexton
 */
public class L06Q04 {
    public static void main(String[] args) {
        GCD(24,8);
        GCD(200,625);
    }
    
    
    public static int GCD(int x,int y){
        int divisor =0;
        if (x<y){
            for(int i=x;i>1;i--){
                if(y%i==0 && x%i==0){
                  divisor = i;
                  break;
                }
            }
        }
        
        else if (y<x){
            for(int i=y;i>1;i--){
                if(x%i==0 && x%i==0){
                  divisor = i;
                  break;
                }
            }
        }
        
        else{
            for(int i=x;i>1;i--){
                if(x%i==0 && x%i==0){
                  divisor = i;
                  break;
                }
            }
        }
        System.out.println("The greatest common divisor for "+x+" & "+y+" is "+ divisor);
        return divisor;
    }
}
