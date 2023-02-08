package parkinglot.component;

import org.junit.jupiter.api.Test;
import util.LocalDateTimeUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParkingTicketTest {
    @Test
    void shouldGenerateParkingTicket() {
        LocalDateTimeUtil localDateTimeUtil = mock(LocalDateTimeUtil.class);
        ParkingTicket parkingTicket = new ParkingTicket(localDateTimeUtil);
        when(localDateTimeUtil.getLocalDateTime()).thenReturn("06-Feb-2023 10:00:00");

        String ticket = parkingTicket.generateEntryTicket(1);
        String expectedTicket = "Parking Ticket:\n" +
                "Ticket Number: 1\n" +
                "Spot Number: 1\n" +
                "Entry Date-time: 06-Feb-2023 10:00:00";

        assertEquals(expectedTicket, ticket);
    }
}