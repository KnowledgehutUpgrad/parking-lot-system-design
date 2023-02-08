package parkinglot.strategy;

import parkinglot.component.ParkingTicket;

public class TwoWheelerAirportFeeStrategy implements ParkingFeeStrategy {
    @Override
    public double getFee(ParkingTicket parkingTicket, String exitDateTime) {
        double totalFee = 0.0;
        long hoursParked = calculateHours(parkingTicket, exitDateTime);

        if (hoursParked >= 0 && hoursParked <= 1) {
            totalFee = 0;
        } else if (hoursParked >= 1 && hoursParked <= 8) {
            totalFee = 40;
        } else if (hoursParked > 8 && hoursParked <= 24) {
            totalFee = 60;
        } else if (hoursParked > 24) {
            totalFee = 80 * Math.ceil(hoursParked / 24.0);
        }

        return totalFee;
    }
}
