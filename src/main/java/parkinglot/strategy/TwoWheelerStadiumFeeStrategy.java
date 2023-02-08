package parkinglot.strategy;

import parkinglot.component.ParkingTicket;

public class TwoWheelerStadiumFeeStrategy implements ParkingFeeStrategy {
    @Override
    public double getFee(ParkingTicket parkingTicket, String exitDateTime) {
        double totalFee = 0.0;
        long hoursParked = calculateHours(parkingTicket, exitDateTime);

        if (hoursParked >= 0 && hoursParked <= 4) {
            totalFee = 30;
        } else if (hoursParked > 4 && hoursParked <= 12) {
            totalFee = 60;
        } else if (hoursParked > 12) {
            totalFee = 100 * (hoursParked - 12) + 90;
        }

        return totalFee;
    }
}
