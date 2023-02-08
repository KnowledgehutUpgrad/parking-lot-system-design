package parkinglot.strategy;

import parkinglot.component.ParkingTicket;

public class SixWheelerMallFeeStrategy implements ParkingFeeStrategy {
    @Override
    public double getFee(ParkingTicket parkingTicket, String exitDateTime) {
        return 50 * calculateHours(parkingTicket, exitDateTime);
    }
}
