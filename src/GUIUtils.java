import java.awt.*;
import javax.swing.*;

/**
 * Utility class containing common GUI constants and helper methods.
 * Reduces code duplication across GUI components.
 */
public class GUIUtils {
    
    // Common colors
    public static final Color BACKGROUND_LIGHT = new Color(240, 240, 240);
    public static final Color BACKGROUND_DARK = new Color(220, 220, 220);
    public static final Color TEXT_DARK = new Color(50, 50, 50);
    public static final Color TEXT_MEDIUM = new Color(70, 70, 70);
    public static final Color SPOT_AVAILABLE = Color.GREEN;
    public static final Color SPOT_OCCUPIED = Color.RED;
    
    // Common fonts
    public static final Font FONT_BOLD_16 = new Font("Arial", Font.BOLD, 16);
    public static final Font FONT_PLAIN_12 = new Font("Arial", Font.PLAIN, 12);
    public static final Font FONT_BOLD_10 = new Font("Arial", Font.BOLD, 10);
    public static final Font FONT_PLAIN_8 = new Font("Arial", Font.PLAIN, 8);
    
    // Common dimensions
    public static final Dimension SPOT_PANEL_SIZE = new Dimension(80, 80);
    public static final Dimension SPOT_BUTTON_SIZE = new Dimension(60, 40);
    public static final Dimension SPOT_LABEL_SIZE = new Dimension(60, 20);
    public static final Dimension COMBO_BOX_SIZE = new Dimension(200, 30);
    public static final Dimension BUTTON_SIZE = new Dimension(80, 30);
    public static final Dimension LEGEND_COLOR_SIZE = new Dimension(20, 20);
    
    // Common insets
    public static final Insets GRID_INSETS = new Insets(2, 2, 2, 2);
    public static final Insets BORDER_INSETS = new Insets(10, 10, 10, 10);
    public static final Insets STATUS_INSETS = new Insets(5, 10, 5, 10);
    
    /**
     * Creates a standardized label with common styling.
     * @param text the label text
     * @param alignment the text alignment
     * @param font the font to use
     * @param color the text color
     * @return a configured JLabel
     */
    public static JLabel createLabel(String text, int alignment, Font font, Color color) {
        JLabel label = new JLabel(text, alignment);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }
    
    /**
     * Creates a standardized button with common styling.
     * @param text the button text
     * @param size the preferred size
     * @return a configured JButton
     */
    public static JButton createButton(String text, Dimension size) {
        JButton button = new JButton(text);
        button.setPreferredSize(size);
        button.setFont(FONT_PLAIN_12);
        return button;
    }
    
    /**
     * Creates a color indicator label for legends.
     * @param color the background color
     * @param size the preferred size
     * @return a configured JLabel with color background
     */
    public static JLabel createColorIndicator(Color color, Dimension size) {
        JLabel indicator = new JLabel();
        indicator.setPreferredSize(size);
        indicator.setBackground(color);
        indicator.setOpaque(true);
        indicator.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return indicator;
    }
    
    /**
     * Parses coordinate string in format "row,col" to integer array.
     * @param coordinates the coordinate string
     * @return array containing [row, col] or null if invalid
     */
    public static int[] parseCoordinates(String coordinates) {
        try {
            String[] parts = coordinates.split(",");
            if (parts.length == 2) {
                return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
            }
        } catch (NumberFormatException e) {
            // Invalid format
        }
        return null;
    }
    
    /**
     * Checks if coordinates are valid for the given grid dimensions.
     * @param row the row index
     * @param col the column index
     * @param maxRows the maximum number of rows
     * @param maxCols the maximum number of columns
     * @return true if coordinates are valid
     */
    public static boolean isValidCoordinates(int row, int col, int maxRows, int maxCols) {
        return row >= 0 && row < maxRows && col >= 0 && col < maxCols;
    }
}
