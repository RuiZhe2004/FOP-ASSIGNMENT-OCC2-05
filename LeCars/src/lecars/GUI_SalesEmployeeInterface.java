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

                // fetching sales information
                List<SalesIO> sales = SalesIO.getSalesInput();

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
        String[][] rowData = parseRawInfo(infoContent);
        JTable table = new JTable(rowData, columnNames);

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