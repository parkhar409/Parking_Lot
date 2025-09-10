import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main user interface for the Parking Lot Status Check application.
 * Provides a graphical interface for viewing and managing parking lot statuses
 * with interactive spot management and real-time updates.
 */
public class UserInterface extends JFrame {
    private ParkingLotManager lotManager;
    private NavigationBar navigationBar;
    private JPanel parkingLotPanel;
    private JScrollPane scrollPane;
    private Timer refreshTimer;

    /**
     * Constructs a new UserInterface with sample data and initializes all components.
     * Sets up the GUI, event handlers, and starts the auto-refresh timer.
     */
    public UserInterface() {
        this.lotManager = ExampleData.createSampleData();
        initializeComponents();
        setupEventHandlers();
        updateDisplay();
        startRefreshTimer();
    }

    /**
     * Initializes all GUI components and sets up the main window layout.
     * Creates the navigation bar, parking lot display area, and status bar.
     */
    private void initializeComponents() {
        setTitle("Parking Lot Status Check");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create navigation bar
        navigationBar = new NavigationBar();
        add(navigationBar, BorderLayout.NORTH);

        // Create parking lot display panel
        parkingLotPanel = new JPanel();
        parkingLotPanel.setLayout(new GridBagLayout());
        parkingLotPanel.setBackground(Color.WHITE);

        // Create scroll pane for the parking lot
        scrollPane = new JScrollPane(parkingLotPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);

        // Create status bar
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusBar.setBackground(GUIUtils.BACKGROUND_DARK);
        statusBar.setBorder(BorderFactory.createEmptyBorder(GUIUtils.STATUS_INSETS.top, GUIUtils.STATUS_INSETS.left, 
                                                           GUIUtils.STATUS_INSETS.bottom, GUIUtils.STATUS_INSETS.right));
        
        JLabel statusLabel = GUIUtils.createLabel("Click on parking spots to toggle their status", JLabel.LEFT, GUIUtils.FONT_PLAIN_12, Color.BLACK);
        statusBar.add(statusLabel);
        
        add(statusBar, BorderLayout.SOUTH);
    }

    /**
     * Sets up event handlers for user interactions.
     * Configures listeners for lot selection changes and refresh button clicks.
     */
    private void setupEventHandlers() {
        // Lot selector change handler
        navigationBar.setLotSelectorListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLotName = navigationBar.getSelectedLotName();
                if (selectedLotName != null) {
                    ParkingLot selectedLot = lotManager.getParkingLotByName(selectedLotName);
                    if (selectedLot != null) {
                        lotManager.setCurrentLot(selectedLot);
                        updateDisplay();
                    }
                }
            }
        });

        // Refresh button handler
        navigationBar.setRefreshButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDisplay();
            }
        });
    }

    /**
     * Updates the entire display to reflect the current parking lot's status.
     * Refreshes the navigation bar, recreates all parking spot panels, and adds the legend.
     */
    private void updateDisplay() {
        ParkingLot currentLot = lotManager.getCurrentLot();
        
        if (currentLot == null) {
            return;
        }

        // Update navigation bar
        navigationBar.updateParkingLot(currentLot);
        navigationBar.updateLotSelector(lotManager.getAllParkingLots());

        // Clear existing parking lot display
        parkingLotPanel.removeAll();

        // Create parking spot panels
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = GUIUtils.GRID_INSETS;

        for (int row = 0; row < currentLot.getRows(); row++) {
            for (int col = 0; col < currentLot.getCols(); col++) {
                ParkingSpot spot = currentLot.getSpot(row, col);
                ParkingSpotPanel spotPanel = new ParkingSpotPanel(spot, row, col, new SpotClickListener());
                
                gbc.gridx = col;
                gbc.gridy = row;
                parkingLotPanel.add(spotPanel, gbc);
            }
        }

        // Add legend
        gbc.gridx = 0;
        gbc.gridy = currentLot.getRows();
        gbc.gridwidth = currentLot.getCols();
        gbc.anchor = GridBagConstraints.CENTER;
        
        JPanel legendPanel = createLegendPanel();
        parkingLotPanel.add(legendPanel, gbc);

        // Refresh the display
        parkingLotPanel.revalidate();
        parkingLotPanel.repaint();
    }

    /**
     * Creates a legend panel that explains the color coding used for parking spots.
     * @return a JPanel containing the legend with color indicators and descriptions
     */
    private JPanel createLegendPanel() {
        JPanel legendPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        legendPanel.setBackground(Color.WHITE);
        legendPanel.setBorder(BorderFactory.createTitledBorder("Legend"));

        // Available spot legend
        JPanel availableLegend = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel availableColor = GUIUtils.createColorIndicator(GUIUtils.SPOT_AVAILABLE, GUIUtils.LEGEND_COLOR_SIZE);
        JLabel availableText = new JLabel("Available");
        availableLegend.add(availableColor);
        availableLegend.add(availableText);

        // Occupied spot legend
        JPanel occupiedLegend = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel occupiedColor = GUIUtils.createColorIndicator(GUIUtils.SPOT_OCCUPIED, GUIUtils.LEGEND_COLOR_SIZE);
        JLabel occupiedText = new JLabel("Occupied (shows duration)");
        occupiedLegend.add(occupiedColor);
        occupiedLegend.add(occupiedText);

        legendPanel.add(availableLegend);
        legendPanel.add(occupiedLegend);

        return legendPanel;
    }

    /**
     * Starts the auto-refresh timer that updates the display every 30 seconds.
     * This ensures that occupation times are kept current without manual refresh.
     */
    private void startRefreshTimer() {
        refreshTimer = new Timer(30000, new ActionListener() { // Refresh every 30 seconds
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDisplay();
            }
        });
        refreshTimer.start();
    }

    /**
     * Inner class that handles click events on parking spot panels.
     * Allows users to toggle spot occupation status by clicking on spots.
     */
    private class SpotClickListener implements ActionListener {
        /**
         * Handles spot click events to toggle occupation status.
         * If the spot is occupied, it will be vacated. If available, it will prompt
         * for a vehicle ID and occupy the spot.
         * @param e the action event containing the spot coordinates
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int[] coordinates = GUIUtils.parseCoordinates(e.getActionCommand());
            if (coordinates == null) {
                return;
            }
            
            int row = coordinates[0];
            int col = coordinates[1];
            
            ParkingLot currentLot = lotManager.getCurrentLot();
            if (currentLot != null) {
                ParkingSpot spot = currentLot.getSpot(row, col);
                if (spot != null) {
                    if (spot.isOccupied()) {
                        spot.vacate();
                    } else {
                        String vehicleId = JOptionPane.showInputDialog(
                            UserInterface.this, 
                            "Enter Vehicle ID:", 
                            "Occupy Spot", 
                            JOptionPane.QUESTION_MESSAGE
                        );
                        if (vehicleId != null && !vehicleId.trim().isEmpty()) {
                            spot.occupy(vehicleId.trim());
                        }
                    }
                    updateDisplay();
                }
            }
        }
    }

    /**
     * Main method to launch the Parking Lot Status Check application.
     * Creates and displays the main user interface on the Event Dispatch Thread.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Using default look and feel
                
                new UserInterface().setVisible(true);
            }
        });
    }
}
