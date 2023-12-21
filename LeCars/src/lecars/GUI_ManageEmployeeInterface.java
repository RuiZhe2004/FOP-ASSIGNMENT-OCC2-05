package lecars;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import lecars.SalesIO;
import lecars.VehicleIO;
import lecars.CustIO;
import lecars.EmployeeIO;
import lecars.StreamReaderHandler;

public class GUI_ManageEmployeeInterface extends JFrame {

    private JPanel contentPanel;
    private JPanel homePanel;
    private JPanel customerPanel;
    private JPanel salesFilterPanel;
    private JPanel salesSearchPanel;
    private JPanel buttonPanel;
    private JPanel salesPanel;
    private JPanel vehiclePanel;
    private JPanel employeePanel;
    private String employeeId = "test";
    private String employeeName = "test";

    public GUI_ManageEmployeeInterface(String employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        initComponents();
        initDynamicContent();
        
    }
    
    private void home(){
        // Home
        homePanel = new JPanel();
        homePanel.setLayout(new GridLayout(3, 2));
        homePanel.add(new JLabel("ID:"));
        homePanel.add(new JLabel(this.employeeId)); // ID field
        homePanel.add(new JLabel("Name:"));
        homePanel.add(new JLabel(this.employeeName)); // Name field
        JButton logoutButton = new JButton("Log Out");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(GUI_SalesEmployeeInterface.this, "Logging out...");
                // Perform logout actions here
                GUI_Login GUI_LoginFrame=new GUI_Login();
                GUI_LoginFrame.setVisible(true);
                GUI_LoginFrame.pack();
                GUI_LoginFrame.setLocationRelativeTo(null);
                GUI_ManageEmployeeInterface.this.dispose();
                
            }
        });
        homePanel.add(logoutButton);
        contentPanel.add(createPanel("Home", homePanel));
    }
    
    private void customer(){
        // Customer
        customerPanel = new JPanel();
        customerPanel.setLayout(new BorderLayout());

        JTextField customerSearchField = new JTextField(""); // Declare the search field
        customerSearchField.setPreferredSize(new Dimension(200,30)); // Set preferred size
        
        JLabel customerSearchLabel = new JLabel("Search:"); // Create a label for the search field

        // Add the label and search field to the panel
        //customerPanel.add(customerSearchLabel, BorderLayout.WEST);
        //customerPanel.add(customerSearchField, BorderLayout.CENTER);

        JButton customerButton = new JButton("Search");
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the input from the search field
                String searchInput = customerSearchField.getText();
                
                // fetching customer information (Restrict employee to gain access to own customer only)
                List<CustIO> cust = SalesIO.filterCustByEmployeeId(employeeId);
                
                // Create a string builder to accumulate the customer information
                StringBuilder custInfo = new StringBuilder();
                
                custInfo.append("-,-,-,-\n");
                String[] columnNames = {"Customer ID", "Customer Name", "Phone Number", "Postcode"};
                
                if (searchInput == null || searchInput.isEmpty()) {
                    // Display all items
                    for (CustIO custs : cust) {
                        // Add logic to process each sale item
                        custInfo.append(custs.toString()).append("\n");
                    }
                } else {
                    // Search for specific items based on searchInput
                    for (CustIO custs : cust) {
                        // Add logic to process matching items
                         if (custs.getCustId().contains(searchInput)) {
                            custInfo.append(custs.toString()).append("\n");
                         }
                         else if (custs.getCustName().contains(searchInput)) {
                            custInfo.append(custs.toString()).append("\n");
                         }
                         else if (custs.getphoneNum().contains(searchInput)) {
                            custInfo.append(custs.toString()).append("\n");
                         }
                         else if (custs.getpostcode().contains(searchInput)) {
                            custInfo.append(custs.toString()).append("\n");
                         }
                    }
                }
                
                // to handle the case where nothing show in the table
                if(custInfo.toString().equals(""))
                    custInfo.append("-,-,-,-\n");

                // Show the accumulated sales information in a single pane
                showInfoInterface("Customer Info", custInfo.toString(), columnNames);
            }
        });
        // Create a separate panel for search
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(customerSearchLabel, BorderLayout.WEST);
        searchPanel.add(customerSearchField, BorderLayout.CENTER);
        searchPanel.add(customerButton, BorderLayout.EAST);
        //customerPanel.add(customerButton, BorderLayout.EAST);
        
        // Add search panel to the north position of vehicle panel
        customerPanel.add(searchPanel, BorderLayout.NORTH);
        
        JButton addNewCustButton = new JButton("Add New Customer");
        addNewCustButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a JDialog for the add new sales interface
                JDialog addNewCustDialog = new JDialog();
                addNewCustDialog.setTitle("Add New Customer");
                addNewCustDialog.setSize(500, 300);
                addNewCustDialog.setModal(true);
                addNewCustDialog.setLocationRelativeTo(null); // Center the dialog on the screen

                // Create components for the interface (JLabels, JTextFields, JButton)
                JLabel custIdLabel = new JLabel("Customer Id:");
                JTextField custIdField = new JTextField(CustIO.getNextUniqueCustId());
                custIdField.setEditable(false);
                custIdField.setPreferredSize(new Dimension(150, 25)); // Set preferred size

                JLabel custNameLabel = new JLabel("Customer Name:");
                JTextField custNameField = new JTextField();
                custNameField.setPreferredSize(new Dimension(150, 25)); // Set preferred size

                JLabel phoneNumLabel = new JLabel("Handphone Number:");
                JTextField phoneNumField = new JTextField();
                phoneNumField.setPreferredSize(new Dimension(150, 25)); // Set preferred size

                JLabel postcodeLabel = new JLabel("Postcode:");
                JTextField postcodeField = new JTextField();
                postcodeField.setPreferredSize(new Dimension(150, 25)); // Set preferred size

                JButton confirmButton = new JButton("Confirm");
                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Retrieve values from input fields
                        String custName = custNameField.getText();
                        String phoneNum = phoneNumField.getText();
                        String postcode = postcodeField.getText();
                        
                        JOptionPane.showMessageDialog(addNewCustDialog, "Customer successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
                                    
                        // Call the method to add new customer entry
                        // addCustSales(String carPlate, String custId, String employeeId, String formattedDateTime)
                        CustIO.addNewCust(custName, phoneNum, postcode);
                    }
                });

                // Create a JPanel with GridBagLayout for the add new sales interface
                JPanel addNewCustPanel = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.WEST; // Align components to the left
                gbc.insets = new Insets(5, 5, 5, 5); // Add some spacing

                gbc.gridx = 0;
                gbc.gridy = 0;
                addNewCustPanel.add(custIdLabel, gbc);

                gbc.gridx = 1;
                gbc.gridy = 0;
                addNewCustPanel.add(custIdField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 1;
                addNewCustPanel.add(custNameLabel, gbc);

                gbc.gridx = 1;
                gbc.gridy = 1;
                addNewCustPanel.add(custNameField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 2;
                addNewCustPanel.add(phoneNumLabel, gbc);

                gbc.gridx = 1;
                gbc.gridy = 2;
                addNewCustPanel.add(phoneNumField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                addNewCustPanel.add(postcodeLabel, gbc);

                gbc.gridx = 1;
                gbc.gridy = 3;
                addNewCustPanel.add(postcodeField, gbc);

                gbc.gridx = 1;
                gbc.gridy = 4;
                addNewCustPanel.add(confirmButton, gbc);

                // Add the panel to the dialog and make it visible
                addNewCustDialog.add(addNewCustPanel);
                addNewCustDialog.setVisible(true);
                
            }
        });
        //customerPanel.add(addNewCustButton, BorderLayout.SOUTH);
        contentPanel.add(createPanel("Customer", customerPanel));
        
        JButton importDataButton = new JButton("Import Data");
        importDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog importDataDialog = new JDialog();
                importDataDialog.setTitle("Add New Customer");
                importDataDialog.setSize(500, 300);
                importDataDialog.setModal(true);
                importDataDialog.setLocationRelativeTo(null);                     
                String outputFilePath = "src/data/cust.csv"; 
                StreamReaderHandler sh = new StreamReaderHandler();
                sh.copySelectedCsvFile(outputFilePath);
            }
        });
        // Create a separate panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addNewCustButton);
        buttonPanel.add(importDataButton);     
        
        // Add button panel below the search panel
        customerPanel.add(buttonPanel, BorderLayout.CENTER);
    }
    
    private void sales(){
        // Sales
        salesSearchPanel = new JPanel();
        salesSearchPanel.setLayout(new BorderLayout());
        
        salesFilterPanel = new JPanel();
        salesFilterPanel.setLayout(new BorderLayout());

        JTextField salesSearchField = new JTextField(""); // Declare the search field
        salesSearchField.setPreferredSize(new Dimension(200, 30)); // Set preferred size

        JLabel salesSearchLabel = new JLabel("Search:"); // Create a label for the search field

//        // Add the label and search field to the panel
//        salesSearchPanel.add(salesSearchLabel, BorderLayout.WEST);
//        salesSearchPanel.add(salesSearchField, BorderLayout.CENTER);

        JButton salesButton = new JButton("Search");
        salesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the input from the search field
                String searchInput = salesSearchField.getText();

                // fetching sales information (Restricted to own employeeId)
                List<SalesIO> sales = SalesIO.filterSalesByEmployeeId(employeeId);

                // Create a StringBuilder to accumulate sales information
                StringBuilder salesInfo = new StringBuilder();
                
                // add dummy value at the start
                // dk why the first line always cannot be printed, so this is the way lol 
                salesInfo.append("-,-,-,-,-\n");
                String[] columnNames = {"Sales ID", "Date/Time", "Car Plate", "Customer ID", "Employee ID"};

                if (searchInput == null || searchInput.isEmpty()) {
                    // Display all items
                    for (SalesIO sale : sales) {
                        // Add logic to process each sale item
                        salesInfo.append(sale.toString()).append("\n");
                    }
                } else {
                    // Search for specific items based on searchInput
                    for (SalesIO sale : sales) {
                        // Add logic to process matching items
                         if (sale.getSalesId().contains(searchInput)) {
                            salesInfo.append(sale.toString()).append("\n");
                         }
                         else if (sale.getCarPlate().contains(searchInput)) {
                            salesInfo.append(sale.toString()).append("\n");
                         }
                         else if (sale.getCustId().contains(searchInput)) {
                            salesInfo.append(sale.toString()).append("\n");
                         }
                         else if (sale.getEmployeeId().contains(searchInput)) {
                            salesInfo.append(sale.toString()).append("\n");
                         }
                    }
                }
                
                // to handle the case where nothing show in the table
                if(salesInfo.toString().equals(""))
                    salesInfo.append("-,-,-,-,-\n");

                // Show the accumulated sales information in a single pane
                showInfoInterface("Sales Info", salesInfo.toString(), columnNames);
            }
        });
