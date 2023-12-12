/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week07;

/**
 *
 * @author lowji
 */
import java.io.*;
import java.util.*;

public class L07Q06 {
    public static void main(String[] args) {
        try {
            BufferedReader pr = new BufferedReader(new FileReader("C:\\Users\\lowji\\OneDrive\\Documents\\NetBeansProjects\\wix1002-2023-occ2-lab-occ2-05\\23005026\\src\\Week07\\product.txt"));
            Map<String, String[]> products = new HashMap<>();

            
            String line1 = pr.readLine();
            while(line1 != null) {
                String[] parts = line1.split(",");
                products.put(parts[0], new String[]{parts[1],parts[2]});
            }
            pr.close();
            
            
                        
            BufferedReader or = new BufferedReader(new FileReader("C:\\Users\\lowji\\OneDrive\\Documents\\NetBeansProjects\\wix1002-2023-occ2-lab-occ2-05\\23005026\\src\\Week07\\order.txt"));
            String line2 = or.readLine();
            while(line2 != null) {
                String[] parts = line2.split(",");
                String[] product = products.get(parts[1]);
                
                if (product != null) {
                    String productName = product[0];
                    double pricePerUnit = Double.parseDouble(product[1]);
                    int orderQuantity = Integer.parseInt(parts[2]);
                    double totalPrice = pricePerUnit * orderQuantity;
                    
                    System.out.printf(parts[1] + " " + productName + " " + orderQuantity + " " + pricePerUnit + " " + totalPrice);
                    System.out.println();
                }
            }
            or.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
