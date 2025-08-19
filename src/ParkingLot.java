// 
public class ParkingLot {
    private ParkingSpot[][] spots;

    public ParkingLot(int rows, int cols) {
        spots = new ParkingSpot[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                spots[i][j] = new ParkingSpot();
            }
        }
    }

    public ParkingSpot getSpot(int row, int col) {
        return spots[row][col];
    }
}
