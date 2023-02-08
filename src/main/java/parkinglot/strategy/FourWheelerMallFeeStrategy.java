package parkinglot.strategy;

import parkinglot.component.ParkingTicket;

public class FourWheelerMallFeeStrategy implements ParkingFeeStrategy {
    @Override
    public double getFee(ParkingTicket parkingTicket, String exitDateTime) {
        return 20 * calculateHours(parkingTicket, exitDateTime);
    }
}
