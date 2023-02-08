package parkinglot.factory;

import parkinglot.component.ParkingTicket;
import parkinglot.util.LocalDateTimeUtil;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public interface ParkingFeeStrategy {
    default long calculateHours(ParkingTicket parkingTicket, String exitDateTime) {
        LocalDateTimeUtil localDateTimeUtil = parkingTicket.getLocalDateTimeUtil();
        LocalDateTime entryTime = localDateTimeUtil.parseToLocalDateTIme(parkingTicket.getEntryDateTime());
        LocalDateTime exitTime = localDateTimeUtil.parseToLocalDateTIme(exitDateTime);

        double totalSecondPerHour = 60.0 * 60.0;
        return (long) Math.ceil(ChronoUnit.SECONDS.between(entryTime, exitTime) / totalSecondPerHour);
    }
    double getFee(ParkingTicket parkingTicket, String exitDateTime);
}
