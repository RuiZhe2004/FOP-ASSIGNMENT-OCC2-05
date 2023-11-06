/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week03;

/**
 *
 * @author User
 */
public class L03Q04 {
    public static void main(String[] args) {
        int p1 = 0;
        p1 = p1 + (int) (Math.random() * 6) + 1;
        p1 = p1 + (int) (Math.random() * 6) + 1;
        System.out.println("Player one dice is " + p1);
        int p2 = 0;
        p2 = p2 + (int) (Math.random() * 6) + 1;
        p2 = p2 + (int) (Math.random() * 6) + 1;
        System.out.println("Player two dice is " + p2);
        if (p1 > p2) {
            System.out.println("Player one wins");
        } else {
            System.out.println("Player two wins");
        }

    }

}
