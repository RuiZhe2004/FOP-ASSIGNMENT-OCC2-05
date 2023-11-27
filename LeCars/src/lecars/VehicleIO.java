package lecars;

import lecars.StreamReaderHandler;
import java.io.*;
import java.util.*;

public class VehicleIO {
    private String carPlate;
    private String carModel;
    private double acquirePrice;
    private int carStatus;
    private double salesPrice;
    private String employeeId;
    
    // Constructor
    public VehicleIO(String carPlate, String carModel, double acquirePrice, int carStatus, double salesPrice) {
        this.carPlate = carPlate;
        this.carModel = carModel;
        this.acquirePrice = acquirePrice;
        this.carStatus = carStatus;
        this.salesPrice = salesPrice;
    }
    
    public String getCarPlate() {
        return carPlate;
    }

    public String getCarModel() {
        return carModel;
    }

    public double getAcquirePrice() {
        return acquirePrice;
    }

    public int getCarStatus() {
        return carStatus;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setAcquirePrice(double acquirePrice) {
        this.acquirePrice = acquirePrice;
    }

    public void setCarStatus(int carStatus) {
        this.carStatus = carStatus;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public boolean hasAccess(EmployeeIO employee) {
        return true;
    }

    public boolean isStatus(int status) {
        return this.carStatus == status || this.carStatus == -1 && status == 0;
    }

    public boolean isPriceAbove(double price) {
        return this.salesPrice >= price;
    }

    //pls add toString method to customize ur output instead of array location, lol
    public String toString(){
        return carPlate+","+carModel+","+acquirePrice+","+carStatus+","+salesPrice;
    }
    
    public static void main(String[] args) {
        List<VehicleIO> vehicles = getVehicleInput();
        System.out.println("");
//        for (VehicleIO vehicle : vehicles) {            
//            System.out.println(vehicle.toString());
//        }
        
        filterByStatus(vehicles, 1);
    }
    
    public static List<VehicleIO> getVehicleInput() {
        List<VehicleIO> vehicles = new ArrayList<>();

        // Get an InputStream for the resource file vehicle.csv
        InputStream resourceStream = SalesIO.class.getResourceAsStream("/data/vehicle.csv");

        if (resourceStream != null) {
            // Convert the InputStream to a String
            String fileContent = StreamReaderHandler.convertStreamToString(resourceStream);

            // to remove the unused row
            fileContent = fileContent.replaceFirst("carPlate,carModel,acquirePrice,carStatus,salesPrice\\n", "");

            // Print or process the file content as needed
            System.out.println(fileContent);


            String[] lineSplit = fileContent.split("\\n");
//            vehicles = new String[lineSplit.length][5];
//
//            for(int line = 0; line < lineSplit.length; line++){
//                vehicles[line] = lineSplit[line].split(",");
//            }

//            for (String line : lineSplit) {
//                String[] attributes = line.split(",");
//                VehicleIO vehicle = new VehicleIO(attributes[0], attributes[1],
//                        Double.parseDouble(attributes[2]), Integer.parseInt(attributes[3]),
//                        Double.parseDouble(attributes[4]), attributes[5]);
//                vehicles.add(vehicle);
//            }
            for (String line : lineSplit) {
                String[] attributes = line.split(",");

                // set soldPrice to null when it is not exist
                Double soldPrice = null;
                // Check soldPrice exist
             /*    if (!attributes[4].isEmpty()) {
                    soldPrice = Double.parseDouble(attributes[4]);
                }*/
                
                //if got price then parse, else =0
                soldPrice=(attributes.length==5)?Double.parseDouble(attributes[4]):0;
                // attributes 0 = carPlate
                // attributes 1 = carModel
                // attributes 2 = acquirePrice
                // attributes 3 = carStatus
                // attributes 4 = salesPrice
                VehicleIO vehicle = new VehicleIO(attributes[0], attributes[1],
                        Double.parseDouble(attributes[2]), Integer.parseInt(attributes[3]),
                        soldPrice);

                // Assign values using setter methods
                vehicle.setCarPlate(attributes[0]);
                vehicle.setCarModel(attributes[1]);
                vehicle.setAcquirePrice(Double.parseDouble(attributes[2]));
                vehicle.setCarStatus(Integer.parseInt(attributes[3]));
                vehicle.setSalesPrice(soldPrice);

                vehicles.add(vehicle);
            }

            
        } else {
            System.err.println("Resource file not found.");
        }
        return vehicles;        
    }
    
    //filtering filtering filtering
    private static void filterByStatus(List<VehicleIO> vehicles, int status) {
        for (VehicleIO vehicle : vehicles) {
            //so that it stops lol,:3
            if (vehicle.carStatus==status) {
                System.out.println("Vehicle with status " + status + ": " + vehicle.toString());
            }
        }
    }
}
