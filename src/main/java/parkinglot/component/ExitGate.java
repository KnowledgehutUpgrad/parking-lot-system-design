package parkinglot.component;

import parkinglot.model.Vehicle;
import parkinglot.manager.ParkingSpotManager;
import parkinglot.model.ParkingSpot;

import java.util.Optional;

public class ExitGate {
    public static final String INVALID_OPERATION = "Invalid Operation";
    private final ExitTicket exitTicket;
    private final ParkingSpotManager parkingSpotManager;

    public ExitGate(ExitTicket exitTicket, ParkingSpotManager parkingSpotManager) {
        this.exitTicket = exitTicket;
        this.parkingSpotManager = parkingSpotManager;
    }

    public String exit(Vehicle vehicle, ParkingTicket parkingTicket) {
        Optional<ParkingSpot> parkingSpot = parkingSpotManager.findParkingSpot(vehicle, parkingTicket.getSpotId());
        if (parkingSpot.isPresent())
            return vacateSpot(vehicle, parkingSpot.get(), parkingTicket);
        else {
            return INVALID_OPERATION;
        }
    }

    private String vacateSpot(Vehicle vehicle, ParkingSpot parkingSpot, ParkingTicket parkingTicket) {
        parkingSpot.vacate();
        return exitTicket.generateExitTicket(vehicle, parkingTicket);
    }
}

