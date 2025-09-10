/**
 * Provides sample data for the parking lot application.
 * Creates multiple parking lots with different configurations and pre-occupied spots
 * to demonstrate the application's functionality.
 */
public class ExampleData {
    
    /**
     * Creates a ParkingLotManager with sample parking lots and pre-occupied spots.
     * This method sets up four different parking lots with varying sizes, rates, and
     * some spots already occupied to simulate a realistic scenario.
     * 
     * @return a ParkingLotManager containing four sample parking lots:
     *         - Downtown Mall (4x6 grid, $3.50/hour)
     *         - Airport Terminal (3x8 grid, $5.00/hour) 
     *         - University Campus (5x5 grid, $2.00/hour)
     *         - City Hospital (3x7 grid, $4.25/hour)
     */
    public static ParkingLotManager createSampleData() {
        ParkingLotManager manager = new ParkingLotManager();
        
        // Create Downtown Mall Parking - 4 rows x 6 columns, $3.50/hour
        ParkingLot downtownMall = new ParkingLot("Downtown Mall", 3.50, 4, 6);
        // Occupy some spots with different vehicle IDs
        downtownMall.occupySpot(0, 0, "ABC123");
        downtownMall.occupySpot(0, 1, "XYZ789");
        downtownMall.occupySpot(1, 2, "DEF456");
        downtownMall.occupySpot(2, 3, "GHI789");
        downtownMall.occupySpot(3, 4, "JKL012");
        
        // Create Airport Terminal Parking - 3 rows x 8 columns, $5.00/hour
        ParkingLot airportTerminal = new ParkingLot("Airport Terminal", 5.00, 3, 8);
        airportTerminal.occupySpot(0, 0, "AIR001");
        airportTerminal.occupySpot(0, 1, "AIR002");
        airportTerminal.occupySpot(1, 3, "AIR003");
        airportTerminal.occupySpot(2, 5, "AIR004");
        airportTerminal.occupySpot(2, 6, "AIR005");
        
        // Create University Campus Parking - 5 rows x 5 columns, $2.00/hour
        ParkingLot universityCampus = new ParkingLot("University Campus", 2.00, 5, 5);
        universityCampus.occupySpot(0, 0, "STU001");
        universityCampus.occupySpot(1, 1, "STU002");
        universityCampus.occupySpot(2, 2, "STU003");
        universityCampus.occupySpot(3, 3, "STU004");
        universityCampus.occupySpot(4, 4, "STU005");
        universityCampus.occupySpot(0, 4, "STU006");
        universityCampus.occupySpot(4, 0, "STU007");
        
        // Create Hospital Parking - 3 rows x 7 columns, $4.25/hour
        ParkingLot hospitalParking = new ParkingLot("City Hospital", 4.25, 3, 7);
        hospitalParking.occupySpot(0, 0, "HOS001");
        hospitalParking.occupySpot(0, 1, "HOS002");
        hospitalParking.occupySpot(1, 2, "HOS003");
        hospitalParking.occupySpot(2, 4, "HOS004");
        hospitalParking.occupySpot(2, 5, "HOS005");
        hospitalParking.occupySpot(2, 6, "HOS006");
        
        // Add all lots to manager
        manager.addParkingLot(downtownMall);
        manager.addParkingLot(airportTerminal);
        manager.addParkingLot(universityCampus);
        manager.addParkingLot(hospitalParking);
        
        return manager;
    }
    
}
