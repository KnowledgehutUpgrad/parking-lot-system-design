package parkinglot;

import parkinglot.component.EntranceGate;
import parkinglot.component.ExitGate;
import parkinglot.manager.ParkingSpotManager;
import parkinglot.manager.TicketManager;
import parkinglot.model.FeeModel;
import parkinglot.model.ParkingSpot;
import parkinglot.model.Vehicle;
import parkinglot.util.LocalDateTimeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static parkinglot.model.Vehicle.*;

public class ParkingLotApplication {
    public int twoWheelerParkingSpotCount;
    public int fourWheelerParkingSpotCount;
    public int sixWheelerParkingSpotCount;

    private final EntranceGate entranceGate;
    private final ExitGate exitGate;

    public ParkingLotApplication(FeeModel feeModel,
                                 int twoWheelerParkingSpotCount,
                                 int fourWheelerParkingSpotCount,
                                 int sixWheelerParkingSpotCount) {
        this.twoWheelerParkingSpotCount = twoWheelerParkingSpotCount;
        this.fourWheelerParkingSpotCount = fourWheelerParkingSpotCount;
        this.sixWheelerParkingSpotCount = sixWheelerParkingSpotCount;

        LocalDateTimeUtil localDateTimeUtil = new LocalDateTimeUtil();
        TicketManager ticketManager = new TicketManager(localDateTimeUtil, new AtomicInteger(), feeModel);
        ParkingSpotManager parkingSpotManager = new ParkingSpotManager(getParkingSpots());
        entranceGate = new EntranceGate(parkingSpotManager, ticketManager);
        exitGate = new ExitGate(parkingSpotManager, ticketManager);
    }

    public void park(Vehicle vehicle) {
        try {
            entranceGate.park(vehicle);
            Thread.sleep(1000);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void unpark(Vehicle vehicle, int ticketNumber) {
        try {
            exitGate.exit(vehicle, ticketNumber);
            Thread.sleep(1000);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private List<ParkingSpot> getParkingSpots() {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        for (int spotId = 1; spotId <= twoWheelerParkingSpotCount; spotId++) {
            parkingSpots.add(new ParkingSpot(spotId, MOTORCYCLE));
        }
        for (int spotId = 1; spotId <= fourWheelerParkingSpotCount; spotId++) {
            parkingSpots.add(new ParkingSpot(spotId, CAR));
        }
        for (int spotId = 1; spotId <= sixWheelerParkingSpotCount; spotId++) {
            parkingSpots.add(new ParkingSpot(spotId, BUS));
        }
        return parkingSpots;
    }
}
