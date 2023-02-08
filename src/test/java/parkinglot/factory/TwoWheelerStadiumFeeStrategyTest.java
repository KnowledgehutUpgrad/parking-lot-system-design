package parkinglot.factory;

import org.junit.jupiter.api.Test;
import parkinglot.component.ParkingTicket;
import util.LocalDateTimeUtil;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TwoWheelerStadiumFeeStrategyTest {
    @Test
    void shouldReturnCorrectTotalFeeForParkedHoursBetween0To4() {
        TwoWheelerStadiumFeeStrategy twoWheelerStadiumFeeStrategy = new TwoWheelerStadiumFeeStrategy();
        LocalDateTimeUtil localDateTimeUtil = mock(LocalDateTimeUtil.class);
        ParkingTicket parkingTicket  = new ParkingTicket(localDateTimeUtil);
        when(localDateTimeUtil.parseToLocalDateTIme(any()))
                .thenReturn(LocalDateTime.of(2023,2,6,1,0))
                .thenReturn(LocalDateTime.of(2023,2,6,4,59));

        double actualFee = twoWheelerStadiumFeeStrategy.getFee(parkingTicket, "06-Feb-2023 10:00:00");

        assertEquals(30.0, actualFee);
    }

    @Test
    void shouldReturnCorrectTotalFeeForParkedHoursBetween4To12() {
        TwoWheelerStadiumFeeStrategy twoWheelerStadiumFeeStrategy = new TwoWheelerStadiumFeeStrategy();
        LocalDateTimeUtil localDateTimeUtil = mock(LocalDateTimeUtil.class);
        ParkingTicket parkingTicket  = new ParkingTicket(localDateTimeUtil);
        when(localDateTimeUtil.parseToLocalDateTIme(any()))
                .thenReturn(LocalDateTime.of(2023,2,6,1,0))
                .thenReturn(LocalDateTime.of(2023,2,6,6,59));

        double actualFee = twoWheelerStadiumFeeStrategy.getFee(parkingTicket, "06-Feb-2023 10:00:00");

        assertEquals(60.0, actualFee);
    }

    @Test
    void shouldReturnCorrectTotalFeeForParkedHoursMoreThan12() {
        TwoWheelerStadiumFeeStrategy twoWheelerStadiumFeeStrategy = new TwoWheelerStadiumFeeStrategy();
        LocalDateTimeUtil localDateTimeUtil = mock(LocalDateTimeUtil.class);
        ParkingTicket parkingTicket  = new ParkingTicket(localDateTimeUtil);
        when(localDateTimeUtil.parseToLocalDateTIme(any()))
                .thenReturn(LocalDateTime.of(2023,2,6,1,0))
                .thenReturn(LocalDateTime.of(2023,2,6,15,59));

        double actualFee = twoWheelerStadiumFeeStrategy.getFee(parkingTicket, "06-Feb-2023 10:00:00");

        assertEquals(390.0, actualFee);
    }
}