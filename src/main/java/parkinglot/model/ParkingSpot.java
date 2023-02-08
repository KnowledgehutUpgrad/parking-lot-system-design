package parkinglot.model;

public class ParkingSpot {
    private final int id;
    private boolean isOccupied;
    private final Vehicle type;

    public ParkingSpot(int id, Vehicle type) {
        this.id = id;
        this.type = type;
        isOccupied = false;
    }

    public int getId() {
        return id;
    }

    public Vehicle getType() {
        return type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void park() {
        isOccupied = true;
    }

    public void vacate() {
        isOccupied = false;
    }
}
