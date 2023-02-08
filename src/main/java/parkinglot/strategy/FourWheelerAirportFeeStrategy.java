package parkinglot.strategy;

import parkinglot.component.ParkingTicket;

public class FourWheelerAirportFeeStrategy implements ParkingFeeStrategy {
    @Override
    public double getFee(ParkingTicket parkingTicket, String exitDateTime) {
        double totalFee = 0.0;
        long hoursParked = calculateHours(parkingTicket, exitDateTime);

        if (hoursParked >= 0 && hoursParked <= 12) {
            totalFee = 60;
        } else if (hoursParked > 12 && hoursParked <= 24) {
            totalFee = 80;
        } else if (hoursParked > 24) {
            totalFee = 100 * Math.ceil(hoursParked / 24.0);
        }

        return totalFee;
    }
}
