/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecars;

/**
 *
 * @author rz_rexton
 */
import java.io.*;
import java.util.*;
import static lecars.EmployeeIO.getEmployeeInput;
import static lecars.EmployeeIO.filterEmployeeByStatus;
import static lecars.SalesIO.getSalesInput;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class ManageEmployee {
    public static void main(String[] args) {
//        System.out.println(getProfitMargin());
        System.out.println(getEmployeeSalary("E0010",1));
        System.out.println(getEmployeeBonus("E0010",0));
    }

    public static void newManageEmployee(String employeeId, String employeeName) {
        
        //load the list of all employees
        List<EmployeeIO> employees = getEmployeeInput();
        
        boolean found = false; //flag for found employee
        boolean alreadyManagementLevel = false; //flag for already management level
        String targetemp = ""; 

        for (EmployeeIO employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {  //if employeeid inserted found
                found = true;
                if (employee.getEmployeeStatus() == 1) {   //when status is already 1
                    alreadyManagementLevel = true;
                    targetemp = employee.getEmployeeName();   //save the found employee name
                    break;
                } else {
                    employee.setEmployeeStatus(1);   //set the status to 1
                    targetemp = employee.getEmployeeName(); //save the found employee name
                    break;
                }
            }
        }

        try {
            File file = new File("src/data/employee.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            // Write header row
            writer.write("employeeId,employeeName,employeeStatus,password\n");

            // Rewrite the original employee details after the target employee status is changed
            for (EmployeeIO employee : employees) {
                writer.write(employee.toString() + "\n");
            }

            writer.close();

            if (!alreadyManagementLevel && !found) {
                System.out.println("Employee with ID " + employeeId + " and name " + employeeName + " are not found.");
            } else if (alreadyManagementLevel) {
                System.out.println("Employee with ID " + employeeId + ", " + targetemp + " is already a management level employee.");
            } else {
                System.out.println("Employee with ID " + employeeId + ", " + targetemp + " has been updated to a management level employee.");
            }
        } catch (IOException e) {
            e.printStackTrace();  //catches any IOException that might occur during file writing operations.
        }
    }
    
    public static double getEmployeeSalary(String employeeId, int employeeStatus){
        double basicSalary = 0;
        double maxAllowance = 0;
        
        OffsetDateTime currentDate = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String todayMonth = currentDate.format(formatter);
//        System.out.println(todayMonth);
//        todayMonth = "2023-07";
        
        Map<String, Double> aggregatedTotalSalesPriceByYearMonthByEmployeeId = SalesIO.aggregateTotalSalesPriceByYearMonthByEmployeeId("E0014");
        // Output the aggregated sales by year and month
//        for (Map.Entry<String, Double> entry : aggregatedTotalSalesPriceByYearMonthByEmployeeId.entrySet()) {
//            System.out.println("Year-Month: " + entry.getKey() + ", Total Sales: " + entry.getValue());
//        }
        
        double totalSalesPriceThisMonth = 0;
        
        if (!(aggregatedTotalSalesPriceByYearMonthByEmployeeId.get(todayMonth) == null)) {
            totalSalesPriceThisMonth = aggregatedTotalSalesPriceByYearMonthByEmployeeId.get(todayMonth);
        }
        
        double commisionFee = totalSalesPriceThisMonth * 0.01;
        
        switch(employeeStatus){
            // management
            case 1:
                basicSalary = 2200;
                maxAllowance = 350;
                break;
                
            // sales
            case 0:
                basicSalary = 1200;
                maxAllowance = 250;
                break;
        }
        
        double salary = commisionFee + basicSalary + maxAllowance;
        return salary;
    }
    
    public static double getEmployeeBonus(String employeeId, int employeeStatus){
        double bonus = 0;
        
        OffsetDateTime currentDate = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String todayMonth = currentDate.format(formatter);
//        todayMonth = "2023-07";
        
        int totalSales = 0;
        List<SalesIO> sales = SalesIO.filterSalesByEmployeeId(employeeId);
        for (SalesIO sale : sales) {
            OffsetDateTime saleDateTime = sale.dateTime();
            String extractYearMonth = saleDateTime.format(formatter);
            if (extractYearMonth.equals(todayMonth)){
                totalSales++;
            }
        }
        System.out.println(totalSales);
        
        Map<String, Double> aggregatedTotalSalesPriceByYearMonthByEmployeeId = SalesIO.aggregateTotalSalesPriceByYearMonthByEmployeeId("E0014");
        // Output the aggregated sales by year and month
//        for (Map.Entry<String, Double> entry : aggregatedTotalSalesPriceByYearMonthByEmployeeId.entrySet()) {
//            System.out.println("Year-Month: " + entry.getKey() + ", Total Sales: " + entry.getValue());
//        }
                
        switch(employeeStatus){
            // management
            case 1:
                double totalSalesPriceThisMonth = 0;
        
                if (!(aggregatedTotalSalesPriceByYearMonthByEmployeeId.get(todayMonth) == null)) {
                    totalSalesPriceThisMonth = aggregatedTotalSalesPriceByYearMonthByEmployeeId.get(todayMonth);
                }
                
                if (aggregatedTotalSalesPriceByYearMonthByEmployeeId.get(todayMonth) == null) totalSalesPriceThisMonth = 0;
                if(totalSalesPriceThisMonth >= 2500000.01)        bonus = totalSalesPriceThisMonth *= 0.0135;
                else if(totalSalesPriceThisMonth >= 1600000.01)   bonus = totalSalesPriceThisMonth *= 0.0125;
                else if(totalSalesPriceThisMonth >= 800000.01)    bonus = totalSalesPriceThisMonth *= 0.0115;
                else                                              bonus = totalSalesPriceThisMonth *= 0.01;
                break;
                
            // sales
            case 0:
                if(totalSales > 15){
                    bonus = 500;
                }
                break;
        }
        
        return bonus;
    }
    
    private static double getProfitMargin(){
        // profit from sales
        double profitMargin = 0;
        List<SalesIO> sales = getSalesInput();
        for (SalesIO sale : sales) {
            VehicleIO vehicle = VehicleIO.searchByVehicleCarPlate(sale.getCarPlate());
            if (vehicle != null){
                profitMargin += vehicle.getSalesPrice() - vehicle.getAcquirePrice();
            }
        }
        
        // deduction from salary
        List<EmployeeIO> employees = getEmployeeInput();
        for (EmployeeIO employee : employees) {
            profitMargin -= getEmployeeSalary(employee.getEmployeeId(), employee.getEmployeeStatus());
            profitMargin -= getEmployeeBonus(employee.getEmployeeId(), employee.getEmployeeStatus());
        }
        
        return profitMargin;
    }
}