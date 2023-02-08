package parkinglot.component;

import parkinglot.manager.ParkingSpotManager;
import parkinglot.manager.TicketManager;
import parkinglot.model.ParkingSpot;
import parkinglot.model.Vehicle;

import java.util.Optional;

public class EntranceGate {
    private static final String NO_SPACE_AVAILABLE = "No space available";
    private final ParkingSpotManager parkingSpotManager;
    private final TicketManager ticketManager;

    public EntranceGate(ParkingSpotManager parkingSpotManager, TicketManager ticketManager) {
        this.parkingSpotManager = parkingSpotManager;
        this.ticketManager = ticketManager;
    }

    public ParkingTicket park(Vehicle vehicle) {
        Optional<ParkingSpot> parkingSpot = parkingSpotManager.findAvailableParkingSpot(vehicle);
        if (parkingSpot.isPresent())
            return bookSpot(parkingSpot.get());
        else {
            throw new IllegalArgumentException(NO_SPACE_AVAILABLE);
        }
    }

    private ParkingTicket bookSpot(ParkingSpot parkingSpot) {
        parkingSpot.park();
        return ticketManager
                .getParkingTicket()
                .generateEntryTicket(parkingSpot.getId());
    }
}
