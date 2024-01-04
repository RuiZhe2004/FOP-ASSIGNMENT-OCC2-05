package lecars;

import lecars.StreamReaderHandler;
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
        for (VehicleIO vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
        System.out.println();
        
        //filter by status, not sold = 1
        //filterVehicleByStatus(1);
        
        //filter by status, sold = 0
        //filterVehicleByStatus(0);
        
        //search by car plate
        VehicleIO vehicle = searchByVehicleCarPlate("ABC9999");
        if(vehicle == null)
            System.out.println("No result");
        else
            System.out.println(vehicle.toString());
        
        //search by car model
        //filterByCarModel("Honda Civic");
        
        //filter by status 0 and car model
        //filterVehicleByStatusAndModel(0, "Honda Civic");
        
        //filter by carPrice
        //filterVehicleByCarSales(10000);
        
        //filter by carModel
        //filterByCarModel("Toyota Corolla");
        
        //add new vehicle
        //addNewVehicle("CBA123","LECAR","10000","0","99999");
        
        soldVehicle("ABC9999",200);
    }
    
    /**
     * Gets the status set.
     *
     * <pre>
     * Pseudocode:
     * 1) Define a final String variable STATUS with the value "1".
     * 2) Define a String variable currentStatus and initialize it to the value of STATUS.
     * 3) Return the value of currentStatus.
     * </pre>
     *
     * @method getStatusSet()
     * @param -
     * @return the status set = 1
     * @see #STATUS
     */
    public static String getStatusSet() {
        final String STATUS = "1";
        String currentStatus = STATUS;
        return currentStatus;
    }
    
    /**
     * Reads and parses sold vehicle data from a CSV file
     *
     * <pre>
     * Pseudocode:
     * 1) Open the CSV file for reading.
     * 2) Skip the first line (header row).
     * 3) Read each line of the file.
     * 4) Split each line into attributes.
     * 5) Parse the attributes to create a VehicleIO object.
     * 6) Add the VehicleIO object to a list.
     * 7) Close the CSV file.
     * 8) Return the list of VehicleIO objects.
     * </pre>
     * 
     * @method getSoldVehicleInput()
     * @param  - 
     * @return A list of VehicleIO objects representing the vehicles in the CSV file.
     * @throws IOException if there is an error reading the CSV file.
     * @see VehicleIO
     */
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
    
    /**
     * Searches for a vehicle by its car plate among the sold vehicles.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of sold vehicles using the getSoldVehicleInput() method.
     * 2) Iterate through the list of vehicles.
     * 3) For each vehicle, compare its car plate to the given car plate.
     * 4) If the car plates match, return the vehicle.
     * 5) If no vehicle is found with the given car plate, return null.
     * </pre>
     *
     * @method searchBySoldVehicleCarPlate()
     * @param carPlate : the car plate of the vehicle to search for
     * @return the vehicle with the given car plate, or null if no such vehicle is found
     * @see #getSoldVehicleInput()
     */
    public static VehicleIO searchBySoldVehicleCarPlate(String carPlate) {
        List<VehicleIO> vehicles = getSoldVehicleInput();
        
        for (VehicleIO vehicle : vehicles) {
            if (vehicle.carPlate.equals(carPlate)) {
                return vehicle;
            }
        }
        return null;
    }
    
    /**
     * Reads and parses all vehicle data from a CSV file
     *
     * <pre>
     * Pseudocode:
     * 1) Get an InputStream for the resource file vehicle.csv.
     * 2) Convert the InputStream to a String.
     * 3) Remove the first line (header row) from the String.
     * 4) Split the String into lines.
     * 5) For each line, split it into attributes.
     * 6) Parse the attributes to create a VehicleIO object.
     * 7) Add the VehicleIO object to a list.
     * 8) Return the list of VehicleIO objects.
     * </pre>
     *
     * @method getVehicleInput()
     * @param -
     * @return A list of VehicleIO objects representing the vehicles in the CSV file.
     * @see VehicleIO
     */
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
    
    /**
     * Filters the list of vehicles by a given status.
     *
     * <pre>
     * Pseudocode:
     * 1) Create a new list to store the filtered vehicles.
     * 2) Get the list of all vehicles using the getVehicleInput() method.
     * 3) Iterate through the list of vehicles.
     * 4) For each vehicle, check if its status matches the given status.
     * 5) If the status matches, add the vehicle to the filtered list.
     * 6) Return the filtered list of vehicles.
     * </pre>
     *
     * @method filterVehicleByStatus()
     * @param status the status to filter by
     * @return a list of vehicles with the given status
     * @see #getVehicleInput()
     */
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
    
    /**
     * Searches for a vehicle by its car plate.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all vehicles using the getVehicleInput() method.
     * 2) Iterate through the list of vehicles.
     * 3) For each vehicle, compare its car plate to the given car plate.
     * 4) If the car plates match, return the vehicle.
     * 5) If no vehicle is found with the given car plate, return null.
     * </pre>
     *
     * @method searchByVehicleCarPlate()
     * @param carPlate the car plate of the vehicle to search for
     * @return the vehicle with the given car plate, or null if no such vehicle is found
     * @see #getVehicleInput()
     */
    public static VehicleIO searchByVehicleCarPlate(String carPlate) {
        List<VehicleIO> vehicles = getVehicleInput();
        
        for (VehicleIO vehicle : vehicles) {
            if (vehicle.carPlate.equals(carPlate)) {
                return vehicle;
            }
        }
        return null;
    }
    
    /**
     * Filters the list of vehicles by a given model.
     *
     * <pre>
     * Pseudocode:
     * 1) Create a new list to store the filtered vehicles.
     * 2) Get the list of all vehicles using the getVehicleInput() method.
     * 3) Iterate through the list of vehicles.
     * 4) For each vehicle, check if its model matches the given model.
     * 5) If the model matches, add the vehicle to the filtered list.
     * 6) Return the filtered list of vehicles.
     * </pre>
     *
     * @method filterByCarModel()
     * @param model the model to filter by
     * @return a list of vehicles with the given model
     */
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
    
    /**
     * Filters the list of vehicles by a given status and model.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all vehicles using the getVehicleInput() method.
     * 2) Iterate through the list of vehicles.
     * 3) For each vehicle, check if its status matches the given status and its model matches the given model.
     * 4) If the status and model match, print the vehicle to the console.
     * </pre>
     *
     * @method filterVehicleByStatusAndModel()
     * @param status the status to filter by
     * @param model the model to filter by
     */
    public static void filterVehicleByStatusAndModel(int status, String model) {
    List<VehicleIO> vehicles = getVehicleInput();
        for (VehicleIO vehicle : vehicles) {
            if (vehicle.getCarStatus() == status && vehicle.getCarModel().equals(model)) {
                System.out.println("Vehicle with " + model + " status " + status + " : " + vehicle.toString());
            }
        }
    }
    
    /**
     * Filters the list of vehicles by a minimum sales price.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all vehicles using the getVehicleInput() method.
     * 2) Iterate through the list of vehicles.
     * 3) For each vehicle, check if its sales price is greater than the given price.
     * 4) If the sales price is greater than the given price, print the vehicle to the console.
     * </pre>
     *
     * @method filterVehicleByCarSales ()
     * @param price the minimum sales price to filter by
     */
    public static void filterVehicleByCarSales (int price) {
        List<VehicleIO> vehicles = getVehicleInput();
        for (VehicleIO vehicle : vehicles) {
            if (vehicle.getSalesPrice() > price) {
                System.out.println("Vehicle with " + price + " above: " + vehicle.toString());
            }
        }
    }
    
    /**
     * Adds a new vehicle to the vehicle list.
     *
     * <pre>
     * Pseudocode:
     * 1) Get the list of all vehicles using the getVehicleInput() method.
     * 2) Check if the given car plate already exists in the list.
     * 3) If the car plate already exists, return an error message.
     * 4) If the car plate does not exist, add the new vehicle to the list.
     * 5) Write the updated list to the CSV file.
     * 6) Return a message indicating whether the vehicle was successfully added or not.
     * </pre>
     *
     * @method addNewVehicle()
     * @param carPlate the car plate of the new vehicle
     * @param carModel the model of the new vehicle
     * @param acquirePrice the acquire price of the new vehicle
     * @param carStatus the status of the new vehicle
     * @param salesPrice the sales price of the new vehicle
     * @return a message indicating whether the vehicle was successfully added or not
     */
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
    
    /**
     * Marks a vehicle as sold and updates its sales price.
     *
     * <pre>
     * Pseudocode:
     * 1) Create a temporary file to write updated data.
     * 2) Write the header row to the temporary file.
     * 3) Iterate through the list of vehicles.
     * 4) For each vehicle, check if its car plate matches the given car plate.
     * 5) If the car plates match, update the vehicle's status to sold and its sales price to the given sales price.
     * 6) Write the updated vehicle to the temporary file.
     * 7) Close the temporary file.
     * 8) Copy the contents of the temporary file to the original file, overwriting the original file.
     * 9) Delete the temporary file.
     * 10) Return a message indicating whether the vehicle was successfully updated or not.
     * </pre>
     *
     * @method soldVehicle()
     * @param carPlate the car plate of the vehicle to mark as sold
     * @param salesPrice the sales price of the vehicle
     * @return a message indicating whether the vehicle was successfully updated or not
     */
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

    

