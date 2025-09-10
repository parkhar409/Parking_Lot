import java.util.ArrayList;
import java.util.List;

/**
 * Manages multiple parking lots and provides functionality to switch between them.
 * Maintains a collection of parking lots and tracks the currently selected lot.
 */
public class ParkingLotManager {
    private List<ParkingLot> parkingLots;
    private ParkingLot currentLot;

    /**
     * Constructs a new ParkingLotManager with an empty list of parking lots.
     * No current lot is set initially.
     */
    public ParkingLotManager() {
        this.parkingLots = new ArrayList<>();
        this.currentLot = null;
    }

    /**
     * Adds a parking lot to the manager's collection.
     * If no current lot is set, the newly added lot becomes the current lot.
     * @param lot the parking lot to add
     */
    public void addParkingLot(ParkingLot lot) {
        parkingLots.add(lot);
        if (currentLot == null) {
            currentLot = lot;
        }
    }

    /**
     * Returns a copy of all parking lots managed by this manager.
     * @return a new ArrayList containing all parking lots
     */
    public List<ParkingLot> getAllParkingLots() {
        return new ArrayList<>(parkingLots);
    }

    /**
     * Gets the currently selected parking lot.
     * @return the current parking lot, or null if no lot is selected
     */
    public ParkingLot getCurrentLot() {
        return currentLot;
    }

    /**
     * Sets the current parking lot to the specified lot.
     * The lot must be in the manager's collection to be set as current.
     * @param lot the parking lot to set as current
     * @return true if the lot was successfully set as current, false if the lot is not in the collection
     */
    public boolean setCurrentLot(ParkingLot lot) {
        if (parkingLots.contains(lot)) {
            this.currentLot = lot;
            return true;
        }
        return false;
    }

    /**
     * Sets the current parking lot by searching for a lot with the specified name.
     * @param name the name of the parking lot to set as current
     * @return true if a lot with the given name was found and set as current, false otherwise
     */
    public boolean setCurrentLotByName(String name) {
        ParkingLot lot = findParkingLotByName(name);
        if (lot != null) {
            this.currentLot = lot;
            return true;
        }
        return false;
    }

    /**
     * Searches for a parking lot with the specified name.
     * @param name the name of the parking lot to find
     * @return the parking lot with the given name, or null if not found
     */
    public ParkingLot getParkingLotByName(String name) {
        return findParkingLotByName(name);
    }
    
    /**
     * Private helper method to find a parking lot by name.
     * Consolidates the duplicate searching logic.
     * @param name the name of the parking lot to find
     * @return the parking lot with the given name, or null if not found
     */
    private ParkingLot findParkingLotByName(String name) {
        for (ParkingLot lot : parkingLots) {
            if (lot.getName().equals(name)) {
                return lot;
            }
        }
        return null;
    }
}
