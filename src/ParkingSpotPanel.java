import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * A Swing component that represents a single parking spot in the GUI.
 * Displays the spot's status (available/occupied) with appropriate colors
 * and shows occupation duration for occupied spots.
 */
public class ParkingSpotPanel extends JPanel {
    private ParkingSpot spot;
    private JButton spotButton;
    private JLabel timeLabel;
    private int row;
    private int col;
    private ActionListener clickListener;

    /**
     * Constructs a new ParkingSpotPanel for the specified parking spot.
     * @param spot the ParkingSpot object this panel represents
     * @param row the row index of this spot in the parking lot grid
     * @param col the column index of this spot in the parking lot grid
     * @param clickListener the action listener to handle spot clicks
     */
    public ParkingSpotPanel(ParkingSpot spot, int row, int col, ActionListener clickListener) {
        this.spot = spot;
        this.row = row;
        this.col = col;
        this.clickListener = clickListener;
        
        initializeComponents();
        updateDisplay();
    }

    /**
     * Initializes the GUI components for this parking spot panel.
     * Creates a button for the spot and a label for displaying occupation time.
     */
    private void initializeComponents() {
        setLayout(new BorderLayout());
        setPreferredSize(GUIUtils.SPOT_PANEL_SIZE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        // Create spot button
        spotButton = new JButton();
        spotButton.setPreferredSize(GUIUtils.SPOT_BUTTON_SIZE);
        spotButton.setFont(GUIUtils.FONT_BOLD_10);
        spotButton.addActionListener(clickListener);
        spotButton.setActionCommand(row + "," + col);
        
        // Create time label
        timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setFont(GUIUtils.FONT_PLAIN_8);
        timeLabel.setPreferredSize(GUIUtils.SPOT_LABEL_SIZE);
        
        add(spotButton, BorderLayout.CENTER);
        add(timeLabel, BorderLayout.SOUTH);
    }

    /**
     * Updates the visual display of this parking spot based on its current status.
     * Sets appropriate colors and text for available (green) and occupied (red) spots.
     */
    public void updateDisplay() {
        if (spot.isOccupied()) {
            spotButton.setBackground(GUIUtils.SPOT_OCCUPIED);
            spotButton.setText("OCCUPIED");
            spotButton.setForeground(Color.WHITE);
            timeLabel.setText(spot.getFormattedOccupationTime());
            timeLabel.setForeground(Color.WHITE);
        } else {
            spotButton.setBackground(GUIUtils.SPOT_AVAILABLE);
            spotButton.setText("AVAILABLE");
            spotButton.setForeground(Color.BLACK);
            timeLabel.setText("Available");
            timeLabel.setForeground(Color.BLACK);
        }
        
        spotButton.setOpaque(true);
        spotButton.setBorderPainted(false);
    }

    /**
     * Updates the parking spot this panel represents and refreshes the display.
     * @param spot the new ParkingSpot object to represent
     */
    public void setSpot(ParkingSpot spot) {
        this.spot = spot;
        updateDisplay();
    }

    /**
     * Gets the parking spot this panel represents.
     * @return the ParkingSpot object
     */
    public ParkingSpot getSpot() {
        return spot;
    }

    /**
     * Gets the row index of this spot in the parking lot grid.
     * @return the row index
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column index of this spot in the parking lot grid.
     * @return the column index
     */
    public int getCol() {
        return col;
    }
}
