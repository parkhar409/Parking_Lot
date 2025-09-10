import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

/**
 * A navigation bar component that displays parking lot information and controls.
 * Shows the current lot name, available spots count, hourly rate, and provides
 * a dropdown to switch between different parking lots and a refresh button.
 */
public class NavigationBar extends JPanel {
    private JLabel lotNameLabel;
    private JLabel availableSpotsLabel;
    private JLabel hourlyRateLabel;
    private JComboBox<String> lotSelector;
    private JButton refreshButton;
    private ParkingLot currentLot;

    /**
     * Constructs a new NavigationBar with default styling and layout.
     */
    public NavigationBar() {
        initializeComponents();
        layoutComponents();
    }

    /**
     * Initializes all the GUI components for the navigation bar.
     * Sets up labels, combo box, and button with appropriate styling.
     */
    private void initializeComponents() {
        setPreferredSize(new Dimension(800, 60));
        setBackground(GUIUtils.BACKGROUND_LIGHT);
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(GUIUtils.BORDER_INSETS.top, GUIUtils.BORDER_INSETS.left, 
                                          GUIUtils.BORDER_INSETS.bottom, GUIUtils.BORDER_INSETS.right)
        ));

        // Lot name label
        lotNameLabel = GUIUtils.createLabel("Select a Parking Lot", JLabel.LEFT, GUIUtils.FONT_BOLD_16, GUIUtils.TEXT_DARK);

        // Available spots label
        availableSpotsLabel = GUIUtils.createLabel("", JLabel.CENTER, GUIUtils.FONT_PLAIN_12, GUIUtils.TEXT_MEDIUM);

        // Hourly rate label
        hourlyRateLabel = GUIUtils.createLabel("", JLabel.CENTER, GUIUtils.FONT_PLAIN_12, GUIUtils.TEXT_MEDIUM);

        // Lot selector combo box
        lotSelector = new JComboBox<>();
        lotSelector.setPreferredSize(GUIUtils.COMBO_BOX_SIZE);
        lotSelector.setFont(GUIUtils.FONT_PLAIN_12);

        // Refresh button
        refreshButton = GUIUtils.createButton("Refresh", GUIUtils.BUTTON_SIZE);
    }

    /**
     * Arranges the components in the navigation bar layout.
     * Places lot information on the left and controls on the right.
     */
    private void layoutComponents() {
        setLayout(new BorderLayout());

        // Left panel for lot name and stats
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        leftPanel.setBackground(GUIUtils.BACKGROUND_LIGHT);
        leftPanel.add(lotNameLabel);
        leftPanel.add(Box.createHorizontalStrut(20));
        leftPanel.add(availableSpotsLabel);
        leftPanel.add(Box.createHorizontalStrut(20));
        leftPanel.add(hourlyRateLabel);

        // Right panel for controls
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        rightPanel.setBackground(GUIUtils.BACKGROUND_LIGHT);
        rightPanel.add(new JLabel("Switch Lot:"));
        rightPanel.add(lotSelector);
        rightPanel.add(refreshButton);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }

    /**
     * Updates the navigation bar display with information from the specified parking lot.
     * @param lot the parking lot to display information for, or null to clear the display
     */
    public void updateParkingLot(ParkingLot lot) {
        this.currentLot = lot;
        if (lot != null) {
            lotNameLabel.setText(lot.getName());
            availableSpotsLabel.setText("Available: " + lot.getAvailableSpots() + "/" + lot.getTotalSpots());
            hourlyRateLabel.setText("Rate: $" + String.format("%.2f", lot.getHourlyRate()) + "/hour");
        } else {
            lotNameLabel.setText("No Parking Lot Selected");
            availableSpotsLabel.setText("");
            hourlyRateLabel.setText("");
        }
    }

    /**
     * Updates the lot selector dropdown with the list of available parking lots.
     * @param lots the list of parking lots to populate the dropdown with
     */
    public void updateLotSelector(List<ParkingLot> lots) {
        lotSelector.removeAllItems();
        for (ParkingLot lot : lots) {
            lotSelector.addItem(lot.getName());
        }
        
        if (currentLot != null) {
            lotSelector.setSelectedItem(currentLot.getName());
        }
    }

    /**
     * Sets the action listener for the lot selector dropdown.
     * @param listener the action listener to handle lot selection changes
     */
    public void setLotSelectorListener(ActionListener listener) {
        lotSelector.addActionListener(listener);
    }

    /**
     * Sets the action listener for the refresh button.
     * @param listener the action listener to handle refresh button clicks
     */
    public void setRefreshButtonListener(ActionListener listener) {
        refreshButton.addActionListener(listener);
    }

    /**
     * Gets the name of the currently selected parking lot from the dropdown.
     * @return the name of the selected lot, or null if no lot is selected
     */
    public String getSelectedLotName() {
        return (String) lotSelector.getSelectedItem();
    }

    /**
     * Gets the currently displayed parking lot.
     * @return the current parking lot, or null if no lot is displayed
     */
    public ParkingLot getCurrentLot() {
        return currentLot;
    }
}
