package lecars;


import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

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
    }
    
    public static List<VehicleIO> getSoldVehicleInput() {
        List<VehicleIO> vehicles = new ArrayList<>();

        try {
            // Create a BufferedReader to read the file
            BufferedReader reader = new BufferedReader(new FileReader("src/data/vehicle.csv"));

            // Skip the first line (header row)
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");

                // set soldPrice to null when it is not exist
                Double soldPrice = null;

                //if got price then parse, else =0
                soldPrice=(attributes.length==5)?Double.parseDouble(attributes[4]):0;

                // Check if salesPrice is not null
                if (soldPrice != 0) {
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
            }

            // Close the BufferedReader
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return vehicles;        
    }


    
    public static String getStatusSet() {
        final String STATUS = "1";
        String currentStatus = STATUS;
        return currentStatus;
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
    
    //add new vehicle
    //carPlate,carModel,acquirePrice,carStatus,salesPrice
    public static String addNewVehicle(String carPlate,String carModel,double acquirePrice,int carStatus,double salesPrice) {
        List<VehicleIO> vehicles = getVehicleInput();
        //carStatus = STATUS;
        
        boolean isDuplicate = vehicles.stream().anyMatch(vehicle -> vehicle.getCarPlate().equals(carPlate));
        
        if (isDuplicate) {
            System.out.println("The car plate has been taken.");
            return "Carplate has been taken.";
        } 
        else {        
            try (FileWriter fw = new FileWriter("src/data/vehicle.csv", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
                
            String lineOfData = String.format("%s,%s,%s,%s,%s", carPlate, carModel, acquirePrice, carStatus, salesPrice);
            out.println(lineOfData);
            System.out.println("Successfully wrote to the file.");
            return "Success";

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                return "An error occurred.";
            }
        }
        
    }
    
    //vehicle sold
    public static String soldVehicle(String carPlate, double salesPrice) {
        List<VehicleIO> vehicles = getVehicleInput();
             
        try {
            // Create a temporary file to write updated data
            File tempFile = new File("src/data/vehicle_temp.csv");
            FileWriter fwTemp = new FileWriter(tempFile, true);
            BufferedWriter bwTemp = new BufferedWriter(fwTemp);
            PrintWriter outTemp = new PrintWriter(bwTemp);
            
            outTemp.println("carPlate,carModel,acquirePrice,carStatus,salesPrice");
            
            boolean searchFlag = false;
            // Iterate through the vehicles
            for (VehicleIO vehicle : vehicles) {
                if (vehicle.getCarPlate().equals(carPlate) && !searchFlag) {
                    System.out.println(vehicle.getCarPlate());
                    System.out.println(vehicle.getCarStatus());
                    if(vehicle.getCarStatus() == 0){
                        // Close the temporary file
                        outTemp.close();
                        bwTemp.close();
                        fwTemp.close();
                        // Delete the temporary file
                        tempFile.delete();
                        return "Sold.";
                    }
                    // Update status and sales price
                    vehicle.setCarStatus(0);
                    vehicle.setSalesPrice(salesPrice);
                    searchFlag = true;
                }

                // Write the updated or unchanged data to the temporary file
                outTemp.println(vehicle.toString());
            }

            // Close the temporary file
            outTemp.close();
            bwTemp.close();
            fwTemp.close();

            // Copy the contents of the temporary file to the original file
            Files.copy(tempFile.toPath(), new File("src/data/vehicle.csv").toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Delete the temporary file
            tempFile.delete();
            
            if (searchFlag) {
                System.out.println("Successfully updated the file.");
                return "Success";
            } else{
                System.out.println("The vehicle does not exist");
                return "No such vehicle";
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return "An error occurred.";
        }
    }
    
}

    

