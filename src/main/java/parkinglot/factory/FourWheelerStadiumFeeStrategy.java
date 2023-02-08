package parkinglot.factory;

import parkinglot.component.ParkingTicket;

public class FourWheelerStadiumFeeStrategy implements ParkingFeeStrategy {
    @Override
    public double getFee(ParkingTicket parkingTicket, String exitDateTime) {
        double totalFee = 0.0;
        long hoursParked = calculateHours(parkingTicket, exitDateTime);

        if (hoursParked >= 0 && hoursParked <= 4) {
            totalFee = 60;
        } else if (hoursParked > 4 && hoursParked <= 12) {
            totalFee = 120 + 60;
        } else if (hoursParked > 12) {
            totalFee = 200 * (hoursParked - 12) + 180;
        }

        return totalFee;
    }
}