//        salesPanel.add(salesButton, BorderLayout.EAST);
        
        JTextField priceAboveField = new JTextField(""); // Declare the priceAboveField field
        priceAboveField.setPreferredSize(new Dimension(200, 30)); // Set preferred size

        JButton salesPriceFilterButton = new JButton("Filter by Sales Price");
        salesPriceFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the price above from the text field
                try {
                    double priceAbove = Double.parseDouble(priceAboveField.getText());

                    // Filter sales data based on the price above
                    List<SalesIO> filteredSales = SalesIO.filterSalesPriceRangeByEmployeeId(priceAbove, employeeId);
                    for (SalesIO sale : filteredSales) {            
                        System.out.println(sale.toString());
                    }
                    
                    // Create a StringBuilder to accumulate sales information
                    StringBuilder salesInfo = new StringBuilder();

                    // add dummy value at the start
                    // dk why the first line always cannot be printed, so this is the way lol 
                    salesInfo.append("-,-,-,-,-\n");
                    // Display the filtered sales data
                    String[] columnNames = {"Sales ID", "Date/Time", "Car Plate", "Customer ID", "Employee ID"};
                    for (SalesIO sale : filteredSales) {
                        // Add logic to process each sale item
                        salesInfo.append(sale.toString()).append("\n");
                    }
                    showInfoInterface("Filtered Sales Info", salesInfo.toString(), columnNames);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(salesSearchPanel, "Invalid input for price above", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
//        salesPanel.add(salesPriceFilterButton, BorderLayout.NORTH);


        
        JButton addNewSalesButton = new JButton("Add New Sales");
        addNewSalesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a JDialog for the add new sales interface
                JDialog addNewSalesDialog = new JDialog();
                addNewSalesDialog.setTitle("Add New Sales");
                addNewSalesDialog.setSize(500, 300);
                addNewSalesDialog.setModal(true);
                addNewSalesDialog.setLocationRelativeTo(null); // Center the dialog on the screen

                // Create components for the interface (JLabels, JTextFields, JButton)
                JLabel salesIdLabel = new JLabel("Sales Id:");
                JTextField salesIdField = new JTextField(SalesIO.getNextUniqueSalesId());
                salesIdField.setEditable(false);
                salesIdField.setPreferredSize(new Dimension(150, 25)); // Set preferred size

                JLabel dateTimeLabel = new JLabel("Date/Time:");
                JTextField dateTimeField = new JTextField(SalesIO.getCurrentDateTime());
                dateTimeField.setEditable(false);
                dateTimeField.setPreferredSize(new Dimension(150, 25)); // Set preferred size

                JLabel employeeIdLabel = new JLabel("Employee Id:");
                JTextField employeeIdField = new JTextField(employeeId);
                employeeIdField.setEditable(false);
                employeeIdField.setPreferredSize(new Dimension(150, 25)); // Set preferred size

                JLabel carPlateLabel = new JLabel("Car Plate:");
                JTextField carPlateField = new JTextField();
                carPlateField.setPreferredSize(new Dimension(150, 25)); // Set preferred size

                JLabel custIdLabel = new JLabel("Customer ID:");
                JTextField custIdField = new JTextField();
                custIdField.setPreferredSize(new Dimension(150, 25)); // Set preferred size
                
                JLabel salesPriceLabel = new JLabel("Sales Price:");
                JTextField salesPriceField = new JTextField();
                salesPriceField.setPreferredSize(new Dimension(150, 25)); // Set preferred size

                JButton confirmButton = new JButton("Confirm");
                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Retrieve values from input fields
                        String carPlate = carPlateField.getText();
                        String custId = custIdField.getText();
                        String formattedDateTime = dateTimeField.getText();
                        
                        double salesPrice = 0.0;  // Default value

                        try {
                            salesPrice = Double.parseDouble(salesPriceField.getText());
                            
                            //////////////////////////////////////////////
                            //    validate got this cust or not first
                            // Validate if the customer exists
                            CustIO foundCustomer = CustIO.searchCustById(custId);
                            if (foundCustomer == null) {
                                System.out.println("No such customer");
                                JOptionPane.showMessageDialog(addNewSalesDialog, "No such customer", "Error", JOptionPane.ERROR_MESSAGE);
                                
                            } else {
                                                                
                                ///////////////////////////////////////////////
                                //    validate got this car or not first
                                //    and then validate status is 1 or not
                                String message = VehicleIO.soldVehicle(carPlate, salesPrice);
                                System.out.println(message);

                                if(message.equals("Success")){
                                    // Show success dialog
                                    JOptionPane.showMessageDialog(addNewSalesDialog, "Sale successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
                                    
                                    // Call the method to add new sales entry
                                    // addNewSales(String carPlate, String custId, String employeeId, String formattedDateTime)
                                    SalesIO.addNewSales(carPlate, custId, employeeId, formattedDateTime);
                                } else if(message.equals("Sold.")){
                                    System.out.println("Sold");
                                    JOptionPane.showMessageDialog(addNewSalesDialog, "Vehicle is already sold", "Information", JOptionPane.INFORMATION_MESSAGE);
                                } else if(message.equals("No such vehicle")){
                                    System.out.println("No such vehicle");
                                    JOptionPane.showMessageDialog(addNewSalesDialog, "No such vehicle", "Error", JOptionPane.ERROR_MESSAGE);
                                }else{
                                    System.out.println("Error occured");
                                    JOptionPane.showMessageDialog(addNewSalesDialog, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            
                        } catch (NumberFormatException ex) {
                            // Handle the case where the input is not a valid
                            ex.printStackTrace();  // Print the exception for debugging purposes
                            JOptionPane.showMessageDialog(addNewSalesDialog, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        
                        

                        // Close the add new sales interface
                        addNewSalesDialog.dispose();
                    }
                });

                // Create a JPanel with GridBagLayout for the add new sales interface
                JPanel addNewSalesPanel = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.WEST; // Align components to the left
                gbc.insets = new Insets(5, 5, 5, 5); // Add some spacing

                gbc.gridx = 0;
                gbc.gridy = 0;
                addNewSalesPanel.add(salesIdLabel, gbc);

                gbc.gridx = 1;
                gbc.gridy = 0;
                addNewSalesPanel.add(salesIdField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 1;
                addNewSalesPanel.add(dateTimeLabel, gbc);

                gbc.gridx = 1;
                gbc.gridy = 1;
                addNewSalesPanel.add(dateTimeField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 2;
                addNewSalesPanel.add(employeeIdLabel, gbc);

                gbc.gridx = 1;
                gbc.gridy = 2;
                addNewSalesPanel.add(employeeIdField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                addNewSalesPanel.add(carPlateLabel, gbc);

                gbc.gridx = 1;
                gbc.gridy = 3;
                addNewSalesPanel.add(carPlateField, gbc);
                
                gbc.gridx = 0;
                gbc.gridy = 4;
                addNewSalesPanel.add(salesPriceLabel, gbc);

                gbc.gridx = 1;
                gbc.gridy = 4;
                addNewSalesPanel.add(salesPriceField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 5;
                addNewSalesPanel.add(custIdLabel, gbc);

                gbc.gridx = 1;
                gbc.gridy = 5;
                addNewSalesPanel.add(custIdField, gbc);

                gbc.gridx = 1;
                gbc.gridy = 6;
                addNewSalesPanel.add(confirmButton, gbc);

                // Add the panel to the dialog and make it visible
                addNewSalesDialog.add(addNewSalesPanel);
                addNewSalesDialog.setVisible(true);
            }
        });
        
        JButton importDataButton = new JButton("Import Data");
        importDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog importDataDialog = new JDialog();
                importDataDialog.setTitle("Add New Sales");
                importDataDialog.setSize(500, 300);
                importDataDialog.setModal(true);
                importDataDialog.setLocationRelativeTo(null);                     

                String outputFilePath = "src/data/sales.csv"; 
                StreamReaderHandler sh = new StreamReaderHandler();
                sh.copySelectedCsvFile(outputFilePath);
            }
        });
        
        salesSearchPanel.add(salesSearchLabel, BorderLayout.WEST);
        salesSearchPanel.add(salesSearchField, BorderLayout.CENTER);
        salesSearchPanel.add(salesButton, BorderLayout.EAST);

        salesFilterPanel.add(priceAboveField, BorderLayout.NORTH);
        salesFilterPanel.add(salesPriceFilterButton, BorderLayout.SOUTH);

//        contentPanel.add(createPanel("Filter Sales", salesFilterPanel),BorderLayout.WEST);

        salesPanel = new JPanel();
        salesPanel.setLayout(new BorderLayout());

        

        buttonPanel = new JPanel();
        buttonPanel.add(addNewSalesButton,  BorderLayout.NORTH);
        buttonPanel.add(importDataButton, BorderLayout.SOUTH);     
        
        salesSearchPanel.add(buttonPanel, BorderLayout.SOUTH);

//System.out.println("salesPanel size: " + salesPanel.getSize());
//System.out.println("buttonPanel size: " + buttonPanel.getSize());
//
//        if (buttonPanel.isVisible()) {
//            System.out.println("button panel visible.");
//        } else {
//            System.out.println("not visible.");
//        }

    }
    
    private void vehicle(){
        // Vehicle
        vehiclePanel = new JPanel();
        vehiclePanel.setLayout(new BorderLayout());

        JTextField vehicleSearchField = new JTextField(""); // Declare the search field
        vehicleSearchField.setPreferredSize(new Dimension(200, 30)); // Set preferred size

        JLabel vehicleSearchLabel = new JLabel("Search:"); // Create a label for the search field

        // Add the label and search field to the panel
        //vehiclePanel.add(vehicleSearchLabel, BorderLayout.WEST);
        //vehiclePanel.add(vehicleSearchField, BorderLayout.CENTER);

        JButton vehicleButton = new JButton("Search");
        vehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the input from the search field
                String searchInput = vehicleSearchField.getText();
                
                // fetching vehicle information
                List<VehicleIO> vehicles = VehicleIO.getVehicleInput();

                // Create a StringBuilder to accumulate sales information
                StringBuilder vehicleInfo = new StringBuilder();
                
                // add dummy value at the start
                // dk why the first line always cannot be printed, so this is the way lol 
                vehicleInfo.append("-,-,-,-,-\n");
                
                String[] columnNames = {"Car Plate", "Car Model", "Acquire Price", "Car Status", "Sales Price"};

                if (searchInput == null || searchInput.isEmpty()) {
                    // Display all items
                    for (VehicleIO vehicle : vehicles) {
                        // Add logic to process each vehicle item
                        vehicleInfo.append(vehicle.toString()).append("\n");
                    }
                } else {
                    // Search for specific items based on searchInput
                    for (VehicleIO vehicle : vehicles) {
                        // Add logic to process matching items
                         if (vehicle.getCarPlate().contains(searchInput)) {
                            vehicleInfo.append(vehicle.toString()).append("\n");
                         }
                         else if (vehicle.getCarModel().contains(searchInput)) {
                            vehicleInfo.append(vehicle.toString()).append("\n");
                         }
                         else if ((vehicle.getAcquirePrice()+"").contains(searchInput)) {
                            vehicleInfo.append(vehicle.toString()).append("\n");
                         }
                         else if ((vehicle.getCarStatus()+"").contains(searchInput)) {
                            vehicleInfo.append(vehicle.toString()).append("\n");
                         }
                         else if ((vehicle.getSalesPrice()+"").contains(searchInput)) {
                            vehicleInfo.append(vehicle.toString()).append("\n");
                         }
                    }
                                        
                }
                
                // to handle the case where nothing show in the table
                if(vehicleInfo.toString().equals(""))
                    vehicleInfo.append("-,-,-,-,-\n");

                // Show the accumulated sales information in a single pane
                showInfoInterface("Vehicles Info", vehicleInfo.toString(), columnNames);
                
            }
        });
          
        JButton addNewVehicleButton = new JButton("Add New Vehicle");
        addNewVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a JDialog for the add new sales interface
                JDialog addNewVehicleDialog = new JDialog();
                addNewVehicleDialog.setTitle("Add New Vehicle");
                addNewVehicleDialog.setSize(500, 300);
                addNewVehicleDialog.setModal(true);
                addNewVehicleDialog.setLocationRelativeTo(null); // Center the dialog on the screen

                // Create components for the interface (JLabels, JTextFields, JButton)

                JLabel carPlateLabel = new JLabel("Car Plate:");
                JTextField carPlateField = new JTextField();
                carPlateField.setPreferredSize(new Dimension(150, 25)); // Set preferred size
                
                JLabel carModelLabel = new JLabel("Car Model:");
                JTextField carModelField = new JTextField();
                carModelField.setPreferredSize(new Dimension(150, 25)); // Set preferred size

                JLabel acquirePriceLabel = new JLabel("Acquire Price:");
                JTextField acquirePriceField = new JTextField();
                acquirePriceField.setPreferredSize(new Dimension(150, 25)); // Set preferred size
                
                JLabel carStatusLabel = new JLabel("Car Status:");
                JTextField carStatusField = new JTextField(VehicleIO.getStatusSet());
                carStatusField.setEditable(false);
                carStatusField.setPreferredSize(new Dimension(150, 25)); // Set preferred size
                
