package parkinglot.manager;

import parkinglot.model.Vehicle;
import parkinglot.model.ParkingSpot;

import java.util.List;
import java.util.Optional;

public class ParkingSpotManager {
    private final List<ParkingSpot> parkingSpots;

    public ParkingSpotManager(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public Optional<ParkingSpot> findAvailableParkingSpot(Vehicle vehicle) {
        return parkingSpots
                .stream()
                .filter(parkingSpot -> parkingSpot.getType() == vehicle && !parkingSpot.isOccupied())
                .findFirst();
    }

    public Optional<ParkingSpot> findParkingSpot(Vehicle vehicle, int spotId) {
        return parkingSpots
                .stream()
                .filter(parkingSpot -> parkingSpot.getType() == vehicle && parkingSpot.getId() == spotId)
                .findFirst();
    }
}
