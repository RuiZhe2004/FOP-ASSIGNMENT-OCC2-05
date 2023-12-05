package lecars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lecars.GUI_Login;

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

    private void initDynamicContent() {
        contentPanel = new JPanel();
        getContentPane().add(contentPanel);

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
                
                showInfoInterface("Customer Info");
            }
        });

        customerPanel.add(customerButton, BorderLayout.EAST);
        contentPanel.add(createPanel("Customer", customerPanel));


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

                // Simulate fetching sales information based on searchInput
                if(searchInput.equals(null)){
                    
                }
                showInfoInterface("sales Info");
            }
        });

        salesPanel.add(salesButton, BorderLayout.EAST);
        contentPanel.add(createPanel("Sales", salesPanel));


        // Vehicle
        vehiclePanel = new JPanel();
        vehiclePanel.setLayout(new BorderLayout());
        vehiclePanel.add(new JTextField(""), BorderLayout.NORTH);
        JButton vehicleButton = new JButton("Search");
        vehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInfoInterface("Vehicle Info");
            }
        });
        vehiclePanel.add(vehicleButton, BorderLayout.CENTER);
        contentPanel.add(createPanel("Vehicle", vehiclePanel));

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

    private void showInfoInterface(String infoTitle) {
        JFrame infoFrame = new JFrame(infoTitle);
        JPanel infoPanel = new JPanel();
        // Add components for info display
        infoFrame.getContentPane().add(infoPanel);
        infoFrame.setSize(300, 200);
        infoFrame.setLocationRelativeTo(null);
        infoFrame.setVisible(true);
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