//                JLabel salesPriceLabel = new JLabel("Sales Price:");
//                JTextField salesPriceField = new JTextField();
//                salesPriceField.setEditable(false);
//                salesPriceField.setPreferredSize(new Dimension(150, 25)); // Set preferred size

                JButton confirmButton = new JButton("Confirm");
                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Retrieve values from input fields
                        String carPlate = carPlateField.getText();
                        String carModel = carModelField.getText();
                        double acquirePrice = Double.parseDouble(acquirePriceField.getText());
                        
                        int carStatus = 1;

                        double salesPrice = 0.0;  // Default value

                        VehicleIO carPlateExist = VehicleIO.searchByVehicleCarPlate(carPlate); 
                        
                        if(carPlateExist != null) {
                            System.out.println("Car plate been taken.");
                            JOptionPane.showMessageDialog(addNewVehicleDialog, "Cannot register the car plate", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(addNewVehicleDialog, "Vehicle successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
                            // Call the method to add new vehicle entry
                            // addNewVehicle(String carPlate,String carModel,double acquirePrice,int carStatus,double salesPrice)
                            VehicleIO.addNewVehicle(carPlate, carModel, acquirePrice, carStatus, salesPrice);
                        }

                        // Close the add new vehicle interface
                        addNewVehicleDialog.dispose();
                    }
                });

                // Create a JPanel with GridBagLayout for the add new vehicles interface
                JPanel addNewVehiclePanel = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.WEST; // Align components to the left
                gbc.insets = new Insets(5, 5, 5, 5); // Add some spacing

                // Add carPlateLabel and carPlateField
                gbc.gridx = 0;
                gbc.gridy = 0;
                addNewVehiclePanel.add(carPlateLabel, gbc);
                gbc.gridx = 1;
                addNewVehiclePanel.add(carPlateField, gbc);

                // Add carModelLabel and carModelField
                gbc.gridx = 0;
                gbc.gridy = 1;
                addNewVehiclePanel.add(carModelLabel, gbc);
                gbc.gridx = 1;
                addNewVehiclePanel.add(carModelField, gbc);

                // Add acquirePriceLabel and acquirePriceField
                gbc.gridx = 0;
                gbc.gridy = 2;
                addNewVehiclePanel.add(acquirePriceLabel, gbc);
                gbc.gridx = 1;
                addNewVehiclePanel.add(acquirePriceField, gbc);

                // Add carStatusLabel and carStatusField
                gbc.gridx = 0;
                gbc.gridy = 3; 
                addNewVehiclePanel.add(carStatusLabel, gbc);
                gbc.gridx = 1;
                addNewVehiclePanel.add(carStatusField, gbc);

