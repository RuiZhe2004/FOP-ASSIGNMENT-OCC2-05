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

    //Add toString method to customize output (instead of array location)
    public String toString(){
        return carPlate+","+carModel+","+acquirePrice+","+carStatus+","+salesPrice;
    }
    
    public static void main(String[] args) {
        List<VehicleIO> vehicles = getVehicleInput();
        System.out.println();
        
        //filter by status, not sold = 1
        filterVehicleByStatus(1);
        
        //filter by status, sold = 0
        filterVehicleByStatus(0);
        
        //search by car plate
        VehicleIO vehicle = searchByVehicleCarPlate("PQR789");
        if(vehicle == null)
            System.out.println("No result");
        else
            System.out.println(vehicle.toString());
        
        //search by car model
        filterByCarModel("Honda Civic");
        
        //filter by status 0 and car model
        filterVehicleByStatusAndModel(0, "Honda Civic");
        
        //filter by carPrice
        filterVehicleByCarSales(10000);
            
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
            //System.out.println(fileContent);


            String[] lineSplit = fileContent.split("\\n");

            for (String line : lineSplit) {
                String[] attributes = line.split(",");

                // set soldPrice to null when it is not exist
                Double soldPrice = null;
                
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
    private static List<VehicleIO> filterVehicleByStatus(int status) {
        List<VehicleIO> filteredVehicles = new ArrayList<>();;
        List<VehicleIO> vehicles = getVehicleInput();
        for (VehicleIO vehicle : vehicles) {
            if (vehicle.carStatus==status) {
                System.out.println("Vehicle with status " + status + ": " + vehicle.toString());
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }
    
    // searching
    // by car plate
    public static VehicleIO searchByVehicleCarPlate(String carPlate) {
        List<VehicleIO> vehicles = getVehicleInput();
        
        for (VehicleIO vehicle : vehicles) {
            if (vehicle.carPlate.equals(carPlate)) {
                return vehicle;
            }
        }
        return null;
    }
    
    //search by carmodel
    public static List<VehicleIO> filterByCarModel(String model) {
        List<VehicleIO> filteredVehiclesCarModel = new ArrayList<>();
        List<VehicleIO> vehicles = getVehicleInput();
        
        for(VehicleIO vehicle : vehicles) {
            if (vehicle.carModel.equals(model)) {
                System.out.println("Vehicle with " + model + " : " + vehicle.toString());
                filteredVehiclesCarModel.add(vehicle);
            }
        }
        return filteredVehiclesCarModel;
    }
    
    //filter carmodel by status
    public static void filterVehicleByStatusAndModel(int status, String model) {
    List<VehicleIO> vehicles = getVehicleInput();
        for (VehicleIO vehicle : vehicles) {
            if (vehicle.getCarStatus() == status && vehicle.getCarModel().equals(model)) {
                System.out.println("Vehicle with " + model + " status " + status + " : " + vehicle.toString());
            }
        }
    }
    
    //filter vehicle with carSales price above
    public static void filterVehicleByCarSales (int price) {
        List<VehicleIO> vehicles = getVehicleInput();
        for (VehicleIO vehicle : vehicles) {
            if (vehicle.getSalesPrice() > price) {
                System.out.println("Vehicle with " + price + " above: " + vehicle.toString());
            }
        }
    }
    
}

    

