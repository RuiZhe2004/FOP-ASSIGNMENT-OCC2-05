package lecars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import lecars.SalesIO;
import lecars.VehicleIO;
import lecars.CustIO;

public class GUI_SalesEmployeeInterface extends JFrame {

    private JPanel contentPanel;
    private JPanel homePanel;
    private JPanel customerPanel;
    private JPanel salesPanel;
    private JPanel vehiclePanel;
    private String employeeId = "test";
    private String employeeName = "test";

    public GUI_SalesEmployeeInterface(String employeeId, String employeeName) {
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
                GUI_SalesEmployeeInterface.this.dispose();
                
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
        customerSearchField.setPreferredSize(new Dimension(200,30));
        
        JLabel customerSearchLabel = new JLabel("Search:"); // Create a label for the search field

        // Add the label and search field to the panel
        customerPanel.add(customerSearchLabel, BorderLayout.WEST);
        customerPanel.add(customerSearchField, BorderLayout.CENTER);

        JButton customerButton = new JButton("Search");
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the input from the search field
                String searchInput = customerSearchField.getText();
                
            }
        });

        customerPanel.add(customerButton, BorderLayout.EAST);
        contentPanel.add(createPanel("Customer", customerPanel));

    }
    
    private void sales(){
        // Sales
        salesPanel = new JPanel();
        salesPanel.setLayout(new BorderLayout());

        JTextField salesSearchField = new JTextField(""); // Declare the search field
        salesSearchField.setPreferredSize(new Dimension(200, 30)); // Set preferred size

        JLabel salesSearchLabel = new JLabel("Search:"); // Create a label for the search field

        // Add the label and search field to the panel
        salesPanel.add(salesSearchLabel, BorderLayout.WEST);
        salesPanel.add(salesSearchField, BorderLayout.CENTER);

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
                         if (sale.getSalesId().equals(searchInput)) {
                            salesInfo.append(sale.toString()).append("\n");
                         }
                         else if (sale.getCarPlate().equals(searchInput)) {
                            salesInfo.append(sale.toString()).append("\n");
                         }
                         else if (sale.getCustId().equals(searchInput)) {
                            salesInfo.append(sale.toString()).append("\n");
                         }
                         else if (sale.getEmployeeId().equals(searchInput)) {
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
        salesPanel.add(salesButton, BorderLayout.EAST);
        
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
        salesPanel.add(addNewSalesButton, BorderLayout.SOUTH);
        
        contentPanel.add(createPanel("Sales", salesPanel));

    }
    
    private void vehicle(){
        // Vehicle
        vehiclePanel = new JPanel();
        vehiclePanel.setLayout(new BorderLayout());

        JTextField vehicleSearchField = new JTextField(""); // Declare the search field
        vehicleSearchField.setPreferredSize(new Dimension(200, 30)); // Set preferred size

        JLabel vehicleSearchLabel = new JLabel("Search:"); // Create a label for the search field

        // Add the label and search field to the panel
        vehiclePanel.add(vehicleSearchLabel, BorderLayout.WEST);
        vehiclePanel.add(vehicleSearchField, BorderLayout.CENTER);

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
                         if (vehicle.getCarPlate().equals(searchInput)) {
                            vehicleInfo.append(vehicle.toString()).append("\n");
                         }
                         else if (vehicle.getCarModel().equals(searchInput)) {
                            vehicleInfo.append(vehicle.toString()).append("\n");
                         }
                         else if ((vehicle.getAcquirePrice()+"").equals(searchInput)) {
                            vehicleInfo.append(vehicle.toString()).append("\n");
                         }
                         else if ((vehicle.getCarStatus()+"").equals(searchInput)) {
                            vehicleInfo.append(vehicle.toString()).append("\n");
                         }
                         else if ((vehicle.getSalesPrice()+"").equals(searchInput)) {
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
        vehiclePanel.add(vehicleButton, BorderLayout.EAST);
        contentPanel.add(createPanel("Vehicle", vehiclePanel));
        
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
        vehiclePanel.add(addNewVehicleButton, BorderLayout.SOUTH);
    }

    private void initDynamicContent() {
        contentPanel = new JPanel();
        getContentPane().add(contentPanel);
        
        home();
        customer();
        sales();
        vehicle();    

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
            contentPanel.add(createPanel("Sales", salesPanel));
        } else if (menuName.equals("Vehicle")) {
            contentPanel.add(createPanel("Vehicle", vehiclePanel));
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

        JMenuItem homeMenuItem = new JMenuItem("Home");
        JMenuItem customerMenuItem = new JMenuItem("Customer");
        JMenuItem salesMenuItem = new JMenuItem("Sales");
        JMenuItem vehicleMenuItem = new JMenuItem("Vehicle");

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

        homeMenu.add(homeMenuItem);
        customerMenu.add(customerMenuItem);
        salesMenu.add(salesMenuItem);
        vehicleMenu.add(vehicleMenuItem);

        menuBar.add(homeMenu);
        menuBar.add(customerMenu);
        menuBar.add(salesMenu);
        menuBar.add(vehicleMenu);

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