//                // Add salesPriceLabel and salesPriceField
//                gbc.gridx = 0;
//                gbc.gridy = 4; 
//                addNewVehiclePanel.add(salesPriceLabel, gbc);
//                gbc.gridx = 1;
//                addNewVehiclePanel.add(salesPriceField, gbc);

                // Add confirmButton
                gbc.gridx = 1;
                gbc.gridy = 4; 
                gbc.gridwidth = 1; 
                addNewVehiclePanel.add(confirmButton, gbc);


                // Add the panel to the dialog and make it visible
                addNewVehicleDialog.add(addNewVehiclePanel);
                addNewVehicleDialog.setVisible(true);
            }
        });
        //vehiclePanel.add(addNewVehicleButton, BorderLayout.NORTH);
        
                     
        JButton importDataButton = new JButton("Import Data");
        importDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog importDataDialog = new JDialog();
                importDataDialog.setTitle("Add New Vehicle");
                importDataDialog.setSize(500, 300);
                importDataDialog.setModal(true);
                importDataDialog.setLocationRelativeTo(null);                     

                String outputFilePath = "src/data/vehicle.csv";
                StreamReaderHandler sh = new StreamReaderHandler();
                sh.copySelectedCsvFile(outputFilePath);
            }
        });
        //vehiclePanel.add(vehicleButton, BorderLayout.EAST);
        // Create a separate panel for search
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(vehicleSearchLabel, BorderLayout.WEST);
        searchPanel.add(vehicleSearchField, BorderLayout.CENTER);
        searchPanel.add(vehicleButton, BorderLayout.EAST);
    
        // Add search panel to the north position of vehicle panel
        vehiclePanel.add(searchPanel, BorderLayout.NORTH);
        
        contentPanel.add(createPanel("Vehicle", vehiclePanel));
        
        // Create a separate panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addNewVehicleButton);
        buttonPanel.add(importDataButton);     
        
        // Add button panel below the search panel
        vehiclePanel.add(buttonPanel, BorderLayout.CENTER);
    }
    private void employee(){
        // Customer
        employeePanel = new JPanel();
        employeePanel.setLayout(new BorderLayout());

        JTextField employeeSearchField = new JTextField(""); // Declare the search field
        employeeSearchField.setPreferredSize(new Dimension(200,30)); // Set preferred size
        
        JLabel employeeSearchLabel = new JLabel("Search:"); // Create a label for the search field

        // Add the label and search field to the panel
        employeePanel.add(employeeSearchLabel, BorderLayout.WEST);
        employeePanel.add(employeeSearchField, BorderLayout.CENTER);

        JButton employeeButton = new JButton("Search");
        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the input from the search field
                String searchInput = employeeSearchField.getText();
                
                // fetching employee information 
                List<EmployeeIO> emp = EmployeeIO.getEmployeeInputwithoutpw();
                
                // Create a string builder to accumulate the employee information
                StringBuilder employeeInfo = new StringBuilder();
                
                employeeInfo.append("-,-,-\n");
                String[] columnNames = {"Employee ID", "Employee Name", "Employee Status"," "};
                
                if (searchInput == null || searchInput.isEmpty()) {
                    // Display all items
                    for (EmployeeIO emps : emp) {
                        // Add logic to process each sale item
                        employeeInfo.append(emps.toString()).append("\n");
                    }
                } else {
                    // Search for specific items based on searchInput
                    for (EmployeeIO emps : emp) {
                        // Add logic to process matching items
                         if (emps.getEmployeeId().contains(searchInput)) {
                            employeeInfo.append(emps.toString()).append("\n");
                         }
                         else if (emps.getEmployeeName().contains(searchInput)) {
                            employeeInfo.append(emps.toString()).append("\n");
                         }
                         else if ((emps.getEmployeeStatus()+"").contains(searchInput)) {
                            employeeInfo.append(emps.toString()).append("\n");
                         }
                    }
                }
                
                // to handle the case where nothing show in the table
                if(employeeInfo.toString().equals(""))
                    employeeInfo.append("-,-,-\n");

                // Show the accumulated sales information in a single pane
                showInfoInterfaceEmp("Employee Info", employeeInfo.toString(), columnNames);
            }
        });
        employeePanel.add(employeeButton, BorderLayout.EAST);
        contentPanel.add(createPanel("Employee", employeePanel));
        
        JButton importDataButton = new JButton("Import Data");
        importDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog importDataDialog = new JDialog();
                importDataDialog.setTitle("Add New Employee");
                importDataDialog.setSize(500, 300);
                importDataDialog.setModal(true);
                importDataDialog.setLocationRelativeTo(null);                     

                String outputFilePath = "src/data/employee.csv";
                StreamReaderHandler sh = new StreamReaderHandler();
                sh.copySelectedCsvFile(outputFilePath);
            }
        });
        
        employeePanel.add(importDataButton, BorderLayout.SOUTH);
    }

    private void initDynamicContent() {
        contentPanel = new JPanel();
        getContentPane().add(contentPanel);
        
        home();
        customer();
        sales();
        vehicle();    
        employee();

        // Set default content to Home
        showContentForMenu("Home");
    }

    private JPanel createPanel(String title, JPanel panel) {
        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setLayout(new BorderLayout());
        wrapperPanel.setBorder(BorderFactory.createTitledBorder(title));
        wrapperPanel.add(panel, BorderLayout.CENTER);
        return wrapperPanel;
    }

    private void showInfoInterface(String infoTitle, String infoContent, String[] columnNames) {
        JFrame infoFrame = new JFrame(infoTitle);
        JPanel infoPanel = new JPanel();

        // Create a JTable to display sales information
        String[][] rawData = parseRawInfo(infoContent);
        JTable table = new JTable(rawData, columnNames);

        // Create a JScrollPane for the JTable
        JScrollPane scrollPane = new JScrollPane(table);

        // Add components for info display
        infoPanel.add(scrollPane);
        infoFrame.getContentPane().add(infoPanel);
        infoFrame.setSize(700, 500);
        infoFrame.setLocationRelativeTo(null);
        infoFrame.setVisible(true);
    }
    
    private void showInfoInterfaceEmp(String infoTitle, String infoContent, String[] columnNames) {
        JFrame infoFrame = new JFrame(infoTitle);
    JPanel infoPanel = new JPanel(new BorderLayout());

    String[][] rawData = parseRawInfo(infoContent);
    DefaultTableModel model = new DefaultTableModel(rawData, columnNames);

    JTable table = new JTable(model);

    // Adding a button to each row
    TableColumn column = table.getColumnModel().getColumn(columnNames.length - 1);
    ButtonEditor buttonEditor = new ButtonEditor(new JCheckBox(), table, infoFrame); // Pass the infoFrame reference
    column.setCellRenderer(new ButtonRenderer());
    column.setCellEditor(buttonEditor);

    JScrollPane scrollPane = new JScrollPane(table);
    infoPanel.add(scrollPane, BorderLayout.CENTER);

    infoFrame.getContentPane().add(infoPanel);
    infoFrame.setSize(800, 500);
    infoFrame.setLocationRelativeTo(null);
    infoFrame.setVisible(true);
}

