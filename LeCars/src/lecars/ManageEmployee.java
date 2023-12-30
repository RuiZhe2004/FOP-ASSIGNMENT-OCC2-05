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
import java.time.*;
import java.time.format.DateTimeFormatter;

public class ManageEmployee extends EmployeeIO{
    public static void main(String[] args) {
        System.out.println(getEmployeeSalary("E0001",1));
//        System.out.println(getEmployeeBonus("E0001",1));
        System.out.println(getProfitMarginThisMonth());
    }
    
    public ManageEmployee(String employeeId, String employeeName, int employeeStatus, String password) {
        super(employeeId, employeeName, employeeStatus, password); // Calls the superclass constructor
    }
    
    public ManageEmployee(String employeeId, String employeeName, int employeeStatus) {
        super(employeeId, employeeName, employeeStatus); // Calls the superclass constructor
    }
    
    /**
     * <pre>
     * To change the status of a sales employee to management employee
     * Pseudocode
     * 1) Check whether the employee exist or not
     * 2) Check whether the employee is already a management employee or not
     * 3) If not a management employee
     *       Input the secret key for the company "abcde"
     * 4) If the secret key is correct then change the status of sales employee to management employee
     * 5) Update in the employee.csv file
     * </pre>
     * 
     * @method    newManageEmployee
     * @param    employeeID  a unique employee ID
     * @param    employeeName the name of the employee
     * @return   void
     * @see      getEmployeeInput()
     */
    public static void newManageEmployee(String employeeId, String employeeName) {
        
        //load the list of all employees
        /**
         * @param   employees   an array list of employee objects
         */
        List<EmployeeIO> employees = EmployeeIO.getEmployeeInput();
        
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
    
    /**
     * <pre>
     * To get the salary of an employee by Employee ID
     * Pseudocode
     * 1) Get the today Year and Month
     * 2) Check from the sales.csv to find the match for the Year and Month
     * 3) Filter the aggregated total sales price by year and month by an employee to match the current year and month
     * 4) Check whether the employee is a sales employee or a management employee
     * 5) Commission fee = 1% of total sales price this month
     * 6) Sales employee
     *       basic salary = 1200
     *       max allowance = 250
     * 7) Management employee
     *       basic salary = 2200
     *       max allowance =350
     * 8) Return the salary = basic salary + commission fee + max allowance
     * </pre>
     * 
     * @method    getEmployeeSalary
     * @param    employeeID  a unique employee ID
     * @param    employeeStatus the status of the employee
     *                          1 for management employee
     *                          0 for sales employee
     * @return   double salary   The salary of an employee according to the sales record this month
     */    
    public static double getEmployeeSalary(String employeeId, int employeeStatus){
        double basicSalary = 0;
        double maxAllowance = 0;
        
        OffsetDateTime currentDate = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String todayYearMonth = currentDate.format(formatter);
//        System.out.println(todayMonth);
//        todayMonth = "2023-07";
        
        Map<String, Double> aggregatedTotalSalesPriceByYearMonthByEmployeeId = SalesIO.aggregateTotalSalesPriceByYearMonthByEmployeeId(employeeId);
        // Output the aggregated sales by year and month
        for (Map.Entry<String, Double> entry : aggregatedTotalSalesPriceByYearMonthByEmployeeId.entrySet()) {
            System.out.println("Year-Month: " + entry.getKey() + ", Total Sales: " + entry.getValue());
        }
        
        double totalSalesPriceThisMonth = 0;
        
        if (!(aggregatedTotalSalesPriceByYearMonthByEmployeeId.get(todayYearMonth) == null)) {
            totalSalesPriceThisMonth = aggregatedTotalSalesPriceByYearMonthByEmployeeId.get(todayYearMonth);
        }
        
        double commissionFee = totalSalesPriceThisMonth * 0.01;
        
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

        double salary = commissionFee + basicSalary + maxAllowance;
        return salary;
    }
    
    
    /**
     * <pre>
     * To get the bonus of an employee by Employee ID
     * Pseudocode
     * 1) Get the today Year and Month
     * 2) Check from the sales.csv to find the match for the Year and Month
     * 3) Filter the aggregated total sales price by year and month by an employee to match the current year and month
     * 4) Check whether the employee is a sales employee or a management employee
     * 5) Sales employee
     *       bonus = 500 if total sales this month > 15
     * 6) Management employee
     *       bonus =
    *           if total sales price this month >= 2500000.01
    *               1.35% of total sales price
    *           if total sales price this month >= 1600000.01
    *               1.25% of total sales price
    *           if total sales price this month >= 800000.01
    *               1.15% of total sales price
    *           else
    *               1% of total sales price
     * 7) Return the bonus
     * </pre>
     * 
     * @method    getEmployeeSalary
     * @param    employeeID  a unique employee ID
     * @param    employeeStatus the status of the employee
     * @return   double bonus   The bonus of an employee according to the sales record this month
     */ 
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
//        System.out.println(totalSales);
        
        Map<String, Double> aggregatedTotalSalesPriceByYearMonthByEmployeeId = SalesIO.aggregateTotalSalesPriceByYearMonthByEmployeeId(employeeId);
        // Output the aggregated sales by year and month
//        for (Map.Entry<String, Double> entry : aggregatedTotalSalesPriceByYearMonthByEmployeeId.entrySet()) {
//            System.out.println("Year-Month: " + entry.getKey() + ", Total Sales: " + entry.getValue());
//        }

        double totalSalesPriceThisMonth = 0;
        
        if (!(aggregatedTotalSalesPriceByYearMonthByEmployeeId.get(todayMonth) == null)) {
            totalSalesPriceThisMonth = aggregatedTotalSalesPriceByYearMonthByEmployeeId.get(todayMonth);
        }
                
        switch(employeeStatus){
            // management
            case 1:
                
                
                if (aggregatedTotalSalesPriceByYearMonthByEmployeeId.get(todayMonth) == null) totalSalesPriceThisMonth = 0;
                if(totalSalesPriceThisMonth >= 2500000.01)        bonus = totalSalesPriceThisMonth *= 0.0135;
                else if(totalSalesPriceThisMonth >= 1600000.01)   bonus = totalSalesPriceThisMonth *= 0.0125;
                else if(totalSalesPriceThisMonth >= 800000.01)    bonus = totalSalesPriceThisMonth *= 0.0115;
                else                                              bonus = totalSalesPriceThisMonth *= 0.01;
                break;
                
            // sales
            case 0:
                if(totalSales > 15 || totalSalesPriceThisMonth > 1000000){
                    bonus = 500;
                }
                break;
        }
        
        return bonus;
    }
  
    
    /**
     * <pre>
     * To get the profit margin of the company this month
     * Pseudocode
     * 1) set the profit margin initally to 0
     * 2) get the total profit margin from sales this month
     * 3) then substract the profit margin from the salary and bonus of each employee this month
     * 4) return the total profit margin this month
     * </pre>
     * 
     * @method  getProfitMarginThisMonth
     * @return  double totalProfitMarginThisMonth   The profit margin of the company this month
     * @see     aggregateProfitMarginByYearMonth()
     * @see     getEmployeeInput()
     * @see     getEmployeeId()
     * @see     getEmployeeStatus()
     */     
    public static double getProfitMarginThisMonth(){
        // profit from sales
        double totalProfitMarginThisMonth = 0;
        
        OffsetDateTime currentDate = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String todayYearMonth = currentDate.format(formatter);
        
        Map<String, Double> aggregatedProfitMarginByYearMonth = SalesIO.aggregateProfitMarginByYearMonth();
        
        if (!(aggregatedProfitMarginByYearMonth.get(todayYearMonth) == null)) {
            totalProfitMarginThisMonth = aggregatedProfitMarginByYearMonth.get(todayYearMonth);
        }
        
        // deduction from salary
        List<EmployeeIO> employees = getEmployeeInput();
        for (EmployeeIO employee : employees) {
            totalProfitMarginThisMonth -= getEmployeeSalary(employee.getEmployeeId(), employee.getEmployeeStatus());
            totalProfitMarginThisMonth -= getEmployeeBonus(employee.getEmployeeId(), employee.getEmployeeStatus());
        }
        
        return totalProfitMarginThisMonth;
    }
}