/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecars;

/**
 *
 * @author szeyu
 */

import java.io.*;
import java.nio.charset.StandardCharsets;

import lecars.CustIO;

public class LeCars {
    public static void main(String[] args) {
        String[][] cust = CustIO.getCustInput();
        System.out.println(cust[0][0]);
    }
}
