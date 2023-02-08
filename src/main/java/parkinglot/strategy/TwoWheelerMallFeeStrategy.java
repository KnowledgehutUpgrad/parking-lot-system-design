package parkinglot.strategy;

import parkinglot.component.ParkingTicket;

public class TwoWheelerMallFeeStrategy implements ParkingFeeStrategy {
    @Override
    public double getFee(ParkingTicket parkingTicket, String exitDateTime) {
        return 10 * calculateHours(parkingTicket, exitDateTime);
    }
}
