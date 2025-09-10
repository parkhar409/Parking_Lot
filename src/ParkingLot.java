
/**
 * Represents a parking lot with a grid of parking spots.
 * Manages spot availability, pricing, and provides methods for spot operations.
 */
public class ParkingLot {
    private String name;
    private double hourlyRate;
    private ParkingSpot[][] spots;
    private int rows;
    private int cols;

    /**
     * Constructs a new ParkingLot with the specified dimensions and pricing.
     * @param name the name of the parking lot
     * @param hourlyRate the cost per hour for parking
     * @param rows the number of rows in the parking lot grid
     * @param cols the number of columns in the parking lot grid
     */
    public ParkingLot(String name, double hourlyRate, int rows, int cols) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.rows = rows;
        this.cols = cols;
        this.spots = new ParkingSpot[rows][cols];
        
        // Initialize all spots as unoccupied
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                spots[i][j] = new ParkingSpot();
            }
        }
    }

    /**
     * Gets the name of this parking lot.
     * @return the parking lot name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the hourly rate for parking in this lot.
     * @return the cost per hour
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Gets the number of rows in the parking lot grid.
     * @return the number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * Gets the number of columns in the parking lot grid.
     * @return the number of columns
     */
    public int getCols() {
        return cols;
    }

    /**
     * Gets the parking spot at the specified coordinates.
     * @param row the row index (0-based)
     * @param col the column index (0-based)
     * @return the ParkingSpot at the given coordinates, or null if coordinates are invalid
     */
    public ParkingSpot getSpot(int row, int col) {
        if (isValidCoordinates(row, col)) {
            return spots[row][col];
        }
        return null;
    }
    
    /**
     * Checks if the given coordinates are valid for this parking lot.
     * @param row the row index
     * @param col the column index
     * @return true if coordinates are valid
     */
    private boolean isValidCoordinates(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    /**
     * Calculates the total number of parking spots in this lot.
     * @return the total number of spots (rows × columns)
     */
    public int getTotalSpots() {
        return rows * cols;
    }

    /**
     * Counts the number of currently available (unoccupied) parking spots.
     * @return the number of available spots
     */
    public int getAvailableSpots() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!spots[i][j].isOccupied()) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Calculates the number of currently occupied parking spots.
     * @return the number of occupied spots
     */
    public int getOccupiedSpots() {
        return getTotalSpots() - getAvailableSpots();
    }

    /**
     * Attempts to occupy a specific parking spot with the given vehicle ID.
     * @param row the row index of the spot to occupy
     * @param col the column index of the spot to occupy
     * @param vehicleId the unique identifier of the vehicle
     * @return true if the spot was successfully occupied, false if the spot is already occupied or coordinates are invalid
     */
    public boolean occupySpot(int row, int col, String vehicleId) {
        if (!isValidCoordinates(row, col)) {
            return false;
        }
        ParkingSpot spot = spots[row][col];
        if (!spot.isOccupied()) {
            spot.occupy(vehicleId);
            return true;
        }
        return false;
    }

    /**
     * Attempts to vacate a specific parking spot.
     * @param row the row index of the spot to vacate
     * @param col the column index of the spot to vacate
     * @return true if the spot was successfully vacated, false if the spot is not occupied or coordinates are invalid
     */
    public boolean vacateSpot(int row, int col) {
        if (!isValidCoordinates(row, col)) {
            return false;
        }
        ParkingSpot spot = spots[row][col];
        if (spot.isOccupied()) {
            spot.vacate();
            return true;
        }
        return false;
    }
}
