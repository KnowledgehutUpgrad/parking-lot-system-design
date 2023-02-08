package parkinglot.component;

import util.LocalDateTimeUtil;

public class ParkingTicket extends Ticket {
    private String entryDateTime;
    private int spotId;

    public ParkingTicket(LocalDateTimeUtil localDateTimeUtil) {
        super(localDateTimeUtil);
    }

    public String generateEntryTicket(int spotId) {
        this.entryDateTime = localDateTimeUtil.getLocalDateTime();
        this.spotId = spotId;

        return "Parking Ticket:\n" +
                "Ticket Number: " + number.incrementAndGet() + "\n" +
                "Spot Number: " + spotId + "\n" +
                "Entry Date-time: " + entryDateTime;
    }

    public String getEntryDateTime() {
        return entryDateTime;
    }

    public int getSpotId() {
        return spotId;
    }
}
