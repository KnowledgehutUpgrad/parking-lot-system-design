package parkinglot.component;

import parkinglot.model.Vehicle;
import parkinglot.manager.ParkingSpotManager;
import parkinglot.model.ParkingSpot;

import java.util.Optional;

public class EntranceGate {
    private static final String NO_SPACE_AVAILABLE = "No space available";
    private final ParkingSpotManager parkingSpotManager;
    private final ParkingTicket parkingTicket;

    public EntranceGate(ParkingTicket parkingTicket, ParkingSpotManager parkingSpotManager) {
        this.parkingTicket = parkingTicket;
        this.parkingSpotManager = parkingSpotManager;
    }

    public String findParkingSpace(Vehicle vehicle) {
        Optional<ParkingSpot> parkingSpot = parkingSpotManager.findAvailableParkingSpot(vehicle);
        if (parkingSpot.isPresent())
            return bookSpot(parkingSpot.get());
        else {
            return NO_SPACE_AVAILABLE;
        }
    }

    private String bookSpot(ParkingSpot parkingSpot) {
        parkingSpot.park();
        return parkingTicket.generateEntryTicket(parkingSpot.getId());
    }
}