class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
        setText("View Details");
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private JTable table; // Store a reference to the table
    private JFrame employeeDetailsFrame; // Declare the frames at the class level
    private JFrame newManagePanelFrame;
    private JFrame NewManagePanelFrame;
    private JFrame infoFrame;

    public ButtonEditor(JCheckBox checkBox, JTable table, JFrame infoFrame) {
        super(checkBox);
        this.table = table; // Store the reference to the table
        this.infoFrame = infoFrame; // Store the reference to the infoFrame
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.convertRowIndexToModel(table.getEditingRow());
                    if (selectedRow != -1) {
                        Object employeeId = table.getValueAt(selectedRow, 0); // employee ID is in column 1
                        Object employeeName = table.getValueAt(selectedRow, 1); // employee name is in column 2
                        Object employeeStatus = table.getValueAt(selectedRow,2);// employee status is in column 3

                JFrame employeeDetailsFrame = new JFrame("Employee Details");
                JPanel employeeDetailsPanel = new JPanel(new GridBagLayout());

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.NORTH; // Aligns components at the top
                gbc.insets = new Insets(10, 10, 5, 10); // Adjust insets for spacing

                JLabel titleLabel = new JLabel("Employee Details", SwingConstants.CENTER);
                Font titleFont = titleLabel.getFont();
                titleLabel.setFont(titleFont.deriveFont(titleFont.getStyle() | Font.BOLD)); // Making the title bold

                JLabel employeeIdLabel = new JLabel("ID        : ");
                JLabel employeeNameLabel = new JLabel("Name  : ");
                JLabel employeeSalaryLabel = new JLabel("Salary : ");
                JLabel employeeBonusLabel = new JLabel("Bonus  : ");

                double salary = ManageEmployee.getEmployeeSalary(employeeId.toString(), Integer.parseInt(employeeStatus.toString()));
                double bonus = ManageEmployee.getEmployeeBonus(employeeId.toString(), Integer.parseInt(employeeStatus.toString()));

                JPanel infoPanel = new JPanel(new GridLayout(4, 1)); // Two rows, four columns for labels and values
                infoPanel.add(employeeIdLabel);
                infoPanel.add(new JLabel(employeeId.toString()));
                infoPanel.add(employeeNameLabel);
                infoPanel.add(new JLabel(employeeName.toString()));
                infoPanel.add(employeeSalaryLabel);
                infoPanel.add(new JLabel(String.valueOf(salary)));
                infoPanel.add(employeeBonusLabel);
                infoPanel.add(new JLabel(String.valueOf(bonus)));

                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                employeeDetailsPanel.add(titleLabel, gbc);

                gbc.gridy++;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.fill = GridBagConstraints.NONE;
                employeeDetailsPanel.add(infoPanel, gbc);

                // Add button for changing to admin if employee status is 0
                if (Integer.parseInt(employeeStatus.toString()) == 0) {
                    JButton changeToAdminButton = new JButton("Change to Admin");
                    changeToAdminButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            newManagePanelFrame = new JFrame("Add New Management Employee");
                            JPanel newManagePanel = new JPanel(new GridBagLayout()); // Using GridBagLayout

                            GridBagConstraints gbcNew = new GridBagConstraints();
                            newManagePanel.setLayout(new GridBagLayout());

                            // Secret key label and text field
                            JLabel secretKeyLabel = new JLabel("Secret key: ");
                            JTextField secretKeyField = new JTextField(20);

                            // Confirm button
                            JButton confirmButton = new JButton("Confirm");
                            confirmButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                            String secretKey = "abcde"; 

                            // Check if the entered secret key matches
                            if (secretKeyField.getText().equals(secretKey)) {
                            // Call the method to make the employee a management level
                            Object employeeId = table.getValueAt(selectedRow, 0); // employee ID is in column 1
                            Object employeeName = table.getValueAt(selectedRow, 1); // employee name is in column 2
                            ManageEmployee.newManageEmployee(employeeId.toString(), employeeName.toString());

                            String successMessage = "Successfully added " + employeeId + ", " + employeeName + " as a management employee.";
                            JOptionPane.showMessageDialog(null, successMessage, "Success", JOptionPane.INFORMATION_MESSAGE);

                            // Close frames and hide panels
                            if (infoFrame != null) {
                                infoFrame.dispose(); // Closes the infoFrame
                            }
                            if (employeeDetailsFrame != null) {
                                employeeDetailsFrame.dispose(); // Closes the Employee Details frame
                            }

                            if (newManagePanelFrame != null) {
                                newManagePanelFrame.dispose(); // Closes the Add New Management Employee frame
                            }
                            
                            if (NewManagePanelFrame != null) {
                                NewManagePanelFrame.dispose(); // Closes the Add New Management Employee frame
                            }

                            } else {
                                JOptionPane.showMessageDialog(null, "Incorrect secret key.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                            
                            // Set up grid bag constraints
                            gbcNew.gridx = 0;
                            gbcNew.gridy = 0;
                            gbcNew.insets = new Insets(10, 10, 5, 10);
                            gbcNew.anchor = GridBagConstraints.WEST;
                            newManagePanel.add(secretKeyLabel, gbcNew);

                            gbcNew.gridx++;
                            newManagePanel.add(secretKeyField, gbcNew);

                            gbcNew.gridx = 1;
                            gbcNew.gridy++;
                            gbcNew.anchor = GridBagConstraints.EAST;
                            gbcNew.fill = GridBagConstraints.NONE;
                            gbcNew.insets = new Insets(10, 0, 10, 10);
                            newManagePanel.add(confirmButton, gbcNew);

                            NewManagePanelFrame = new JFrame("Add New Management Employee");
                            NewManagePanelFrame.getContentPane().add(newManagePanel);
                            NewManagePanelFrame.setSize(400, 200);
                            NewManagePanelFrame.setLocationRelativeTo(null);
                            NewManagePanelFrame.setVisible(true);
                            // Add the panel to the dialog and make it visible
                        }
                    });

                    gbc.gridy++;
                    gbc.insets = new Insets(10, 0, 10, 0); // Adjust insets for spacing
                    gbc.anchor = GridBagConstraints.CENTER; // Align button to the center
                    gbc.fill = GridBagConstraints.HORIZONTAL; // Allow the button to expand horizontally
                    employeeDetailsPanel.add(changeToAdminButton, gbc);
                }


                    JPanel centerPanel = new JPanel(new GridBagLayout());
                    GridBagConstraints centerGbc = new GridBagConstraints();
                    centerGbc.gridx = 0;
                    centerGbc.gridy = 0;
                    centerPanel.add(employeeDetailsPanel, centerGbc);

                    employeeDetailsFrame.getContentPane().add(centerPanel);
                    employeeDetailsFrame.setSize(400, 200);
                    employeeDetailsFrame.setLocationRelativeTo(null);
                    employeeDetailsFrame.setVisible(true);
                }
                    if (infoFrame != null) {
                        infoFrame.dispose(); // Closes the infoFrame
                    }
                    
                    if (employeeDetailsFrame != null) {
                        employeeDetailsFrame.dispose(); // Closes the Employee Details frame
                    }

                    if (newManagePanelFrame != null) {
                        newManagePanelFrame.dispose(); // Closes the Add New Management Employee frame
                    }
                    
                    if (NewManagePanelFrame != null) {
                        newManagePanelFrame.dispose(); // Closes the Add New Management Employee frame
                    }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return button;
    }
}

    // Helper method to parse raw information into a 2D array for JTable
    private String[][] parseRawInfo(String salesInfo) {
        String[] rows = salesInfo.split("\n");
        String[][] rowData = new String[rows.length - 1][5]; // Assume 5 columns for sales info, adjust if needed

        for (int i = 1; i < rows.length; i++) {
            String[] columns = rows[i].split(",");
            System.arraycopy(columns, 0, rowData[i - 1], 0, columns.length);
        }

        return rowData;
    }


    private void showContentForMenu(String menuName) {
        // Customize the content based on the menu clicked
        contentPanel.removeAll(); // Clear existing content

        if (menuName.equals("Home")) {
            contentPanel.add(createPanel("Home", homePanel));
        } else if (menuName.equals("Customer")) {
            contentPanel.add(createPanel("Customer", customerPanel));
        } else if (menuName.equals("Sales")) {
            contentPanel.add(createPanel("Filter Sales", salesFilterPanel));
            contentPanel.add(createPanel("Sales", salesSearchPanel));
        } else if (menuName.equals("Vehicle")) {
            contentPanel.add(createPanel("Vehicle", vehiclePanel));
        } else if (menuName.equals("Employee")){
            contentPanel.add(createPanel("Employee", employeePanel));
        }

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sales Employee Interface");
        setSize(800, 600);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu homeMenu = new JMenu("Home");
        JMenu customerMenu = new JMenu("Customer");
        JMenu salesMenu = new JMenu("Sales");
        JMenu vehicleMenu = new JMenu("Vehicle");
        JMenu employeeMenu = new JMenu("Employee");

        JMenuItem homeMenuItem = new JMenuItem("Home");
        JMenuItem customerMenuItem = new JMenuItem("Customer");
        JMenuItem salesMenuItem = new JMenuItem("Sales");
        JMenuItem vehicleMenuItem = new JMenuItem("Vehicle");
        JMenuItem employeeMenuItem = new JMenuItem("Employee");

        homeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showContentForMenu("Home");
            }
        });

        customerMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showContentForMenu("Customer");
            }
        });

        salesMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showContentForMenu("Sales");
            }
        });

        vehicleMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showContentForMenu("Vehicle");
            }
        });
        
        employeeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showContentForMenu("Employee");
            }
        });

        homeMenu.add(homeMenuItem);
        customerMenu.add(customerMenuItem);
        salesMenu.add(salesMenuItem);
        vehicleMenu.add(vehicleMenuItem);
        employeeMenu.add(employeeMenuItem);

        menuBar.add(homeMenu);
        menuBar.add(customerMenu);
        menuBar.add(salesMenu);
        menuBar.add(vehicleMenu);
        menuBar.add(employeeMenu);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI_SalesEmployeeInterface("","").setVisible(true);
            }
        });
    }
}
