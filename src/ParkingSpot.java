import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Represents an individual parking spot in a parking lot.
 * Tracks occupation status, vehicle information, and duration of occupation.
 */
public class ParkingSpot {
    private boolean isOccupied;
    private LocalDateTime occupationStartTime;
    private String vehicleId;
    
    /**
     * Constructs a new ParkingSpot that is initially unoccupied.
     */
    public ParkingSpot() {
        this.isOccupied = false;
        this.occupationStartTime = null;
        this.vehicleId = null;
    }
    
    /**
     * Checks if this parking spot is currently occupied.
     * @return true if the spot is occupied, false otherwise
     */
    public boolean isOccupied() {
        return isOccupied;
    }
    
    /**
     * Occupies this parking spot with the given vehicle ID.
     * Sets the occupation start time to the current time.
     * @param vehicleId the unique identifier of the vehicle occupying this spot
     */
    public void occupy(String vehicleId) {
        this.isOccupied = true;
        this.occupationStartTime = LocalDateTime.now();
        this.vehicleId = vehicleId;
    }
    
    /**
     * Vacates this parking spot, making it available again.
     * Clears the occupation start time and vehicle ID.
     */
    public void vacate() {
        this.isOccupied = false;
        this.occupationStartTime = null;
        this.vehicleId = null;
    }
    
    /**
     * Calculates the duration this spot has been occupied.
     * @return Duration object representing how long the spot has been occupied,
     *         or Duration.ZERO if the spot is not occupied
     */
    public Duration getOccupationDuration() {
        if (!isOccupied || occupationStartTime == null) {
            return Duration.ZERO;
        }
        return Duration.between(occupationStartTime, LocalDateTime.now());
    }
    
    /**
     * Gets the vehicle ID of the vehicle currently occupying this spot.
     * @return the vehicle ID, or null if the spot is not occupied
     */
    public String getVehicleId() {
        return vehicleId;
    }
    
    /**
     * Returns a human-readable string representation of the occupation time.
     * @return "Available" if unoccupied, or formatted time string (e.g., "2h 30m", "45m") if occupied
     */
    public String getFormattedOccupationTime() {
        if (!isOccupied) {
            return "Available";
        }
        
        Duration duration = getOccupationDuration();
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        
        if (hours > 0) {
            return String.format("%dh %dm", hours, minutes);
        } else {
            return String.format("%dm", minutes);
        }
    }
}
