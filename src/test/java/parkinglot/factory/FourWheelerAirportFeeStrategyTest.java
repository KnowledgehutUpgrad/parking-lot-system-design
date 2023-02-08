package parkinglot.factory;

import org.junit.jupiter.api.Test;
import parkinglot.component.ParkingTicket;
import util.LocalDateTimeUtil;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FourWheelerAirportFeeStrategyTest {
    @Test
    void shouldReturnCorrectTotalFeeForParkedHoursBetween0To12() {
        FourWheelerAirportFeeStrategy fourWheelerAirportFeeStrategy = new FourWheelerAirportFeeStrategy();
        LocalDateTimeUtil localDateTimeUtil = mock(LocalDateTimeUtil.class);
        ParkingTicket parkingTicket  = new ParkingTicket(localDateTimeUtil);
        when(localDateTimeUtil.parseToLocalDateTIme(any()))
                .thenReturn(LocalDateTime.of(2023,2,6,1,0))
                .thenReturn(LocalDateTime.of(2023,2,6,13,59));

        double actualFee = fourWheelerAirportFeeStrategy.getFee(parkingTicket, "06-Feb-2023 10:00:00");

        assertEquals(80.0, actualFee);
    }

    @Test
    void shouldReturnCorrectTotalFeeForParkedHoursBetween1To8() {
        FourWheelerAirportFeeStrategy fourWheelerAirportFeeStrategy = new FourWheelerAirportFeeStrategy();
        LocalDateTimeUtil localDateTimeUtil = mock(LocalDateTimeUtil.class);
        ParkingTicket parkingTicket  = new ParkingTicket(localDateTimeUtil);
        when(localDateTimeUtil.parseToLocalDateTIme(any()))
                .thenReturn(LocalDateTime.of(2023,2,6,1,0))
                .thenReturn(LocalDateTime.of(2023,2,6,23,59));

        double actualFee = fourWheelerAirportFeeStrategy.getFee(parkingTicket, "06-Feb-2023 10:00:00");

        assertEquals(80.0, actualFee);
    }

    @Test
    void shouldReturnCorrectTotalFeeForParkedHoursMoreThan1Day() {
        FourWheelerAirportFeeStrategy fourWheelerAirportFeeStrategy = new FourWheelerAirportFeeStrategy();
        LocalDateTimeUtil localDateTimeUtil = mock(LocalDateTimeUtil.class);
        ParkingTicket parkingTicket  = new ParkingTicket(localDateTimeUtil);
        when(localDateTimeUtil.parseToLocalDateTIme(any()))
                .thenReturn(LocalDateTime.of(2023,2,6,1,0))
                .thenReturn(LocalDateTime.of(2023,2,7,1,1));

        double actualFee = fourWheelerAirportFeeStrategy.getFee(parkingTicket, "06-Feb-2023 10:00:00");

        assertEquals(200.0, actualFee);
    }
}