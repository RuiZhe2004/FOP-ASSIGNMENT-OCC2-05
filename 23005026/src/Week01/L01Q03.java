/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week01;

/**
 *
 * @author ooiru
 */
public class L01Q03 {
    public static void main(String[] args) {
        topbtm();
        System.out.println("*       *        *     *           ***             * *");
        System.out.println("*       *       *       *         *****           *   *");
        repeat();
        System.out.println("*       *       *       *           *           *       *");
        repeat();
        System.out.println("*       *       *       *           *             *   *");
        System.out.println("*       *        *     *            *              * *");
        topbtm();
    }
    
    public static void topbtm() {
        System.out.printf("%-19s%-17s%-16s%-5s%n","*********",          "***",              "*",               "*");
    }
    
    public static void repeat() {
        System.out.printf("%-8s%-8s%-8s%-12s%-13s%-6s%-10s%n","*",       "*",       "*",       "*",           "*",            "*",     "*");
    }
    
}
