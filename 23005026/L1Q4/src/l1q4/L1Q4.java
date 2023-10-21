/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package l1q4;

/**
 *
 * @author lowji
 */
public class L1Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 6;
        int[] lt = {25, 16, 20, 27, 32, 8};
        String[] month = {"Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "  (MONTH 2016)" };
        System.out.println("1 asterisk (*) = 100");
        ver(lt, month);
    }
    
    public static void ver(int t[], String m[]) {
        int n = t.length;
        int p = m.length;
        int  max = t[0];
        for(int i=1; i < n; i+=1) {
            if (t[i] > max) {
                max = t[i];
            }    
        }
        
        for (int floor_num = max; floor_num >= 1; floor_num -= 1){
            for (int j = 0; j < n; j += 1){
                if(t[j] >= floor_num) {
                    System.out.printf("%6s"," *");
                }else{
                    System.out.printf("%6s","  ");
                }
            }
            System.out.println();
        }
        
        System.out.printf("%2s", "");
        for (int i = 0; i < p; i++){
            System.out.printf("%6s", m[i]);
        }
        System.out.println();
    }
}
