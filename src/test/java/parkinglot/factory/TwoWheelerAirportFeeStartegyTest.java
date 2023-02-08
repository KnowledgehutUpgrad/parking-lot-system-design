package parkinglot.factory;

import org.junit.jupiter.api.Test;
import parkinglot.component.ParkingTicket;
import util.LocalDateTimeUtil;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TwoWheelerAirportFeeStartegyTest {
    @Test
    void shouldReturnCorrectTotalFeeForParkedHoursBetween0To1() {
        TwoWheelerAirportFeeStartegy twoWheelerAirportFeeStartegy = new TwoWheelerAirportFeeStartegy();
        LocalDateTimeUtil localDateTimeUtil = mock(LocalDateTimeUtil.class);
        ParkingTicket parkingTicket  = new ParkingTicket(localDateTimeUtil);
        when(localDateTimeUtil.parseToLocalDateTIme(any()))
                .thenReturn(LocalDateTime.of(2023,2,6,1,0))
                .thenReturn(LocalDateTime.of(2023,2,6,1,59));

        double actualFee = twoWheelerAirportFeeStartegy.getFee(parkingTicket, "06-Feb-2023 10:00:00");

        assertEquals(0.0, actualFee);
    }

    @Test
    void shouldReturnCorrectTotalFeeForParkedHoursBetween1To8() {
        TwoWheelerAirportFeeStartegy twoWheelerAirportFeeStartegy = new TwoWheelerAirportFeeStartegy();
        LocalDateTimeUtil localDateTimeUtil = mock(LocalDateTimeUtil.class);
        ParkingTicket parkingTicket  = new ParkingTicket(localDateTimeUtil);
        when(localDateTimeUtil.parseToLocalDateTIme(any()))
                .thenReturn(LocalDateTime.of(2023,2,6,1,0))
                .thenReturn(LocalDateTime.of(2023,2,6,8,59));

        double actualFee = twoWheelerAirportFeeStartegy.getFee(parkingTicket, "06-Feb-2023 10:00:00");

        assertEquals(40.0, actualFee);
    }

    @Test
    void shouldReturnCorrectTotalFeeForParkedHoursBetween8To24() {
        TwoWheelerAirportFeeStartegy twoWheelerAirportFeeStartegy = new TwoWheelerAirportFeeStartegy();
        LocalDateTimeUtil localDateTimeUtil = mock(LocalDateTimeUtil.class);
        ParkingTicket parkingTicket  = new ParkingTicket(localDateTimeUtil);
        when(localDateTimeUtil.parseToLocalDateTIme(any()))
                .thenReturn(LocalDateTime.of(2023,2,6,1,0))
                .thenReturn(LocalDateTime.of(2023,2,6,23,59));

        double actualFee = twoWheelerAirportFeeStartegy.getFee(parkingTicket, "06-Feb-2023 10:00:00");

        assertEquals(60.0, actualFee);
    }

    @Test
    void shouldReturnCorrectTotalFeeForParkedHoursMoreThan1Day() {
        TwoWheelerAirportFeeStartegy twoWheelerAirportFeeStartegy = new TwoWheelerAirportFeeStartegy();
        LocalDateTimeUtil localDateTimeUtil = mock(LocalDateTimeUtil.class);
        ParkingTicket parkingTicket  = new ParkingTicket(localDateTimeUtil);
        when(localDateTimeUtil.parseToLocalDateTIme(any()))
                .thenReturn(LocalDateTime.of(2023,2,6,1,0))
                .thenReturn(LocalDateTime.of(2023,2,7,1,1));

        double actualFee = twoWheelerAirportFeeStartegy.getFee(parkingTicket, "06-Feb-2023 10:00:00");

        assertEquals(160.0, actualFee);
    }
}